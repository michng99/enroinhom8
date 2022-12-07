const router = require("express").Router();
const { PlayList, validate } = require("../models/playlist");
const { BaiHat } = require("../models/baihat");
const { User } = require("../models/user");
const auth = require("../middleware/auth");
const validateObjectId = require("../middleware/validateObjectId");
const Joi = require("joi");

// Tạo danh sách bài hát
router.post("/", auth, async (req, res) => {
	const { error } = validate(req.body);
	if (error) return res.status(400).send({ message: error.details[0].message });

	const user = await User.findById(req.user._id);
	const playList = await PlayList({ ...req.body, user: user._id }).save();
	user.playlists.push(playList._id);
	await user.save();

	res.status(201).send({ data: playList });
});

// sửa danh sách theo id
router.put("/edit/:id", [validateObjectId, auth], async (req, res) => {
	const schema = Joi.object({
		tendsp: Joi.string().required(),
		mota: Joi.string().allow(""),
		img: Joi.string().allow(""),
	});
	const { error } = schema.validate(req.body);
	if (error) return res.status(400).send({ message: error.details[0].message });

	const playlist = await PlayList.findById(req.params.id);
	if (!playlist) return res.status(404).send({ message: "Playlist not found" });

	const user = await User.findById(req.user._id);
	if (!user._id.equals(playlist.user))
		return res.status(403).send({ message: "User don't have access to edit!" });

	playlist.tendsp = req.body.tendsp;
	playlist.mota = req.body.mota;
	playlist.img = req.body.img;
	await playlist.save();

	res.status(200).send({ message: "Updated successfully" });
});

// them bai hat vao danh sach
router.put("/add-song", auth, async (req, res) => {
	const schema = Joi.object({
		IdDanhSachPhat: Joi.string().required(),
		IdBaiHat: Joi.string().required(),
	});
	const { error } = schema.validate(req.body);
	if (error) return res.status(400).send({ message: error.details[0].message });

	const user = await User.findById(req.user._id);
	const playlist = await PlayList.findById(req.body.IdDanhSachPhat);
	if (!user._id.equals(playlist.user))
		return res.status(403).send({ message: "User don't have access to add!" });

	if (playlist.baihats.indexOf(req.body.IdBaiHat) === -1) {
		playlist.baihats.push(req.body.IdBaiHat);
	}
	await playlist.save();
	res.status(200).send({ data: playlist, message: "Added to playlist" });
});

// xoa bai hat khoi danh sach
router.put("/remove-song", auth, async (req, res) => {
	const schema = Joi.object({
		IdDanhSachPhat: Joi.string().required(),
		IdBaiHat: Joi.string().required(),
	});
	const { error } = schema.validate(req.body);
	if (error) return res.status(400).send({ message: error.details[0].message });

	const user = await User.findById(req.user._id);
	const playlist = await PlayList.findById(req.body.IdDanhSachPhat);
	if (!user._id.equals(playlist.user))
		return res
			.status(403)
			.send({ message: "User don't have access to Remove!" });

	const index = playlist.baihats.indexOf(req.body.IdBaiHat);
	playlist.baihats.splice(index, 1);
	await playlist.save();
	res.status(200).send({ data: playlist, message: "Removed from playlist" });
});

// danh sach cua nguoi dung
router.get("/favourite", auth, async (req, res) => {
	const user = await User.findById(req.user._id);
	const playlists = await PlayList.find({ _id: user.playlists });
	res.status(200).send({ data: playlists });
});

// lay danh sach ngau nhien
router.get("/random", auth, async (req, res) => {
	const playlists = await PlayList.aggregate([{ $sample: { size: 10 } }]);
	res.status(200).send({ data: playlists });
});

// lay danh sach theo id
router.get("/:id", [validateObjectId, auth], async (req, res) => {
	const playlist = await PlayList.findById(req.params.id);
	if (!playlist) return res.status(404).send("not found");

	const baihats = await BaiHat.find({ _id: playlist.baihats });
	res.status(200).send({ data: { playlist, baihats } });
});

// lay toan bo danh sach
router.get("/", auth, async (req, res) => {
	const playlists = await PlayList.find();
	res.status(200).send({ data: playlists });
});

// xoa danh sach theo id
router.delete("/:id", [validateObjectId, auth], async (req, res) => {
	const user = await User.findById(req.user._id);
	const playlist = await PlayList.findById(req.params.id);
	if (!user._id.equals(playlist.user))
		return res
			.status(403)
			.send({ message: "User don't have access to delete!" });

	const index = user.playlists.indexOf(req.params.id);
	user.playlists.splice(index, 1);
	await user.save();
	await playlist.remove();
	res.status(200).send({ message: "Removed from library" });
});

module.exports = router;