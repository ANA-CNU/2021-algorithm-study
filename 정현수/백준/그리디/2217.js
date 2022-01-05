const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

const N = Number(input[0]);
input.shift();
const ropes = input.map(i => Number(i));

// 문제 풀이
function solution(N, ropes) {
	const sortRopes = ropes.sort((a, b) => a - b);	
	const arr = [];

	for (let i = 0; i < N; i += 1) {
		arr.push(sortRopes[i] * (N - i));
	}

	console.log(Math.max(...arr));
}

// 제출
solution(N, ropes);
