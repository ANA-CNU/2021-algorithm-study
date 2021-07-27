#include <iostream>
#include <vector>
#include <queue>
using namespace std;
vector<vector<int>> v;
vector<bool> check;

int bfs(int start)
{
	check[start] = true;
	queue<pair<int, int>> q;
	for (int i = 0; i < v[start].size(); i++)
		q.push(make_pair(1, v[start][i]));

	int sum = 0;
	while(!q.empty())
	{
		int level = q.front().first;
		int target = q.front().second;
		q.pop();

		if (check[target]) continue;

		sum += level;
		check[target] = true;
		for (int i = 0; i < v[target].size(); i++)
			q.push(make_pair(level + 1, v[target][i]));
	}

	return sum;
}

int main()
{
	int n, m;
	cin >> n >> m;

	v.assign(n + 1, vector<int>(0, 0));
	for (int i = 0; i < m; i++)
	{
		int f1, f2;
		cin >> f1 >> f2;
		v[f1].push_back(f2);
		v[f2].push_back(f1);
	}

	int minimum = INT32_MAX;
	int index = n + 1;
	for (int i = 1; i <= n; i++)
	{
		check.clear();
		check.assign(n + 1, false);
		int comp = bfs(i);
		if (minimum >= comp)
		{
			index = minimum == comp ? min(index, i) : i;
			minimum = comp;
		}
	}

	cout << index << '\n';

	return 0;
}