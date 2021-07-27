#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main()
{
	int t;
	cin >> t;
	cin.ignore();

	vector<int> dq;
	while(t--)
	{
		string cmd = "";
		getline(std::cin, cmd);

		if (cmd.find("push_back") != string::npos)
		{
			dq.push_back(stoi(cmd.substr(10)));
		}
		else if (cmd.find("push_front") != string::npos)
		{
			int front = stoi(cmd.substr(11));
			dq.push_back(-1);
			for (int i = dq.size() - 1; i >= 1; i--)
			{
				dq[i] = dq[i - 1];
			}
			dq[0] = front;
		}
		else if(cmd == "front")
		{
			cout << (dq.size() != 0 ? dq.front() : -1) << '\n';
		}
		else if(cmd == "back")
		{
			cout << (dq.size() != 0 ? dq.back() : -1) << '\n';
		}
		else if(cmd == "size")
		{
			cout << dq.size() << '\n';
		}
		else if(cmd == "empty")
		{
			cout << (dq.size() == 0) << '\n';
		}
		else if(cmd == "pop_back")
		{
			cout << (dq.size() == 0 ? -1 : dq.back()) << '\n';
			if (dq.size() != 0)
				dq.pop_back();
		}
		else if(cmd == "pop_front")
		{
			cout << (dq.size() == 0 ? -1 : dq.front()) << '\n';
			if (dq.size() != 0)
			{
				for (int i = 0; i < dq.size() - 1; i++)
					dq[i] = dq[i + 1];
				dq.pop_back();
			}
		}
	}


	return 0;
}
