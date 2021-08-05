/**
 * @file 16197.cpp
 * @author choi-min-woo (dandalf@o.cnu.ac.kr)
 * @brief 사람은 바뀌면 죽는다고 했는데,
 * 나는 1-index로 바꿔서 해보려다가 죽을뻔 했다. 다음부터 그러지 말아야지.
 * @date 2021-08-05
 *
 * @copyright Copyright (c) 2021
 *
 */

#include <bits/stdc++.h>
#define int long long
#define min3(a, b, c) min(a, min(b, c))
#define max3(a, b, c) max(a, max(b, c))

using namespace std;
typedef pair<int, int> pii;

int mx, my;
int field[21][21];
int visited[21][21][21][21];
vector<pii> delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

bool is_falling(pii cur, pii d) {
  int x = cur.first + d.first;
  int y = cur.second + d.second;
  return 1 <= x and x <= mx and 1 <= y and y <= my;
}

pii move(pii cur, pii d) {
  int x = cur.first + d.first;
  int y = cur.second + d.second;
  if (field[y][x] == 1)
    return cur;
  else
    return make_pair(x, y);
}

int go(pair<pair<pii, pii>, int> param) {
  queue<pair<pair<pii, pii>, int>> q;
  q.push(param);
  while (!q.empty()) {
    auto p = q.front();
    q.pop();
    auto first = p.first.first;
    auto second = p.first.second;
    auto time = p.second;
    if (time == 10) return -1;
    for (auto d : delta) {
      bool first_fall = !is_falling(first, d);
      bool second_fall = !is_falling(second, d);
      if (first_fall and second_fall) continue;
      if (first_fall or second_fall) return time + 1;
      pii n_first = move(first, d);
      pii n_second = move(second, d);
      if (visited[n_first.first][n_first.second][n_second.first]
                 [n_second.second])
        continue;
      visited[n_first.first][n_first.second][n_second.first][n_second.second] =
          true;
      q.push({{n_first, n_second}, time + 1});
    }
  }
  return -1;
}

int32_t main(void) {
#ifndef ONLINE_JUDGE
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
#endif  // ONLINE_JUDGE
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  pair<pair<pii, pii>, int> f = {{{-1, -1}, {-1, -1}}, 0};

  cin >> my >> mx;
  for (int y = 1; y <= my; y++) {
    string line;
    cin >> line;
    for (int x = 1; x <= mx; x++) {
      if (line[x - 1] == '#') field[y][x] = 1;
      if (line[x - 1] == 'o') {
        if (f.first.first.first == -1) {
          f.first.first = {x, y};
        } else {
          f.first.second = {x, y};
          visited[f.first.first.first][f.first.first.second][x][y] = true;
        }
      }
    }
  }
  cout << go(f) << '\n';

  return 0;
}