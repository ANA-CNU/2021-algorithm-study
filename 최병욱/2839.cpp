#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int three = 0;
	int five = 0;
	while(n > 0)
	{
		if (n % 5 == 0)
		{
			five = n / 5;
			n %= 5;
		}
		else
		{
			three++;
			n -= 3;
		}
	}

	cout << (n < 0 ? -1 : three + five) << '\n';


	return 0;
}