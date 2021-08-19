const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[n, ...arr] = input;
[n, price] = n.split(' ');
price = Number(price);
arr = arr.map(i => Number(i));
solution(n, price, arr);

// 문제 풀이
function solution(n, price, money) {
    let nowIndex = n - 1;
    let answer = 0;
    while (price !== 0) {
        if (price < money[nowIndex]) nowIndex -= 1;
        else {
            price -= money[nowIndex];
            answer += 1;
        }
    }
    console.log(answer);
}