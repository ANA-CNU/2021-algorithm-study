#include <iostream>
using namespace std;

int main()
{
	int t = 0;
	cin >> t;

	while(t--)
	{
		int h, w, n;
		cin >> h >> w >> n;

		int floor = n % h;
		int num = n % h == 0 ? n / h : n / h + 1;

		cout << (floor == 0 ? h : floor) << (num < 10 ? "0" : "") << num << '\n';
	}

	return 0;
}