const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
input = Number(input[0]);
let dp = new Array(input).fill(0);
dp = [0, 0, 1, 1, ...dp];
solution(input);

function solution(n) {
    for (let i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + 1;
        if (i % 2 === 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        if (i % 3 === 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
    }
    console.log(dp[n]);
}
