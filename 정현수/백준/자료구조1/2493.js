const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, strings] = input;

// 문제 풀이
function solution(n, strings) {
	const split = strings.split(' ');
	const stack = [];
	const answer = [];

	for (let i = 0; i < n; i += 1) {
		const current = {
			index: i + 1,
			item: Number(split[i]),
		};
		
		if (stack.length === 0) {
			stack.push(current);
			answer.push(0);
			continue;
		}
		
		if (stack[stack.length - 1].item < current.item) {
			while (stack.length) {
				if (stack[stack.length - 1].item >= current.item) {
					break;
				} else {
					stack.pop();
				}
			}
			if (!stack.length) {
				answer.push(0);
			} else {
				answer.push(stack[stack.length - 1].index);
			}
			stack.push(current);
		} else {
			if (!stack.length) {
				answer.push(0);
			} else {
				answer.push(stack[stack.length - 1].index);
			}
			stack.push(current);
		}
	}

	return answer.join(' ');
}

// 제출
const answer = solution(n, strings);
console.log(answer);
