inputNum = int(input())
stairScores = []
for i in range(inputNum):
    inputScore = int(input())
    stairScores.append(inputScore)
maxScore = [0] * inputNum+3
for i in range(inputNum):

    if i == 0:
        maxScore[0] = stairScores[i]
        continue
    elif i == 1:
        maxScore[1] = stairScores[0] + stairScores[1]
        continue
    elif i == 2:
        maxScore[2] = max(stairScores[0], stairScores[1]) + stairScores[2]
        continue
    maxScore[i] = max(maxScore[i-3] + stairScores[i-1],
                      maxScore[i-2]) + stairScores[i]

print(maxScore[-1])
