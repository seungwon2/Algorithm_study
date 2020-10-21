N = int(input(""))
paper = [[int(x) for x in input().split()]for y in range(N)]
result = [0, 0, 0]


def check(paper, startx, starty, length):
    pin = paper[startx][starty]
    for i in range(startx, startx+length):
        for j in range(starty, starty+length):
            if paper[i][j] != pin:
                return False
    return True


def divide(startx, starty, n):
    if check(paper, startx, starty, n):
        pin = paper[startx][starty]
        if pin == -1:
            result[0] += 1
        elif pin == 0:
            result[1] += 1
        else:
            result[2] += 1
    else:
        for i in range(3):
            for j in range(3):
                divide(startx + i * n//3, starty + j * n//3, n//3)
    return


divide(0, 0, N)
for i in range(3):
    print(result[i], end="\n")
