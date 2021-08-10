// [N과 M (5)](https://www.acmicpc.net/problem/15654)
// 백트래킹 기초 문제
// 조합을 뽑아내는 문제인것 같아서 조합이나 순열 구현을 고민했는데, 자세히 살펴보니 백트래킹이였음.
// 백트래킹을 구현할때 개념이 조금 부족해서 속도가 조금 더뎠음. 하지만 개념을 확실히 짚고 넘어가서 좋은듯함.
// 나는 정답을 vector를 for문돌리면서 출력했는데 string을 인자로 써서 출력하는 방식도 있었다. 다음부턴 이것을 활용해보면 좋을듯.

#include<bits/stdc++.h>
using namespace std;

vector<int> nums;
vector<bool> check;
vector<int> print;

void solve(int start, int cnt)
{
	if (cnt <= 0)
	{
		print.push_back(nums[start]);
		for (int i = 0; i < print.size(); i++)
		{
			cout << print[i] << " ";
		}
		cout << '\n';
		print.pop_back();

		return;
	}

	check[start] = true;
	print.push_back(nums[start]);
	for (int i = 0; i < nums.size(); i++)
	{
		if (check[i]) continue;

		solve(i, cnt - 1);
	}
	check[start] = false;
	print.pop_back();
}

int main()
{
	int n, m;
	cin >> n >> m;

	nums.assign(n, 0);
	for (int i = 0; i < n; i++)
		cin >> nums[i];

	sort(nums.begin(), nums.end());

	check.assign(n, false);
	for (int i = 0; i < nums.size(); i++)
	{
		solve(i, m - 1);
	}

	return 0;
}