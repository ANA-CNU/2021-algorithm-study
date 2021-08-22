function solution(s) {
    const len = s.length;
    let answer = 0;
    for(let i = 0; i < len; i++) {
        if(checkIsRight(s)) answer += 1;
        s = rotate(s);
    }
    
    return answer;
}

function checkIsRight(s) {
    const open = ['(', '{', '['];
    const close = [')', '}', ']'];
    const stack = [];
    
    for (let i = 0; i < s.length; i++) {
        if (open.includes(s[i])) stack.push(s[i]);
        
        else if (close.includes(s[i])) {
            if (stack.length === 0) return false;
            const pop = stack.pop();
            const popIndex = open.findIndex(item => item === pop);
            const closePopIndex = close.findIndex(item => item === s[i]);
            if (popIndex !== closePopIndex) return false;
        }
    }
    
    if (stack.length === 0) return true;
    return false;
}

function rotate(s) {
    const arr = s.split('');
    const first = arr[0];
    arr.splice(0, 1);
    arr.push(first);
    return arr.join('');
}
