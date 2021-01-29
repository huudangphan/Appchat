const monogoose = require('mongoose');
const UserSchema = monogoose.Schema({
    name: String,
    id_user: String,
    pass: String,
    display_name: String
}, { collection: 'user' });

module.exports = monogoose.model('User', UserSchema);