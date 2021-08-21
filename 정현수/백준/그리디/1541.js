const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
input = input[0];
solution(input);

// 문제 풀이
function solution(arr) {
	const splitted = arr.split("-");
	let answer = 0;
	if (splitted[0].includes("+")) {
		answer += splitted[0]
			.split("+")
			.reduce((acc, item) => Number(acc) + Number(item), 0);
	} else {
		answer = Number(splitted[0]);
	}

	for (let i = 1; i < splitted.length; i += 1) {
		if (splitted[i].includes("+")) {
			const splittedFromPlus = splitted[i].split("+");
			const sum = splittedFromPlus.reduce(
				(acc, item) => Number(acc) + Number(item),
				0
			);
			answer -= sum;
		} else {
			answer -= Number(splitted[i]);
		}
	}

	console.log(answer);
}
