def quicksort(lst):
    if len(lst) <= 1:
        return lst
    else:
        pivot = lst.pop()
    left = []
    right = []
    for i in lst:
        if i < pivot:
            left.append(i)
        else:
            right.append(i)
    return quicksort(left) + [pivot] + quicksort(right)

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(quicksort(lst))