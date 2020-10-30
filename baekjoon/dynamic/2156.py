N = int(input())
wine = [0, 0, 0]
for i in range(N):
    wine.append(int(input()))

table = [0 for i in range(len(wine))]

for i in range(3, N+3):
    table[i] = max(table[i-1], table[i-2]+wine[i],
                   table[i-3]+wine[i-1]+wine[i])

print(table[-1])
