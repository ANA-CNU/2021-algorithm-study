// [N과 M (8)](https://www.acmicpc.net/problem/15657)
// 백트래킹 기초 문제
// 이전 문제와 비슷해서 아주 쉽게 품

#include<bits/stdc++.h>
using namespace std;

vector<int> nums;

void solve(int start, int cnt, string print)
{
	if (cnt <= 0)
	{
		print += to_string(nums[start]);
		cout << print << '\n';
		return;
	}

	for (int i = start; i < nums.size(); i++)
	{
		solve(i, cnt - 1, print + to_string(nums[start]) + " ");
	}
}

int main()
{
	int n, m;
	cin >> n >> m;

	nums.assign(n, 0);
	for (int i = 0; i < n; i++)
		cin >> nums[i];

	sort(nums.begin(), nums.end());

	for (int i = 0; i < nums.size(); i++)
	{
		solve(i, m - 1, "");
	}

	return 0;
}