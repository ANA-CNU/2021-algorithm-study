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

int n, s;
vector<int> a;

int temp[11111111];

void func(int l, int r, int sum){

    if(l == r){
        temp[sum + (int)2e6]++;
        return;
    }

    func(l+1, r, sum);
    sum += a[l];
    func(l+1, r, sum);
}
ll ans = 0;

void func2(int l, int r, int sum){
    if(l == r){
        ans += temp[s - sum + (int)2e6];
        return;
    }
    func2(l+1, r, sum);
    sum += a[l];
    func2(l+1, r, sum);
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
	
	cin >> n >> s;
    a = vector<int>(n);
    for(int i=0; i<n; i++){
        cin >> a[i];
    }
    
    vector<int> l, r;
    func(0, n/2, 0);
    func2(n/2, n, 0);

    sort(r.begin(), r.end());
    if(s == 0) ans--;
    cout << ans << endl;


    return 0;
}
