fn main() {
    let x = 5;//変数宣言(整数)
    
    let x = x + 1;//シャドーイング

    let x = x * 2;
    
    println!("the value ob number is: {}",x);

    let x = 2.0;//f64

    let y: f32 = 3.0;//f32

    //論理型
    let t = true;
    let f: bool = false;

    //文字型
    let c = 'z';

    //タプル
    let tup: (i32,f64,u8) = (500,6.4,1);//位置ごとに型を書く

    let tup = (500,6.4,1);//書かなくてもいい
    let (x,y,z) = tup;
    println!("the value of y is: {}",y);

    println!("first: {} second: {} last: {}",tup.0,tup.1,tup.2);//タプルアクセス

    //配列
    let a = [1,2,3,4,5];

    //アクセス
    let first = a[0];

    another_function(5);

    //式　よくわからない。。。
    let x = 5;

    let y = {
        let x = 3;
        x + 1//ここでは;をつけない
    };
    println!("the value of y is :{}",y);

    let x = five();

    println!("the value of x is: {}",x);
    
    let x = plus_one(x);
    println!("x + 1 = {}",x);

    let number = 3;
    if number < 5{
        println!("condition was true");
    }else{
        println!("condition was false");
    }

    let mut number = 3;

    while number != 0{
        println!("{}!",number);

        number -= 1;
    }
    println!("LiftOff!!!");

    judgh(9);

    let p = Person{
        name:String::from("john"),
        age:8
    };

    let count:i32;

    for count in 0..10{
        println!("count:{}",count);
    }
}

fn another_function(x: i32){
    println!("another function");
    println!("the value of number is: {}",x);
}

fn five() -> i32{
    5
}

fn plus_one(x: i32) -> i32{
    x + 1
}

fn judgh(number: i32){
    let number = number;

    if number < 5{
        println!("condition was true")
    }else{
        println!("condition was false")
    }
}

struct Person{
    name:String,
    age:u32,
}