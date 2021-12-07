// [크로아티아 알파벳](https://www.acmicpc.net/problem/2941)
// 문자열 구현 문제
// 스택 안쓰고 그냥 벡터 써서 앞에서 푸는 식으로 짜도 됐을듯?
// 너무 장황하게 코드를 짠거같다 ㅎㅎ..

#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	string str;
	cin >> str;
	
	int answer = 0;
	string keywords[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	stack<char> st;
	for (int i = 0; i < str.length(); i++)
	{
		st.push(str[i]);
		
		for (int i = 0; i < 8; i++)
		{
			string keyword = keywords[i];
			if (st.size() < keyword.length()) continue;
			
			bool ok = true;
			vector<char> temp;
			auto cnt = keyword.length();
			while (cnt--)
			{
				if (keyword[cnt] != st.top())
				{
					auto idx = temp.size();
					while(idx--)
						st.push(temp[idx]);
					
					ok = false; break;
				}
				
				temp.push_back(st.top());
				st.pop();
			}
			
			if (ok)
			{
				answer++;
				
				// 크로아티아 알파벳이 매칭될때마다 남은것들은 비워준다
				while (!st.empty())
				{
					answer++;
					st.pop();
				}
			}
		}
	}
	
	// 남은 알파벳 다 비워준다
	while (!st.empty())
	{
		answer++;
		st.pop();
	}
	
	cout << answer << '\n';
}
