const iter = 100000;
let start = new Date();
let end = new Date();

// const arr = [];

// start = new Date();
// for (let i = 0; i < iter; i += 1) arr.push(i);
// end = new Date();

// console.log(`array push ${iter}: ${end - start}ms`);

// start = new Date();
// for (let i = 0; i < iter; i += 1) arr.pop();
// end = new Date();

// console.log(`array pop ${iter}: ${end - start}ms`);

// start = new Date();
// for (let i = 0; i < iter; i += 1) arr.shift();
// end = new Date();

// console.log(`array shift ${iter}: ${end - start}ms`);

class Node {
	constructor(item) {
		this.item = item;
		this.prev = null;
	}
}

class Stack {
	constructor() {
		this.top = null;
		this.size = 0;
	}

	push(item) {
		const node = new Node(item);
		if (!this.size) this.top = node;
		else {
			node.prev = this.top;
			this.top = node;
		}
		this.size += 1;
	}

	pop() {
		if (!this.size) return null;
		
		const pop = this.top;
		this.top = this.top.prev;
		this.size -= 1;
		return pop.item;
	}

	getTop() {
		return this.top ? this.top.item : null;
	}
}

const stack = new Stack();

start = new Date();
for (let i = 0; i < iter; i += 1) {
	stack.push(i);
}
end = new Date();

console.log(`stack push ${iter}: ${end - start}ms`);

start = new Date();
for (let i = 0; i < iter; i += 1) {
	stack.pop();
}
end = new Date();

console.log(`stack pop ${iter}: ${end - start}ms`);


function App() {
	return (
		<h1>Hello, GodDaeHee!</h1>
	);
} 

function App() {
	return React.createElement("h1", null, "Hello, GodDaeHee!");
}
