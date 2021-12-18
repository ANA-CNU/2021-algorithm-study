string=input().split("-")
ans=0
for i in string[0].split("+"):
    ans+=int(i)
for s in range(1,len(string)):
    tmp=0
    for i in string[s].split("+"):
        tmp+=int(i)
    ans-=tmp
print(ans)
