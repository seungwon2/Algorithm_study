from sys import stdin


def solution(n):
    if memo[n] == -1:
        if n == 1:
            memo[n] = 1
            return 1
        if n == 2:
            memo[n] = 2
            return 2
        if n == 3:
            memo[n] = 4
            return 4
        else:
            memo[n] = solution(n-1) + solution(n-2) + solution(n-3)
            return solution(n-1) + solution(n-2) + solution(n-3)
    else:
        return memo[n]


case = int(input())

for _ in range(case):
    num = int(stdin.readline())
    memo = [-1]*(num+1)
    print(solution(num))
