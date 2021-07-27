#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <tuple>
using namespace std;

int M, N, H;

vector<vector<vector<int>>> mat;
queue<tuple<int, int, int>> q;

void bfs()
{
	while (!q.empty())
	{
		int x  = get<0>(q.front());
		int y = get<1>(q.front());
		int z = get<2>(q.front());
		q.pop();

		int dx[] = {-1, 1, 0, 0, 0, 0};
		int dy[] = {0, 0, 1, -1, 0, 0};
		int dz[] = {0, 0, 0, 0, 1, -1};
		for (int it = 0; it < 6; it++)
		{
			int newX = x + dx[it];
			int newY = y + dy[it];
			int newZ = z + dz[it];
			if (newX < 0 || newX >= M || newY < 0 || newY >= N || newZ < 0 || newZ >= H)
				continue;

			if (mat[newZ][newY][newX] == 0)
			{
				mat[newZ][newY][newX] = mat[z][y][x] + 1;
				q.push(make_tuple(newX, newY, newZ));
			}
		}
	}
}

int solve()
{
	bfs();

	int ret = 0;
	for (int z = 0; z < H; z++)
	{
		for (int y = 0; y < N; y++)
		{
			for (int x = 0; x < M; x++)
			{
				if (mat[z][y][x] == 0)
					return -1;

				ret = max(ret, mat[z][y][x] - 1);
			}
		}
	}

	return ret;
}

int main()
{
	cin >> M >> N >> H;

	mat.assign(H, vector<vector<int>>(N, vector<int>(M, 0)));
	for (int z = 0; z < H; z++)
	{
		for (int y = 0; y < N; y++)
		{
			for (int x = 0; x < M; x++)
			{
				cin >> mat[z][y][x];
				if (mat[z][y][x] == 1) q.push(make_tuple(x, y, z));
			}
		}

	}

	cout << solve() << endl;

	return 0;
}