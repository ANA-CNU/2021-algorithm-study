const fs = require("fs");
// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';
// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

let input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

// 문제 풀이
class Node {
	constructor(value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}

class LinkedList {
	constructor() {
		this.head = null;
		this.tail = null;
		this._size = 0;
	}

	add(value) {
		const newNode = new Node(value);

		if (!this.head) {
			this.head = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
		}

		this.tail = newNode;
		this._size++;

		return newNode;
	}

	getHead() {
		return this.head.value;
	}

	removeHead() {
		this.head = this.head.next;
		this.head.prev = null;
		this._size--;
	}

	getSize() {
		return this._size;
	}
}

function solution(input) {
	const cards = new LinkedList();
	for (let i = 1; i <= input; i++) {
		cards.add(i);
	}
	while (cards.getSize() !== 1) {
		cards.removeHead();
		cards.add(cards.getHead());
		cards.removeHead();
	}

	return cards.getHead();
}

input = Number(input[0]);
const card = solution(input);
console.log(card);
