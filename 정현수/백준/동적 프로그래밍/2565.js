const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[n, ...arr] = input;
n = Number(n);
arr = arr.map(i => i.split(' ').map(v => Number(v)));
solution(n, arr);

// 문제 풀이
function solution(n, arr) {
    let dp = new Array(n).fill(1);
    
    // 왼쪽 줄을 기준으로 오름차순 정렬 후
    arr.sort((a, b) => a[0] - b[0]);

	// 오른쪽 줄을 기준으로
    // 가장 긴 오름차순 부분 수열의 길이를 구하고
    for (let i = 1; i < n; i++) {
        const current = arr[i][1];
        let count = 0;
        for (let j = 0; j < i; j++) {
            const before = arr[j][1];
            if (current > before) count = Math.max(count, dp[j]);
        }
        dp[i] = count + 1;
    }
	
    // 그 부분 수열을 전체 길이 n 에서 뺀 값이 정답
    console.log(n - Math.max(...dp));
}