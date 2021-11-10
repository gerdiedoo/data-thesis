function firstRecurringNumber(input) {
  const map = {};

  for (let i = 0; i < input.length; i++) {
    if (map[input[i]] !== undefined) {
      return input[i];
    }
    map[input[i]] = i;
  }

  return undefined;
}

// test
console.log(firstRecurringNumber([2, 5, 6, 7, 2, 3, 4, 5]));
console.log(firstRecurringNumber([2, 5, 5, 7, 2, 3, 4, 5]));
console.log(firstRecurringNumber([2, 5, 7, 9, 3, 4, 8]));
console.log(firstRecurringNumber([]));
