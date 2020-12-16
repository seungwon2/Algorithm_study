from sys import stdin, setrecursionlimit

setrecursionlimit(100000000)

Tree = list(map(int, (input("").split())))


def preToPost(tree, node, bound):
    right = node + 1
    while right <= bound and tree[right] < tree[node]:
        right += 1
    left = node + 1
    if left <= right - 1:
        preToPost(tree, left, right - 1)
    if right <= bound:
        preToPost(tree, right, bound)
    print(tree[node])


preToPost(Tree, 0, len(Tree) - 1)
