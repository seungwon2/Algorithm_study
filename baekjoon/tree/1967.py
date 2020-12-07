N = int(input(""))
tree = {}

for i in range(N-1):
    parent, child, weight = list(map(int, input("").split()))
    if parent not in tree:
        tree[parent] = [[child, weight]]
    else:
        tree[parent].append([child, weight])
print(tree)

leaf = []
for i in range(1, N+1):
    if i not in tree:
        leaf.append(i)
print(leaf)
# root에서 leaf까지 최장 거리
root_length = 0
leaf_length = 0
leaf_length_final = 0


def root_longest(node):

    if node in leaf:
        return 0
    if len(tree[node]) == 2:
        return max(root_length, tree[node][0][1] + root_longest(tree[node][0][0]), tree[node][1][1] + root_longest(tree[node][1][0]))
    else:
        return max(root_length, tree[node][0][1] + root_longest(tree[node][0][0]))


# leaf에서 leaf까지 최장 거리
def leaf_longest(node):
    if node in leaf:
        return 0
    print("길이", len(tree[node]))
    if len(tree[node]) == 2:
        return max(leaf_length, leaf_longest(tree[node][0][0]), leaf_longest(tree[node][1][0]))
    else:
        return max(leaf_length, leaf_longest(tree[node][0][1]))


print(root_longest(1))

for i in tree:
    print(i)
    print(leaf_longest(i))
    leaf_length_final = max(leaf_length_final, leaf_longest(i))


print(max(root_length, leaf_length_final))
