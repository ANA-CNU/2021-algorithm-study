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

int n, m;

struct tri{
    int a, b, c;
    tri(int _a, int _b, int _c) : a(_a), b(_b), c(_c){};
};

pair<int,int> nextNums(int a, int b){
    if(a == b) return {-1, -1};
    if(a > b){
        a -= b;
        b += b;
    }
    else if(b > a){
        b -= a;
        a += a;
    }
    return {a,b};
}

int visited[1555][1555];


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int a, b, c;
    cin >> a >> b >> c;

    tri t(a,b,c);

    queue<tri> q;
    q.push(t);
    
    memset(visited, -1, sizeof(visited));
    if(a == b && b == c){
        cout << 1 << endl;
        return 0;
    }
    visited[a][b] = 0 ;

    int d = (a + b + c) / 3;
    if((a + b + c) % 3 != 0){
        cout << 0 << endl;
        return 0;
    }
    int ans = 0;
    
    while(!q.empty()){
        tri here = q.front();
        if(visited[d][d] == 1){
            ans = 1;
            break;
        }
        q.pop();
        int one = here.a, two = here.b, three = here.c;
        auto temp = nextNums(one, two);
        if(temp.first != -1 && temp.first < 5)
            if(visited[temp.first][temp.second] == -1){
                visited[temp.first][temp.second] = 1;
                tri next(temp.first, temp.second, three);
                q.push(next);
            }
        temp = nextNums(one, three);
        if(temp.first != -1)
            if(visited[temp.first][two] == -1){
                visited[temp.first][two] = 1;
                tri next(temp.first, two, temp.second);
                q.push(next);
            }
        temp = nextNums(two, three);
        if(temp.first != -1)
            if(visited[one][temp.first] == -1){
                visited[one][temp.first] = 1;
                tri next(one, temp.first, temp.second);
                q.push(next);
            }
    }
    
    
    cout << ans << endl;
    
    return 0;
}
