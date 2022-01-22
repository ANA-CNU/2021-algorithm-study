const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [a, b] = input[0].split(' ');
const A = +a;
const B = +b;

// 문제 풀이:
function solution(A, B) {

}

// 제출
const answer = solution(A, B);
console.log(answer);
