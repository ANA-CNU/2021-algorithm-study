const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [n, strings] = input;

// 문제 풀이
function solution(n, strings) {
	const split = strings.split(' ');
	const stack = [];
	const answer = [];

	for (let i = 0; i < n; i += 1) {
		const current = {
			index: i + 1,
			item: Number(split[i]),
		};
		
		// 스택에 아무것도 없을 때(처음 시작)에는 스택에 넣어주고 정답에 0을 넣어준다.
		if (stack.length === 0) {
			stack.push(current);
			answer.push(0);
			continue;
		}
		
		// 현재의 값이 스택의 TOP의 Item이 클 경우에
		if (stack[stack.length - 1].item < current.item) {
			// 스택이 빌 때 까지 반복문을 돈다.
			// 스택의 TOP이 현재의 값보다 같거나 클 경우 break로 빠져나온다. (레이저 신호를 수신)
			// 아닐 경우에는 계속 stack을 pop한다.
			while (stack.length) {
				if (stack[stack.length - 1].item >= current.item) {
					break;
				} else {
					stack.pop();
				}
			}
			answer.push(!stack.length ? 0 : stack[stack.length - 1].index); // 정답 배열에는 스택의 길이에 따라 답을 넣어준다. (0 or stack의 TOP)
			stack.push(current); // 스택에는 현재 값을 넣어준다.
		} else { // 현재의 값이 스택의 TOP의 Item이 작을 경우에
			answer.push(!stack.length ? 0 : stack[stack.length - 1].index); // 정답 배열에는 스택의 길이에 따라 답을 넣어준다. (0 or stack의 TOP)
			stack.push(current); // 스택에는 현재 값을 넣어준다.
		}
	}

	return answer.join(' ');
}

// 제출
const answer = solution(n, strings);
console.log(answer);
