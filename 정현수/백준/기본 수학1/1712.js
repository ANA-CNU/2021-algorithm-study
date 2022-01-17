const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [a, b, c] = input[0].split(' ');

// 문제 풀이
function solution(a, b, c) {
	const A = +a;
	const B = +b;
	const C = +c;

	if (B >= C) return -1;
	else return Math.floor(A / (C - B)) + 1;
}

// 제출
const answer = solution(a, b, c);
console.log(answer);
