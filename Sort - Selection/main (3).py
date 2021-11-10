class Sorter:
    def __init__(self, list):
        self.list = list

    def selectionSort(self):
        unsortedList = self.list[:]
        sortedList = []
        indexSmallest = 0

        while len(unsortedList) > 0:
            for i in range(len(unsortedList)):
                if unsortedList[i] <= unsortedList[indexSmallest]:
                    indexSmallest = i
            sortedList.append(unsortedList[indexSmallest])
            unsortedList.pop(indexSmallest)
            indexSmallest = 0
        return sortedList

    def bubbleSort(self):
        list = self.list[:]
        notDone = True
        while notDone:
            print(list)
            notDone = False
            for i in range(len(list)):
                if(i != len(list) - 1):
                    if(list[i] > list[i + 1]):
                        temp = list[i]
                        list[i] = list[i + 1]
                        list[i + 1] = temp
                        notDone = True
                        # break
        return list

    def insertionSort(self):
        list = self.list[:]

        for i in range(1, len(list)):
            while(i > 0 and list[i] < list[i - 1]):
                temp = list[i]
                list[i] = list[i - 1]
                list[i - 1] = temp
                i -= 1

        return list

    def quickSort(self):
        list = self.list[:]
        less = []
        equal = []
        greater = []

        if len(list) > 1:
            pivot = list[0]
            for x in list:
                if x < pivot:
                    less.append(x)
                elif x == pivot:
                    equal.append(x)
                elif x > pivot:
                    greater.append(x)
            return sorted(less) + equal + sorted(greater)
        else:
            return list


sorter = Sorter([68,12,34,8,16,78])
# print(sorter.selectionSort())
# print(sorter.bubbleSort())
# print(sorter.insertionSort())
print(sorter.quickSort())
