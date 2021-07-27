#include <iostream>
#include <algorithm>
using namespace std;

int convertSansu(int num)
{
	int ret = 0;
	int temp = 0;

	temp = num % 10;
	ret += temp * 100;
	num /= 10;

	temp = num % 10;
	ret += temp * 10;
	num /= 10;

	temp = num % 10;
	ret += temp;
	return ret;
}

int main()
{
	int a, b;
	cin >> a >> b;

	int c1 = convertSansu(a);
	int c2 = convertSansu(b);

	int ans = max(c1, c2);
	cout << ans << endl;

	return 0;
}