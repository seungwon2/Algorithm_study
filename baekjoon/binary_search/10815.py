input_num = input("")
input_array = input("").split()
tree_num = input("")
tree_array = input("").split()


class Node(object):
    def __init__(self, data):
        self.data = data
        self.left = self.right = None


class BinarySearchTree(object):
    def __init__(self):
        self.root = None

    def insert(self, data):
        self.root = self._insert_value(self.root, data)
        return self.root is not None

    def _insert_value(self, node, data):
        if node is None:
            node = Node(data)
        else:
            if data <= node.data:
                node.left = self._insert_value(node.left, data)
            else:
                node.right = self._insert_value(node.right, data)
        return node

    def find(self, key):
        return self._find_value(self.root, key)

    def _find_value(self, root, key):
        if root is None:
            return root is not None
        elif root.data == key:
            return True
        elif key < root.data:
            return self._find_value(root.left, key)
        else:
            return self._find_value(root.right, key)
        return False


bst = BinarySearchTree()

for i in input_array:
    bst.insert(i)

for element in tree_array:
    if bst.find(element) == True:
        print(1, end=' ')
    elif bst.find(element) == False:
        print(0, end=' ')
