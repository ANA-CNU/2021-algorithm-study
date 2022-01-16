const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = +input[0].split(' ')[0];
const poketmons = input.slice(1, n + 1);
const questions = input.slice(n + 1)

// 문제 풀이
function solution(poketmons, questions) {
	const map = new Map(poketmons.map((poketmon, index) => [poketmon, index + 1]));
	questions.forEach(question => {
		if (Number.isNaN(+question)) console.log(map.get(question));
		else console.log(poketmons[+question - 1]);
	});
}

// 제출
solution(poketmons, questions);
