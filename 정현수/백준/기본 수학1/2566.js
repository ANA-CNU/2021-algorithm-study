const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n")
  .map((row) => row.split(" ").map(Number));

function solution(input) {
  let max = 0;
  let maxPos = "";

  for (let i = 0; i < input.length; i += 1) {
    for (let j = 0; j < input[0].length; j += 1) {
      if (max < input[i][j]) {
        max = Math.max(input[i][j], max);
        maxPos = `${i + 1} ${j + 1}`;
      }
    }
  }

  console.log(max);
  console.log(maxPos);
}

solution(input);
