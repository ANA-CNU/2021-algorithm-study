const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input[0]);

// 문제 풀이
function solution(n) {
	let answer = 0;
	if (n === 1 || n === 3) return -1;

	while (n > 0) {
		if (n % 2 === 1 || n % 5 === 0) {
			answer += 1;
			n -= 5;
		} else if (n % 2 === 0) {
			answer += 1;
			n -= 2;
		}
	}

	return answer;
}

// 제출
const answer = solution(n);
console.log(answer);
