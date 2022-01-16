const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");


// 문제 풀이
function solution(poketmons, questions) {
	
}

// 제출
solution(poketmons, questions);
