#!/usr/bin/env python
#
# Mehmet Dursun INCE 26.03.2013 
#
# Using insertion sort algorithm in huge data stack.
#
import time

numbers = []

def insertion_sort(list):
    i = 0
    j = 0
    for index in range(len(list)):
        j = index
        while (j > 0) and (list[j-1] > list[j]):
            list[j-1] , list[j] = list [j] , list[j-1]
            j -= 1
                
def read_from_file(filepath):
    del numbers[:]
    file = open(filepath,'r')
    for i in file:
        numbers.append(int(i))
    file.close()

def print_first_ten_number():
    print numbers[0:9]
        
def print_last_ten_number():
    print numbers[len(numbers)-10:len(numbers)]
	
def append_result_to_file(str):
    with open("results.txt", "a") as result:
        result.write(str+"\n")
        result.close()
        
if __name__ == '__main__':
    #1k
    read_from_file("../1k.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("1k = " + str(end-start))
    #10k
    read_from_file("../10k.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("10k = " + str(end-start))
    #100k
    read_from_file("../100k.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("100k = " + str(end-start))
    #1m
    read_from_file("../1m.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("1m = " + str(end-start))
    #2m
    read_from_file("../2m.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("2m = " + str(end-start))     
    #4m
    read_from_file("../4m.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("4m = " + str(end-start))
    #8m
    read_from_file("../8m.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("8m = " + str(end-start))
    #10m
    read_from_file("../10m.lst")
    start = time.clock()
    insertion_sort(numbers)
    end = time.clock()
    append_result_to_file("10m = " + str(end-start))
