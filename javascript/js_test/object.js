const obj = {"key":"value"};

const color = {
    red:"red",
    bule:"bure",
    green:"green"
};

console.log(color.green);
console.log(color["red"]);

color.black = "black";
color["white"] = "white";
console.log(color.black);
console.log(color["white"]);

console.log(color.hasOwnProperty("bule"));

const merged = Object.assign({},obj,color);

console.log(merged);