numbers = input("스페이스바로 띄어서 숫자 입력: ").split(" ")
i = 0
while True:

    if numbers[i] == '0':
        break
    else:
        print(numbers[i])
        i = i+1
