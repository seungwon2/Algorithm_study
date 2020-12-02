N = int(input(""))
tree = ["A"]+["0"]*(N**2)

for i in range(N):
    node_info = list(input("").split(" "))
    parent_index = tree.index(node_info[0])
    if node_info[1] != ".":
        tree[parent_index*2+1] = node_info[1]
    if node_info[2] != ".":
        tree[parent_index*2+2] = node_info[2]


def postOrder(tree, root):
    print("root: ", root)
    print(tree[root])
    if tree[root] == "G":
        return
    if tree[root*2+1] != "0":
        return postOrder(tree, root*2+1)
    else:
        if tree[root*2+2] != "0":
            return postOrder(tree, root*2+2)
        else:
            if root % 2 == 0:
                return postOrder(tree, root//2)
            else:
                return postOrder(tree, root//2+1)


postOrder(tree, 0)
