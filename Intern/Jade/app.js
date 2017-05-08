var express = require('express');
var path = require('path');
var app = express();

app.set('views', path.join(__dirname, 'views'));
 
// ตั้งค่าให้ Express ใช้ View Engine ชื่อว่า Jade
app.set('view engine', 'jade');
 

// res.render('file') คือการให้ทำการ render ไฟล์ ที่อยู่ในโฟลเดอร์ views
// เมื่อ client เข้าถึงหน้า Home Page ของเว็บไซต์ http://localhost:5555/
// app.get(URL, getHomePage)
// URL - คือ PATH ของเว็บไซต์
// getHomePage คือ callback function ที่มี request และ response
app.get('/', function (req, res) {
    res.render('index.jade');
});

app.get('/', function(req, res){
	res.render('multiple.jade');
})
 
// start server ด้วย port 5555
var server = app.listen(5555, function() {
    console.log('Express.js is running... Port 5555');
});