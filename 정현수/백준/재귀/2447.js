const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split(' ');
input = Number(input[0]);

// 문제 풀이
function solution(input) {
    // input * input 배열 만들기 (*로 채움)
    let arr = new Array(input);
    for (let i = 0; i < arr.length; i++) {
        arr[i] = new Array(input).fill('*');
    }

    // 구멍 뚫기 함수
    const punching = (input, x, y) => {
        if (input === 1) return;
        let center = input / 3;
        if (center < 3) center = 1;
        let start = center - center;
        let last = center + center;

        // 구멍 뚫기
        for (let i = center; i < last; i++) {
            for (let j = center; j < last; j++) {
                arr[i + x][j + y] = ' ';
            }
        }

        punching(center, start + x, start + y);
        punching(center, start + x, center + y);
        punching(center, start + x, last + y);
        punching(center, center + x, start + y);
        punching(center, center + x, last + y);
        punching(center, last + x, start + y);
        punching(center, last + x, center + y);
        punching(center, last + x, last + y);
    } 

    punching(input, 0, 0);
    return arr.reduce((answer, row) => {
        return answer += row.join('') + '\n';
    }, '');;
}

// 제출
console.log(solution(input));
