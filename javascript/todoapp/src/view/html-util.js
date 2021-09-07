export function escapeSpecialChars(str){
    return str
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}
export function htmlToElement(html){
    const template = document.createElement("template");
    template.innerHTML = html;
    return template.content.firstElementChild;
}

export function element(string,...values){
    const htmlString = string.reduce((result,str,i) =>{
        const value = values[i - 1];
        if(typeof value === "string"){
            return result + escapeSpecialChars(value) + str;
        }else{
            return result + String(value) + str;
        }
    });
    return htmlToElement(htmlString);
}
export function render(bodyElement,comtainerElement){
    containerElement.innerHTML = "";
    containerElement.appendChild(bodyElement);
}