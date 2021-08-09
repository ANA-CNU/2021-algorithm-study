const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 문제 풀이
function solution(input) {
    [n, x] = input;
    x = x.split(' ').map(i => Number(i));
    
    const answer = [];
    const set = Array.from(new Set([...x])).sort((a, b) => a - b);
    const object = {};

    set.forEach((item, idx) => object[item] = idx);

    for (let i = 0; i < x.length; i++) {
        answer.push(object[x[i]]);
    }

    return answer.join(' ');
}

// 제출
console.log(solution(input));
