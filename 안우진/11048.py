# BOJ 11048
import sys
input=sys.stdin.readline
n,m=map(int,input().split())
candy=[list(map(int, input().split())) for _ in range(n)]
dp=[[0]*(m+1) for _ in range(n+1)]
def f():
    for i in range(n):
        for j in range(m):
            dp[i+1][j+1] = candy[i][j] + max(dp[i][j+1], dp[i+1][j+1], dp[i+1][j])
f()
print(dp[n][m])
