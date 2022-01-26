const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

// console.log(input);

const n = +input[0];
const k = +input[1];
const sensor = input[2].split(' ').map(i => +i);

// 문제 풀이:
function solution(n, k, sensor) {
	if (k >= n) return 0;
	
	const diff = [];
	let answer = 0;

	sensor.sort((a, b) => a - b);
	
	for (let i = 0; i < n - 1; i += 1) {
		diff.push(sensor[i + 1] - sensor[i]);
	}

	diff.sort((a, b) => b - a);
	
	for (let i = k - 1; i < n - 1; i += 1) {
		answer += diff[i];
	}

	return answer;
}

// 제출
const answer = solution(n, k, sensor);
console.log(answer);
