const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, number] = input;
const [length, count] = n.split(' '); 

// 문제 풀이:
function solution(length, count, number) {
	const splited = number.split('');
	const stack = [];

	for (let i = 0; i < length; i += 1) {
		const current = splited[i];

		// 스택이 채워져 있고, 스택의 Top이 현재 값보다 작고, count값이 있을 때 반복문을 돈다.
		while (stack.length && stack[stack.length - 1] < current && count) {
			// 위의 조건들이 만족된다면, 스택에서 pop, count - 1을 한다.
			stack.pop();
			count -= 1;
		}
		stack.push(current);
	}

	// 반례
	// 2 1
	// 21
	for (let i = 0; i < count; i += 1) {
		stack.pop();
	}

	return stack.join('');
}

// 제출
const answer = solution(length, count, number);
console.log(answer);
