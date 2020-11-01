n = int(input())
pay = list(map(int, input().split()))

result = 0
today = 0

pay.append(0)
print(pay)
stack = [(0, pay[0])]

for i in range(1, n+1):
    today = i
    while stack and stack[-1][1] > pay[i]:
        day, daily_pay = stack.pop()
        result = max(result, daily_pay*(i-day))
    stack.append((today, pay[i]))

print(result)
