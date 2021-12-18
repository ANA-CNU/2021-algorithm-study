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

int adj[555][555];
int dp[555][555];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;
    memset(dp, INF, sizeof(dp));
    for(int i =0; i<m; i++){
        int a, b;
        cin >> a >> b;
        a--, b--;
        dp[a][b] = 1;
    }
    for(int k=0; k <n; k++){
        for(int i=0; i< n; i++){
            for(int j =0; j<n; j++){
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
            }
        }
    }

    int ret =0;
    for(int i =0; i<n; i++){
        int temp = 0;
        for(int j =0; j<n; j++){
            if(dp[i][j] != INF || dp[j][i] != INF) temp++;
        }
        
        if(temp == n-1) ret++;
    }

    cout << ret << endl;

    return 0;
}
