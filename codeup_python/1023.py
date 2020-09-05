import math

a = float(input("실수를 하나 입력하세요: "))
int_a = int(a)
decimal_a = (a - int(a))
total_length = len(str(decimal_a))-2

print(int_a)
print(int(decimal_a*int(10**total_length)))
