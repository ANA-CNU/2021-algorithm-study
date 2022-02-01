const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

// console.log(input);

const n = +input[0];
const find = +input[1];

// 문제 풀이:
function solution(n, find) {
  const start = Math.floor(n / 2);
  const arr = []; 
  let x = start;
  let y = start;
  let findAnswer = '';
  let count = 1;
  let rowAddCount = 1; // 한 방향에 몇 개의 변수를 추가해야 하는지 보는 변수
  let rowCount = 0; // 한 방향에 몇 개의 변수가 추가 됐는지 확인하는 변수
  let direction = 'up';

  // 배열 만들기
  for (let i = 0; i < n; i += 1) {
    const tempArray = [];
    for (let j = 0; j < n; j += 1) {
      tempArray.push(0);
    }
    arr.push(tempArray);
  }

  // 1. 배열 채우기
  // 2. 방향에 따라 x, y 바꾸기
  // 3. 방향 바꾸기
  while ((n * n) + 1 !== count) {
    switch (direction) {
      case 'left':
        arr[x][y--] = count;
        rowCount += 1;
        if (rowCount === rowAddCount) {
          direction = 'up';
          rowCount = 0;
          rowAddCount += 1;
        }
        break;
      case 'up':
        arr[x--][y] = count;
        rowCount += 1;
        if (rowCount === rowAddCount) {
          direction = 'right';
          rowCount = 0;
        }
        break;
      case 'right':
        arr[x][y++] = count;
        rowCount += 1;
        if (rowCount === rowAddCount) {
          direction = 'down';
          rowCount = 0;
          rowAddCount += 1;
        }
        break;
      case 'down':
        arr[x++][y] = count;
        rowCount += 1;
        if (rowCount === rowAddCount) {
          direction = 'left';
          rowCount = 0;
        }
        break;
    }
    count += 1;

    if (count === find) {
      findAnswer = `${x + 1} ${y + 1}`;
    }
  }

  // 정답 출력
  for (let i = 0; i < arr.length; i += 1) {
    console.log(arr[i].join(' '));
  }
  console.log(findAnswer);
}

// 제출
solution(n, find);
