# BOJ 11724
import sys
sys.setrecursionlimit(10**5)
input=sys.stdin.readline

def dfs(i):
    visit[i]=1
    for j in range(1,N+1):
        if graph[i][j]==1 and not visit[j]:
            dfs(j)

N,M=map(int,input().split())
graph=[[0]*(N+1) for _ in range(N+1)]
visit=[0]*(N+1)
for i in range(M):
    a,b=map(int,input().split())
    graph[a][b]=1
    graph[b][a]=1
ans=0
for i in range(1,N+1):
    if not visit[i]:
        ans+=1
        dfs(i)
print(ans)
