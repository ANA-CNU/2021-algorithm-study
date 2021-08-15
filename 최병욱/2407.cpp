// [조합](https://www.acmicpc.net/problem/2407)
// BigInteger 계산 구현 문제
// 처음에는 조합 공식을 어떻게든 재구성해서 푸는 방식으로 접근해보았지만 이 접근은 실패.
// 계속 고민해도 잘 모르겠어서 타 블로그를 보고 string과 파스칼의 삼각형으로 연산하는 힌트를 얻고 스스로 구현해서 품.
// string으로 연산한다는 아이디어만 떠올랐다면 쉽게 풀수있었을거라서 이 점이 아쉬움.
// 파스칼의 삼각형을 아예 몰랐었는데 이번 기회에 공부해서 좋았던듯.

#include <bits/stdc++.h>
using namespace std;
vector<vector<string>> p;
int n, m;

string add(string num1, string num2)
{
	string ret = "";
	int len = max(num1.length(), num2.length());
	int idx1 = num1.length() - 1;
	int idx2 = num2.length() - 1;
	int carry = 0;
	for (int i = 0; i < len; i++)
	{
		int n1 = idx1 >= 0 ? num1[idx1--] - '0' : 0;
		int n2 = idx2 >= 0 ? num2[idx2--] - '0' : 0;
		int sum = n1 + n2 + carry;
		ret = to_string(sum % 10) + ret;
		carry = sum >= 10 ? 1 : 0;
	}

	return carry > 0 ? "1" + ret : ret;
}

void pascal()
{
	p.assign(n + 1, vector<string>(n + 1, "0"));
	for (int i = 0; i < n + 1; i++)
	{
		for(int j = 0; j < i + 1; j++)
		{
			if (j == 0 || j == i)
				p[i][j] = to_string(1);
			else
				p[i][j] = add(p[i - 1][j - 1], p[i - 1][j]);
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;
	pascal();

	cout << p[n][m] << '\n';

	return 0;
}