days = input("방문 주기 3개 입력: ").split(" ")

visitant1 = int(days[0])
visitant2 = int(days[1])
visitant3 = int(days[2])

day = 1

while True:
    if day % visitant1 != 0 or day % visitant2 != 0 or day % visitant3 != 0:
        day = day+1
    elif day % visitant1 == 0 and day % visitant2 == 0 and day % visitant3 == 0:
        print(day)
        break
