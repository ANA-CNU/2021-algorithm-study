const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let arr = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 인풋 처리
const open = ["(", "["];
const closed = [")", "]"];
let stack;
const yesno = [];
arr.slice(0, arr.length - 1).forEach((v) => {
	let isNo = false;
	stack = [];
	for (let i = 0; i < v.length; i++) {
		if (open.includes(v[i])) stack.push(v[i]);
		else if (closed.includes(v[i])) {
			if (stack.pop() !== open[closed.indexOf(v[i])]) {
				yesno.push("no");
				isNo = true;
				break;
			}
		}
	}
	if (!isNo) {
		if (stack.length === 0) yesno.push("yes");
		else yesno.push("no");
	}
});
console.log(yesno.join("\n"));
