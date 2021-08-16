const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[n, ...arr] = input;
n = Number(n);
arr = arr[0].split(' ').map(i => Number(i));
solution(n, arr);

// 문제 풀이
function solution(n, dp) {
    let max = dp[0];
    // 전에 값과 비교해서
    // 전에 값이 음수가 아니고, 지금 값이랑 더했을 때도 음수가 아니면
    // 더해도 됨
    for (let i = 1; i < n; i++) {
        if (dp[i - 1] > 0 && dp[i] + dp[i - 1] > 0) {
            dp[i] += dp[i - 1];
        }

        if (max < dp[i]) {
            max = dp[i];
        }
    }  
    console.log(max);
}