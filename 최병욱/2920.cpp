#include <iostream>
#include <vector>
using namespace std;

int main()
{
	vector<int> arr;

	for (int i = 0; i < 8; i++)
	{
		int n;
		cin >> n;
		arr.push_back(n);
	}

	// 0 = ascending, 1 = descending, 2 = mixed
	int state = -1;
	for (int i = 0; i < arr.size() - 1; i++)
	{
		if (arr[i] < arr[i + 1])
		{
			if (state == 1)
			{
				state = 2;
				break;
			}

			state = 0;
		}
		else if (arr[i] > arr[i + 1])
		{
			if (state == 0)
			{
				state = 2;
				break;
			}

			state = 1;
		}
	}

	cout << (state == 0 ? "ascending" : state == 1 ? "descending" : "mixed") << endl;

	return 0;
}