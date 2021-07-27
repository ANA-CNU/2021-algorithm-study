#include <iostream>
using namespace std;

int fac(int num)
{
	if (num <= 1)
		return 1;
	else
		return num * fac(num - 1);
}

int main()
{
	int n, k;
	cin >> n >> k;

	cout << fac(n) / (fac(k) * fac(n - k));
	return 0;
}