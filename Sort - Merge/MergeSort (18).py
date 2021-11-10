def Sort(list, l, middle, r):
    left = list[l:middle+1]
    right = list[middle+1:r+1]
    print(left, right)
    i = 0
    j = 0
    k = l
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            list[k] = left[i]
            i+=1
        else:
            list[k]=right[j]
            j+=1
        k+=1
    while i < len(left):
        list[k]=list[i]
        k+=1
        i+=1
    while j < len(right):
        list[k]=list[j]
        k+=1
        j+=1

def MergeSort(list, l, r):
    if l == r:
        return
    MergeSort(list, l, (l+r)//2)
    MergeSort(list, (l+r)//2+1, r)
    Sort(list, l, (r+l)//2, r)
