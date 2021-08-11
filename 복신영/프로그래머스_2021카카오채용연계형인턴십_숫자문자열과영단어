def solution(s):
    arr = ['zero','one','two','three','four','five','six','seven','eight','nine']
    
    answer = ''
    word = ''
    for i in s:
        if 47 < ord(i) < 58:
            answer += i
        else:
            word += i
            if word in arr:
                answer += str(arr.index(word))
                word = ''
    return int(answer)
    
