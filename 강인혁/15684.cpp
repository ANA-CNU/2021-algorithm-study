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

bool ladder[111][555];

int n, m ,h;
int dst[111];

int ans = 4;

void func(int g, int cnt){
    if(ans < 4) return;
    if(cnt == g){
        //O(N * M), base case
        bool flag = true;
        for(int j=1; j<=m; j++){
            int curX = j;
            for(int i =1; i<=n; i++){
                if(ladder[i][curX]){
                    curX++;
                }
                else if(ladder[i][curX-1]){
                    curX--;
                }
            }
            if(curX != j){
                flag = false;
                break;
            }
        }
        if(flag){
            ans = min(ans, g);
        }
        return;
    }

    for(int j=1; j<m; j++){
        for(int i =1; i<=n; i++){
            if(ladder[i][j] || ladder[i][j-1] || ladder[i][j+1]) continue;
            ladder[i][j] = true;
            func(g, cnt+1);
            ladder[i][j] = false;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> m >> h >> n;

    memset(ladder, false, sizeof(ladder));
    for(int i=0; i<h; i++){
        int a, b;
        cin >> a >> b;
        ladder[a][b] = true;
    }

    for(int i =0; i<4; i++){
        func(i,0);
        if(ans != 4){
            cout << ans << endl;
            break;
        }
    }
    if(ans == 4) cout << -1 << endl;

    return 0;
}
