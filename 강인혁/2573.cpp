#include<iostream>
#include<string>
#include<sstream>
#include<vector>
#include<map>
#include<cmath>
#include<algorithm>
#include<regex>
#include<queue>
#include<stack>
#include <array>
typedef long long ll;
using namespace std;    

const int INF= 0x3f3f3f3f;
const ll MOD = 1000000;

const int dy[4] = {0,0,-1,1};
const int dx[4] = {1,-1,0,0};

int n, m;
int block[333][333];
bool visited[333][333];
int cnt = 0;
bool flag = false;  // for dfs

int vCnt =0;

void dfs(int y, int x){
    visited[y][x] = true;
    vCnt ++;
    for(int i=0; i<4; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if(block[ny][nx] > 0 && !visited[ny][nx]) {
            dfs(ny,nx);
        }
    }
}

bool visited2[333][333];
bool visited3[333][333];
// 방금 녹았다는 것에서 오류가 나서 만든 배열


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n >> m;

    for(int i =0; i<n; i++){
        for(int j =0; j<m; j++){
            cin >> block[i][j];
            if(block[i][j] != 0) cnt++;
            else visited2[i][j] = true;
        }
    }

    // feels like bfs
    queue<pair<pair<int,int>, int>> q;
    // init phase
    for(int y =0; y<n; y++){
        for(int x =0; x<m; x++){
            if(block[y][x] == 0) continue;
            bool f = false;
            for(int k=0; k<4; k++){
                if(f) break;
                int ny = y + dy[k], nx = x + dx[k];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(block[ny][nx] == 0){
                    f = true;
                }
            }
            if(f){
                q.push({{y,x}, 0});
                visited2[y][x] = true;
            }
            
        }
    }

    ////////////////
    int curT = 0;
    bool first = true;
    while(!q.empty()) {
        auto pp = q.front();
        q.pop();
        auto p = pp.first;
        int y = p.first, x = p.second;
        
        int t = pp.second;
        if(curT == t - 1 || first){
            first = false;
            curT = t;
            vCnt =0;
            memset(visited3, false, sizeof(visited3));
            memset(visited, false, sizeof(visited));
            dfs(y,x);
            if(vCnt != cnt) flag = true;
            if(flag){
                cout << t << endl;
                break;
            }
        }
        for(int k=0; k<4; k++){
            int ny = y + dy[k], nx = x + dx[k];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(visited3[ny][nx]){
                continue;
            }
            if(block[ny][nx] <= 0 && block[y][x] > 0){
                block[y][x]--;
            }
        }
        // 내가 녹을 때 만약 물이랑 접한적 없는 게 있다면 넣어줌
        if(block[y][x] <= 0){
            visited3[y][x] = true;
            cnt--;
            for(int k=0; k<4; k++){
                int ny = y + dy[k], nx = x + dx[k];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(!visited2[ny][nx]){
                    visited2[ny][nx] = true;
                    q.push({{ny,nx}, t+1});
                }
            }
        }

        if(block[y][x] > 0) q.push({{y,x}, t+1});
    }

    if(!flag) cout << 0 << endl;

    // for(int i=0; i<n; i++){
    //     for(int j=0 ; j<m; j++){
    //         if(block[i][j] < 10) cout << 0;
    //         cout << block[i][j] << " ";
    //         // cout << visited2[i][j] << " ";
    //     }
    //     cout << endl;
    // }

    
    
    return 0;
}
