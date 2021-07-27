#include <iostream>
using namespace std;

int main()
{
	int t = 0;
	cin >> t;

	while (t--)
	{
		int m, n, x, y;
		cin >> m >> n >> x >> y;

		int answer = -1;
		for (int i = x; i <= m * n; i+=m)
		{
			int comp = i % n == 0 ? n : i % n; // 나누어 떨어졌다면 그 수는 n임
			if (comp == y)
			{
				answer = i;
				break;
			}
		}

		cout << answer << '\n';
	}

	return 0;
}