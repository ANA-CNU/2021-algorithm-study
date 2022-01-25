const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...times] = input;
n = +n;
times = times.map(i => i.split(' ').map(j => +j));

// 문제 풀이:
// 시작 시간과 끝 시간을 구분 지어 하나의 객체에 저장
// 객체를 돌면서 동시에 진행되고 있는 강의실이 몇 개인지 파악
function solution(n, times) {
	let answer = 0;
	let classroom = 0;
	const obj = [];
	
	for (let i = 0; i < n; i += 1) {
		obj.push({ time: times[i][0], start: 1 });
		obj.push({ time: times[i][1], start: -1 });
	}

	obj.sort((a, b) => a.time === b.time ? a.start - b.start : a.time - b.time);

	obj.forEach(schedule => {
		if (schedule.start === -1) {
			classroom -= 1;
		} else if (schedule.start === 1) {
			classroom += 1;
		}

		answer = classroom > answer ? classroom : answer;
	});

	return answer;
}

// 제출
const answer = solution(n, times);
console.log(answer);
