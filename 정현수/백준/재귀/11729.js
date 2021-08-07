const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split(' ');
input = Number(input[0]);

// 문제 풀이
function solution(input) {
    let count = 0;
    let answer = [];

    const hanoi = (n, from, other, to) => {
        if (!n) return;

        // from에 있는 거를 other로 옮긴다.
        // 왜? n을 옮기기 위해선 n-1 다른데로 옮겨
        hanoi(n - 1, from, to, other);
        answer.push([from, to]);
        count += 1;

        // other에서 to로 옮긴다. = n - 1를 다시 to로 옮긴다.
        hanoi(n - 1, other, from, to);
    }

    hanoi(input, 1, 2, 3);
    console.log(count);
    return answer.map(i => i.join(" ")).join("\n");
}

// 제출
console.log(solution(input));
