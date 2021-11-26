// [트리플 소트](https://www.acmicpc.net/problem/20309);
// 수학 + 애드 혹 문제
// 실제로 자리를 바꾸면서 돌려봐도 무방할거라 생각했는데 N이 300000까지라 N^2되면 TE가 남
// 단순히 모든 케이스를 열거해보면 홀수 자리에는 홀수만, 짝수 자리에는 짝수만 와야만 정렬이 가능하단걸 알수있음
// 문제 풀기전엔 최소 케이스부터 빠르게 정리해보는 습관을 들이자

#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	vector <int> nums(n, 0);
	for (int i = 0; i < n; i++)
		cin >> nums[i];

	for (int i = 0; i < n; i++)
	{
		if (i % 2 != (nums[i] - 1) % 2)
		{
			cout << "NO" << '\n';
			return 0;
		}
	}

	cout << "YES" << '\n';
}