input_num = input("")
input_array = set(map(int, input("").split()))
tree_num = input("")
tree_array = list(map(int, input("").split()))

for num in tree_array:
    if num in input_array:
        print(1, end=" ")
    else:
        print(0, end=" ")
