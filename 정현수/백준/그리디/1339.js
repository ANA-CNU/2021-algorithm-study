const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

const n = Number(input[0]);
const list = input.slice(1);

// 문제 풀이
function solution(n, list) {
	let hashMap = new Map();
	let count = 0;
	let answer = 0;
	let current = 9;

	for (let i = 0; i < n; i += 1) {
		for (let j = 0; j < list[i].length; j += 1) {
			count = Math.pow(10, list[i].length - (j + 1));
			hashMap.set(list[i][j], (hashMap.get(list[i][j]) || 0) + count);
		}
	}
	
	const sortMap = new Map([...hashMap.entries()].sort((a, b) => b[1] - a[1]));

	for (let [_, alphabetValue] of sortMap) {
		answer += current * alphabetValue;
		current -= 1;
	}

	console.log(answer);
}

// 제출
solution(n, list);
