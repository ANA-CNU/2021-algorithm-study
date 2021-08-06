const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 문제 풀이
function solution(input) {
    const testCaseLength = input[0];
    let answer = '';

    for (let i = 0; i < testCaseLength; i++) {
        const test = input[i + 1].split(' ');
        const iterator = Number(test[0]);
        const str = test[1];
        
        str.split('').forEach(char => {
            for (let j = 0; j < iterator; j++) {
                answer += char;
            }
        });

        if (i !== testCaseLength - 1) answer += '\n';
    }

    return answer;
}

// 제출
console.log(solution(input));
