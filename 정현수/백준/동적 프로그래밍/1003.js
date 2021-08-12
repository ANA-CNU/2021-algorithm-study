const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[n, ...arr] = input;

arr = arr.map(i => Number(i));
const memo = Array.from(Array(41), () => new Array(2).fill(0));

function solution(arr) {
    for (let i = 0; i < n; i++) {
        console.log(fibonacci(arr[i], memo).join(' '));
    }
}

function fibonacci(n, memo) {
    if (n === 0) {
        memo[n] = [1, 0]; 
        return memo[n];
    } 
    if (n === 1) {
        memo[n] = [0, 1];
        return memo[n];
    }
    if (n === 2) {
        memo[n] = [1, 1];
        return memo[n];
    }

    // 메모이제이션이 되어 있으면 바로 리턴
    if (memo[n][0] !== 0 && memo[n][1] !== 0) {
        return memo[n];
    }

    let num1 = fibonacci(n - 1, memo);
    let num2 = fibonacci(n - 2, memo);

    memo[n] = [num1[0] + num2[0], num1[1] + num2[1]];
    return memo[n];
}

solution(arr);