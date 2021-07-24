//test code

function hello(name){
    console.log("こんにちは" + name + "さん");
}

hello("名前");

let bootTitle = "Javascript Primaer";
const bootCategory = "プログラミング";

bootTitle = "new";
console.log(typeof bootTitle);
console.log(1_000_000);

const obj = {
    "key":"value"
};
console.log(obj.key);
console.log(obj["key"]);

console.log(2 ** 4);
console.log(Math.pow(2,4));

console.log(typeof +"11");

const array = [1,2];
const [a,b] = array;
console.log(a,b);

true && console.log("run");
false && console.log("not run");

const valueA = true ? "A" : "B";
const valueB = false ? "A" : "B";

console.log(valueA);
console.log(valueB);


const factorial = function innerFact(n){
    if(n === 0){
        return 1;
    }
    return n * innerFact(n-1);
}

console.log(factorial(3));

const mul = x => x * x;
console.log(mul(10));