def solution(n):
    n = int(n)
    three = []
    while n != 0:
        a = n%3
        n = int(n/3)
        three.insert(0,a)
    
    answer = 0
    l = len(three)
    for i in range(l):
        answer += three[i] * (3 ** i)
        
    return answer
    
