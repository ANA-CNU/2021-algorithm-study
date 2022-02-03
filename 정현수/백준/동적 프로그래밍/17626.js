const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const [n] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n")
  .map(Number);

function solution(n) {
  const memo = new Array(n + 1).fill(0);
  memo[1] = 1;

  for (let i = 2; i <= n; i += 1) {
    let min = 4;
    for (let j = 1; j * j <= i; j += 1) {
      min = Math.min(min, memo[i - j * j]);
    }
    memo[i] = min + 1;
  }
  
  return memo[n];
}

const answer = solution(n);
console.log(answer);
