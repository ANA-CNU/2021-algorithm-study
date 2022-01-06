const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

const n = input[0];

// 문제 풀이
function solution(n) {
	// 우선 0이 포함되어 있지 않으면 30의 배수가 아니다.
	if (!n.split('').includes('0')) {
		console.log('-1');
		return;
	}

	// 모든 자리의 수를 합하고, 그게 3으로 나누어지면 3의 배수이다.
	const numberSplitArray = n.split('').map(i => Number(i));
	const sumOfEachPosition = numberSplitArray.reduce((acc, cur) => acc + cur);
	
	if (sumOfEachPosition % 3 !== 0) console.log('-1');
	else console.log(numberSplitArray.sort((a, b) => b - a).join(''));
}

// 제출
solution(n);
