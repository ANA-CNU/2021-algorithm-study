#include <iostream>
#include <vector>
using namespace std;
vector<vector<bool>> likes;
vector<vector<int>> seats;
int n;

int GetLikes(int y, int x, int num)
{
    int ret = 0;
    int dy[] = {1, 0, -1, 0};
    int dx[] = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++)
    {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;

        if (likes[num][seats[ny][nx]]) ret++;
    }

    return ret;
}

int GetEmpties(int y, int x)
{
    int ret = 0;
    int dy[] = {1, 0, -1, 0};
    int dx[] = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++)
    {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;

        if (!seats[ny][nx]) ret++;
    }

    return ret;
}

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    vector<int> order;
    likes.assign(n * n + 1, vector<bool>(n * n + 1, false));
    for (int i = 0; i < n * n; i++)
    {
        int num;
        cin >> num;
        order.push_back(num);

        int target = 0;
        for (int j = 0; j < 4; j++)
        {
            cin >> target;
            likes[num][target] = true;
        }
    }

    seats.assign(n, vector<int>(n, 0));
    for (int it = 0; it < order.size(); it++)
    {
        int num = order[it];
        int maxLike = 0;
        int maxEmpty = 0;
        pair<int, int> best = make_pair(n - 1, n - 1);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (seats[i][j]) continue;

                int like = GetLikes(i, j, num);
                int empty = GetEmpties(i, j);
                if (like > maxLike ||
                    (maxLike == like && empty > maxEmpty) ||
                    (maxLike == like && empty == maxEmpty && i < best.first) ||
                    (maxLike == like && empty == maxEmpty && i == best.first && j < best.second))
                {
                    maxLike = like;
                    maxEmpty = empty;
                    best = make_pair(i, j);
                }
            }
        }

        seats[best.first][best.second] = num;
    }

    int answer = 0;
    for (int i = 0; i < n ; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int like = GetLikes(i, j, seats[i][j]);
            int add = 0;
            if (like == 1) add = 1;
            else if (like == 2) add = 10;
            else if (like == 3) add = 100;
            else if (like == 4) add = 1000;
            answer += add;
        }
    }

    cout << answer << '\n';
}