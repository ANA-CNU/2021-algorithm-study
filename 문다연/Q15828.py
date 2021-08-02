buffer = int(input())

router = []

while True:
    packet = int(input())
    if packet == -1 :
        break;
    if packet == 0:
        router.pop(0)
    else:
        if len(router) < buffer:
            router.append(packet)

if len(router) == 0:
    print("empty")
else:
    while len(router) > 0:
        print(router.pop(0), end=' ')