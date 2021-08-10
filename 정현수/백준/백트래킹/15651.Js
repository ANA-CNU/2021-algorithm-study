const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');


// 문제 풀이
function solution(input) {
    [n, m] = input[0].split(' ');
    const N = Number(n);
    const M = Number(m);
    let result = '';
    const output = [];

    function dfs(count) {
        if (count === M) {
            result += `${output.join(' ')}\n`;
            return;
        }

        for (let i = 0; i < N; i++) {
            output.push(i + 1);
            dfs(count + 1);
            output.pop();
        }
    }

    dfs(0);
    return result;
}

// 제출
console.log(solution(input));
