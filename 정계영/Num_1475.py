import sys

if __name__ == '__main__':
    input = int(sys.stdin.readline())
    map = map(int, str(input))
    room_num = [0] * 10


    for e in map :
        if e == 6 or e == 9:
            if room_num[6] <= room_num[9]:
                room_num[6] += 1
            else :
                room_num[9] += 1
        else :
            room_num[e] += 1

    print(max(room_num))




