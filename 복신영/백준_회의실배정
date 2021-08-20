import sys
input = sys.stdin.readline
n = int(input())
time = []
for _ in range(n):
    a, b = input().split()
    time.append([int(a), int(b)])

time = sorted(time, key=lambda x: (x[1], x[0]))
answer = 1
t = time[0][1]
for i in range(1, n):
    if t <= time[i][0]:
        t = time[i][1]
        answer += 1

print(answer)
