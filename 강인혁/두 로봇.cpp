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

const int INF = 0x7FFFFFFF;
int n, m;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    int start, dst;
    cin >> start >> dst;

    vector<pair<int,int>> adj[111111];
    for(int i=0; i<n-1; i++){
        int a, b, c;
        cin >> a >> b >> c;
        adj[a].push_back({b,c});
        adj[b].push_back({a,c});
    }

    vector<int> dist(111111, -1);
    vector<int> parent(111111, 0);
    parent[start] = start;

    queue<int> q;
    q.push(start);
    dist[start] =0;
    while(!q.empty()){
        int here = q.front();
        q.pop();
        int cost = dist[here];

        for(int i=0; i< adj[here].size(); i++){
            int next = adj[here][i].first;
            int length = adj[here][i].second;

            if(dist[next] == -1){
                int nextCost = cost + length;
                q.push(next);
                dist[next] = nextCost;
                parent[next] = here;
            }
        }
    }

    // start에서 dst에 이르는 경로를 뽑아내기
    vector<int> path;
    int next = dst;
    while(next != parent[next]){
        path.push_back(next);
        next = parent[next];
    }

    int maxL = 0;
    for(int i=0; i< path.size(); i++){
        int pathV = path[i];
        maxL = max(maxL, dist[pathV] - dist[parent[pathV]]);
    }

    cout << dist[dst] - maxL << endl;

    return 0;
}
