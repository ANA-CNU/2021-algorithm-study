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

int n;

int block[222][222];
int dist[222][222];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int cnt = 1;
    while(1){
        cin >> n;
        if(n == 0) break;
        memset(block, 0, sizeof(block));
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cin >> block[i][j];
            }
        }

        memset(dist, INF, sizeof(dist));
        priority_queue<pair<int, pair<int,int>>> q;
        q.push({-block[0][0], {0,0}});
        while(!q.empty()){
            auto pp = q.top();
            q.pop();
            auto p = pp.second;
            int cost = -pp.first;
            int y =  p.first, x = p.second;
            if(y == n-1 && x == n-1) break;
            if(cost > dist[y][x]) continue;

            for(int i=0; i<4; i++){
                int ny = y + dy[i], nx = x + dx[i];
                if(ny <0 || nx < 0 || ny >= n || nx >= n) continue;
                int nc = cost + block[ny][nx];
                if(dist[ny][nx] <= nc) continue;
                dist[ny][nx] = nc;
                q.push({-nc, {ny, nx}});
            }
        }
        cout << "Problem " << cnt << ": " << dist[n-1][n-1] << endl;
        cnt++;
    }
    return 0;
}
