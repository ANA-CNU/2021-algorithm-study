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

int adj[555][2];
int dp[555][555];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        int r, c;
        cin >> r >> c;
        adj[i][0] = r;
        adj[i][1] = c;
    }
    // memset(dp, INF, sizeof(dp));
    for(int i=0; i<n; i++) dp[i][i] = 0;
    for(int i = 1; i <n; i++){
        for(int j = i-1; j >=0; j--){
            dp[j][i] = INF;
            for(int k =0; k <= i-j; k++){
                dp[j][i] = min(dp[j][i], dp[j][j+k] + dp[j+k+1][i] + adj[j][0] * adj[j+k][1] * adj[i][1]);
            }

        }
    }

    cout << dp[0][n-1];

    return 0;
}
