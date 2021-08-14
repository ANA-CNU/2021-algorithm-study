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

// idx에서 펠린드롬의 반지름의 길이
int dp[222222];

int ans = 0;

void manacher(string s, int n){
    
    int r= 0, p =0;
    for(int i=0; i<n; i++){
        if(r >= i){
            dp[i] = min(dp[2 * p - i], r - i);
        }

        while(s[i - dp[i] - 1] == s[i + dp[i] + 1]
        && i - dp[i] - 1 >= 0
        && i + dp[i] + 1 < n){
            dp[i]++;
        }

        if(r < i + dp[i]){
            r = i + dp[i];
            p = i;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string s;
    cin >> s;
    int n = s.size();
    string temp;
    temp += '$';
    for(int i=0; i<n; i++){
        temp += s[i];
        temp += '$';
    }

    manacher(temp, 2 * n + 1);
    ans = 0;
    for(int i=0; i< 2 * n + 1; i++){
        ans = max(ans, dp[i]);
    }

    cout << ans << endl;

    return 0;
}
