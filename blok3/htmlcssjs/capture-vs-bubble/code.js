document.querySelector('#btn').addEventListener(
    'click',
    () => {
        console.log("btn: Click!")
        let v = document.querySelector('#field').value
        document.querySelector('#name').innerText = `Bram zegt: ${v}` // string interpolation
        document.querySelector('#field').value = ''
    },
    true);

document.querySelector('#container').addEventListener(
    'click',
    () => {
        console.log("container: Click!")
    },
    true);


function handleClick() {
    let book = {};
    book.title = 'E = mc²';
    book.author = 'Einstein';
    book.languages = ['Dutch', 'English'];
    book.printIsbn = () => {
        console.log('978-3-16-148410-0');
    };

    book.printIsbn()

    // console.log(book.pages())
}
