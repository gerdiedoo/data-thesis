class HashTable {
  constructor(size) {
    this.data = new Array(size);
  }

  set(key, value) {
    const address = this._hash(key);
    if (!this.data[address]) {
      this.data[address] = [];
    }
    this.data[address].push([key, value]);
    return this.data;
  }

  get(key) {
    const address = this._hash(key);
    const currentBucket = this.data[address];
    if(currentBucket) {
      for(let i = 0; i < currentBucket.length; i++) {
        if(currentBucket[i][0] === key) {
          return currentBucket[i][1];
        }
      }
    }
    return undefined;
  }

  keys() {
    const keysArray = [];
    for(let i = 0; i < this.data.length; i++) {
      if(this.data[i]) {
        for(let j = 0; j < this.data[i].length; j++) {
          keysArray.push(this.data[i][j][0]);
        }
      }
    }
    return keysArray;
  }

  // A made up hash function.
  // Practically hashing a key takes O(1) time.
  _hash(key) {
    let hash = 0;
    for(let i = 0; i < key.length; i++) {
      hash = (hash + key.charCodeAt(i) * key.length) % this.data.length;
    }
    return hash;
  }
}

// test

const myHashTable = new HashTable(50);
console.log(myHashTable.set('grapes', 1000));
console.log(myHashTable.get('grapes'));
console.log(myHashTable.keys());
