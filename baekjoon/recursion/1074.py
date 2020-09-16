n, r, c = map(int, input().split())
result = 0
while n > 0:
    mark = (2 ** n) // 2
    if n > 1:
        if mark > r and mark <= c:
            result += mark ** 2
            c -= mark
        elif mark <= r and mark > c:
            result += (mark ** 2) * 2
            r -= mark
        elif mark <= r and mark <= c:
            result += (mark ** 2) * 3
            r -= mark
            c -= mark
    elif n == 1:
        if r == 0 and c == 1:
            result += 1
        elif r == 1 and c == 0:
            result += 2
        elif r == 1 and c == 1:
            result += 3
    n -= 1
print(result)
