const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...arr] = input;
const cityAndPeople = arr.map(i => i.split(' ').map(j => +j));

// 문제 풀이:
function solution(n, cityAndPeople) {
	// 마을 번호를 오름차순 정렬한다.
	cityAndPeople.sort((a, b) => a[0] - b[0]);

	// 각 마을에 있는 인구수를 전부 합쳐서 변수에 저장한다.
	const peopleCount = cityAndPeople.reduce((acc, cur) => acc + cur[1], 0);
	let sum = 0;

	// 마을을 돌면서, 전체 인구수의 절반을 넘거나 같은 지점이 우체국을 놓는 지점이다.
	for (let i = 0; i < n; i += 1) {
		sum += cityAndPeople[i][1];
		if (peopleCount / 2 <= sum) return cityAndPeople[i][0];
	}

	return cityAndPeople[cityAndPeople.length - 1][0];
}

// 제출
const answer = solution(n, cityAndPeople);
console.log(answer);
