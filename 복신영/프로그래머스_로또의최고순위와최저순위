def solution(lottos, win_nums):
    answer = []
    l = len([i for i in lottos if i in win_nums])
    if l > 1:
        answer.append(7-l)
    else:
        answer.append(6)
        
    h = lottos.count(0)
    if h + l > 1:
        answer.append(7-l-h)
    else:
        answer.append(6)
    answer.sort()
    return answer
    
