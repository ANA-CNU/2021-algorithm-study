const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, ...times] = input;
n = +n;
times = times.map(i => { return { start: i.split(' ')[0], end: i.split(' ')[1] } });

// 문제 풀이:
function solution(n, times) {
	let rooms = 0;
	let max = 0;
	const startTimes = times.map(time => { return { time: +time.start, isStart: 1 } });
	const endTimes = times.map(time => { return { time: +time.end, isStart: -1 } });
	const sortedTimes = [...startTimes, ...endTimes].sort((a, b) => a.time === b.time ? a.isStart - b.isStart : a.time - b.time);

	sortedTimes.forEach(time => {
		rooms = time.isStart === 1 ? rooms + 1 : rooms - 1;
		if (max <= rooms) max = rooms;
	});

	return max;
}

// 제출
const answer = solution(n, times);
console.log(answer);
