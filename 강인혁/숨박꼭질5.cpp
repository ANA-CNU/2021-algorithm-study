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

const int INF = 987654321;
const int MAX = 500001;

int sum(int n){
    return n * (n + 1) / 2;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    int n, k;
    cin >> n >> k;
    int dist[2][MAX];
    memset(dist, -1, sizeof(dist));
    // 위치, 시간
    queue<pair<int,int>> q;
    q.push({n, 0});

    while(!q.empty()){
        int here = q.front().first;
        int time = q.front().second;
        q.pop();

        if(here < 0 || here >= MAX) continue;
        if(dist[time%2][here] != -1) continue;

        dist[time % 2][here] = time;

        q.push({here + 1, time + 1});
        q.push({here - 1, time + 1});
        q.push({here * 2, time + 1});
    }

    for(int i=0; i< MAX; i++){
        int nextK = k + sum(i);
        if(nextK > MAX) break;
        if(dist[i % 2][nextK] != -1 && dist[i%2][nextK] <= i){
            cout << i << endl;
            return 0;
        }
    }
    cout << -1;

    return 0;
}
