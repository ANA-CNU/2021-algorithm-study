from collections import deque

n, k = map(int, input().split())
arr = deque([])
for i in range(1, n+1):
    arr.append(i)

cnt = 0
result = []
while len(arr) > 0:
    for j in range(0, len(arr)):
        if cnt == k:
            for i in range(0, k):
                temp = arr.popleft()
                arr.append(temp)
            a = arr.pop()
            result.append(a)
    cnt += 1

print('<', end='')
c = 0
for i in result:
    c += 1
    print(i, end='')
    if c < len(result):
        print(', ',end='')
print('>', end='')
