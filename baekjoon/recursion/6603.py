from itertools import combinations

while True:
    numbers = list(map(int, input().split()))
    if numbers[0] == 0:
        break
    del numbers[0]
    numbers = list(set(numbers))
    numbers.sort()

    for combination in list(combinations(numbers, 6)):
        for number in combination:
            print(number, end=" ")
        print()
    print()
