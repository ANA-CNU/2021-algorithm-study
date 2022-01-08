const fs = require("fs");

// 백준 제출 할 때 주석 제거
// const readFileSyncAddress = '/dev/stdin';

// VSC 테스트 할 때 주석 제거
const readFileSyncAddress = "input.txt";

const input = fs.readFileSync(readFileSyncAddress).toString().trim().split("\n");

let [n, ...list] = input;
list = list.map(i => Number(i));

class Heap {
	constructor(){
		this.items = [];
	}

	//값을 서로 바꾸는 메소드
	swap(index1, index2){
		let temp = this.items[index1]; // items의 index1의 값을 temp(임시공간)에 담음
		this.items[index1] = this.items[index2]; // index1에 index2의 값을 저장
		this.items[index2] = temp; // index2에 아까 index1의 값을 temp에 넣어놓은 값을 저장
	}

	//부모 인덱스 구하는 메소드
	findParentIndex(index){
		return Math.floor((index-1) / 2);
	}

	//왼쪽 자식 인덱스 구하는 메소드
	findLeftChildIndex(index){
		return index * 2 + 1;
	}

	//오른쪽 자식 인덱스 구하는 메소드
	findRightChildIndex(index){
		return index * 2 + 2;
	}

	//부모 노드 구하는 메소드
	findParent(index){
		return this.items[this.findParentIndex(index)];
	}

	//왼쪽 자식 노드 구하는 메소드
	findLeftChild(index){
		return this.items[this.findLeftChildIndex(index)];
	}

	//오른쪽 자식 노드 구하는 메소드
	findRightChild(index){
		return this.items[this.findRightChildIndex(index)];
	}

	//최대 힙의 경우 최댓값을 반환하고 최소 힙의 경우 최솟값을 반환하는 메소드
	peek(){
		return this.items[0];
	}

	//힙의 크기(항목 개수)를 반환하는 메소드
	size(){
		return this.items.length;
	}
}

class MinHeap extends Heap {
	// MinHeap 클래스는 Heap 클래스를 상속받았으므로 Heap 클래스의 메소드를 모두 사용할 수 있다.
	bubbleUp(){
		let index = this.items.length-1;
		while(this.findParent(index) !==undefined && this.findParent(index) > this.items[index]){
				this.swap(index, this.findParentIndex(index));
				index = this.findParentIndex(index);
		}
	}

	bubbleDown(){
		let index = 0;
		while(this.findLeftChild(index) !==undefined && (this.findLeftChild(index) < this.items[index] || this.findRightChild(index) < this.items[index])){
			let smallerIndex = this.findLeftChildIndex(index);
			if(this.findRightChild(index) !==undefined && this.findRightChild(index) < this.items[smallerIndex]){
					smallerIndex = this.findRightChildIndex(index);
			}
			this.swap(index, smallerIndex);
			index = smallerIndex;
		}
	}

	// 힙에 원소를 추가하는 함수
	add(item){
		this.items[this.items.length] = item;
		this.bubbleUp();
	}

	// 힙에서 원소를 빼내는 함수
	// 최소 힙이라면 최솟값이 빠져나올 것이고 최대힙이라면 최댓값이 빠져나온다.
	poll(){
		let item = this.items[0]; // 첫번째 원소 keep
		this.items[0] = this.items[this.items.length - 1]; // 맨 마지막 원소를 첫번째 원소로 복사
		this.items.pop(); // 맨 마지막 원소 삭제
		this.bubbleDown();
		return item; // keep해둔 값 반환
	}
}

// 문제 풀이
function solution(n, list) {
	let minHeap = new MinHeap();
	let compareCount = 0;
	let beforeCount = 0;

	for (let i = 0; i < n; i += 1) {
		minHeap.add(list[i]);
	}

	for (let i = 0; i < n - 1; i += 1) {
		const first = minHeap.poll();
		const second = minHeap.poll();

		beforeCount = first + second;
		minHeap.add(beforeCount);
		compareCount += beforeCount;
	}

	console.log(compareCount);
}

// 제출
solution(n, list);
