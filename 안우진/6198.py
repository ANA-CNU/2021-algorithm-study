import sys
input=sys.stdin.readline
N=int(input())
height=[int(input()) for _ in range(N)]
stack=[]
ans=0
for i in range(N):
    while stack and height[i] >= height[stack[-1]]:
        stack.pop()
    stack.append(i)
    ans+=len(stack)-1
print(ans)
