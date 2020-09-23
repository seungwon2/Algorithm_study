N, M = map(int, input("").split())
trees = list(map(int, input("").split()))


def binary_search():
    start = 0
    end = max(trees)
    height = 0
    while(start <= end):
        mid = (start+end)//2
        sum = 0
        for tree in trees:
            if tree-mid > 0:
                sum += (tree-mid)
        if sum < M:
            end = mid-1
        if sum >= M:
            height = mid
            start = mid+1
    return height


print(binary_search())
