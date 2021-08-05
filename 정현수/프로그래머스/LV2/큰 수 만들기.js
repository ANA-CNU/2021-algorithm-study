function solution(number, k) {
    const stack = [];
    number = number.split('');
    
    for (let i = 0; i < number.length; i += 1) {
        // 스택의 크기가 0이면 일단 넣는다.
        if (stack.length === 0) {
            stack.push(number[i]);
            continue;
        }
        
        // 스택의 맨 위에 있는 값과 number[i]를 비교
        // number[i]가 stack의 맨 윗 값보다 크면 계속 pop
        // pop할 때마다 k를 줄여준다. 
        while (k > 0 && stack[stack.length - 1] < number[i]) {
            stack.pop();
            k--;
        }
        
        stack.push(number[i]);
    }
    
    return stack.join('').substr(0, stack.length - k);
}
