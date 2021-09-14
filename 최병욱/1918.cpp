#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	string str;
	cin >> str;

	stack<char> st;
	for (int i = 0; i < str.length(); i++)
	{
		char c = str[i];
		if (c >= 'A' && c <= 'Z')
		{
			cout << c;
		}
		else if (c == '*' || c == '/')
		{
			while(!st.empty() && (st.top() == '*' || st.top() == '/'))
			{
				cout << st.top();
				st.pop();
			}
			st.push(c);
		}
		else if (c == '+' || c == '-')
		{
			while(!st.empty() && st.top() != '(')
			{
				cout << st.top();
				st.pop();
			}
			st.push(c);
		}
		else if (c == '(')
		{
			st.push(c);
		}
		else if (c == ')')
		{
			while(!st.empty() && st.top() != '(')
			{
				cout << st.top();
				st.pop();
			}

			if (!st.empty()) st.pop();
		}
	}

	while (!st.empty())
	{
		cout << st.top();
		st.pop();
	}

	return 0;
}