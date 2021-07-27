#include <iostream>
using namespace std;

int main()
{
	int l;
	cin >> l;

	string str;
	cin >> str;

	long long ans = 0;
	long long r = 1;
	for (int i = 0; i < str.size(); i++)
	{
		ans = (ans + (int(str[i]) - 0x60) * r) % 1234567891;
		r = (r * 31) % 1234567891;
	}

	cout << ans << '\n';

	return 0;
}