#include <iostream>
#include <vector>
using namespace std;
int M, N, K;
vector<vector<int>> map;

void dfs(int x, int y)
{
	map[y][x]++;

	int dx[] = {1, -1, 0, 0};
	int dy[] = {0, 0, 1, -1};
	for (int i = 0; i < 4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < 0 || nx >= M || ny < 0 || ny >= N)
			continue;

		if (map[ny][nx] == 1)
			dfs(nx, ny);
	}
}

int main()
{
	int t;
	cin >> t;

	while (t--)
	{
		cin >> M >> N >> K;
		map.clear();
		map.assign(N, vector<int>(M, 0));

		for (int i = 0; i < K; i++)
		{
			int x, y;
			cin >> x >> y;
			map[y][x]++;
		}

		int answer = 0;
		for (int y = 0; y < N; y++)
		{
			for (int x = 0; x < M; x++)
			{
				if (map[y][x] == 1)
				{
					dfs(x, y);
					answer++;
				}
			}
		}

		cout << answer << '\n';
	}

	return 0;
}