def solution(answers):
    
    std1 = [1,2,3,4,5]
    std2 = [2,1,2,3,2,4,2,5]
    std3 = [3,3,1,1,2,2,4,4,5,5]
    
    score1, score2, score3 = [1,0], [2,0], [3,0]
    
    for i in range(len(answers)):
        a = answers[i]
        if std1[i%5] == a:
            score1[1] += 1
        if std2[i%8] == a:
            score2[1] += 1
        if std3[i%10] == a:
            score3[1] += 1
        
    score = [score1, score2, score3]
    sortedS = sorted(score, key = lambda x : -x[1])
    
    first = sortedS[0][1]
    return [i[0] for i in score if first == i[1]]