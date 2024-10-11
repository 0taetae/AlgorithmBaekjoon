function solution(edges) {
    const graph = new Map()
    edges.forEach(([start, end]) => {
        if(!graph.get(start)) {
            graph.set(start,[0, 0])
        }
        if(!graph.get(end)) {
            graph.set(end,[0, 0])
        }
        
        graph.get(start)[0] += 1;
       graph.get(end)[1] += 1;
    })
    
    const answer = [0,0,0,0];
    for(const [key, values] of graph) {
        if(!values) continue;
        
        if(values[0] >= 2 && values[1] === 0) {
            answer[0] = key
        } else if (values[0] === 0 && values[1] > 0) {
            answer[2] += 1
        } else if(values[0] >= 2 && values[1] >= 2) {
            answer[3] += 1
        }
    }
    answer[1] = graph.get(answer[0])[0] - answer[2] - answer[3]
    
    return answer
    

}

