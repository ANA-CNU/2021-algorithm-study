#include <iostream>
#include<vector>
using namespace std;

int main()
{
	int t;
	cin >> t;

	while(t--)
	{
		int k, n;
		cin >> k;
		cin >> n;

		vector<vector<int>> map(k + 1, vector<int>(n, 0));
		for (int y = 0; y <= k; y++)
		{
			for (int x = 0; x < n; x++)
			{
				if (y == 0)
				{
					map[y][x] = x + 1;
				}
				else
				{
					for (int it = 0; it <= x; it++)
					{
						map[y][x] += map[y - 1][it];
					}
				}

				cout << map [y][x] << ' ';
			}
			cout << endl;
		}

		cout << map[k][n - 1] << endl;
	}

	return 0;
}