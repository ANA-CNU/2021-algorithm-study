import sys
sys.setrecursionlimit(10**5)
input=sys.stdin.readline
T=int(input())

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def dfs(a,b):

   for i in range(4):
      da=a+dx[i]
      db=b+dy[i]
      if 0<=da<M and 0<=db<N and land[da][db]==1:
         land[da][db]=land[a][b]
         dfs(da,db)
   
for _ in range(T):
   M,N,K=map(int,input().split())
   ans=0
   land=[[0]*N for _ in range(M)]
   stack=[]
   for _ in range(K):
      a,b=map(int,input().split())
      land[a][b]=1
      stack.append((a,b))
   while stack:
      a,b=stack.pop()
      if land[a][b]==1:
         land[a][b]=ans+2
         ans+=1
         dfs(a,b)
   print(ans)
