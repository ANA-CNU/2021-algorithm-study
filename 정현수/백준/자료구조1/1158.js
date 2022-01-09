const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

const [n, k] = input[0].split(' ');

// 문제 풀이
function solution(n, k) {
	const queue = [];
	const answer = [];
	for (let i = 0; i < n; i += 1) queue.push(i + 1);
	
	let count = 1;
	while (queue.length) {
		const shiftItem = queue.shift();
		if (count % k === 0) {
			answer.push(shiftItem);
		} else {
			queue.push(shiftItem);
		}
		count += 1;
	}

	console.log(`<${answer.join(', ')}>`);
}

// 제출
solution(n, k);
