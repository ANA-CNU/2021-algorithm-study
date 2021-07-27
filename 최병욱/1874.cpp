#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;

	vector<int> seq;
	for (int i = 0; i < n; i++)
	{
		int num = 0;
		cin >> num;
		seq.push_back(num);
	}

	string output = "";
	vector<int> stack;
	int cursor = 1;
	int target = 0;
	for (int i = 0; i < seq.size(); i++)
	{
		target = seq[i];
		auto it = find(stack.begin(), stack.end(), target);

		if (cursor <= target)
		{
			for (int j = cursor; j <= target; j++)
			{
				stack.push_back(j);
				output += "+\n";
			}

			stack.pop_back();
			output += "-\n";
			cursor = target + 1;
		}
		else if(it != stack.end())
		{
			int idx = distance(stack.begin(), it);
			int size = stack.size() - idx;
			for (int j = 0; j < size; j++)
			{
				stack.pop_back();
				output += "-\n";
			}
		}
		else
		{
			output = "NO";
			break;
		}
	}

	cout << output;

	return 0;
}
