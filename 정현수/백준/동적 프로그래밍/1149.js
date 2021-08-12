const fs = require('fs');
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 인풋 처리
[N, ...arr] = input;
N = Number(N);
arr = arr.map(i => i.split(' ').map(i => Number(i)));

for (let i = 1; i < N; i++) {
    arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
    arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
    arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
}

console.log(Math.min(...arr[N - 1]));