const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

// console.log(input);

const n = +input[0];
const crane = input[1].split(' ').map(i => +i);
const m = +input[2];
const box = input[3].split(' ').map(i => +i);

// 문제 풀이:
function solution(n, crane, m, box) {
	crane.sort((a, b) => b - a);
	box.sort((a, b) => b - a);
	let answer = 0;

	// 불가능 할 때 
	if (box[0] > crane[0]) return -1;

	while (box.length) {
		let count = 0;

		for (let i = 0; i < n; i += 1) {
			if (count === box.length) {
				break;
			} else if (crane[i] >= box[count]) {
				box.splice(count, 1);
			} else {
				count += 1;
			}
		}
		answer += 1;
	}
	return answer;
}

// 제출
const answer = solution(n, crane, m, box);
console.log(answer);
