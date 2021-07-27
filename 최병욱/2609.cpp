#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
	int a, b;
	cin >> a >> b;

	int ans1 = 0;
	int big = max(a, b);
	for (int i = 1; i <= big; i++)
	{
		if (a % i == 0 && b % i == 0)
			ans1 = i;
	}

	int ans2 = 0;
	int small = a > b ? a : b;
	int another = a > b ? b : a;
	int check = 0;
	while(check += small)
	{
		if (check % another == 0)
		{
			ans2 = check;
			break;
		}
	}

	cout << ans1 << '\n' << ans2 << '\n';

	return 0;
}