import sys

if __name__ == '__main__':
    test = 1
    while 1 :
        stack = []
        input = sys.stdin.readline().rstrip()
        flag = False
        if input[:1] == '-':
            break

        count = 0

        for c in input:
            if c == '}':
                if stack:
                    stack.pop()
                else:
                    count += 1
                    stack.append(c)
            else:
                stack.append(c)

        count += len(stack) // 2

        print(str(test) + ". " + str(count))
        test += 1
