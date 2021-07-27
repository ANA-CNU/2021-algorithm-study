#include <iostream>
using namespace std;

int main()
{
	int biggest = -1;
	int idx = -1;
	for (int i = 0; i < 9; i++)
	{
		int n = 0;
		cin >> n;
		if (biggest < n)
		{
			biggest = n;
			idx = i + 1;
		}
	}

	cout << biggest << endl << idx << endl;

	return 0;
}