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

const int INF = 1e9;

int n, m, k;

char block[111][111];

const int dy[4] = {0,0,-1,1};
const int dx[4] = {1,-1,0,0};

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> m >> n;
    vector<pair<int,int>> light;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> block[i][j];
            if(block[i][j] == 'C'){
                light.push_back({i,j}); 
            }
        }
    }

    int startY = light[0].first, startX = light[0].second;
    int dstY = light[1].first, dstX = light[1].second;

    vector<vector<int>> dist(n+1, vector<int>(m+1, -1));
    dist[startY][startX] = 0;
    
    queue<pair<pair<int,int>,int>> q;
    q.push({{startY, startX}, 0});

    while(!q.empty()){
        int y = q.front().first.first, x = q.front().first.second;
        int cost = q.front().second;
        q.pop();
        
        for(int i=0; i<4; i++){
            int nextY = y + dy[i], nextX = x + dx[i];
            bool turned = true;
            vector<pair<int,int>> temp;
            while(nextY >=0 && nextY < n && nextX >= 0 && nextX < m){
                if(block[nextY][nextX] == '*') break;
                if(dist[nextY][nextX] == -1){
                    temp.push_back({nextY, nextX});
                }
                else if(dist[nextY][nextX] == cost-1){
                    turned = false;
                }
                nextY += dy[i], nextX += dx[i];
            }

            if(turned){
                for(int j=0; j< temp.size(); j++){
                    int yy = temp[j].first, xx = temp[j].second;
                    dist[yy][xx] = cost + 1;
                    q.push({{yy, xx}, cost + 1});
                }
            }

        }
    }
    
    cout << dist[dstY][dstX] -1 << endl;

    return 0;
}
