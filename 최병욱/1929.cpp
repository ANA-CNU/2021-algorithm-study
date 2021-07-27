#include <iostream>
using namespace std;
int arr[1000001];

int main()
{
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int m, n;
	cin >> m >> n;

	for (int i = m; i <= n; i++)
	{
		arr[i] = i;
	}

	for (int i = 2; i <= n; i++)
	{
		for (int j = i + i; j <= n; j+= i)
			arr[j] = 0;
	}

	for (int i = 2; i <= n; i++)
	{
		if (arr[i] != 0)
			cout << arr[i] << (i != n ? "\n" : "");
	}

	return 0;
}
