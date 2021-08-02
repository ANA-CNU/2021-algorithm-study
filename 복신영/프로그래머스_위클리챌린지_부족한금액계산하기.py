def solution(price, money, count):
    m = [0]
    for i in range(1, count+1):
        m.append(price * i + m[i-1])

    left = m[-1] - money
    answer =  left if left > 0 else 0 
    return answer