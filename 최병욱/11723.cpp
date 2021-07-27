// https://www.acmicpc.net/problem/11723
// 비트 마스킹으로 다시 풀어봐도 괜찮을듯

#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> arr(21, 0);

	int t;
	cin >> t;
	cin.ignore();

	while(t--)
	{
		string cmd = "";
		getline(std::cin, cmd);

		if (cmd.find("add") != string::npos)
		{
			arr[stoi(cmd.substr(4))] = true;
		}
		else if(cmd.find("remove") != string::npos)
		{
			arr[stoi(cmd.substr(7))] = false;
		}
		else if(cmd.find("check") != string::npos)
		{
			cout << arr[stoi(cmd.substr(6))] << '\n';
		}
		else if(cmd == "empty")
		{
			for (int i = 1; i < arr.size(); i++)
				arr[i] = false;
		}
		else if(cmd == "all")
		{
			for (int i = 1; i < arr.size(); i++)
				arr[i] = true;
		}
		else if(cmd.find("toggle") != string::npos)
		{
			arr[stoi(cmd.substr(7))] = !arr[stoi(cmd.substr(7))];
		}
	}

	return 0;
}