function bubbleSort(array) {
  for (let i = 0; i < array.length; i++) {
    let swaps = 0;
    for (let j = 0; j < array.length - i; j++) {
      if (array[j + 1] < array[j]) {
        const temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
        swaps++;
      }
    }
    // to ensure a best case time-complexity of O(n)
    if (!swaps) {
      break;
    }
  }
}

// test
let myArray = [3, 7, 5, 6, 4, 2];
bubbleSort(myArray);
console.log(myArray);

myArray = [1, 2, 3, 4, 5];
bubbleSort(myArray);
console.log(myArray);

myArray = [5, 4, 3, 2, 1];
bubbleSort(myArray);
console.log(myArray);
