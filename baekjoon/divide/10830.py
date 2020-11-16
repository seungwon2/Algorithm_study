def mul(n, matrix1, matrix2):
    result = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] += matrix1[i][k] * matrix2[k][j]
            result[i][j] %= 1000

    return result


def divide(n, b, matrix):
    if b == 1:
        return matrix
    elif b == 2:
        return mul(n, matrix, matrix)
    else:
        tmp = divide(n, b//2, matrix)
        if b % 2 == 0:
            return mul(n, tmp, tmp)
        else:
            return mul(n, mul(n, tmp, tmp), matrix)


n, b = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

result = divide(n, b, a)
for row in result:
    for num in row:
        print(num % 1000, end=' ')
    print()
