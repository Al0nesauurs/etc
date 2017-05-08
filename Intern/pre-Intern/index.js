var users = require('./users');
var app = require('express')();
var port = process.env.PORT || 7777;
var bodyParser = require('body-parser');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
    }));

app.get('/', function (req, res){
	res.send('<h1>HELLO WORLD NODE.JS</h1>');
});

app.get('/index', function(req, res){
	res.send('<h1>THIS IS INDEX PAGE</h1>');
});

//Call function findAll in users.js
app.get('/user', function(req, res){
	res.json(users.findAll());
});

app.get('/user/:id', function (req, res) {
    var id = req.params.id;
    res.json(users.findById(id));
});
 
app.post('/newuser', function (req, res) {
    var json = req.body;
    res.send('Add new ' + json.name + ' Completed!');
});

app.listen( port,function(){
	console.log('STARTING NODE ON PORT '+port );
});