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

int n, m;

int block[11][11];

bool visited[11][11];

// y,x가 기존의 비숍이랑 겹치는지 조사 O(n^)
bool judge(int y, int x){
    // 왼쪽위
    for(int j = x-1, i = y-1; j>=0 && i >=0; j--, i--){
        if(visited[i][j]) return false;
    }
    // 오른쪽위
    for(int j = x + 1, i = y-1; j<n && i >= 0; j++, i--){
        if(visited[i][j]) return false;
    }

    return true;
}

int ans;

// 모든 경우 돌며 최대 개수 갱신
void func(int y, int x, int cnt, int start){
    ans = max(ans, cnt);

    int temp =0;
    for(int i=start; i< n*n; i+=2){
        int yy = i /n, xx = i%n;
        if(temp != yy && n % 2 == 0){
            temp = yy;
            i--;
            xx = i % n;
        }
        if(i <= y * n + x) continue;
        if(block[yy][xx] == 0) continue;
        if(judge(yy, xx) == false) continue;

        visited[yy][xx] = true;
        func(yy, xx, cnt + 1, start);
        visited[yy][xx] = false;
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    cin >> n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> block[i][j];
        }
    }


    ans = -1;
    
    func(-1,-1,0,0);
    int ans2 = ans;

    ans = -1;
    func(-1,-1,0,1);
    cout << ans + ans2 << endl;

   
    return 0;
}
