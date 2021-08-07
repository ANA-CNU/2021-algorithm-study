const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split(' ');
input = Number(input[0]);

// 문제 풀이
function solution(input) {
    if (!input || input === 1) return 1;
    return input * solution(input - 1);
}

// 제출
console.log(solution(input));
