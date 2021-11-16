                                                          
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
const ll MOD = 1000000;

ll ccw(pair<int,int> p1, pair<int,int> p2, pair<int,int> p3){
    ll dot = (p2.first - p1.first) * (p3.second - p1.second) - (p3.first - p1.first) * (p2.second - p1.second);
    return dot;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    vector<pair<int,int>> p;
    for(int i =0; i<4; i++){
        int y, x;
        cin >> x >> y;
        p.push_back({x,y});
    }

    ll t1 = ccw(p[0], p[1], p[2]);
    ll t2 = ccw(p[0], p[1], p[3]);
    if(t1 * t2 < 0){
        cout << 1 << endl;
    }
    else cout << 0 << endl;



    return 0;
}
