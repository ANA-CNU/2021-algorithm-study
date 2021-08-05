const combine = (array, r) => { 
    const n = array.length;

    // 들어온 배열의 길이가 0 이거나 뽑아야 하는 개수가 0 일 때
    if (n === 0 || r === 0) return ['']; 
    // 배열의 길이와 뽑아야 하는 길이가 같을 때는 바로 리턴
    if (n === r) return [array.join('')]; 

    const next = array.slice(1);

    return [ 
        ...combine(next, r - 1).map(v => `${array[0]}` + v), 
        ...combine(next, r) 
    ]; 
} 

const isEqual = (a, b) => a.length === b.length && a.every((v, i) => v === b[i]); 

function solution(relation) {
    const columnLength = relation[0].length, 
          columnIndexes = Array(columnLength).fill(0).map((_, i) => i);
    let columnSet = []; 

    for (let i = columnLength; i > 0; i--) {
        console.log(`...combine(${columnIndexes}, ${i})`);
        columnSet.push(...combine(columnIndexes, i)); 
    }

    console.log(columnSet);

    let answer = 0, s; 

    while (columnSet.length > 0) { 
        s = columnSet.pop().split(''); 

        if (relation.map(v => s.map(i => v[i])).some((v, i, a) => i !== a.findIndex(_v => isEqual(_v, v)))) 
            continue; 

        answer++; 

        for (let i = 0; i < columnSet.length; i++) 
            if (s.every(v => columnSet[i].includes(v))) columnSet.splice(i--, 1); 
    } 
    return answer; 
}
