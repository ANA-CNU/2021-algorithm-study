const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

input = Number(input[0]);

// 문제 풀이
function solution(input) {
    let answer = 0;
    let count = 0;
    while(answer !== input) {
        count += 1;
        if (`${count}`.includes('666')) answer += 1;
    }

    return count;
}

// 제출
console.log(solution(input));
