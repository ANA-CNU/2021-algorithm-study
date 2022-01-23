const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const string = input[0];

// 문제 풀이:
function solution(string) {
	const splited = string.split('');
	const maximum = findMaximum(splited);
	const minimum = findMinimum(splited);
	console.log(maximum);
	console.log(minimum);
}

function findMaximum(string) {
	let stack = [];
	let number = '';

	for (let i = 0; i < string.length; i += 1) {
		const item = string[i];

		if (item === 'M') {
			stack.push(item);
			continue;
		}

		if (item === 'K') {
			// const pushItme = stack.length ? String(5 * (10 ** stack.length)) : 5;
			if (stack.length) {
				number += '5';
				for (let i = 0; i < stack.length; i += 1) {
					number += '0';
				}
			} else {
				number += '5';
			}
			stack = [];
		}
	}

	if (stack.length) stack.forEach(_ => number += '1');
	return number;
}

function findMinimum(string) {
	let stack = [];
	let number = '';

	for (let i = 0; i < string.length; i += 1) {
		const item = string[i];

		if (item === 'M') {
			stack.push(item);
			continue;
		}

		if (item === 'K') {
			if (!stack.length) {
				number += '5';
			} else {
				number += '1';
				for (let i = 0; i < stack.length - 1; i += 1) {
					number += '0';
				}
				// number += (String(10 ** (stack.length - 1)));
				number += '5';
				stack = [];
			}
		}
	}

	if (stack.length) {
		number += '1';
		for (let i = 0; i < stack.length - 1; i += 1) {
			number += '0';
		}
	}
	return number;
}

// 제출
solution(string);
