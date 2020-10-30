n = int(input())
pay = list(map(int, input().split()))

result = 0
cursor = 0
a = 0

pay.append(0)
stack = [(0, pay[0])]
for i in range(1, n+1):
    cursor = i
    while stack and stack[-1][1] > pay[i]:
        cursor, temp = stack.pop()
        result = max(result, temp*(i-cursor))
    stack.append((cursor, pay[i]))

print(result)
