const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
let [n, ...routes] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n");

n = +n;
routes = routes.map((i) => i.split(" ").map(Number));

function solution(n, routes) {}

const answer = solution(n, routes);
console.log(answer);
