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
typedef long long ll;
using namespace std;    

const int INF= 0x3f3f3f3f;

ll dp[111][111];

// 0은 아래, 1은 옆에
int p[111][111][3];

int dy[2] = {1,0};
int dx[2] = {0,1};

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n, m;
    cin >> n >> m;
    int k;
    cin >>k;
    for(int i =0; i<k; i++){
        int sy, sx, ey, ex;
        cin >> sy >> sx >> ey >> ex;
        if(sy > ey) swap(sy, ey);
        if(sx > ex) swap(sx, ex);
        if(sy != ey) p[sy][sx][0] =1;
        else p[sy][sx][1] = 1;
    }

    dp[0][0] = 1;
    for(int y=0; y<=n; y++){
        for(int x =0; x<=m; x++){
            for(int k=0; k<2; k++){
                int ny = y + dy[k], nx = x + dx[k];
                if(p[y][x][k] == 1) continue;
                dp[ny][nx] += dp[y][x];
            }
        }
    }
    
    cout << dp[n][m] << endl;



    return 0;
}
