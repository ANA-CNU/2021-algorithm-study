const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = input[0];

// 문제 풀이
function solution(n) {
	n = n.replace(/XXXX/g, 'AAAA');
	n = n.replace(/XX/g, 'BB');

	return n.split('').includes('X') ? -1 : n;
}

// 제출
const answer = solution(n);
console.log(answer);
