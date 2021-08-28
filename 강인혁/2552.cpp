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

const int INF= numeric_limits<int>::max();

ll n, k;

// [전구] = 스위치
vector<int> A;
// 스위치의 최소값, 상태들
map<int, vector<ll>> m;

int ans;

// left, right, 스위치, 상태, 전구
void func(int l, int r, int minS, int maxS, ll state, int maxB){
    if(l == r){
		// 공집합 빼
		if(state == 0) return;
		m[minS].push_back(state);
		k--;
		if(k == 0)
			ans = state;
		
		return;
    }

	func(l-1, r, minS, maxS, state, maxB);
	if(A[l] > maxS){
		if(minS == INF) func(l-1, r, A[l], A[l], state | ll(pow(2,l-1)), l);
		else func(l-1, r, minS, A[l], state | ll(pow(2,l-1)), maxB);
	}
}

void func2(int l, int r, int minS, int maxS, ll state, int maxB){
	if(ans != -1) return;
	if(l ==r){
		if(state == 0) return;
		// 일단 {공집합} X {state} 먼저 보기
		if(k == 1){
			ans = state;
			
			return;

		}
		k--;
		// func에서 만들었던 수열과 합치기
		int cnt =  0;
		auto it = m.upper_bound(maxS);
		for( ; it != m.end(); it++){
			auto vec = it->second;
			int sz = vec.size();	
			cnt += sz;	
		}
		if(k > cnt) k-=cnt;
		else{
			vector<int> temp;
			for(it = m.upper_bound(maxS); it != m.end(); it++){
				auto vec = it->second;
				int sz = vec.size();
				for(int i =0; i<sz; i++){
					temp.push_back(state | vec[i]);
				}
			}
			sort(temp.begin(), temp.end());
			ans = temp[k-1];
		}

		return;
	}

	func2(l-1, r, minS, maxS, state, maxB);
	if(A[l] > maxS){
		if(minS == INF) func2(l-1, r, A[l], A[l], state | ll(pow(2,l-1)), l);
		else func2(l-1, r, minS, A[l], state | ll(pow(2,l-1)), maxB);
	}
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    A = vector<int>(n+1);
    for(int i=n; i>0; i--){
		int s;
        cin >> s;
		A[i] = s;
    }
    
    cin >> k;
	k--; // 공집합 빼기
	if(k == 0){
		cout << 0 << endl;
		return 0;
	}

    ans = -1;

	func(n/2, 0, INF, 0, 0, 0);
	func2(n, n/2, INF, 0, 0, 0);

	cout << ans << endl;
    

    return 0;
}
