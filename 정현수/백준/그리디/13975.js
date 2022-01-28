const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

// console.log(input);

const [testcaseCount, ...testcases] = input;

class MinHeap {
  constructor() {
    this.heap = [null];
  }

  push(value) {
    this.heap.push(value);
    let curIndex = this.heap.length - 1;
    let parentIndex = Math.floor(curIndex / 2);

    while (parentIndex !== 0 && this.heap[parentIndex] > value) {
      const temp = this.heap[parentIndex];
      this.heap[parentIndex] = value;
      this.heap[curIndex] = temp;

      curIndex = parentIndex;
      parentIndex = Math.floor(curIndex / 2);
    }
  }

  pop() {
    if (this.heap.length === 2) return this.heap.pop();
    const returnValue = this.heap[1];
    this.heap[1] = this.heap.pop();

    let curIndex = 1;
    let leftIndex = 2;
    let rightIndex = 3;
    while (
      this.heap[curIndex] > this.heap[leftIndex] ||
      this.heap[curIndex] > this.heap[rightIndex]
    ) {
      if (this.heap[leftIndex] > this.heap[rightIndex]) {
        // 왼쪽과 부모를 교환
        const temp = this.heap[curIndex];
        this.heap[curIndex] = this.heap[rightIndex];
        this.heap[rightIndex] = temp;
        curIndex = rightIndex;
      } else {
        const temp = this.heap[curIndex];
        this.heap[curIndex] = this.heap[leftIndex];
        this.heap[leftIndex] = temp;
        curIndex = leftIndex;
      }
      leftIndex = curIndex * 2;
      rightIndex = curIndex * 2 + 1;
    }
    return returnValue;
  }
  isEmpty() {
    return this.heap.length === 2;
  }
}

// 문제 풀이:
function solution(testcaseCount, testcases) {
	for (let i = 0; i < testcaseCount; i += 1) {
		const heap = new MinHeap();
		testcases[(i * 2) + 1].split(' ').forEach(i => heap.push(+i));
		let answer = 0;
		
		while (!heap.isEmpty()) {
			const addFileSize = heap.pop() + heap.pop();
			answer += addFileSize;
			heap.push(addFileSize);
		}

		console.log(answer);
	}
}

// 제출
solution(testcaseCount, testcases);
