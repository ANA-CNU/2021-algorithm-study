#include <iostream>
#include <vector>
using namespace std;

int GetIndex(int n)
{
	if (n < 0)
		return n * -1 + 10000000;

	return n;
}

int main()
{
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n;

	vector<int> v(20000001, 0);
	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		v[GetIndex(num)]++;
	}

	cin >> m;

	for (int i = 0; i < m; i++)
	{
		int num;
		cin >> num;
		cout << v[GetIndex(num)] << (i != m - 1 ? " " : "");
	}

	return 0;
}
