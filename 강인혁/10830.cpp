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

const int INF = 1e9;

int n, m, k;

const int MOD = 1000;

class squareMatrix{
    public:
        int n;
        squareMatrix operator * (const squareMatrix& rhs);
        vector<vector<int>> mat;
        squareMatrix identity();
        squareMatrix pow(const squareMatrix& A,ll b);
};

squareMatrix squareMatrix::identity(){
    vector<vector<int>> ret(n, vector<int>(n,0));
    for(int i =0; i<n; i++)
        for(int j=0; j<n; j++)
            if(i == j) ret[i][j] = 1;

    squareMatrix m;
    m.mat = ret;
    m.n = n;
    return m;
}
squareMatrix squareMatrix::operator*(const squareMatrix& rhs){
    vector<vector<int>> ret(n, vector<int>(n, 0));

    for(int y =0; y<n; y++){
        for(int x=0; x<n; x++){
            for(int i=0; i<n; i++){
                ret[y][x] += mat[y][i] * rhs.mat[i][x];
                ret[y][x] %= MOD;
            }
        }
    }
    squareMatrix m;
    m.mat = ret;
    m.n = n;
    return m;
}

squareMatrix squareMatrix::pow(const squareMatrix& A, ll b){
    if(b == 0) return identity();
    if(b % 2) return pow(A, b-1) * A;

    squareMatrix half = pow(A, b/2);
    return half * half;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    ll b;
    cin >> n >> b;
    vector<vector<int>> mat(n, vector<int>(n, 0));
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> mat[i][j];
        }
    }

    squareMatrix m;
    m.mat = mat;
    m.n = n;
    m = m.pow(m, b);
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cout << m.mat[i][j] << " ";
        }
        cout << endl;
    }


    return 0;
}
