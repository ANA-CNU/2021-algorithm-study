// [행렬 제곱](https://www.acmicpc.net/problem/10830)
// 거듭제곱을 분할 정복으로 푸는 문제
// 이전에 풀어봤던 분류의 문제라서 푸는방법은 알았으나 행렬 곱셈 구현이 굉장히 귀찮았던 문제
// 파이썬을 익혀놓는게 좋긴할듯
// 자잘구레한 예외 처리가 많아서 성가셨던 문제(ex: b의 입력값이 천억이상, 지수가 1이고 원소가 1000일때 % 1000 해줘야 하고..)

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > mult(vector<vector<int> > a, vector<vector<int> > b)
{
	vector<vector<int> > ret(a.size(), vector<int>(a.size(), 0));
	for (int i = 0; i < a.size(); i++) // A의 열 길이
		for (int j = 0; j < b.size(); j++) // B의 행 길이
		{
			for (int k = 0; k < b.size(); k++) // 반복자
				ret[i][j] += a[i][k] * b[k][j];
			ret[i][j] %= 1000;
		}

	return ret;
}

vector<vector<int> > pow(const vector<vector<int> > &mat, long long expo)
{
	vector<vector<int> > ret(mat.size(), vector<int>(mat.size(), 0));

	if (expo == 0)
	{
		for (int i = 0; i < ret.size(); i++)
			ret[i][i] = 1;
	}
	else if(expo == 1)
	{
		for (int i = 0; i < ret.size(); i++)
			for (int j = 0; j < ret.size(); j++)
				ret[i][j] = mat[i][j] % 1000;
	}
	else
	{
		vector<vector<int> > temp = pow(mat, expo / 2);
		if (expo % 2 == 0)
			ret = mult(temp, temp);
		else
		{
			vector<vector<int> > temp2 = mult(temp, mat);
			ret = mult(temp, temp2);
		}
	}

	return ret;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	long long b;
	cin >> b;

	vector<vector<int> > mat(n, vector<int>(n, 0));
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> mat[i][j];
		}
	}

	vector<vector<int> > answer = pow(mat, b);
	for (int i = 0; i < answer.size(); i++)
	{
		for (int j = 0; j < answer.size(); j++)
			cout << answer[i][j] << ' ';
		cout << '\n';
	}
}
