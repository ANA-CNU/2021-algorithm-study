def solution(number, k):
    count = 0
    l = len(number)
    stack = [number[0]]
    
    for i in range(1, l):
        current = number[i]
        while (current > stack[-1]) and (count < k):
            stack.pop(-1)
            count += 1
            if len(stack) == 0: break
            
        stack.append(current)
        
    if len(stack) > k:
        stack = stack[:l-k]
            
    return ''.join(stack)
    
