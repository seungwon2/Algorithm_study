from itertools import combinations

N, M = map(int, input("").split())
cards = list(map(int, input("").split()))
com_cards = list(combinations(cards, 3))
max_sum = 0

for i in range(len(com_cards)):
    sum = com_cards[i][0]+com_cards[i][1]+com_cards[i][2]
    if sum > max_sum and sum <= M:
        max_sum = sum

print(max_sum)
