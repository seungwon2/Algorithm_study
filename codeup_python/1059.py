decimal = int(input("정수 입력: "))
# 10진수 not binary연산 완료된 값으로 변경
not_binary = bin(~decimal)
# 2진수 기준으로 int로 변환
print(int(not_binary, 2))
