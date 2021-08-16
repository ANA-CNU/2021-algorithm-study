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

solution(n, arr);

// 문제 풀이
function solution(n, arr) {
    const upDP = new Array(n).fill(1);
    const downDP = new Array(n).fill(1);

    // 앞에서부터 배열을 돈다.
    // 증가하는 부분 수열의 최대 길이들을 구한다.
    for (let i = 1; i < n; i++) {
        const current = arr[i];
        let count = 1;
        for (let j = 0; j < i; j++) {
            const before = arr[j];
            if (current > before) count = Math.max(count, upDP[j] + 1);
        }
        upDP[i] = count;
    }

    // 뒤에서부터 배열을 돈다.
    // 감소하는 부분 수열의 최대 길이들을 구한다.
    for (let i = n - 2; i >= 0; i--) {
        const current = arr[i];
        let count = 1;
        for (let j = i + 1; j < n; j++) {
            const before = arr[j];
            if (current > before) count = Math.max(count, downDP[j] + 1);
        }
        downDP[i] = count;
    }

    // 증가하는 부분 수열, 감소하는 부분 수열의 길이들을 더한다.
    // 그 중 최대값의 - 1 이 정답
    const answer = upDP.map((val, idx) => val + downDP[idx]);
    console.log(Math.max(...answer) - 1);
}
