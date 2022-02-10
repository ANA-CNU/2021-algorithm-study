const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
let [n, ...routes] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n");

n = +n;
routes = routes.map((i) => i.split(" ").map(Number));

function solution(n, routes) {
  const dp = new Array(n).fill(null).map(() => new Array(n).fill(BigInt(0)));
  dp[0][0] = 1;

  for (let i = 0; i < n; i += 1) {
    for (let j = 0; j < n; j += 1) {
      if (dp[i][j] === 0 || (i === n - 1 && j === n - 1)) continue;

      const jump = routes[i][j];
      const right = j + jump;
      const down = i + jump;

      if (down < n) dp[down][j] += BigInt(dp[i][j]);
      if (right < n) dp[i][right] += BigInt(dp[i][j]);
    }
  }

  return dp[n - 1][n - 1].toString();
}

const answer = solution(n, routes);
console.log(answer);
