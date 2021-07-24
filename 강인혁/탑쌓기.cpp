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

int h[1111111];
int n;

int ans[1111111];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> h[i];
    }

    stack<pair<int,int>> st;
    st.push({INF, 0});
    for(int i=1; i<=n; i++){
        while(st.top().first <= h[i]){
            st.pop();
        }

        ans[i] = st.top().second;
        st.push({h[i], i});
    }

    for(int i=1; i<=n; i++){
        cout << ans[i] << " ";
    }

    return 0;
}
