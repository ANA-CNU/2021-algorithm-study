#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	vector<int> v;
	for (int i = 0; i < 10; i++)
	{
		int n;
		cin >> n;

		if(find(v.begin(), v.end(), n % 42) == v.end())
		{
			v.push_back(n % 42);
		}
	}

	cout << v.size() << endl;

	return 0;
}