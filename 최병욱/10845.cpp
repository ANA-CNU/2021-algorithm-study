#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main()
{
	int t;
	cin >> t;
	cin.ignore();

	vector<int> q;
	while(t--)
	{
		string cmd = "";
		getline(std::cin, cmd);

		if (cmd.find("push") != string::npos)
		{
			q.push_back(stoi(cmd.substr(5)));
		}
		else if(cmd == "front")
		{
			cout << (q.size() != 0 ? q.front() : -1) << '\n';
		}
		else if (cmd == "back")
		{
			cout << (q.size() != 0 ? q.back() : -1) << '\n';
		}
		else if(cmd == "size")
		{
			cout << q.size() << '\n';
		}
		else if(cmd == "empty")
		{
			cout << (q.size() == 0) << '\n';
		}
		else if(cmd == "pop")
		{
			cout << (q.size() == 0 ? -1 : q.front()) << '\n';
			if (q.size() != 0)
			{
				for (int i = 0; i < q.size() - 1; i++)
				{
					q[i] = q[i + 1];
				}
				q.pop_back();
			}
		}
	}

	return 0;
}
