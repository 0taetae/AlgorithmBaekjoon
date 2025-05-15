import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Info{
        int x,y,cnt;
        Info(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt; 
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        System.out.println(n);
        boolean[][] visited = new boolean[n][m];
        
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,0,1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur.x==n-1 && cur.y==m-1){
                answer = cur.cnt;
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx>=n || ny>=m || nx<0|| ny<0 || visited[nx][ny] || maps[nx][ny]==0) continue;
                q.add(new Info(nx,ny,cur.cnt+1));
                visited[nx][ny] = true;
            }
        }
        if(answer == 0){
            answer = -1;
        }
        
        
        return answer;
    }
}