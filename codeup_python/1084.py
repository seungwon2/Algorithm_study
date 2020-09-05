colors = input("빨강 초록 파랑 순서대로 입력: ").split(" ")
r = int(colors[0])
g = int(colors[1])
b = int(colors[2])
count = 0
for i in range(0, r):
    for j in range(0, g):
        for k in range(0, b):
            print(i, j, k)
            count = count + 1
print(count)
