const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split(' ');
input = input[0];

// 문제 풀이
function solution(input) {
    const croatian = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z='];
    let answer = 0;
    for (let i = 0; i < croatian.length; i++) {
        while (input !== input.replace(croatian[i], '')) {
            answer += 1;
            input = input.replace(croatian[i], ' ');
        }
    }
    return answer + input.split(' ').join('').length;
}

// 제출
console.log(solution(input));
