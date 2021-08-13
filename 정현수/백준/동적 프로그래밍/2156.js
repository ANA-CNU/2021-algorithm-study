const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[n, ...arr] = input;
arr = arr.map(i => Number(i));
n = Number(n);
let memo = new Array(n);
solution(n, arr, memo);

function solution(n, arr, memo) {
    memo[0] = arr[0];
    memo[1] = Math.max(arr[0] + arr[1] ,arr[1]);
    memo[2] = Math.max(memo[0] + arr[2], arr[1] + arr[2], memo[1]);

    for (let i = 3; i < n; i++) {
        // 지금 + 1칸 전 + 3칸 전 축적 vs 지금 + 2칸 전 축적
        memo[i] = Math.max(memo[i - 3] + arr[i - 1] + arr[i], memo[i - 2] + arr[i]);
        memo[i] = Math.max(memo[i - 1], memo[i]);
    }

    console.log(memo);
    console.log(memo[n - 1]);
}