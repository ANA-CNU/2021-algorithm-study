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
#include <array>
typedef long long ll;
using namespace std;    

const int INF= 0x3f3f3f3f;
const ll MOD = 1000000;

const int dy[4] = {0,0,-1,1};
const int dx[4] = {1,-1,0,0};

struct DisjointSet{
    vector<int> parent;
    vector<int> rank;
    DisjointSet(int n){
        parent = vector<int>(n);
        for(int i=0; i<n; i++) parent[i] = i;
        rank = vector<int>(n, 0);
    }

    void merge(int u, int v){
        u = find(u), v = find(v);
        if(u == v) return;
        parent[u] = v;
    }
    int find(int u){
        if(parent[u] == u) return u;
        return find(parent[u]);
    }
};

int n, m;
int isMan[1111];
vector<pair<int,int>> adj[1111];


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;
    for(int i=0; i<n; i++){
        char c;
        cin >> c;
        if(c == 'M') isMan[i] = 1;
        else isMan[i] = 0;
    }

    for(int i=0; i<m; i++){
        int u, v, d;
        cin >> u >> v >> d;
        u--, v--;
        if(isMan[u] == isMan[v]) continue;
        adj[u].push_back({d, v});
        adj[v].push_back({d,u});
    }
    
    vector<bool> selected(n, false);

    vector<bool> added(n, false);
    vector<int> minWeight(n , INF), parent(n, -1);

    minWeight[0] = 0, parent[0] = 0;
    int ret = 0;
    for(int iter=0; iter <n; iter++){
        int u = -1;
        for(int v=0; v< n; v++){
            if(!added[v] && (u == -1 || minWeight[u] > minWeight[v]))
                u = v;
        }

        ret += minWeight[u];
        added[u] = true;

        for(int i=0; i < adj[u].size(); i++) {
            auto p = adj[u][i];
            int v = p.second;
            int cost = p.first;
            if(minWeight[v] < cost) continue;
            minWeight[v] = cost;
            parent[v] = u;
            selected[u] = selected[v] = true;
        }
    }
    bool flag = true;
    for(int i=0; i< n; i++) if(!selected[i]) flag = false;
    
    if(!flag) cout << -1 << endl;
    else cout << ret << endl;

    return 0;
}
