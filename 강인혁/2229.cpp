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

int dp[11111];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    vector<int> A(n);
    for(int i=0; i<n; i++) cin >> A[i];
    memset(dp, 0, sizeof(dp));
    dp[1] = abs(A[1]- A[0]);
    for(int i =1; i<n; i++){
        for(int k=1; k<i; k++){
            int minV = INF, maxV =0;
            for(int j =k; j <=i; j++){
                minV = min(minV, A[j]);
                maxV = max(maxV, A[j]);
                int score = maxV - minV;
                dp[i] = max(dp[i], dp[k-1] + score);
            }
        }
    }

    cout << dp[n-1] << endl;


    return 0;
}
