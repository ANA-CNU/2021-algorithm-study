const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [N, ...numbers] = input;

// 문제 풀이
function solution(N, numbers) {
	console.log(numbers);
}

// 제출
const answer = solution(N, numbers);
console.log(answer);
