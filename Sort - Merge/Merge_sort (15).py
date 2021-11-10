def mergesort(lst):
    if len(lst)<=1:
        return lst
    else:
        mid = len(lst) // 2
        left = lst[mid:]
        right = lst[:mid]
        mergesort(left)
        mergesort(right)
        i = j = k = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                lst[k] = left[i]
                i += 1
            else:
                lst[k] = right[j]
                j += 1
            k += 1
        return lst

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(lst)