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

const ll INF = numeric_limits<ll>::max();

int n, k;
ll cache[111][111111];
//시간
int w[111111], b[111111];
// 돈
int wv[111111], bv[111111];

int ans = -1;

// 이전까지 도시, 걸린시간
// 현재 도시의 현재 시간에서 얻을 수 있는 가장 큰 돈
ll func(int c, int t){
    if(t < 0) return -INF;
    if(c == 0) return 0;
    ll &ret = cache[c][t];
    if(ret != -1) return ret;
    ret = -INF;
    ret = max(ret, func(c-1, t - w[c]) + wv[c]);
    ret = max(ret, func(c-1, t- b[c]) + bv[c]);
    return ret;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> k;
    memset(cache, -1, sizeof(cache));
    for(int i=1; i<=n; i++){
        cin >> w[i] >> wv[i] >> b[i] >> bv[i];
    }

    cout << func(n, k);


    return 0;
}
