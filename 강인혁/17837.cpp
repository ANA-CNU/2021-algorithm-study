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
#include<list>
typedef long long ll;
using namespace std;    

const int INF= 0x3f3f3f3f;
const ll MOD = 1000000;

const int dy[5] = {0,0,0,-1,1};
const int dx[5] = {0,1,-1,0,0};
int n, k;

list<int> block[22][22];
int c[22][22];

int dir[22];
// 위치 정보
pair<int,int> node[22];

bool flag = false;

void mov(int idx){
    int y = node[idx].first, x = node[idx].second;
    
    int ny = y + dy[dir[idx]], nx = x + dx[dir[idx]];

    // 제자리 진동
    if(c[ny][nx] == 2 || ny < 1 || ny > n || nx < 1 || nx > n){
        ny = y - dy[dir[idx]], nx = x - dx[dir[idx]];
        if(dir[idx] == 1) dir[idx] = 2;
        else if(dir[idx] == 2) dir[idx] = 1;
        else if(dir[idx] == 4) dir[idx] = 3;
        else dir[idx] = 4;
        if(ny < 1 || ny > n || nx < 1 || nx > n || c[ny][nx] == 2){
            return;
        }
        mov(idx);
        return;
    }

    bool rev = c[ny][nx] == 1 ? true : false;

    list<int> curList = block[y][x];
    list<int>::reverse_iterator where;

    list<int> newOne;
    // make newOne
    int cnt =0;
    for(auto it = curList.rbegin(); it != curList.rend(); it++){
        if(*it == idx){
            where = it;
            cnt++;
            if(rev){
                newOne.push_back(*it);
                node[*it] = {ny,nx};
            }
            else{
                newOne.push_front(*it);
                node[*it] = {ny,nx};
            }
            break;
        }
        else{
            cnt++;
            if(rev){
                newOne.push_back(*it);
                node[*it] = {ny,nx};
            }
            else{
                newOne.push_front(*it);
                node[*it] = {ny,nx};
            }
        }
    }
    // pop
    for(int i=0; i<cnt; i++) curList.pop_back();


    // update list
    if(block[ny][nx].empty()){
        block[y][x] = curList;
        block[ny][nx] = newOne;
    }
    else{
        block[y][x] = curList;
        block[ny][nx].splice(block[ny][nx].end(), newOne);
    }
}



int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> k;

    memset(c, -1, sizeof(c));
    for(int i=1; i<=n; i++) for(int j=1; j<=n; j++) cin >> c[i][j];

    for(int i=1; i<=k; i++){
        int d, y, x;
        cin >> y >> x >> d;
        block[y][x].push_back(i);
        node[i] = {y,x};
        dir[i] = d;
    }

    for(int turn = 1; turn <= 1000; turn++){
        for(int i=1; i<=k; i++){
            mov(i);
            for(auto no : node){
                if(block[no.first][no.second].size() >= 4){
                    cout << turn << endl;
                    return 0;
                }
            }
        }     
    }
    cout << -1 << endl;

    return 0;
}

