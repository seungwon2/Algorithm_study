N = int(input(""))
A = list(map(int, input("").split()))
B = list(map(int, input("").split()))

result = 0
A.sort()
for i in range(N):
    result += A[i]*max(B)
    B.remove(max(B))

print(result)
