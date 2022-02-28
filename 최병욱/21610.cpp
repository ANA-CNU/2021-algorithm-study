#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> board(n, vector<int>(n, 0));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> board[i][j];
        }
    }

    int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
    vector<pair<int, int>> clouds;
    clouds.push_back(make_pair(n - 1, 0)); clouds.push_back(make_pair(n - 1, 1)); clouds.push_back(make_pair(n - 2, 0)); clouds.push_back(make_pair(n - 2, 1));
    for (int it = 0; it < m; it++)
    {
        int d, s;
        cin >> d >> s;

        // cloud move
        for (int i = 0; i < clouds.size(); i++)
        {
            int ny = clouds[i].first + (dy[d - 1] * s) % n;
            int nx = clouds[i].second + (dx[d - 1] * s) % n;
            ny = ny < 0 ? n + ny : ny >= n ? ny - n : ny;
            nx = nx < 0 ? n + nx : nx >= n ? nx - n : nx;
            clouds[i] = make_pair(ny, nx);
        }

        // increase water amount under cloud
        vector<vector<bool>> prevClouds(n, vector<bool>(n, false));
        for (int i = 0; i < clouds.size(); i++)
        {
            board[clouds[i].first][clouds[i].second]++;
            prevClouds[clouds[i].first][clouds[i].second] = true;
        }

        // check diagonal
        for (int i = 0; i < clouds.size(); i++)
        {
            int add = 0;
            for (int j = 0; j < 4; j++)
            {
                int ny = clouds[i].first + ("0202"[j] - '1');
                int nx = clouds[i].second + ("0022"[j] - '1');
                if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;

                if (board[ny][nx]) add++;
            }

            board[clouds[i].first][clouds[i].second] += add;
        }

        // create new clouds
        clouds.clear();
        for (int i =0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (prevClouds[i][j]) continue;

                if (board[i][j] >= 2){ clouds.push_back(make_pair(i, j)); board[i][j] -= 2; }
            }
        }
    }

    int answer = 0;
    for (int i =0; i < n; i++){
        for (int j = 0; j < n; j++){
            answer += board[i][j];
        }
    }
    cout << answer << '\n';
}