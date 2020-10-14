N, K = map(int, input("").split())

count = 0

num = [True] * (N+1)
for i in range(2, N+1):
    for j in range(i, N+1, i):
        if num[j] == True:
            num[j] = False
            count += 1
            if count == K:
                print(j)
                break
