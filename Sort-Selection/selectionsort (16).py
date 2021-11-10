#!/usr/bin/env python
#
# Mehmet Dursun INCE 26.03.2013 
#
# Using quick sort algorithm in huge data stack.
#
import time
from functools import partial
from operator import getitem

numbers = []

          
def selection_sort():
    n = len(numbers)
    for i in range (0, n-1):
        minI = min(range(i,n), key = partial(getitem, numbers))
        numbers[i], numbers[minI] = numbers[minI], numbers[i] 
    
def read_from_file(filepath):
    del numbers[:] # Listeyi temizle
    file = open(filepath, "r")
    for i in file:
        numbers.append(int(i))

def print_first_ten_number():
    print numbers[0:9]
        
def print_last_ten_number():
    print numbers[len(numbers)-10:len(numbers)]

def append_result_to_file(str):
    with open("results.txt", "a") as result:
        result.write(str+"\n")
        result.close()
    
if __name__=="__main__":                       # If this script is run as a program:
    #1k
    read_from_file("../test.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("1k = " + str(end-start))
    #10k
    read_from_file("../10k.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("10k = " + str(end-start))
    #100k
    read_from_file("../100k.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("100k = " + str(end-start))
    #1m
    read_from_file("../1m.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("1m = " + str(end-start))
    #2m
    read_from_file("../2m.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("2m = " + str(end-start))     
    #4m
    read_from_file("../4m.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("4m = " + str(end-start))
    #8m
    read_from_file("../8m.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("8m = " + str(end-start))
    #10m
    read_from_file("../10m.lst")
    start = time.clock()
    selection_sort()
    end = time.clock()
    append_result_to_file("10m = " + str(end-start))
