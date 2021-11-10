////////////////////////////////////////////////////////////////
// Boiler plate code of stack.
class Stack {
  constructor() {
    this.stackData = [];
  }

  peek() {
    return this.stackData[this.stackData.length - 1];
  }

  push(value) {
    this.stackData.push(value);
  }

  pop() {
    return this.stackData.pop();
  }
}
//////////////////////////////////////////////////////////////////

class Queue {
  constructor() {
    this.queueDataStack = new Stack();
  }

  peek() {
    return this.queueDataStack.peek();
  }

  enqueue(value) {
    const tempStack = new Stack();
    while (this.queueDataStack.peek()) {
      tempStack.push(this.queueDataStack.pop());
    }
    tempStack.push(value);
    while (tempStack.peek()) {
      this.queueDataStack.push(tempStack.pop());
    }
  }

  dequeue() {
    return this.queueDataStack.pop();
  }
}

// tests

const myQueue = new Queue();
console.log(myQueue.peek());
myQueue.enqueue('Michael');
console.log(myQueue.peek());
myQueue.enqueue('Dwight');
myQueue.enqueue('Jim');
console.log(JSON.stringify(myQueue));
console.log(myQueue.dequeue());
console.log(JSON.stringify(myQueue));
console.log(myQueue.dequeue());
console.log(myQueue.dequeue());
console.log(JSON.stringify(myQueue));
