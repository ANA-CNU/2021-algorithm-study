#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	int n, m;
	cin >> n >> m;
	
	vector<int> mems(n + 1, 0);
	for (int i = 1; i <= n; i++)
		cin >> mems[i];
	
	int maxCost = 0;
	vector<int> costs(n + 1, 0);
	for (int i = 1; i <= n; i++)
	{
		cin >> costs[i];
		maxCost += costs[i];
	}
	
	vector<vector<int>> dp(n + 1, vector<int>(maxCost + 1, 0));
	for (int i = 1; i <= n; i++)
	{
		for (int j = 0; j <= maxCost; j++)
		{
			dp[i][j] = j - costs[i] >= 0 ? max(dp[i - 1][j], mems[i] + dp[i - 1][j - costs[i]]) : dp[i - 1][j];
		}
	}

	for (int i = 0; i <= maxCost; i++)
	{
		if (dp[n][i] >= m)
		{
			cout << i << '\n';
			break;
		}
	}
}
