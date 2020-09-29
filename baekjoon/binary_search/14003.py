import sys

length = int(input(""))
numbers = list(map(int, input("").split()))
DP = [[-1000000001, -1]]
Trace = [0]*length


for i in range(length):

    low = 0
    high = len(DP)-1

    while low <= high:
        mid = (low+high)//2
        if DP[mid][0] < numbers[i]:
            low = mid+1
        else:
            high = mid-1

    if low >= len(DP):
        Trace[i] = DP[low-1][1]
        DP.append([numbers[i], i])
    else:
        DP[low][0] = numbers[i]
        DP[low][1] = i
        Trace[i] = DP[low-1][1]

print(len(DP)-1)

result = []
cur_index = DP[len(DP)-1][1]
while cur_index != -1:
    result.append(numbers[cur_index])
    cur_index = Trace[cur_index]

for i in range(len(result)-1, -1, -1):
    print(result[i], end=" ")
