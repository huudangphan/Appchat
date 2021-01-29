const mongoose = require("mongoose");

const Schema = mongoose.Schema;

let sign = new Schema({
    username: {
        type: String
    },
    pass: {
        type: String
    }

});

module.exports = mongoose.model("sign", sign);