function solution(left, right) {
  let sum = 0;
  for (let i = left; i <= right; i++) {
    let divides = [];
    for (let j = 0; j <= i; j++) {
      if (i % j === 0) divides.push(j);
    }
    sum += divides.length % 2 === 0 ? i : -i;
  }
  return sum;
}
