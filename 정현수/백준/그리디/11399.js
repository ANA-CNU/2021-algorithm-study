const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
[n, arr] = input;
n = Number(n);
arr = arr.split(" ").map((i) => Number(i));
solution(n, arr);

// 문제 풀이
function solution(n, times) {
	let answer = 0;
	let temp = 0;
	times = times.sort((a, b) => a - b);
	for (let i = 0; i < n; i++) {
		temp += times[i];
		answer += temp;
	}
	console.log(answer);
}
