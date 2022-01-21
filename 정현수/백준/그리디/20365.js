const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...colors] = input;
n = +n;
colors = colors[0];

// 문제 풀이:
// 핵심 아이디어: RR, BBB 이렇게 한 덩이씩 붙어있으면 하나로 보자.
// 그리고 덩이가 많은 것을 우선 전부 다 칠하고, 나머지 덩이를 칠한다.
function solution(n, colors) {
	let answer = 1;

	const blueCount = colors.split('R').filter(i => i).length;
	const redCount = colors.split('B').filter(i => i).length;
	const larger = blueCount > redCount ? 'B' : 'R';
	const split = colors.split(larger);
	split.forEach(string => { if (string) answer += 1; });

	return answer;
}

// 제출
const answer = solution(n, colors);
console.log(answer);
