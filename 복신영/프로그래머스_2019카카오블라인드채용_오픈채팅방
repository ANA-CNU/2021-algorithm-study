def solution(record):
    record = [i.split() for i in record]
    user = {i[1] : i[2] for i in record if i[0] == 'Enter' or i[0] == 'Change'}

    answer = []
    for i in record:
        name = user[i[1]]
        if i[0] == 'Enter':
            answer.append(name + '님이 들어왔습니다.')
        elif i[0] == 'Leave':
            answer.append(name + '님이 나갔습니다.')
            
    return answer
    
