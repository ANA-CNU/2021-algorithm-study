const fs = require('fs');

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = 'input.txt';

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

// 문제 풀이
function solution(input) {
	[n, ...person] = input;
	let count = [];

	for (let i = 0; i < n; i++) {
		let rank = 0;
		for (let j = 0; j < n; j++) {
			if (i === j) continue;
			[aWeight, aTall] = person[i].split(' ');
			[bWeight, bTall] = person[j].split(' ');

			if (Number(aWeight) < Number(bWeight) && Number(aTall) < Number(bTall))
				rank += 1;
		}
		count.push(rank + 1);
	}
	return count.join(' ');
}

// 제출
console.log(solution(input));
