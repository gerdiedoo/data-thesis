def insertionsort(lst):
    if len(lst) <= 1:
        return lst
    else:
        for i in range(1, len(lst)):
            while lst[i] < lst[i-1] and i > 0:
                lst[i], lst[i-1] = lst[i-1], lst[i]
                i -= 1
        return lst

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(insertionsort(lst))
