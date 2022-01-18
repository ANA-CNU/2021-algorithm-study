const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [numbers, ...inputs] = input;
const [N] = numbers.split(' ');
const s = inputs.slice(0, +N);
const m = inputs.slice(+N);

// 문제 풀이
function solution(m, s) {
	const obj = {};
	let answer = 0;

	s.forEach(item => obj[item] = true);
	m.forEach(item => { if (obj[item]) answer += 1; })
	return answer;
}

// 제출
const answer = solution(m, s);
console.log(answer);
