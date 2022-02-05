# 균형잡힌 세상_4949
def check_bracket(val):
    stack = []
    for i in val:
        if i == '(' or i == '[':
            stack.append(i)
        elif i == ')' or i == ']':
            if len(stack) > 0:
                p = stack.pop()
                if i == ')' and p == '[':
                    return 'no'
                elif i == ']' and p == '(':
                    return 'no'
            else:
                return 'no'
    if len(stack) != 0:
        return 'no'
    else:
        return 'yes'

while True:
    val = input()

    if val == '.':
        break
    else:
        print(check_bracket(list(val)))
