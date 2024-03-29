import sys
sys.setrecursionlimit(10**9)

V = int(sys.stdin.readline())

matrix = [[] for _ in range(V+1)]
# 입력받는 부분
for _ in range(V-1):
    s, e, d = map(int, sys.stdin.readline().split())
    matrix[s].append([e, d])
    matrix[e].append([s, d])

# 첫번째 DFS결과
result1 = [0 for _ in range(V+1)]


def DFS(start, matrix, result):
    for e, d in matrix[start]:
        if result[e] == 0:
            result[e] = result[start]+d
            DFS(e, matrix, result)


DFS(1, matrix, result1)  # 아무노드에서 시작해준다.

tmpmax = 0  # 최대값 구하기
index = 0  # 최장경로 노드

for i in range(len(result1)):
    if tmpmax < result1[i]:
        tmpmax = result1[i]
        index = i

# 최장경로 노드에서 다시 DFS를 통해 트리지름구하기
result2 = [0 for _ in range(V+1)]
DFS(index, matrix, result2)
print(max(result2))
