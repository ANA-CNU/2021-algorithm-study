#include <iostream>
#include <vector>
using namespace std;
vector<int> cache;


int count(int n, int x)
{
	if (cache[n] != -1)
		return cache[n];

	if (n % 5 == 0)
	{
		return cache[n] = count(n / x, x) + 1;
	}
	else
		return 0;
}


int main()
{
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n + 1; i++)
	{
		cache.push_back(-1);
	}

	int ans = 0;
	for (int i = 1; i <= n; i++)
	{
		ans += count(i, 5);
	}

	cout << ans << '\n';

	return 0;
}
