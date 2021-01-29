// Import express
const Db = require('mongodb').Db;
const mongoose = require('mongoose');
const express = require('express');
const User = require('./model/usermodel');
const Server = require('mongodb').Server
const { query } = require('express');
const usermodel = require('./model/usermodel');
const register = require('./model/register');
const signin = require('./model/signin');

// Connect database
mongoose.connect("mongodb://localhost:27017/mobile")
    .then(() => { console.log("OK") })
    .catch(err => { console.log(err.message) });
// Initialize the app
const app = express();
// Send message for default URL
app.get('/', (req, res) => res.send('Hello World with Express'));

app.get('/user', (req, res) => {
    console.log("avc");
    User.find()
        .then(user => {
            console.log(user);
            res.json({ 'users': user });
        })
        .catch(err => {
            console.log(err);
            res.send({ 'message': err.message });
        });
});




app.post('/register', (req, res, next) => {
    // const name = req.body.name;
    // const pass = req.body.pass;
    console.log(req.body);

    User.insertMany({

        name: req.body.name,
        pass: req.body.pass
    })


    .catch(err => {
        res.send({ 'message': err.message });
    });


});
app.post('/signup', function(req, res, next) {
    var user = {
        Name: req.body.name,

        Pass: req.body.pass,

    };
    var UserReg = mongoose.model('sign', RegSchema);
    UserReg.create(user, function(err, newUser) {
        if (err) return next(err);
        req.session.user = email;
        return res.send('Logged In!');
    });
});

// Launch app to listen to specified port
app.listen(3000, function() {
    console.log("Running RestHub on port 3000");
});