#include <iostream>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        string cmd;
        cin >> cmd;

        int dx[] = {0, -1, 0, 1};
        int dy[] = {1, 0, -1, 0};
        int dir = 0; // 0 = north, 1 = east, 2 = south, 3 = west
        pair<int, int> curPos = make_pair(0, 0);
        pair<int, int> rt = make_pair(0, 0);
        pair<int, int> lb = make_pair(0, 0);
        for (int i = 0; i < cmd.length(); i++)
        {
            auto c = cmd[i];
            if (c == 'F')
                curPos = make_pair(curPos.first + dx[dir], curPos.second + dy[dir]);
            else if (c == 'B')
                curPos = make_pair(curPos.first - dx[dir], curPos.second - dy[dir]);
            else if (c == 'L')
                dir = dir - 1 < 0 ? 3 : dir - 1;
            else if (c == 'R')
                dir = dir + 1 > 3 ? 0 : dir + 1;

            rt = make_pair(max(curPos.first, rt.first), max(curPos.second, rt.second));
            lb = make_pair(min(curPos.first, lb.first), min(curPos.second, lb.second));
        }

        int width = rt.first - lb.first;
        int height = rt.second - lb.second;
        cout << width * height << '\n';
    }
}