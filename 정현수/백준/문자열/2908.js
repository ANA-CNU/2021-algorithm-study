const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split(' ');

// 문제 풀이
function solution(input) {
    const A = input[0].split('').reverse().join('');
    const B = input[1].split('').reverse().join('');
    return A > B ? A : B;
}

// 제출
console.log(solution(input));
