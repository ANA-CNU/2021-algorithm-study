const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[n, arr] = input;
n = Number(n);
arr = arr.split(' ').map(i => Number(i));

solution(n ,arr);

// 문제 풀이
function solution(n, arr) {
    if (n === 0) console.log(0);
    else if (n === 1) console.log(1); 
    else {
        let dp = new Array(n).fill(1);
        for (let i = 1; i < n; i++) {
            const current = arr[i];
            const values = [1];
            for (let j = 0; j < i; j++) {
                const before = arr[j];
                if (current > before) values.push(dp[j] + 1);
            }
            dp[i] = Math.max(...values);
        }
        console.log(Math.max(...dp));
    }
}
