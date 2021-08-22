def solution(s):
    s = list(s)
    answer = [s[0]]
    l = len(s)
    for i in range(1, l):
        if len(answer) != 0:
            if answer[-1] == s[i]:
                answer.pop()
            else:
                answer.append(s[i])
        else:
            answer.append(s[i])
        
    if len(answer) == 0:
        return 1
    return 0
    
