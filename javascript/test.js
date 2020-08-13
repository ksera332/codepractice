function myFunction(p1,p2){
    return p1 * p2;
}

function displayDate(){
    document.getElementById("time").innerHTML = Date();
}

var person = {
    firstName:"john",
    lastName: "Doe",
    fullName: function(){
        return this.firstName + " " + this.lastName;
    }
}
document.getElementById("test").innerHTML = person.fullName();

var txt = "slice test string";
document.getElementById("slice").innerHTML = txt.slice(3,8);

var cars = ["TOYOTA","HONDA","NISSAN"];
var text = "";
for(var i = 0;i<cars.length;i++){
    text += cars[i] + "<br>";
}
document.getElementById("loop").innerHTML = text;
