def solution(s):
    s = s[2:len(s)-2].split('},{')
    s = [i.split(',') for i in s]
    s = sorted(s, key=lambda x : len(x))
    answer = [int(s[0][0])]
    pre = s[0]
    for i in range(1, len(s)):
        answer.extend([int(k) for k in s[i] if k not in pre])
        pre = s[i]
    return answer
    
