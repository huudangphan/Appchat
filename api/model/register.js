const mongoose = require("mongoose");

const Schema = mongoose.Schema;

let register = new Schema({
    username: {
        type: String
    },
    pass: {
        type: String
    }

});

module.exports = mongoose.model("register", register);