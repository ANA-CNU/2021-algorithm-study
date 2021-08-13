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

int n, m, k;
vector<pair<int,int>> p;

int cache[555][555];

int cost(int s, int i, int e){
    int ret = p[s].first * p[i].second * p[e].second;
    return ret;
}

// [s,e]의 최소 연산 횟수
int func(int s, int e){
    int &ret = cache[s][e];
    if(ret != INF) return ret;
    ret = INF;

    if(s + 1 == e){
        return cost(s,s,e);
    }
    else if(s == e){
        return 0;
    }
    
    // 교환법칙으로 쪼개서 보기
    for(int i=s; i<e; i++){
        int temp = 0;
        temp += func(s, i);
        temp += func(i+1, e);
        temp += cost(s,i, e);
        ret = min(ret, temp);
    }
    if(ret == INF){
        cout << s <<  "  "<< e << endl;
    }
    return ret;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n;
    
    for(int i=0; i<n; i++){
        int r, c;
        cin >> r >> c;
        p.push_back({r,c});
    }
    
    memset(cache, INF, sizeof(cache));
    cout << func(0, n-1);
    


    return 0;
}
