const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [string] = input;

// 문제 풀이
function solution(string) {
	const split = string.split('');
	const stack = [];
	let answer = '';

	// 괄호를 만났을 때
	for (let i = 0; i < split.length; i += 1) {
		const str = split[i];

		if (str === '(') {
			stack.push(str);
		} else if (str === ')') {
			while (stack.length && stack[stack.length - 1] !== '(') {
				answer += stack.pop();
			}
			stack.pop();
		} else if (str === '*' || str === '/') {
			while (stack.length && stack[stack.length - 1] === '*' || stack[stack.length - 1] === '/') {
				answer += stack.pop();
			}
			stack.push(str);
		} else if (str === '+' || str === '-') {
			while (stack.length && stack[stack.length - 1] !== '(') {
				answer += stack.pop();
			}
			stack.push(str);
		} else {
			answer += str;
		}
	}

	while (stack.length) {
		answer += stack.pop();
	}

	return answer;
}

// 제출
const answer = solution(string);
console.log(answer);
