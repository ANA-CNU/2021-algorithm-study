const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [strings] = input;

// 문제 풀이
function solution(strings) {
	const string = strings.split('');
	const stack = [];

	if (!checkPossible(string)) {
		return 0;
	}

	for (let i = 0; i < string.length; i += 1) {
		let top = stack[stack.length - 1];
		const cur = string[i];

		if (cur === '(' || cur === '[') {
			stack.push(cur);
		} else if (cur === ')' || cur === ']') {
			const reverse = cur === ')' ? '(' : '[';
			const point = reverse === '(' ? 2 : 3;

			if (top === reverse) {
				stack.pop();
				stack.push(point);
			} else {
				let temp = 0;
				while (1) {
					const pop = stack.pop();
					if (typeof pop === 'number') {
						temp += pop;
					} else if (pop === reverse) {
						stack.push(temp * point);
						break;
					}
				}
			}
		}
	}
	return stack.reduce((acc, cur) => acc + cur);
}

function checkPossible(string) {
	const stack = [];
	for (let i = 0; i < string.length; i += 1) {
		let top = stack[stack.length - 1];
		const cur = string[i];

		if (cur === ']' && top === '[') {
			stack.pop();
		} else if (cur === ')' && top === '(') {
			stack.pop();
		} else {
			stack.push(cur);
		}
	}

	return stack.length ? false : true;
}

// 제출
const answer = solution(strings);
console.log(answer);
