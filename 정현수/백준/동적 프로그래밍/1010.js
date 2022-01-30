const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

// console.log(input);

const [count, ...T] = input;

// 문제 풀이:
function solution(count, T) {
  for (let i = 0; i < count; i += 1) {
    const [N, M] = T[i].split(' ');
    console.log(parseInt(factorial(M) / (factorial(N) * factorial(M - N)) + 0.5));
  }
}

function factorial(num) {
  if (num === 1 || num === 0) {
      return 1;
  }
  return num * factorial(num - 1);
};

// 제출
solution(count, T);
