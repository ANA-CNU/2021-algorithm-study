const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const number = +input[0];

// 문제 풀이:
function solution(number) {
	let answer = 0;
	
	while (number > 0) {
		if (number % 5 === 0) {
			number -= 5;
		} else {
			number -= 3;
		}
		answer += 1;
	}

	return number === 0 ? answer : -1;
}

// 제출
const answer = solution(number);
console.log(answer);
