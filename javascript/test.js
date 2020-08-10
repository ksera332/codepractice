function myFunction(p1,p2){
    return p1 * p2;
}

var person = {
    firstName:"john",
    lastName: "Doe",
    fullName: function(){
        return this.firstName + " " + this.lastName;
    }
}

document.getElementById("test").innerHTML = person.fullName();