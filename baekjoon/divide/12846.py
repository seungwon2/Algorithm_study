N = int(input())
pay = list(map(int, input().split()))
max_pay = []

for i in range(N):
    for k in range(i, N):
        if pay[i] > pay[k]:
            pin = k-1
            break
        else:
            pin = N-1
    max_pay.append(pay[i]*(pin-i+1))

print(max(max_pay))
