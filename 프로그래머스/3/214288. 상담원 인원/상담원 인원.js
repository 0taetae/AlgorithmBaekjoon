const p = []


function solution(k, n, reqs) {
    const hashMap = new Map()
    reqs.forEach(([a, b, c]) => {
        hashMap.set(c, hashMap.get(c) ? [...hashMap.get(c), [a,b]] : [[a, b]])
    })
    const remain = n-k
    dfs([], remain, hashMap.size, 0)

    let answer = Number.MAX_SAFE_INTEGER;
    p.forEach((t) => {
        let i = 0;
        let remain = 0;
        for(values of hashMap.values()) {
            const num = t[i] + 1;
            let waiting = 0;
            const kk = new Array(num).fill(0);
            values.forEach(([start, time], idx) => {
                const min = Math.min(...kk)
                const index = kk.indexOf(min);
                if(min > start && min > 0) {
                    waiting += min - start
                    kk[index] = min + time;
                } else {
                    kk[index] = start+time;
                }
                
            })
            remain += waiting
            i++;
        }
        answer = Math.min(remain, answer)
    })
    
    return answer;
}

function dfs(arr, remain, NumOfPar, sum) {    
    if(arr.length === NumOfPar-1) {
        const newArr = [...arr, remain-sum]
        p.push(newArr)
        return;
    }
    for(let i = 0; i <= remain; i++) {
        if(sum + i > remain) break;
        const newArr = [...arr];
        newArr.push(i);
        dfs(newArr, remain, NumOfPar, sum+i);
    }
}