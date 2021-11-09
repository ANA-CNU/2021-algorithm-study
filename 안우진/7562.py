# BOJ 7562
import sys
from collections import deque
r=sys.stdin.readline

def bfs():
    while queue:
        a,b=queue.popleft()
        if a==to_x and b==to_y:
            return
        for i in range(8):
            da=a+dx[i]
            db=b+dy[i]
            if 0<=da<line and 0<=db<line and visit[da][db]==0:
                visit[da][db]=visit[a][b]+1
                queue.append((da,db))

dx=[1,2,1,2,-1,-2,-1,-2]
dy=[2,1,-2,-1,2,1,-2,-1]

for _ in range(int(r())):
    line = int(r())
    from_x, from_y=map(int, r().split())
    to_x,to_y=map(int, r().split())
    visit=[[0]*line for _ in range(line)]
    queue=deque([(from_x,from_y)])
    bfs()
    print(visit[to_x][to_y])
