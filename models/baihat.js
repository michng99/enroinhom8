const mongoose = require("mongoose");
const Joi = require("joi");

const sodoBaiHat = new mongoose.Schema({
	tenbaihat: { type: String, required: true },
	tacgia: { type: String, required: true },
	baihat: { type: String, required: true },
	hinhanh: { type: String, required: true },
	thoiluong: { type: String, required: true },
});

const validate = (baihat) => {
	const schema = Joi.object({
		tenbaihat: Joi.string().required(),
		tacgia: Joi.string().required(),
		baihat: Joi.string().required(),
		hinhanh: Joi.string().required(),
		thoiluong: Joi.number().required(),
	});
	return schema.validate(baihat);
};

const BaiHat = mongoose.model("baihat", sodoBaiHat);

module.exports = { BaiHat, validate };