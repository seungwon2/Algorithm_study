information = input("시작값, 등차값, 몇번째 수: ").split(' ')
a = int(information[0])
d = int(information[1])
n = int(information[2])
result = a+((n-1)*d)
print(result)
