                                                          
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

ll n;

typedef vector<vector<ll>> mat;

mat getDefault(ll n){
    mat ret = vector<vector<ll>>(n, vector<ll>(n, 0));
    for(ll i=0; i<n; i++) ret[i][i] = 1;
    return ret;
}


// a와 b의 곱셈
mat multiply(mat a, mat b){
    if(a[0].size() != b.size()){
        return mat(0);
    }

    mat ret = mat(a.size(), vector<ll>(b[0].size(), 0));
    for(ll j= 0; j < b[0].size(); j++){
        for(ll i =0; i < a.size(); i++){
            for(ll k =0; k < b.size(); k++){
                ret[i][j] += a[i][k] * b[k][j];
                ret[i][j] %= MOD;
            }
        }
    }

    return ret;
}


// a를 n번 제곱, a는 무조건 정방행렬이어야함
mat pow(mat a, ll n){
    if(n == 1) return a;
    if(n % 2) return multiply(pow(a, n-1), a);
    
    mat temp = pow(a, n/2);
    return multiply(temp, temp);
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    if(n ==1 || n == 2){
        cout << 1 << endl;
        return 0;
    }
    mat start = vector<vector<ll>>(2, vector<ll>(2));
    start[0][0] = start[0][1] = start[1][0] = 1;
    mat ret = pow(start, n-2);
    mat baseCase = mat(2, vector<ll>(1));
    baseCase[0][0] = 1;
    baseCase[1][0] = 1;

    ret = multiply(ret, baseCase);

    
    cout << ret[0][0] << endl;


    return 0;
}
