def selectionsort(lst):
    if len(lst) <= 1:
        return lst
    else:
        for i in range(len(lst)-1):
            for j in range(i, len(lst)):
                if lst[j] < lst[i]:
                    lst[j], lst[i] = lst[i], lst[j]
        return lst

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(selectionsort(lst))