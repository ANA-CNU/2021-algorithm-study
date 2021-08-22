const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
[n, distances, cities] = input;
n = Number(n);
distances = distances.split(" ").map((i) => BigInt(i));
cities = cities.split(" ").map((i) => BigInt(i));
solution(n, distances, cities);

// 문제 풀이
function solution(n, distances, cities) {
	let answer = 0n;
	let nowOliPrice = cities[0];

	for (let i = 0; i < distances.length; i += 1) {
		answer += nowOliPrice * distances[i];

		if (nowOliPrice > cities[i + 1]) nowOliPrice = cities[i + 1];
	}

	console.log(String(answer));
}
