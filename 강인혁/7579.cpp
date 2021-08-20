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

//const int INF = numeric_limits<int>::max();
const int INF= 0X3F3F3F3F;

int N, M;
vector<int> m, c;; 
vector<pair<double, int>> efficiency;

int n;
// cost에서 얻을 수 있는 최대 메모리
int cache[111][11111];

// here에서 cost로 얻을 수 있는 최대 메모리 반환
int canGet(int here, int cost){
    if(here >= N) return 0;

    int& ret = cache[here][cost];
    if(ret != -1) return ret;
    ret = 0;
    
    ret = canGet(here+1, cost);
    if(cost >= c[here])
        ret = max(ret, canGet(here+1, cost - c[here]) + m[here]);

    return ret;
}

// M을 얻을 수 있는 최소 메모리 반환
int func(){
    int ans =-1;
    int cost =0;
    while(1){
        if(canGet(0, cost) >= M){
            ans = cost;
            break;
        }
        cost++;
        if(cost > 11111) break;
    }
    return ans;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
	cin >> N >> M;
	m = vector<int>(N,0);
	c = vector<int>(N,0);
	for(int i=0; i<N; i++) cin >> m[i];
	for(int i=0; i<N; i++) cin >> c[i];

	memset(cache, -1, sizeof(cache));
	cout << func() << endl;
	

	

    return 0;
}
