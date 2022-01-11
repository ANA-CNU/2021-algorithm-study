const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, ...testcases] = input;

// 문제 풀이
function solution(n, testcases) {
	for (let i = 0; i < n; i += 1) {
		let count = 1;
		let M = Number(testcases[i * 2].split(' ')[1]);
		const queue = testcases[i * 2 + 1].split(' ').map(i => Number(i));

		while (1) {
			const shiftItem = queue.shift();
			if (Math.max(...queue) <= shiftItem && M === 0) {
				console.log(count);
				break;
			} else if (Math.max(...queue) > shiftItem && M === 0) {
				queue.push(shiftItem);
				M = queue.length - 1;
			} else if (Math.max(...queue) > shiftItem) {
				queue.push(shiftItem);
				M -= 1;
			} else if (Math.max(...queue) <= shiftItem) {
				count += 1;
				M -= 1;
			}
		}
	}
}

// 제출
solution(n, testcases);
