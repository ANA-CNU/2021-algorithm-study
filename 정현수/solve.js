const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
[n, ...arr] = input;
n = Number(n);
arr = arr.map((i) => i.split(" ").map((v) => Number(v)));
solution(n, arr);

// 문제 풀이
function solution(n, times) {
	times = times.sort((a, b) => {
		if (a[1] - b[1] === 0) {
			return a[0] - b[0];
		}
		return a[1] - b[1];
	});
	let nowClass = times[0];
	let answer = 1;
	for (let i = 1; i < n; i++) {
		const temp = times[i];
		if (nowClass[1] <= temp[0]) {
			nowClass = times[i];
			answer += 1;
		}
	}

	console.log(answer);
}
