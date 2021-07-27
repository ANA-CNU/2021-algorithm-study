#include <iostream>
using namespace std;


int main()
{
	int n;
	cin >> n;

	char g = 'F';
	if (n <= 100 && n >= 90)
	{
		g = 'A';
	}
	else if (n <= 89 && n >= 80)
	{
		g = 'B';
	}
	else if(n <= 79 && n >= 70)
	{
		g = 'C';
	}
	else if(n <= 69 && n >= 60)
	{
		g = 'D';
	}

	cout << g << endl;

	return 0;
}