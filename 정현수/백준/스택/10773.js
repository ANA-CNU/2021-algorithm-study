const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
[n, ...numbers] = input;
n = Number(n);
numbers = numbers.map((i) => Number(i));
solution(n, numbers);

// 문제 풀이
function solution(n, numbers) {
	let stack = [];
	for (let i = 0; i < n; i += 1) {
		if (numbers[i] === 0) stack.pop();
		else {
			stack.push(numbers[i]);
		}
	}
	let answer = stack.length ? stack.reduce((acc, item) => acc + item, 0) : 0;
	console.log(answer);
}
