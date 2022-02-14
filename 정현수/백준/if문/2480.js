const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const [first, second, third] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n")[0]
  .split(" ")
  .map(Number);

function solution(first, second, third) {
  const set = new Set([first, second, third]);

  if (set.size === 1) {
    return 10000 + first * 1000;
  } else if (set.size === 2) {
    if (first === second || first === third) {
      return 1000 + first * 100;
    } else if (second === third) {
      return 1000 + second * 100;
    }
  } else if (set.size === 3) {
    return Math.max(first, second, third) * 100;
  }
}

const answer = solution(first, second, third);
console.log(answer);
