const emptyARRAY = [];
const numbers = [1,2,3];
const matrix = [
    ["a","b"],
    ["c","d"]
]

console.log(matrix.length)
console.log(Array.isArray(matrix));

const array = ["one","two","three"];
const [first,second,third] = array;
console.log(first);

console.log(array.indexOf("two"));

console.log(array.slice(1,2));

console.log(array.includes("two"));