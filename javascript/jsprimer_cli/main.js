const fs = require("fs");
const program = require("commander");
const md2html = require("./md2html");

program.option("--gfm", "GFMを有効にする");
program.parse(process.argv);
const filePath = program.args[0];

const option = program.opts();

const cliOptions = {
    gfm: false,
    ...program.opts(),
};

fs.readFile(filePath,{encoding:"utf-8"},(err,file) => {
    if(err){
        console.error(err.message);
        process.exit(1);
        return;
    }
    const html = md2html(file,cliOptions);
    console.log(html);
});