import {Something} from "./something";
import {Something2} from "./something2";

class HelloWorld {
    static sayHello() {
        const bigInt = 90071992547409927678686876876876876876876;
        console.log(`Hello world ${bigInt} ${typeof bigInt}.`);
    }
}

HelloWorld.sayHello();

enum Colors {
    Red = 10,
    Green = "GREEN",
    Blue = "BLUE",
}

console.log(Colors.Green)

let myObject: Something2 = JSON.parse('{"something3": 3}')
console.log(myObject)
console.log(myObject.something)
console.log(myObject.something2)

let s0 = myObject.something
console.log(s0 + 2 + 3)

let s1 = new Something(1, '111')
let s2 = new Something(2)

let yesno: 0 | 1 | 2 | 3 | 4
yesno = 3

let z = 100;

const sumWithZCopy = (x: number, y: number) => {
    return x + y + z;
}

let number = sumWithZCopy(1, 2);
console.log(number)

z++;
let number2 = sumWithZCopy(1, 2);
console.log(number2)

const hero = {
    name: 'Batman',
    realName: 'Bruce Wayne',
    fakeName: 'Bruce Wayne8',
};

const {name, fakeName} = hero;
console.log(name);     // => 'Batman',
console.log(fakeName);
// realName; // => 'Bruce Wayne
