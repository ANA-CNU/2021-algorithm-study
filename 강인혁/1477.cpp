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
#include <list>
typedef long long ll;
using namespace std;    

const int INF= 0x3f3f3f3f;
const ll MOD = 1000000;

const int dy[4] = {0,-1,0,1};
const int dx[4] = {1,0,-1,0};

int n, m, l;
vector<int> dists;
vector<int> pos;
// 각 구간에 휴게소 몇개를 놓을 수 있는가
// d의 배수보다 커질때마다 하나씩 증가
bool decision(int d) {
    int cnt =0;
    for(int i=0; i < dists.size(); i++){
        cnt += dists[i] / d;
        if(dists[i] % d == 0) cnt--;
    }
    return cnt <= m;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    cin >> n >> m >> l;
    
    pos.push_back(0);
    for(int i=0; i<n; i++) {
        int t;
        cin >> t;
        pos.push_back(t);
    }
    pos.push_back(l);
    sort(pos.begin(), pos.end());

    for(int i=0; i < pos.size() -1; i++){
        dists.push_back(pos[i+1] - pos[i]);
    }

    int lo = 0, hi = l-1;
    // decision(hi) = true
    while(lo + 1 < hi) {
        int mid = (lo + hi) / 2;
        // m개로 최대값이 mid이게 지을 수 있나
        if(decision(mid)) {
            hi = mid;
        }
        else{
            lo = mid;
        }
    }
    cout << hi << endl;
    

    
    return 0;
}
