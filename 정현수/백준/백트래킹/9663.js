const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

input = Number(input[0]);
// 문제 풀이
function solution(input) {
    // 조합 문제
    const visited = new Array(input).fill(0);
    let answer = 0;

    dfs(0);

    function dfs(x) {
        if (x === input) {
            answer += 1;
        } else {
            for (let i = 0; i < input; i++) {
                if (visited[x]) continue;
                visited[x] = i;
                if(check(x)) dfs(x + 1);
                visited[x] = 0;
            }
        }
    }

    function check(x) {
        for (let i = 0; i < x; i++) {
            if (visited[x] === visited[i]) return false;
            if (Math.abs(visited[x] - visited[i]) === x - i) return false;
        }
        return true;
    }

    return answer;
}

// 제출
console.log(solution(input));
