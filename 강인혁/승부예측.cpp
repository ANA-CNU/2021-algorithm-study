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

pair<double,double> adj[5][5];
vector<double> ans;

int wins[5][5];

bool cmp(pair<int,int> a, pair<int,int> b){
    return a.first > b.first;
}

void func(int i, int j, double rates){
    if(rates < numeric_limits<double>::epsilon()){
        return;
    }

    if(i == 2 &&  j == 3){
        vector<int> scores(4, 0);
        for(int y= 0; y<4; y++){
            for(int x=y+1; x <4; x++){
                if(wins[y][x] == 1){
                    scores[y] += 3;
                }
                else if(wins[y][x] == 0){
                    scores[y] += 1;
                    scores[x] += 1;
                }
                else{
                    scores[x] += 3;
                }
            }
        }

        vector<pair<int,int>> vp;
        for(int i=0; i<4; i++){
            vp.push_back({scores[i], i});
        }

        int cnt = 2;
        while(cnt > 0){
            int num =0, mx;
            sort(vp.begin(), vp.end(), cmp);
            mx = vp.front().first;

            for(int i=0; i<4; i++){
                if(vp[i].first == mx) num++;
            }

            for(int i=0; i<num; i++){
                double add = num < cnt ? rates : rates * ((double)cnt / num);
                ans[vp[i].second] += add;
                vp[i].first = -1;
            }
            cnt -= cnt > num ? num : cnt;
        }
        
        return;
    }
    j++;
    if(j == 4){
        i++;
        j = i+1;
    }
    wins[i][j] = 1;
    func(i, j, rates * adj[i][j].first);
    wins[i][j] = 0;
    func(i, j, rates * adj[i][j].second);
    wins[i][j] = -1;
    func(i, j, rates * adj[j][i].first);
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    vector<string> country(55);
    map<string, int> m;
    for(int i=0; i<4; i++){
        cin >> country[i];
        m[country[i]] = i;
    }

    for(int i=0; i<6; i++){
        string first, second;
        double win, draw, lose;
        cin >> first >> second >> win >> draw >> lose;
        adj[m[first]][m[second]] = {win, draw};
        adj[m[second]][m[first]] = {lose, draw};
    }

    ans = vector<double>(4, 0);

    func(0,0, 1.0);


    for(int i=0; i<4; i++){
        cout << ans[i] << endl;
    }

    return 0;
}
