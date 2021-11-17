// [가장 긴 바이토닉 부분 수열](https://www.acmicpc.net/problem/11054)
// DP 최적화 구조 문제
// 기준이 되는 수의 왼쪽 오른쪽으로 DP를 사용해주면 쉽게 풀 수 있는 문제
// 골드3 정도의 문제는 아닌거같은 느낌?

#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	vector<int> nums(n, 0);
	for (int i = 0; i < n; i++)
		cin >> nums[i];

	vector<int> left(n, 0); // 왼쪽끝에서 시작하는 증가 수열
	for (int i = 0; i < n; i++)
	{
		int biggest = 0;
		for (int j = 0; j < i; j++)
		{
			if (nums[j] < nums[i] && biggest < left[j])
				biggest = left[j];
		}
		left[i] = biggest + 1; // 자기 자신도 더해줌
	}

	vector<int> right(n, 0); // 오른쪽 끝에서 시작하는 증가 수열
	for (int i = n - 1; i >= 0; i--)
	{
		int biggest = 0;
		for (int j = i + 1; j < n; j++)
		{
			if (nums[j] < nums[i] && biggest < right[j])
				biggest = right[j];
		}
		right[i] = biggest + 1; // 자기 자신도 더해줌
	}

	int answer = 0;
	for (int i = 0; i < n; i++)
		answer = max(answer, left[i] + right[i] - 1);

	cout << answer << '\n';


	return 0;
}