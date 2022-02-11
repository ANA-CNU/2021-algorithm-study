const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
let [T, ...cases] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n");

function solution(T, cases) {
  for (let i = 0; i < T; i += 1) {
    const n = cases[i * 3];
    const line1 = cases[i * 3 + 1].split(' ').map(Number);
    const line2 = cases[i * 3 + 2].split(' ').map(Number);

    const dp = [[0, line1[0], line2[0]]];
    for (let j = 1; j < n; j += 1) {
      dp[j] = [
        Math.max(...dp[j - 1]),
        Math.max(dp[j - 1][0], dp[j - 1][2]) + line1[j],
        Math.max(dp[j - 1][0], dp[j - 1][1]) + line2[j],
      ];
    }

    console.log(Math.max(...dp[n - 1]));
  }
}

solution(T, cases);
