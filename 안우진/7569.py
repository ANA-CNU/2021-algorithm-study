# BOJ 7569

import sys
from collections import deque

# 전역변수보다 지역변수 참조가 더 빠르다.
# 같은 코드여도 함수 안에 넣었을 때 속도 차이를 보여줌
# (Python 3 WA, PyPy3 AC)

input=sys.stdin.readline
M,N,H = map(int,input().split())
ans=0
tomato=[[[0]*H for _ in range(N)] for _ in range(M)]
loop=deque([])
for i in range(H):
    for j in range(N):
        tmp = input().split()
        for k in range(M):
            tomato[k][j][i] = int(tmp[k])
            if tmp[k] == '1':
                loop.append((k, j, i))
dh = [0,0,0,0,1,-1]
dn = [1,-1,0,0,0,0]
dm = [0,0,1,-1,0,0]
while loop:
    m,n,h=loop.popleft()
    for i in range(6):
        if 0 <= m+dm[i] < M and 0 <= n+dn[i] < N and 0 <= h+dh[i] < H and tomato[m+dm[i]][n+dn[i]][h+dh[i]]==0:
            tomato[m+dm[i]][n+dn[i]][h+dh[i]]=tomato[m][n][h]+1
            loop.append((m+dm[i],n+dn[i],h+dh[i]))
for a in tomato:
    for b in a:
        if 0 in b:
            print(-1)
            exit(0)
        ans=max(ans,max(b))
print(ans-1)

