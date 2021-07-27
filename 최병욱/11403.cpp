#include <iostream>
#include <vector>
using namespace std;
vector<vector<int>> list;
vector<bool> check;

bool dfs(int start, int target)
{
	if (check[start] && start == target) return true;

	for (int i = 1; i < list[start].size(); i++)
	{
		// 해당 경로로 갈 수 있고 방문한 지점이 아니라면 탐색.
		if (list[start][i] && !check[i])
		{
			check[i] = true;
			if (dfs(i, target)) return true;
		}
	}

	return false;
}

int main()
{
	int n;
	cin >> n;

	list.assign(n + 1, vector<int>(n + 1, 0));
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			int check = 0;
			cin >> check;
			if (check)
				list[i][j]++;
		}
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			check.clear();
			check.assign(n + 1, false);
			cout << int(dfs(i, j)) <<  (j != n ? " " : "");
		}
		cout << '\n';
	}
}