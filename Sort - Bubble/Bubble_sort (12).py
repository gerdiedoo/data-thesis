def bubblesort(lst):
    if len(lst) <= 1:
        return lst
    else:
        sorted = False
        while sorted != True:
            sorted = True
            for i in range(len(lst)-1):
                if lst[i] > lst[i+1]:
                    sorted = False
                    lst[i], lst[i+1] = lst[i+1], lst[i]
        return lst

lst = [7, 5, 3, 1, 5, 9, 8, 4, 6, 2, 10]
print(bubblesort(lst))