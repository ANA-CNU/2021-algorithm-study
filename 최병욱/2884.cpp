#include <iostream>
using namespace std;

int main()
{
	int h, m;
	cin >> h >> m;

	m -= 45;
	if (m < 0)
	{
		cout << (h == 0 ? 23 : h - 1) << ' ' << 60 + m << endl;
	}
	else
		cout << h << ' ' << m << endl;

	return 0;
}