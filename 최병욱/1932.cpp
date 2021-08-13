// [정수 삼각형](https://www.acmicpc.net/problem/1932)
// DFS로 풀었을때는 시간 초과를 받아서 시간 복잡도 계산을 해보니 O(2^n)으로 코드가 작동하고있었음.
// 그래서 DP로 풀이를 해보니 O(N^2 + NlogN)으로 풀이가 가능해서 로직을 다시 짜고 제출하니 AC를 받음.
// 코드의 마지막 부분에 가장 큰 수를 찾기위해 쓰는 sort를 쓰지않으면 O(N^2 + N)으로 줄일 수 있을것같다.
// 다른 사람의 코드를 보고 좀 더 깔끔하게 짤 방법이 없는지 고민해보기.

#include <bits/stdc++.h>
using namespace std;
int n;
vector<vector<int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n;

	v.assign(n, vector<int>(n, 0));
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < i + 1; j++)
		{
			int num;
			cin >> num;

			if (i == 0){
				v[i][j] = num;
			}
			else{
				v[i][j] = num + max(v[i - 1][j - 1 < 0 ? 0 : j - 1], v[i - 1][j]);
			}
		}
	}

	sort(v[n - 1].begin(), v[n - 1].end());
	cout << v[n - 1][n - 1] << '\n';

	return 0;
}