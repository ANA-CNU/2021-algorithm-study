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

int n, k;
vector<int> v, c;
vector<pair<int,int>> p;

// 가치, 가격
// 가치를 만들 수 있는 가장 최소 가격 저장
map<int,int> m1;
map<int,int> m2;

void func(int l, int r, int vSum, int cSum){
    if(l == r){
        if(m1.find(vSum) == m1.end()){
            m1[vSum] = cSum;
        }
        else{
            m1[vSum] = min(m1[vSum], cSum);
        }
        return;
    }

    func(l+1, r, vSum, cSum);
    vSum += v[l];
    cSum += c[l];
    func(l+1, r, vSum, cSum);
}

int ans = INF;
void func2(int l, int r, int vSum, int cSum){
    if(l == r){
        if(m1.lower_bound(k - vSum) != m1.end()){
            ans = min(ans, m1.lower_bound(k - vSum)->second + cSum);
        }
        return;
    }
    func2(l+1, r, vSum, cSum);
    vSum += v[l];
    cSum += c[l];
    func2(l+1, r, vSum, cSum);
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
	
	cin >> n;
    v = vector<int>(n);
    c = vector<int>(n);
    for(int i=0; i<n; i++){
        cin >> c[i];
    }
    for(int i=0; i<n; i++){
        cin >> v[i];
    }

    p = vector<pair<int,int>>(n);

    cin >> k;
    int t;
    cin >> t;
    int initMoney =0;;
    while(t--){
        int temp;
        cin >> temp;
        initMoney += c[temp];
    }

    func(0, n/2, 0,0);
    int minCost = INF;
    for(auto it = m1.rbegin(); it != m1.rend(); it++){
        if(it->second < minCost){
            minCost = it->second;
        }
        else{
            it->second = minCost;
        }
    }

    func2(n/2, n, 0,0);
    if(ans == INF) cout << -1 << endl;
    else if(ans - initMoney < 0) cout << 0 << endl;
    else cout << ans - initMoney << endl;

    return 0;
}
