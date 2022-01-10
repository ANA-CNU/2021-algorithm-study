const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

const [n, expression, ...nums] = input;
const numbers = nums.map(i => Number(i));

// 문제 풀이
function solution(n, expression, numbers) {
	let ASCII = 65;
	const stack = [];
	const operators = ['-', '/', '+', '*'];
	const transformer = {};

	const calculator = {
		'+': (a, b) => a + b,
		'-': (a, b) => a - b,
		'*': (a, b) => a * b,
		'/': (a, b) => a / b,
	};

	for (let i = 0; i < n; i += 1) {
		const alphabet = String.fromCharCode(ASCII++);
		transformer[alphabet] = numbers[i];
	}

	const transformExpression = expression.split('').map(value => !operators.includes(value) ? transformer[value] : value);

	for (let i = 0; i < transformExpression.length; i += 1) {
		let pushValue = transformExpression[i];
		if (operators.includes(pushValue)) {
			const secondValue = stack.pop();
			const firstValue = stack.pop();
			const calculateFunction = calculator[pushValue];
			pushValue = calculateFunction(firstValue, secondValue);
		}
		stack.push(pushValue);
	}

	return (Math.floor(stack[0] * 100) / 100).toFixed(2);
}

// 제출
const answer = solution(n, expression, numbers);
console.log(answer);
