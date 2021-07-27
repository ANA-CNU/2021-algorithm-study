#include <iostream>
#include <queue>
using namespace std;

int main()
{
	string str = "";
	cin >> str;

	queue<int> terms;
	string numStr = "";
	int sum = 0;
	for (int i = 0; i < str.length(); i++)
	{
		if (str[i] != '+' || str[i] != '-')
			numStr += str[i];

		if (str[i] == '+' || str[i] == '-' || i == str.length() -1)
		{
			sum += stoi(numStr);
			numStr = "";

			if (str[i] == '-' || i == str.length() -1)
			{
				terms.push(sum);
				sum = 0;
			}
		}
	}

	int answer = terms.front();
	terms.pop();
	while (!terms.empty())
	{
		answer -= terms.front();
		terms.pop();
	}

	cout << answer << '\n';

	return 0;
}