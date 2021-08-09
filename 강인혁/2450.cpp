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

int n;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n;
    vector<int> arr(n);
    int cnt[4] = {0};
    for(int i=0; i<n; i++){
        cin >> arr[i];
        cnt[arr[i]]++;
    }

    int ans = INF;
    vector<int> temp = {1,2,3};
    do{
        int pos[4][4] = {0};
        int curIdx = 0;
        for(int i=0; i<3; i++){
            int curNum = temp[i];
            int curNumCnt = cnt[curNum];
            for(int j = curIdx; j < curIdx + curNumCnt; j++){
                pos[arr[j]][curNum]++;
            }
            curIdx += curNumCnt;

        }

        ans = min(ans, pos[1][2] + pos[1][3] + max(pos[2][3], pos[3][2]));
    }
    while(next_permutation(temp.begin(), temp.end()));

    cout << ans << endl;

    return 0;
}
