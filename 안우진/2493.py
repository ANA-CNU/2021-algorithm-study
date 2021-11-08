# BOJ 2493 탑
# BOJ 17298 오큰수 와 유사함
import sys
r=sys.stdin.readline
N=int(r())
ans=[0]*N
height=list(map(int,r().split()))
stack=[]
for i in range(N-1,-1,-1):
    while stack and height[i] >= height[stack[-1]]:
        ans[stack.pop()] = i+1
    stack.append(i)
print(*ans)
