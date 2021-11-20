# BOJ 1629
# 분할정복 거듭제곱
A,B,C=map(int, input().split())
ans=1
while B:
    if B & 1:
        ans*=A%C
    A*=A%C
    B=B>>1
print(ans%C)
