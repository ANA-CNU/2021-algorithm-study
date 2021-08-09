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
vector<int> pos[111][111];
int a[111][111];
int b[111][111];

const int dy[8] = {-1,-1,-1,0,0,1,1,1};
const int dx[8] = {-1,1,0,-1,1,-1,1,0};

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m >> k;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cin >> a[i][j];
            // 초기값 5
            b[i][j] = 5;
        }
    }
    
    int cnt = 0;
    for(int i=0; i<m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        pos[a][b].push_back(c);
        cnt++;
    }

    for(int l=0; l<k; l++){
        // 봄, 여름
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(pos[i][j].size() == 0) continue;
                vector<int> temp;
                sort(pos[i][j].begin(), pos[i][j].end());

                int dieE = 0;
                for(int p=0; p< pos[i][j].size(); p++){
                    int age = pos[i][j][p];
                    if(b[i][j] >= age){
                        b[i][j] -= age;
                        temp.push_back(age+1);
                    }
                    else{
                        cnt--;
                        int nutrient = age/2;
                        dieE += nutrient;
                    }
                }
                
                pos[i][j].clear();
                for(int ii =0; ii < temp.size(); ii++){
                    pos[i][j].push_back(temp[ii]);
                }
                b[i][j] += dieE;
            }
        }
        
        // 가을
        for(int y=1; y<=n; y++){
            for(int x=1; x<=n; x++){
                int s = pos[y][x].size();
                if(s == 0) continue;
                for(int p=0; p< s; p++){
                    int age = pos[y][x][p];
                    if(age % 5 != 0) continue;
                    for(int i=0; i<8; i++){
                        int nextY = y + dy[i], nextX = x + dx[i];
                        if(nextY <= 0 || nextY > n || nextX <= 0 || nextX > n) continue;
                        pos[nextY][nextX].push_back(1);
                        cnt++;
                    }
                }
            }
        }

        // 겨울
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                b[i][j] += a[i][j];
            }
        }
    }
    cnt = 0;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cnt += pos[i][j].size();
        }
    }
    cout << cnt << endl;

    return 0;
}
