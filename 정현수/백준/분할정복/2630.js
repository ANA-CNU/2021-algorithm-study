const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

[number, ...paper] = input;
number = Number(number);
paper = paper.map((string) => string.split(" ").map((i) => Number(i)));

// 문제 풀이
function solution(number, paper) {
	let white = 0,
		blue = 0;
	function divide(x, y, length) {
		let tempCount = 0;
		for (let i = x; i < x + length; i += 1) {
			for (let j = y; j < y + length; j += 1) {
				if (paper[i][j]) tempCount += 1;
			}
		}

		if (!tempCount) {
			white += 1;
		} else if (tempCount === length * length) {
			blue += 1;
		} else {
			divide(x, y, length / 2);
			divide(x, y + length / 2, length / 2);
			divide(x + length / 2, y, length / 2);
			divide(x + length / 2, y + length / 2, length / 2);
		}
	}

	divide(0, 0, number);
	console.log(white);
	console.log(blue);
}

// 제출
solution(number, paper);
