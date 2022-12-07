const jwt = require("jsonwebtoken");

module.exports = (req, res, next) => {
	const token = req.header("x-auth-token");
	if (!token)
		return res
			.status(400)
			.send({ message: "Kết nối thất bại, không có mã nào được cung cấp" });

	jwt.verify(token, process.env.JWTPRIVATEKEY, (err, validToken) => {
		if (err) {
			return res.status(400).send({ message: "Mã không hợp lệ" });
		} else {
			req.user = validToken;
			next();
		}
	});
};