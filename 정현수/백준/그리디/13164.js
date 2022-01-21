const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, tall] = input;
const [N, K] = n.split(' ').map(i => +i);
tall = tall.split(' ').map(i => +i);

// 문제 풀이
function solution(N, K, tall) {
	let answer = 0;
	const diff = [];

	// 각 원소들의 차이를 구해서 배열에 넣습니다.
	for (let i = 0; i < N - 1; i += 1) {
		diff.push(tall[i + 1] - tall[i]);
	}

	// 차이 배열을 오름차순 정렬합니다.
	diff.sort((a, b) => a - b);

	for (let i = 0; i < diff.length - (K - 1); i += 1) {
		answer += diff[i];
	}

	return answer;
}

// 제출
const answer = solution(N, K, tall);
console.log(answer);
