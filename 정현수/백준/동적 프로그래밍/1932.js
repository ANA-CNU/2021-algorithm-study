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
solution(N, arr);

// 내려가면서 N - 1부터 0까지 돌면서
// 대각선 둘 중에 큰 거를 더해서 축적해 나간다.
function solution(N, arr) {
    for (let i = N - 2; i >= 0; i--) {
        for (let j = 0; j < arr[i].length; j++) {
            arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
        }
    }
    console.log(arr[0][0]);
}
