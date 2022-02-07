const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const input = require("fs").readFileSync(path).toString().trim().split("\n");

class Node {
  constructor(item) {
    this.item = item;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  push(item) {
    const node = new Node(item);
    if (!this.tail) {
      this.tail = node;
    } else {
      this.head.next = node;
    }
    this.head = node;
    this.size += 1;
  }

  pop() {
    if (!this.getSize()) {
      return -1;
    } else {
      const poped = this.tail.item;
      this.tail = this.tail.next;
      this.size -= 1;
      return poped;
    }
  }

  getSize() {
    return this.size;
  }

  front() {
    return this.getSize() ? this.tail.item : -1;
  }

  back() {
    return this.getSize() ? this.head.item : -1;
  }

  empty() {
    return this.getSize() ? 0 : 1;
  }
}

function solution(input) {
  const queue = new Queue();
  const answer = [];

  for (let i = 1; i < input.length; i += 1) {
    const command = input[i].split(" ")[0];

    switch (command) {
      case "push":
        queue.push(input[i].split(" ")[1]);
        break;
      case "pop":
        answer.push(queue.pop());
        break;
      case "front":
        answer.push(queue.front());
        break;
      case "back":
        answer.push(queue.back());
        break;
      case "size":
        answer.push(queue.getSize());
        break;
      case "empty":
        answer.push(queue.empty());
        break;
    }
  }

  return answer.join("\n");
}

const answer = solution(input);
console.log(answer);
