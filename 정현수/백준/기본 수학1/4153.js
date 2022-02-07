const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n")
  .map((i) => i.split(" ").map(Number));

function solution(input) {
  for (let i = 0; i < input.length - 1; i += 1) {
    input[i].sort((a, b) => a - b);
    [a, b, c] = input[i];
    a ** 2 + b ** 2 === c ** 2 ? console.log("right") : console.log("wrong");
  }
}

solution(input);
