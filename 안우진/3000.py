import sys; from collections import defaultdict
r=sys.stdin.readline
lx=defaultdict(list); ly=defaultdict(list)
dots=[]
for _ in range(int(r())):
    x,y=map(int,r().split())
    lx[x].append(y); ly[y].append(x)
    dots.append((x,y))
ans=0
for dot in dots:
    ans+=(len(lx[dot[0]])-1)*(len(ly[dot[1]])-1)
print(ans)
