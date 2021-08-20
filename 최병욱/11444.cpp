// [피보나치 수 6](https://www.acmicpc.net/problem/11444)
// 1e+18의 입력값을 받아서 피보나치 수를 구해야하는 문제
// 입력값이 말도안되게 높아져서 메모이제이션을 사용 할수도 없었다.
// 1시간 가량 고민해봤지만 실마리도 잡히지않아서 타 블로그의 설명만 보고 구현한 문제
// 행렬의 제곱으로 피보나치 수를 구할수있다는게 인상깊었었음
// 거듭제곱을 분할 정복으로 푸는것도 다시금 배워갈수있었다.
// 다른 사람의 풀이를 보면서 확실히 다지고 가면 좋을듯함.

#include <bits/stdc++.h>
#define MOD 1000000007
using namespace std;

vector<vector<long long>> mult(vector<vector<long long>> a, vector<vector<long long>> b)
{
	vector<vector<long long>> ret(2, vector<long long>(2, 0));
	for (int i = 0; i < 2; i++)
	{
		ret[i][0] = (a[i][0] * b[0][0] + a[i][1] * b[1][0]) % MOD;
		ret[i][1] = (a[i][0] * b[0][1] + a[i][1] * b[1][1]) % MOD;
	}
	return ret;
}

vector<vector<long long>> solve(long long n)
{
	if (n == 1)
	{
		vector<vector<long long>> ret {{1, 1}, {1, 0}};
		return ret;
	}

	auto half = solve(n / 2);
	if (n % 2 == 0)
	{
		return mult(half, half);
	}
	else
	{
		vector<vector<long long>> zero{{1, 1}, {1, 0}};
		return mult(mult(half, half), zero);
	}
}

int main()
{
	long long n;
	cin >> n;
	cout << (n == 0 ? 0 : solve(n)[1][0]) << '\n';

	return 0;
}