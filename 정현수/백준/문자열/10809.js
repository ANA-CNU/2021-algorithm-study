const fs = require('fs');

// 백준 제출
// const input = fs.readFileSync('/dev/stdin').toString().split(' ');

// VSC 테스트 용
let input = fs.readFileSync('input.txt').toString().split(' ');
input = input[0];

// 문제 풀이
function solution(input) {
    input = input.split('');

    const alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
    const answer = [];

    for (let i = 0; i < alphabet.length; i++) {
        answer.push(input.findIndex(item => item == alphabet[i]));
    }

    return answer.join(' ');
}

console.log(solution(input));
