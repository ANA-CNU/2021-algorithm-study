const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

const [n, ...nums] = input;
const numbers = nums.map(i => Number(i));

// 문제 풀이
function solution(n, numbers) {
	const stack = [];
	let answer = '';
	let count = 1;

	for (let i = 0; i < n; i += 1) {
		const number = numbers.shift();
		
		while (count <= number) {
			stack.push(count++);
			answer += '+ ';
		}

		const popedItem = stack.pop();
		if (popedItem !== number) {
			return 'NO';
		}
		answer += '- ';
	}

	return answer.split(' ').join('\n');
}

// 제출
const answer = solution(n, numbers);
console.log(answer);
