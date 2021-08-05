function solution(name){ 
    const arr = [0]; 
    const answer = [...name].reduce((answer, s, i) => {
        // 원소가 'A'일 때
        if (s === "A") {
            // 전에 원소가 'A'가 아니면 임시 배열에 PUSH
            // 앞의 A 개수 - (인덱스 - 1)
            if (name[i - 1] !== "A") arr.push(checkA(name, i) - (i - 1));
            
            // 한 칸 이동
            return answer + 1; 
        }
        
        // 원소가 'A'가 아니면 바꾼거랑 이동한 것 더함
        return answer + changeAlphabet(name[i]) + 1; 
    }, 0); 
    
    return answer - Math.max(...arr) - 1; 
}

function changeAlphabet(al) {
    const aCode = 'A'.charCodeAt(0);
    const zCode = 'Z'.charCodeAt(0);
    const alCode =  al.charCodeAt(0);
    const moveFromA = Math.abs(aCode - alCode);
    const moveFromZ = Math.abs(zCode - alCode) + 1;
    return moveFromA > 13 ? moveFromZ : moveFromA;
}

function checkA(name, index) {
    let count = 0;
    
    for (let i = index; i < name.length; i++) {
        if (name[i] !== 'A') break;
        count += 1;
    }

    return count;
}
