from itertools import combinations

length = int(input(""))
numbers = list(map(int, input("").split(" ")))
numbers_set = []


numbers = list(set(numbers))
numbers.sort()


def increase_check(numbers, length):
    temp = inc = 0
    for i in range(length-1):
        temp = numbers[i+1] - numbers[i]
        if temp == inc:
            temp = inc
        elif temp == 0:
            inc = temp
        else:
            temp = 0
    if temp == inc:
        print(len(numbers), end="\n")
        for number in numbers:
            print(number, end=" ")
        exit()


for i in range(0, len(numbers)+1):
    c = combinations(numbers, i)
    numbers_set.extend(c)

numbers_set.reverse()

for com in numbers_set:
    increase_check(com, len(com))
