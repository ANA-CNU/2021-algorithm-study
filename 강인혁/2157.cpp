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

int adj[333][333];
int dp[333][333];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n, m, k;
    cin >> n >> m >> k;
    for(int i=0; i<k; i++){
        int a, b, c;
        cin >> a >> b >> c;
        if(a > b) continue;
        if(adj[a][b] > c) continue;
        adj[a][b] = c;
    }
    
    memset(dp, -INF, sizeof(dp));
    dp[1][1] = 0;
    for(int l = 2; l <= m; l++){
        for(int i=2; i<=n; i++){
            for(int j =1; j<i; j++){
                if(adj[j][i] != 0){
                    dp[i][l] = max(dp[i][l], dp[j][l-1] + adj[j][i]);
                }
            }
        }
    }
    int ret =0;
    for(int i =1; i<=m; i++) ret = max(ret, dp[n][i]);
    cout << ret << endl;


    return 0;
}
