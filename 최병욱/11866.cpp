#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n, k;
	cin >> n >> k;

	cout << '<';

	vector<int> v;
	for (int i = 0; i < n; i++)
	{
		v.push_back(i + 1);
	}

	int start = 0;
	while(v.size() != 0)
	{
		int erase = (start + (k - 1)) % v.size();
		cout << v[erase] << (v.size() == 1 ? "" : ", ");
		start = erase;
		v.erase(v.begin() + erase);
	}

	cout << '>';

	return 0;
}