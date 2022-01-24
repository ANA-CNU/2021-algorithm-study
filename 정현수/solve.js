const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, number] = input;
n = +n;
number = number.split(' ').map(i => +i);

// 문제 풀이:
function solution(n, number) {
	const max = Math.max(...number);
	let answer = [];

	for (let i = 1; i <= max; i++) {
		for (let j = 0; j < n; j++) {
			if (number[j] % i != 0) j = n;
			if (j == n - 1) answer.push(i + "\n");
		}
	}

	return answer.join('').trim();
}

// 제출
const answer = solution(n, number);
console.log(answer);
