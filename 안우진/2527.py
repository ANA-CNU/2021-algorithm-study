for _ in range(4):
    # cord[0], cord[1] ~ cord[2], cord[3]
    # cord[4], cord[5] ~ cord[6], cord[7]
    cord = list(map(int,input().split()))
    

    if ( (cord[0] == cord[6] and cord[1] == cord[7]) or (cord[2] == cord[4] and cord[3] == cord[5]) or
    (cord[0] == cord[6] and cord[3] == cord[5]) or (cord[2] == cord[4] and cord[1] == cord[7]) ):
        print('c')
    
    elif (cord[6] < cord[0]) or (cord[7] < cord[1]) or (cord[4] > cord[2]) or (cord[5] > cord[3]):
        print('d')

    # c와 d의 조건문때문에 b는 이렇게 해도 괜찮음
    elif ( (cord[0] == cord[6]) or (cord[2] == cord[4]) or 
    (cord[3] == cord[5]) or (cord[1] == cord[7]) ):
        print('b')

    else:
        print('a')
