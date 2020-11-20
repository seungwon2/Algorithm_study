N, K = map(int, input("").split())
inputNum = []
answer = []
for i in range(N):
    inputNum.append(i+1)
kill = 0

while True:
    if len(inputNum) == 0:
        break
    kill = (kill+K-1) % len(inputNum)
    answer.append(inputNum[kill])
    del inputNum[kill]

print("<", ", ".join(map(str, answer)), ">", sep="")
