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

const ll INF= numeric_limits<ll>::max();

int n;
vector<ll> A, B;

// 점수, 배열, 인원
map<ll, ll> m[32];

void print(ll c){
    vector<int> temp;
    for(int i =0; i<n; i++){
        temp.push_back(c % 2);
        c /=2;
    }
    reverse(temp.begin(), temp.end());
    for(int i=0; i< temp.size(); i++){
        cout << temp[i] + 1 << " ";
    }
}

void func(int l, int r, ll curSum, int oneCnt, ll curArr){
    if(l == r){
        if(m[oneCnt].find(curSum) == m[oneCnt].end())
            m[oneCnt][curSum] = curArr;
        else m[oneCnt][curSum] = min(m[oneCnt][curSum], curArr);
        
        return;
    }
    
    func(l+1, r, curSum + A[l], oneCnt+1, curArr);
    func(l+1, r, curSum - B[l], oneCnt, curArr | ll(pow(2, n-1-l)));
}

pair<ll,ll> ans = {INF, INF};

void func2(int l, int r, ll curSum, int twoCnt, ll curArr){
    if(l == r){
        if(m[twoCnt].size() == 0) return;
        auto it = m[twoCnt].lower_bound(-curSum);

        ll nextArr = curArr | it->second;
        if(it != m[twoCnt].end())
            ans = min(ans, {abs(curSum + it->first), nextArr});
        
        if(it != m[twoCnt].begin()){
            --it;
            nextArr = curArr | it->second;
            ans = min(ans, {abs(curSum + it->first), nextArr});
        }
        
        return;
    }
    func2(l+1, r, curSum + A[l], twoCnt, curArr);
    func2(l+1, r, curSum - B[l], twoCnt + 1, curArr | ll(pow(2, n-1-l)));
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    A = vector<ll>(n);
    B = vector<ll>(n);
    for(int i = 0; i<n; i++){
        cin >> A[i];
    }
    for(int i =0; i<n; i++){
        cin >> B[i];
    }

    func(0, n/2, 0, 0, 0);
    func2(n/2, n, 0, 0, 0);
    
    //cout << ans.first << "   " << ans.second << endl;
    print(ans.second);
    
    return 0;
}
