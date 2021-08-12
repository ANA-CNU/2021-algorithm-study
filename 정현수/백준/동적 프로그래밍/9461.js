const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[N, ...numbers] = input;
N = Number(N);
numbers = numbers.map(i => Number(i));

let memo = new Array(90).fill(0);
memo = [0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, ...memo];

function fibo(n) {
    if (memo[n]) return memo[n];
    else return memo[n] = fibo(n - 1) + fibo(n - 5);
}

for (let i = 0; i < N; i++) {
    console.log(fibo(numbers[i]));
}
