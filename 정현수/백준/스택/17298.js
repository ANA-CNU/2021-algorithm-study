const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
[n, ...numbers] = input;
n = Number(n);
numbers = numbers[0].split(" ").map((i) => Number(i));
solution(n, numbers);

// 문제 풀이
function solution(n, numbers) {
	// 3 5 2 7
	let stack = [];
	for (let i = 0; i < n; i += 1) {
		while (stack.length && numbers[stack[stack.length - 1]] < numbers[i]) {
			numbers[stack.pop()] = numbers[i];
		}
		stack.push(i);
	}

	while (stack.length) {
		numbers[stack.pop()] = -1;
	}

	console.log(numbers.join(" "));
}
