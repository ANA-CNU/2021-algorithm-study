#include <iostream>
using namespace std;

int main()
{
	int n, x;
	cin >> n >> x;

	for (int i = 0; i < n; i++)
	{
		int num = 0;
		cin >> num;
		if (num < x)
			cout << num << ' ';
	}
}