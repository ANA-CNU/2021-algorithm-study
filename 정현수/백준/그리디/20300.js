const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...loss] = input;
n = +n;
loss = loss[0].split(' ').map(i => BigInt(i));

// 문제 풀이
function solution(n, loss) {
	let answer = 0;
    loss.sort((a, b) => a < b ? -1 : 1);

	if (loss.length % 2 === 1) {
		answer = loss.pop();
		n -= 1;
	}

	for (let i = 0; i < n / 2; i += 1) {
		const sum = loss[i] + loss[loss.length - 1 - i];
		answer = sum > answer ? sum : answer;
	}

	return answer;
}

// 제출
const answer = solution(n, loss);
console.log(String(answer));
