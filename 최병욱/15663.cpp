// [N과 M (9)](https://www.acmicpc.net/problem/15657)
// 백트래킹 기초 문제
// 중복되는 수열은 나오지 않게 하는데 애먹은 문제
// 나는 무식하게 나왔던 수열들을 배열 안에 모두 저장해뒀다가 새로운 수열이 나올때마다 이 배열 안에있는것들과 비교해서 중복되면 제외시키도록 했음.
// 하지만 이 방법은 입력값이 커지면 커질수록 굉장히 비효율적이다.
// https://www.acmicpc.net/source/29911314 <- 여기의 코드가 내거랑 비슷한데 효율적으로 잘 짜여져있음

#include<bits/stdc++.h>
using namespace std;

vector<int> nums;
vector<bool> check;
vector<string> p;

void solve(int start, int cnt, string print)
{
	if (cnt <= 0)
	{
		print += to_string(nums[start]);
		if (find(p.begin(), p.end(), print) == p.end())
			p.push_back(print);

		return;
	}

	check[start] = true;
	for (int i = 0; i < nums.size(); i++)
	{
		if (check[i]) continue;

		solve(i, cnt - 1, print + to_string(nums[start]) + " ");
	}
	check[start] = false;
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
	int last = -1;
	for (int i = 0; i < nums.size(); i++)
	{
		if (last == nums[i]) continue;
		last = nums[i];

		solve(i, m - 1, "");

		for (int it = 0; it < p.size(); it++)
			cout << p[it] << '\n';
		p.clear();
	}

	return 0;
}