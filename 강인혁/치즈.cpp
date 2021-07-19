#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<cstring>
#include<map>
#include<cmath>
#include<stack>
#define endl '\n'
typedef long long ll;

using namespace std;

const int INF = 987654321;
const int dy[4] = {1,-1,0,0};
const int dx[4] = {0,0,-1,1};

int n, m;

int block[111][111] = {0,};
bool visited[111][111] = {false,};

void dfs(int y, int x){
    visited[y][x] = true;
    for(int i=0; i<4; i++){
        int nextY = y + dy[i], nextX = x + dx[i];
        if(nextY < 0 || nextY >= n || nextX < 0 || nextX >=m) continue;
        if(!visited[nextY][nextX] && block[nextY][nextX] == 0)
            dfs(nextY, nextX);
    }
}
void dfsAll(){
    for(int i=0; i<n; i++){
        if(!visited[0][i] && block[0][i] == 0) dfs(0,i);
    }
    for(int i=0; i<n; i++){
        if(!visited[n-1][i] && block[n-1][i] == 0) dfs(m-1,i);
    }
    for(int i=1; i<n-1; i++){
        if(!visited[0][i] && block[0][i] == 0) dfs(0, i);
    }
    for(int i=1; i<m-1; i++){
        if(!visited[m-1][i] && block[n-1][i] == 0) dfs(n-1, i);
    }
}

// 시간, 개수
pair<int, int> bfs(){
    priority_queue<pair<int, pair<int,int>>> q;
    
    int dist[111][111];
    memset(dist, -1, sizeof(dist));
    int test[111][111];
    //초기값
    dfsAll();
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(block[i][j] == 1){
                bool flag = false;
                for(int k=0; k<4; k++){
                    int nextY = i + dy[k], nextX = j + dx[k];
                    if(nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) continue;
                    if(visited[nextY][nextX]){
                        flag = true;
                        break;
                    }
                }
                if(flag == true){
                    q.push({0, {i,j}});
                    dist[i][j] = 0;
                    test[i][j] = 1;
                }
            }
        }
    }

    int t = -1;
    
    while(!q.empty()){
        int y = q.top().second.first, x = q.top().second.second;
        int cost = -q.top().first;
        t = max(t, cost);
        q.pop();
        for(int i=0; i<4; i++){
            int nextY = y + dy[i], nextX = x + dx[i];
            if(nextY < 0 || nextY >= n || nextX < 0 || nextX >=m) continue;
            
            if(dist[nextY][nextX] == -1){
                if(block[nextY][nextX] == 1){
                    q.push({-cost-1, {nextY, nextX}});
                    dist[nextY][nextX] = cost + 1;
                }
                else{
                    q.push({-cost, {nextY, nextX}});
                    dist[nextY][nextX] = cost;
                }
            }
        }
    }

    int cnt = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(dist[i][j] == t && block[i][j] == 1) cnt++;
        }
    }
    return {t, cnt};
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> block[i][j];
        }
    }

    pair<int,int> ret = bfs();
    cout << ret.first + 1 << endl;
    cout << ret.second << endl;
    
    return 0;
}
