const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...testcases] = input;
n = Number(n);
testcases = testcases[0].split(' ').map(i => Number(i));

// 문제 풀이
function solution(n, testcases) {
	const answer = [1];
	let balloons = testcases.map((item, index) => {
		return {item, index: index + 1}
	});;
	let index = 0;
	let paper = balloons[0].item - 1;
	balloons.splice(0, 1);

	while (balloons.length) {
		if (paper > 0 || index - paper === 0) {
			index = (index + paper) % balloons.length;
		} else if (paper < 0) {
			index = balloons.length - Math.abs(index + paper);
		}
		paper = balloons[index].item;
		answer.push(balloons[index].index);
		balloons.splice(index, 1);
	}

	return answer.join(' ');
}

// 제출
const answer = solution(n, testcases);
console.log(answer);
