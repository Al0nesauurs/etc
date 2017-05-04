var users = [
{
	"id":  1,
	"username" : "rikimaru",
	"name" : "riki",
	"position" : "StealthAssasin"
},
{
	"id" : 2,
	"username" : "terrorblade",
	"name" : "terror",
	"position" : "DemonHunter",
}
];

exports.findAll = function (){return users;};

exports.findById= function (){
	for (var i =0;i<users.legnth;i++)
	{
		if(users[i].id==id)
			return users[i];
	}
};