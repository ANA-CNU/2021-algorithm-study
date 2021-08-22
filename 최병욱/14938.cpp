// [서강그라운드](https://www.acmicpc.net/problem/14938)
// 그래프 최단거리 탐색 문제
// 보자마자 어제 공부한 플로이드-와샬이 떠올라서 쉽게 풀었음.
// DFS와 다익스트라로도 풀이가 가능하다고 하니 풀이를 참고해볼것!

#include <bits/stdc++.h>
#define INF 15000
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m, r;
	cin >> n >> m >> r;

	vector<int> items(n, INF);
	for (int i = 0; i < n; i++)
	{
		cin >> items[i];
	}

	vector<vector<int>> dp(n, vector<int>(n, INF));
	for (int i = 0; i < n; i++)
		dp[i][i] = 0;

	for (int i = 0; i < r; i++)
	{
		int from, to, cost;
		cin >> from >> to >> cost;
		dp[from - 1][to - 1] = cost;
		dp[to - 1][from - 1] = cost;
	}

	for (int k = 0; k < n; k++)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
			}
		}
	}

	int answer = 0;
	for (int i = 0; i < n; i++)
	{
		int comp = 0;
		for (int j = 0; j < n; j++)
		{
			if (dp[i][j] <= m) comp += items[j];
		}
		answer = max(answer, comp);
	}

	cout << answer << '\n';

	return 0;
}