brackets = input("")
calculated = []

for bracket in brackets:
    if bracket == ")":
        temp = 0
        while calculated:
            top = calculated.pop()
            if top == "(":
                if temp == 0:
                    calculated.append(2)
                else:
                    calculated.append(temp*2)
                break
            elif top == "[":
                print("0")
                exit(0)
            else:
                if temp == 0:
                    temp = int(top)
                else:
                    temp = temp + int(top)
    elif bracket == "]":
        temp = 0
        while calculated:
            top = calculated.pop()
            if top == "[":
                if temp == 0:
                    calculated.append(3)
                else:
                    calculated.append(temp*3)
                break
            elif top == "(":
                print("0")
                exit(0)
            else:
                if temp == 0:
                    temp = int(top)
                else:
                    temp = temp + int(top)
    else:
        calculated.append(bracket)

result = 0

for element in calculated:
    if type(element) != int:
        print("0")
        exit(0)
    else:
        result += element

print(result)
