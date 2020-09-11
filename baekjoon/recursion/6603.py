from itertools import combinations


def main():
    while True:
        numbers = list(map(int, input().split()))
        numbers = list(set(numbers))
        numbers.sort()

        if numbers[0] == 0:
            break
        big_list = list(combinations(numbers, 6))
        for combination in big_list:
            for number in combination:
                print(number, end=" ")
            print()
        print()


main()
