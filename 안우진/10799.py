# BOJ 10799

b=list(input().replace("()", "|"))
res=0; ans=0
for i in b:
    if i == '(':
        res+=1
    elif i == ')':
        res-=1; ans+=1
    else: # |
        ans+=res
print(ans)
