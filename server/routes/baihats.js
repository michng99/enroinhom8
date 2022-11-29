const router = require("express").Router();
const { User } = require("../models/user");
const { BaiHat, validate } = require("../models/baihat");
const auth = require("../middleware/auth");
const admin = require("../middleware/admin");
const validateObjectId = require("../middleware/validateObjectId");

//Tao bai hat (post)
router.post("/", admin, async (req, res) => 
{
    const { err } = validate(req.body);
    if (err) return res.status(400).send({ message: err.details[0].message });
    
    const baihat = await BaiHat(req.body).save();
    res.status(201).send({data: baihat, message: "Tạo bài hát thành công"});
});

//Lay danh sach bai hat
router.get("/", async(_req, res) => {
    const baihats = await BaiHat.find();
    res.status(200).send({data: baihats });
});

//Cap nhat bai hat
router.put("/:id", [validateObjectId, admin], async (req, res) => 
{
    const baihat = await BaiHat.findByIdAndUpdate(
        req.params.id, req.body, {new: true});
    res.status(200).send({data: baihat, message: "Đã cập nhật bài hát"});
});

//Xoa bai hat theo id
router.delete("/:id", [validateObjectId, admin], async (req, res) => 
{
    await BaiHat.findByIdAndUpdate(req.params.id);
    res.status(200).send({message: "Đã xoá bài hát"});
})

//Bai hat yeu thich (giong cap nhat)
router.put("/like/:id", [validateObjectId, auth], async (req, res) => {
	let resMessage = "";
	const baihat = await BaiHat.findById(req.params.id);
	if (!baihat) return res.status(400).send({ message: "Bài hát không tồn tại" });

	const user = await User.findById(req.user._id);
	const index = user.likedSongs.indexOf(baihat._id);
	if (index === -1) {
		user.likedSongs.push(baihat._id);
		resMessage = "Đã thêm bài hát yêu thích";
	} else {
		user.likedSongs.splice(index, 1);
		resMessage = "Đã xoá bài hát yêu thích";
	}

	await user.save();
	res.status(200).send({ message: resMessage });
});

//Lay tat ca bai hat yeu thich
router.get("/like", auth, async (req, res) => {
	const user = await User.findById(req.user._id);
	const baihats = await BaiHat.find({ _id: user.baiHatDaThich });
	res.status(200).send({ data: baihats });
});

module.exports = router;




/// dùng GridFS để thêm bài hát vào Mongodb