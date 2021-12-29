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

// const int INF= 0x3f3f3f3f;
const ll MOD = 1000000;

const ll INF = numeric_limits<ll>::max();

struct Data {
    ll f, s, t;
    ll sum;
    bool operator < (const Data& rhs) const {
        return sum < rhs.sum;
    }
};

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n, m;

    cin >> n;
    vector<ll> arr(n);
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());

    Data t;
    t.f = arr[0], t.s = arr[1], t.t = arr[2];
    t.sum = INF;

    for(int i=0; i <n-1; i++) {
        int target = arr[i];
        int start = i + 1, end = n-1;
        while(start < end) {

            Data tt;
            tt.f = arr[i], tt.s = arr[start], tt.t = arr[end];
            tt.sum = abs(tt.f + tt.s + tt.t);

            t = min(t, tt);

            if(arr[start] + arr[end] + target < 0) {
                start++;
            }
            else end--;
        }
    }

    cout << t.f << " " << t.s << " " << t.t << endl;
    

    return 0;
}
