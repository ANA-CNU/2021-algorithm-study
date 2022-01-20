const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...loss] = input;
n = +n;
loss = loss[0].split(' ').map(i => Number(i));

// 문제 풀이
function solution(n, loss) {
	let answer = 0;
	loss.sort((a, b) => a - b);

	if (loss.length % 2 === 1) {
		answer = loss.pop();
		n -= 1;
	}

	for (let i = 0; i < n / 2; i += 1) {
		answer = Math.max(loss[i] + loss[loss.length - 1 - i], answer);
	}

	return answer;
}

// 제출
const answer = solution(n, loss);
console.log(String(BigInt(answer)));

// // 문제 풀이
// function solution(n, loss) {
// 	let answer = 0;

// 	for (let i = 0; i < loss.length - 1; i += 1) {
// 		for (let j = 0; j < loss.length - i; j += 1) {
// 			if (loss[j] > loss[j + 1]) {
// 				const a = loss[j];
// 				loss[j] = loss[j + 1];
// 				loss[j + 1] = a;
// 			}
// 		}
// 	}

// 	if (loss.length % 2 === 1) {
// 		answer = loss.pop();
// 		n -= 1;
// 	}

// 	for (let i = 0; i < n / 2; i += 1) {
// 		const sum = loss[i] + loss[loss.length - 1 - i];
// 		answer = sum > answer ? sum : answer;
// 	}

// 	return answer;
// }

