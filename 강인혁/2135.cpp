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

int cache[555][555];

vector<int> getProperDivisor(int n){
    vector<int> ans;
    for(int i=2; i < n; i++){
        if(n % i == 0) ans.push_back(i);
    }
    ans.push_back(1);
    return ans;
}

int getDensedLength(const string& s, int idx){
    int n = s.size();
    int & ans = cache[idx][idx+n-1];

    vector<int> divs = getProperDivisor(n);
    for(auto div : divs){
        int cnt = 0;
        bool flag = true;
        for(int i=0; i<= n - div; i+= div){
            if(s.substr(i, div) != s.substr(0, div)){
                flag = false;
                break;
            }
            else cnt++;
        }

        if(!flag){
            continue;
        }
        else{
            if(cnt < 10) cnt  = 1;
            else if( cnt < 100) cnt = 2;
            else cnt =3;
            ans = min(ans, cnt + cache[idx][idx+div-1] + 2);
        }
    }

    return ans;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    string s;
    cin >> s;
    int n = s.size();
    memset(cache, INF, sizeof(cache));
    for(int i=0; i<n; i++) cache[i][i] = 1;
    // length
    for(int l=1; l<=n; l++){
        // start idx
        for(int i =0; i<n; i++){
            cache[i][i+l-1] = min(cache[i][i+l-1], getDensedLength(s.substr(i,l), i));
            for(int j =1; j<l; j++){
                cache[i][i+l-1] = min(cache[i][i+l-1], cache[i][i+j-1] + cache[i+j][i+l-1]);
            }
        }
    }

    cout << cache[0][n-1] << endl;

    return 0;
}
