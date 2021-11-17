#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (i == 0 || i == n - 1)
			{
				cout << '*';
			}
			else if (j == 0 || j == n - 1)
			{
				cout << '*';
			}
			else
			{
				int left = i > n / 2 ? n - 1 - i : i;
				int right = i > n / 2 ? i : n - 1 - i;
				if (j == left || j == right)
					cout << '*';
				else
					cout << ' ';
			}
		}
		cout << '\n';
	}


	return 0;
}
