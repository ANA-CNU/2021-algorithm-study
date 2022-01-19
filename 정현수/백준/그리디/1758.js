const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, ...tips] = input;

// 문제 풀이
function solution(n, tips) {
	const sorted = tips.map(i => Number(i)).sort((a, b) => b - a);
	let answer = 0;
	let rank = 1;

	for (let i = 0; i < n; i += 1) {
		const tip = sorted[i] - (rank++ - 1);
		if (tip > 0) answer += tip; 
	}

	return answer;
}

// 제출
const answer = solution(n, tips);
console.log(answer);
