const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split(' ');
input = Number(input[0]);

// 문제 풀이
function solution(input) {
    if (input === 0) return 0;
    if (input === 1 || input === 2) return 1;
    return solution(input - 1) + solution(input - 2); 
}

// 제출
console.log(solution(input));
