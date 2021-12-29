def pow(a, r):
    res=1
    while r:
        if r&1:
            res=res*a%MOD
            r-=1
        a=a*a%MOD
        r>>=1
    return res

import sys; r=sys.stdin.readline
MOD = 1_000_000_007
M=int(r())
ans=0
for _ in range(M):
    N,S=map(int,r().split())
    ans+=S*pow(N,MOD-2)%MOD
    ans%=MOD
print(ans)
