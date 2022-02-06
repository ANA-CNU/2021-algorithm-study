# 무승부만 dfs했지만 승패 모두 해줘야 했었다..

def dfs(n, k):
    global ans
    if ans: return
    if n==6:
        if sum(win) + sum(lose) + sum(draw) == 0:
            ans=1
        return
    if k==6:
        dfs(n+1, n+2)
        return
    for i in range(k,6):
        if win[n] and lose[i]:
            win[n]-=1; lose[i]-=1
            dfs(n, i+1)
            win[n]+=1; lose[i]+=1
        if draw[n] and draw[i]:
            draw[n]-=1; draw[i]-=1
            dfs(n, i+1)
            draw[n]+=1; draw[i]+=1
        if lose[n] and win[i]:
            lose[n]-=1; win[i]-=1
            dfs(n, i+1)
            lose[n]+=1; win[i]+=1

for _ in range(4):
    case=list(map(int,input().split()))
    win=[];draw=[];lose=[];ans=0
    for i in range(6):
        if case[i*3]+case[i*3+1]+case[i*3+2]!=5:
            print(0,end=' ')
            ans=1
            break
        win.append(case[i*3])
        draw.append(case[i*3+1])
        lose.append(case[i*3+2])
    if ans: continue
    dfs(0,1)
    print(ans,end=' ')
