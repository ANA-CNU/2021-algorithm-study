const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const [N, K] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n")[0]
  .split(" ")
  .map(Number);

function solution(N, K) {
  const array = Array.from({ length: N }, (_, i) => i + 1);
  const answer = [];
  let count = 0;

  while (array.length) {
    count = (count + K - 1) % array.length;
    answer.push(array[count]);
    array.splice(count, 1);
  }

  return `<${answer.join(", ")}>`;
}

const answer = solution(N, K);
console.log(answer);
