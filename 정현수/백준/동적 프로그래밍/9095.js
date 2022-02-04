const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const [T, ...numbers] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n")
  .map(Number);

function solution(T, numbers) {
  const memo = [...Array(11)];

  memo[1] = 1;
  memo[2] = 2;
  memo[3] = 4;

  // n은 10까지니까 10까지만 저장
  for (let i = 4; i < 11; i += 1) {
    memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
  }

  // 정답 출력
  for (let i = 0; i < T; i += 1) {
    console.log(memo[numbers[i]]);
  }
}

solution(T, numbers);
