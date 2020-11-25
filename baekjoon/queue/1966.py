from collections import deque
case = int(input(""))

for i in range(case):
    N, M = map(int, input("").split())
    que = deque(list(map(int, input("").split())))
    cnt = 0
    while que:
        top = max(que)
        M -= 1
        pop = que.popleft()
        if top != pop:
            que.append(pop)
            if M < 0:
                M = len(que)-1
        else:
            cnt += 1
            if M == -1:
                print(cnt)
                break
