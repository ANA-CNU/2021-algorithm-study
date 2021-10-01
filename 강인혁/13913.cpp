#include<iostream>
#include<string>
#include<sstream>
#include<vector>
#include<map>
#include<cmath>
#include<algorithm>
#include<regex>
#include<queue>
typedef long long ll;
using namespace std;    

const int INF= 0x3f3f3f3f;

int n, k;

int dx[3] = {1,-1,0};

vector<int> path(111111,-1);

int bfs(int start){
    queue<int> q;
    vector<int> dist(111111, -1);
    q.push(start);
    dist[start] = 0;
    while(!q.empty()){
        int here = q.front();
        q.pop();

        int next = here;
        for(int i=0; i<3; i++){
            int dxx = dx[i];
            if(dxx == 0){
                next = here *2;
                if(next > 100000) continue;
            }
            else next = here + dxx;
            if(next < 0) continue;
            if(dist[next] == -1){
                q.push(next);
                dist[next] = dist[here]+1;
                path[next] = here;
            }
        }
    }

    return dist[k];
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> k;

    cout << bfs(n) << endl;
    vector<int> p;
    int here = k;
    while(here != -1){
        p.push_back(here);
        here = path[here];
    }
    reverse(p.begin(), p.end());
    for(auto pth : p) cout << pth << " ";
    return 0;
}
