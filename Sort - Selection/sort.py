#Algorithm and implementation is based from examples
#found at http://interactivepython.org/courselib/static/pythonds/SortSearch/TheSelectionSort.html
def selection_sort(list):
    for fillslot in range(len(list)-1,0,-1):
       positionOfMax=0
       for location in range(1,fillslot+1):
           if list[location]>list[positionOfMax]:
               positionOfMax = location

       temp = list[fillslot]
       list[fillslot] = list[positionOfMax]
       list[positionOfMax] = temp
    return list

#Algorithm and implementation is based from examples
#found at http://interactivepython.org/courselib/static/pythonds/SortSearch/TheMergeSort.html
def merge_sort(list):
    if(len(list) > 1):
        mid = int(len(list)/2)
        left = list[:mid]
        right = list[mid:]

        merge_sort(left)
        merge_sort(right)
        
        i,j,k = 0,0,0
        while(i < len(left) and j < len(right)):
            if(left[i] < right[j]):
                list[k] = left[i]
                i+=1
            else:
                list[k] = right[j]
                j+=1
            k+=1

        while(i < len(left)):
            list[k]=left[i]
            i+=1
            k+=1

        while(j < len(right)):
            list[k]=right[j]
            j+=1
            k+=1
    return list 

#algorithm based on in class example. Implementation my own
def count_sort(arr,max): 
    count = [0] * (max+1)
    for i in range(0,max):
      count[arr[i]] +=1
    for j in range(0, max):
      count[j] += count[j-1]
    sorted = [0] * (len(arr)+1) 
    for v in arr:
      sorted[count[v]] = v
      count[v] -= 1

    return sorted[1:]
  
