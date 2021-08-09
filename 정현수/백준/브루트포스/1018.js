const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 문제 풀이
function solution(input) {
    [size, ...arr] = input;
    [row, col] = size.split(' ');
    arr = arr.map(str => str.trim('\r').split(''));

    const answer = [];
    const line = ['WBWBWBWB', 'BWBWBWBW'];

    // i = x축 - 8
    // j = y축 - 8
    for (let i = 0; i <= row - 8; i++) {
        for (let j = 0; j <= col - 8; j++) {
            
            // 두 개의 경우를 생각하기 위한 for문
            for (let z = 0; z < 2; z++) {
                let count = 0;

                // 8*8 정사각형을 도는 for문
                for (let x = 0; x < 8; x++) {
                    for (let y = 0; y < 8; y++) {
                        const current = arr[i + x][j + y];
                        if (current !== line[(x + z) % 2][y]) count++; 
                    }
                }  
                answer.push(count);
            }
        }
    }
    return Math.min(...answer);
}

// 제출
console.log(solution(input));
