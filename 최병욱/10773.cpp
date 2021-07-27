#include <iostream>
#include <stack>
using namespace std;

int main()
{
	int k;
	cin >> k;

	stack<int> st;
	for (int i = 0; i < k; i++)
	{
		int num;
		cin >> num;

		if (num == 0 && !st.empty())
			st.pop();
		else
			st.push(num);
	}

	int sum = 0;
	while(!st.empty())
	{
		sum += st.top();
		st.pop();
	}

	cout << sum << endl;

	return 0;
}