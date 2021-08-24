const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
[n, ...strings] = input;
n = Number(n);
solution(n, strings);

// 문제 풀이
function solution(n, strings) {
	for (let i = 0; i < n; i += 1) {
		const string = strings[i];
		const stack = [];
		let result = "YES";

		for (let j = 0; j < string.length; j += 1) {
			if (string[j] === "(") stack.push(string[j]);
			else if (string[j] === ")") {
				if (!stack.pop()) {
					result = "NO";
					break;
				}
			}
		}

		if (stack.length !== 0) result = "NO";
		console.log(result);
	}
}
