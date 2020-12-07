N = int(input())
tree = {}
for _ in range(N - 1):
    n1, n2 = map(int, input().split())
    if n1 not in tree:
        tree[n1] = [n2]
    else:
        tree[n1].append(n2)
    if n2 not in tree:
        tree[n2] = [n1]
    else:
        tree[n2].append(n1)

parent = [0] * (N + 1)
parent[1] = 1
stack = [1]

while stack:
    n = stack.pop()
    for i in tree[n]:
        if not parent[i]:
            parent[i] = n
            stack.append(i)

for i in range(2, len(parent)):
    print(parent[i])
