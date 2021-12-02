import sys
r=sys.stdin.readline
N=int(r()); link = [[] for _ in range(N+1)]; parent = [0]*(N+1)

// func() 을 재귀형태로 구현했을 때 지금 방식보다 메모리를 3배 더 많이 썼다.
def func():
    q=[1]
    while q:
        p = q.pop()
        for l in link[p]:
            if not parent[l]:
                parent[l] = p
                q.append(l)
            
for i in range(N-1):
    a,b=map(int,r().split())
    link[a].append(b); link[b].append(a);
func()
for i in range(2,N+1):
    print(parent[i])
