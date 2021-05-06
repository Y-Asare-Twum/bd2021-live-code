document.querySelector('#btn').addEventListener('click', () => {
    console.log("btn: Click!")
    let v = document.querySelector('#field').value
    document.querySelector('#name').innerText = ` ${v}`
    document.querySelector('#field').value = ''
}, true);

document.querySelector('#container').addEventListener('click', () => {
   console.log("container: Click!")
}, true);
