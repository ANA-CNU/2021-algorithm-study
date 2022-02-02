const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = +input[0];
const numbers = input[1].split(' ').map(Number);

// 문제 풀이:
function solution(n, numbers) {
  const min = numbers.sort((a, b) => b - a).pop();
  let answer = [];

  for (let i = 1; i < min + 1; i += 1) {
    if (min % i === 0) answer.push(i);
  }

  for (let i = 0; i < n - 1; i += 1) {
    for (let j = 0; j < answer.length; j += 1) {
      if (numbers[i] % answer[j] !== 0) answer[j] = 0;
    }
  }

  
  return answer.filter(i => i).join('\n');
}

// 제출
const answer = solution(n, numbers);
console.log(answer);
