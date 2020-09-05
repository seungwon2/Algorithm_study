first_letter = input("input something: ")

if (type(first_letter) == int):
    print(first_letter+1)
elif (type(first_letter) == str):
    next_letter = chr(ord(first_letter)+1)
    print(next_letter)
