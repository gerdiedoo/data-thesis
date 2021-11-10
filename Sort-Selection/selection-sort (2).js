function selectionSort(array) {
  for (let i = 0; i < array.length - 1; i++) {
    let min = array[i];
    for (let j = i + 1; j < array.length; j++) {
      if (array[j] < min) {
        min = array[j];
        array[j] = array[i];
        array[i] = min;
      }
    }
  }
}

// test
let myArray = [3, 7, 5, 6, 4, 2];
selectionSort(myArray);
console.log(myArray);

myArray = [1, 2, 3, 4, 5];
selectionSort(myArray);
console.log(myArray);

myArray = [5, 4, 3, 2, 1];
selectionSort(myArray);
console.log(myArray);
