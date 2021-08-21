n, k = map(int, input().split(' '))
q = [str(i+1) for i in range(n)]
a = ['<']

while len(q) != 0:
    for _ in range(k-1):
        rt = q.pop(0)
        q.append(rt)
    rt = q.pop(0)
    a.append(rt)
    a.append(', ')

a.pop()
a.append('>')
a = ''.join(a)
print(a)
