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
int block[55][55];
bool visited[55][55];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    for(int i=0; i<n; i++){
        string s;
        cin >> s;
        for(int j=0; j<n; j++) block[i][j] = s[j]-'0';
    }

    priority_queue<pair<int, pair<int,int>>> q;
    q.push({0, {0,0}});
    visited[0][0] = true;

    int ans = 0;
    
    while(!q.empty()) {
        auto pp = q.top();
        q.pop();
        int cost = -pp.first;
        auto p = pp.second;
        int y = p.first, x = p.second;
        if(y == n-1 && x == n-1){
            ans = cost;
            break;
        }
        for(int i =0; i<4; i++){
            int ny = y + dy[i], nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = true;
            int nc = cost + 1;
            if(block[ny][nx] == 0) q.push({-nc, {ny, nx}});
            else q.push({-cost, {ny, nx}});
        }
    }
    cout << ans << endl;

    return 0;
}
