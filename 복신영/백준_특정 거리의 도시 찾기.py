from collections import deque
import sys
input = sys.stdin.readline
n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
answer = [-1] * (n+1)
answer[x] = 0 
for _ in range(m):
    a, b = list(map(int, input().split()))
    graph[a].append(b)
q = deque([x])

while q:
    cur = q.popleft()
    for i in graph[cur]:
        if answer[i] == -1:
            answer[i] = answer[cur] + 1 
            q.append(i)
            
for i in range(n+1):
    if answer[i] == k:
        print(i)
if k not in answer:
    print(-1)
    
