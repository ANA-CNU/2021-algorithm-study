// [치즈](https://www.acmicpc.net/problem/2638)
// BFS 응용 문제
// 치즈의 외부 공기 부분을 걸러내는 아이디어가 생각이 안나 고생했던 문제
// 잘 생각해보니 BFS로 외부 공기 부분만 걸러낼수있어 푸는 방법을 알고나선 쉽게 풀었음

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
    int n, m;
    cin >> n >> m;

    vector<vector<int> > map(n, vector<int>(m, 0));
    queue<pair<int, int> > q;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> map[i][j];

            if (map[i][j])
                q.push(make_pair(i, j));
        }
    }

    int answer = 0;
    while (!q.empty())
    {
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        queue<pair<int, int> > spread;
        vector<vector<bool> > visit(n, vector<bool>(m, false));
        spread.push(make_pair(0, 0));
        visit[0][0] = true;
        while(!spread.empty())
        {
            pair<int, int> p = spread.front();
            spread.pop();

            map[p.first][p.second] = 2;

            for (int j = 0; j < 4; j++)
            {
                int nx = p.second + dx[j];
                int ny = p.first + dy[j];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                if (visit[ny][nx] || map[ny][nx] == 1) continue;

                visit[p.first][p.second] = true;
                spread.push(make_pair(ny, nx));
            }
        }

        int size = q.size();
        for (int i = 0; i < size; i++)
        {
            pair<int, int> p = q.front();
            q.pop();

            int out = 0;
            for (int j = 0; j < 4; j++)
            {
                int nx = p.second + dx[j];
                int ny = p.first + dy[j];
                if (nx < 0 || nx >= m || ny <0 || ny >= n) continue;

                if (map[ny][nx] == 2) out++;
            }

            if (out >= 2)
                map[p.first][p.second] = 0;
            else
                q.push(p);
        }

        answer++;
    }

    cout << answer << '\n';
}
