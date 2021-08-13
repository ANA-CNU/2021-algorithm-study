def solution(scores):
    answer = []
    idx = []
    l = len(scores)
    
    stu = [sum([scores[j][i] for j in range(l)]) for i in range(l)]
    
    for i in range(l):
        my = [scores[j][i] for j in range(l)]
        if (scores[i][i] == max(my) or scores[i][i] == min(my)) and my.count(scores[i][i]) == 1:
            stu[i] -= scores[i][i]
            idx.append(i)
    
    for i in range(l):
        if i in idx:
            stu[i] /= (l-1)
        else:
            stu[i] /= l
    
    for i in stu:
        if 90 <= i:
            answer.append("A")
        elif 80 <= i < 90:
            answer.append("B")
        elif 70 <= i < 80:
            answer.append("C")
        elif 50 <= i < 70:
            answer.append("D")
        else:
            answer.append("F")
        
    return ''.join(answer)
    
