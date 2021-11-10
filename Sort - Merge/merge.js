function merge(srcA, srcB) {
  return srcA.reduce((acc, item, index, itemsA) => [
      ...acc,
      ...(!index
        ? srcB.filter(itemB => itemB <= item)
        : srcB.filter(itemB => (itemB <= item && itemB > itemsA[index - 1]))
      ),
      item], []);
}
