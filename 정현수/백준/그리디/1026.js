const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");
const n = Number(input[0]);
const A = input[1].split(' ').map(i => Number(i));
const B = input[2].split(' ').map(i => Number(i));

// 문제 풀이
function solution(n, A, B) {
	const sortA = A.sort((a, b) => a - b);
	const sortB = B.sort((a, b) => b - a);
	let S = 0;

	for (let i = 0; i < n; i += 1) {
		S += sortA[i] * sortB[i];
	}

	console.log(S);
}

// 제출
solution(n, A, B);
