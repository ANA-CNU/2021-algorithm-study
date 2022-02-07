from collections import deque
from sys import stdin

length = int(stdin.readline())
deq = deque()

for i in range(0, length):
    val = stdin.readline().split()

    s = val[0]
    l = 0
    if len(val) > 1:
        l = val[1]

    if s == 'push_front':
        deq.appendleft(l)
    elif s == 'push_back':
        deq.append(l)
    elif s == 'pop_front':
        if len(deq) > 0:
            temp = deq.popleft()
            print(temp)
        else:
            print(-1)
    elif s == 'pop_back':
        if len(deq) > 0:
            temp = deq.pop()
            print(temp)
        else:
            print(-1)
    elif s == 'size':
        print(len(deq))
    elif s == 'empty':
        if len(deq) > 0:
            print(0)
        else:
            print(1)
    elif s == 'front':
        if len(deq) > 0:
            temp = deq.popleft()
            deq.appendleft(temp)
            print(temp)
        else:
            print(-1)
    elif s == 'back':
        if len(deq) > 0:
            temp = deq.pop()
            deq.append(temp)
            print(temp)
        else:
            print(-1)