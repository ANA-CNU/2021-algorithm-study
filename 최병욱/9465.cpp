// [스티커](https://www.acmicpc.net/problem/9465)
// 전형적인 DP 문제
// 예전에 한번 풀려고 시도했었다가 실패한 문제
// 그래서 DP로 풀어야한다는것은 인지하고있었으나 대각선 3개이상까지 확인을 해야하나 고민을해서 풀지 못한 문제
// DP문제는 항상 노트에 써가면서 풀도록 해볼것

#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin >> t;

	while (t--)
	{
		int n;
		cin >> n;

		vector<vector<int>> v(2, vector<int>(n + 2, 0));
		for (int i = 0; i < n; i++)
			cin >> v[0][2 + i];

		for (int i = 0; i < n; i++)
			cin >> v[1][2 + i];

		for (int col = 2; col < n + 2; col++)
		{
			v[0][col] += max(v[1][col - 1], v[1][col - 2]);
			v[1][col] += max(v[0][col - 1], v[0][col - 2]);
		}

		cout << max(v[0][n + 1], v[1][n + 1]) << '\n';

	}

	return 0;
}