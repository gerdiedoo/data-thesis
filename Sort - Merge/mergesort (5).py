def compare(a,b):
    return True if a < b else False

def merge_sort(sort_list):
    if len(sort_list)>1:
        mid = len(sort_list)//2

        left_half = merge_sort(sort_list[:mid])
        right_half = merge_sort(sort_list[mid:])
        
        output = []
        while left_half!=[] and right_half!=[]:
            output.append(left_half.pop(0) if compare(left_half[0],right_half[0]) else right_half.pop(0))
        output += left_half+right_half

        return output
    else:
        return sort_list
        

'''
#Testing

final_order = merge_sort([199,4,51,24,2,3,42,1,1])
print(final_order)
'''
