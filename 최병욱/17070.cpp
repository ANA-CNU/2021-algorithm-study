// [파이프 옮기기 1](https://www.acmicpc.net/problem/17070)
// 브루트포스 문제
// 푸는법은 바로 알았는데 삽질을 너무해서 시간이 너무 오래걸린 문제
// 로직 짜기전에 문제를 꼼꼼히 읽어서 로직을 확실히 하고 가는게 시간을 좀 더 줄일 수 있는 방법같다.
// 2시간 이상 풀리지않으면 답을 보거나 다른것을 하는게 더 빨리 풀 수 있을것같다

#include <iostream>
#include <vector>
using namespace std;
int N;

int solve(vector<vector<int> > &board, pair<int, int> pos, int state)
{
    pair<int, int> end;
    if (state == 0)
        end = make_pair(pos.first + 1, pos.second);
    else if (state == 1)
        end = make_pair(pos.first, pos.second + 1);
    else
        end = make_pair(pos.first + 1, pos.second + 1);
    if (end.first == N - 1 && end.second == N - 1) return 1;

    int ret = 0;
    for (int i = 0; i < 3; i++)
    {
        // 가로 -> 세로 & 세로 -> 가로 방지
        if ((state == 0 && i == 1) || (state == 1 && i == 0)) continue;

        if (i == 0 && (end.first + 1 >= N || board[end.second][end.first + 1])) continue;

        if (i == 1 && (end.second + 1 >= N || board[end.second + 1][end.first])) continue;

        if (i == 2 && (end.first + 1 >= N || end.second + 1 >= N || board[end.second + 1][end.first] || board[end.second][end.first + 1] || board[end.second + 1][end.first + 1]))
            continue;

        ret += solve(board, end, i);
    }

    return ret;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;

    vector<vector<int> > board(N, vector<int>(N, 0));
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> board[i][j];
        }
    }

    cout << solve(board, make_pair(0, 0), 0) << '\n';
}
