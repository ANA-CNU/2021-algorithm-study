const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [a, b] = input[0].split(' ');
const A = +a;
const B = +b;

// 문제 풀이:
// B를 생각한다. 끝자리가 1이 될 때까지 2로 나누고,
// 1이 되면 1을 빼고 다시 2로 나누기 시작한다.
function solution(A, B) {
	let answer = 0;

	while (A !== B) {
		if (A > B) {
			return -1;
		} else if (getLastPositionNumber(B) === 1) {
			B = removeOneOfLastPosition(B);
			answer += 1;
		} else if (getLastPositionNumber(B) !== 1) {
			B /= 2;
			answer += 1;
		}
	}

	return answer + 1;
}

function getLastPositionNumber(number) {
	return Number(String(number).split('')[String(number).split('').length - 1]);
}

function removeOneOfLastPosition(number) {
	const spliited = String(number).split('');
	spliited.pop();
	return Number(spliited.join(''));
}

// 제출
const answer = solution(A, B);
console.log(answer);
