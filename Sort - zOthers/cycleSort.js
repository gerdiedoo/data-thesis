/* Explanation
*/

function cycleSort (arrData) {
  'use strict'
  const dataMax = arrData.length
  let pos
  let item
  let temp

  console.log('Initial:', arrData.join(), `[Count:${dataMax}]`)
  for (let cycleStart = 0; cycleStart < dataMax - 1; cycleStart++) {
    item = arrData[ cycleStart ]
    pos = cycleStart
    for (let i = cycleStart + 1; i < dataMax; i++) {
      if (arrData[ i ] < item) pos++
    }
    if (pos === cycleStart) continue
    while (item === arrData[ pos ]) pos++
    if (item !== arrData[ pos ]) {
      temp = arrData[ pos ]
      arrData[ pos ] = item
      item = temp
    }
    while (pos !== cycleStart) {
      pos = cycleStart
      for (let i = cycleStart + 1; i < dataMax; i++) {
        if (arrData[ i ] < item) pos++
      }
      while (item === arrData[ pos ]) pos++
      if (item !== arrData[ pos ]) {
        temp = arrData[ pos ]
        arrData[ pos ] = item
        item = temp
      }
    }
    console.log('Cycle:', arrData.join())
  }
  console.log('Final:', arrData.join())
  return arrData
}
