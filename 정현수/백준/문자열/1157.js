const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 문제 풀이
function solution(input) {
    const answer = new Array(26).fill(0)
    input = input[0].toUpperCase();

    for (let i = 0; i < input.length; i++) {
        answer[input[i].charCodeAt(0) - 65] += 1;
    }
    
    const max = Math.max(...answer);
    return answer.filter(value => value === max).length === 1 
     ? String.fromCharCode(answer.findIndex(val => val === max) + 65)
     : '?';
}

// 제출
console.log(solution(input));
