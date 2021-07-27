#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;

int main()
{
	while (true)
	{
		vector<int> v(3, -1);

		for (int i = 0; i < 3; i++)
		{
			cin >> v[i];
		}

		if (v[0] == 0 && v[1] == 0 && v[2] == 0) break;

		int biggest = -1;
		int idx = -1;
		for (int i = 0; i < 3; i++)
		{
			if (biggest < v[i])
			{
				biggest = v[i];
				idx = i;
			}
		}

		vector<int> remain;
		for (int i = 0; i < 3; i++)
		{
			if (i != idx)
				remain.push_back(v[i]);
		}

		cout << (int(pow(v[idx], 2) == int(pow(remain[0], 2)) + int(pow(remain[1], 2)) ) ? "right" : "wrong" ) << endl;
	}

	return 0;
}