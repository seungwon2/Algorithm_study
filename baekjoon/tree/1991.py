N = int(input(""))
tree = {}
root = None
for i in range(N):
    node_info = list(input("").split(" "))
    tree[node_info[0]] = [node_info[1], node_info[2]]


def preOrder(tree, root):
    if root == '.':
        return
    print(root, end="")
    preOrder(tree, tree[root][0])
    preOrder(tree, tree[root][1])


def inOrder(tree, root):
    if root == '.':
        return
    inOrder(tree, tree[root][0])
    print(root, end="")
    inOrder(tree, tree[root][1])


def postOrder(tree, root):
    if root == '.':
        return
    postOrder(tree, tree[root][0])
    postOrder(tree, tree[root][1])
    print(root, end="")


preOrder(tree, "A")
print()
inOrder(tree, "A")
print()
postOrder(tree, "A")
