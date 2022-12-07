const mongoose = require("mongoose");
const Joi = require("joi");

const ObjectId = mongoose.Schema.Types.ObjectId;

const playListSchema = new mongoose.Schema({
	tendsp: { type: String, required: true },
	user: { type: ObjectId, ref: "user", required: true },
	mota: { type: String },
	baihats: { type: Array, default: [] },
	img: { type: String },
});

const validate = (playlist) => {
	const schema = Joi.object({
		tendsp: Joi.string().required(),
		user: Joi.string().required(),
		mota: Joi.string().allow(""),
		baihats: Joi.array().items(Joi.string()),
		img: Joi.string().allow(""),
	});
	return schema.validate(playlist);
};

const PlayList = mongoose.model("playList", playListSchema);

module.exports = { PlayList, validate };