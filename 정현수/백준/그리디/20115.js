const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...drinks] = input;
n = +n;
drinks = drinks[0].split(' ').map(i => Number(i));

// 문제 풀이
function solution(n, drinks) {
	drinks.sort((a, b) => a - b);

	for (let i = 0; i < n - 1; i += 1) {
		const larger = drinks.pop();
		drinks.push(larger + (drinks.pop() / 2));
	}

	return drinks[0];
}

// 제출
const answer = solution(n, drinks);
console.log(answer);
