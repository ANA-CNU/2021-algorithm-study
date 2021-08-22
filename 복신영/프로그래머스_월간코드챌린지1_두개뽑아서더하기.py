import itertools
def solution(numbers):
    arr = itertools.combinations(numbers, 2)
    answer = set()
    for i in arr:
        answer.add(i[0] + i[1])
        
    return sorted(list(answer))
    
