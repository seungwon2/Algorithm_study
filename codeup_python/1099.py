box = [[int(x) for x in input().split(" ")]for y in range(10)]
x = 1
y = 1

while True:
    while box[x][y] == 0:
        box[x][y] = 9
        if box[x][y+1] == 0:
            y = y + 1

        elif box[x][y+1] == 1:
            x = x + 1

        elif box[x][y+1] == 2:
            y = y + 1

    if box[x][y] == 2:
        box[x][y] = 9
        break

    if box[x][y] == 1:
        x = x + 1

for i in range(10):
    for j in range(10):
        print(box[i][j], end=" ")
    print()
