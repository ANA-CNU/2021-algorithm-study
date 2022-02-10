#include <bits/stdc++.h>
#define deb(x) cout << #x << " : " << x << "\n"
#define deb_pair(x, y)                                                         \
    cout << "(" << #x << ", " << #y << ") : (" << x << ", " << y << ")\n"
#define deb_tuple(x, y, z)                                                     \
    cout << "(" << #x << ", " << #y << ", " << #z << ") : (" << x << ", " << y \
         << ", " << z << ")\n"
#define ALL(x) (x).begin(), (x).end()
using namespace std;

const long long MOD = 1000000007;

long long pow(long long x, long long y) {
    long long p = x;
    long long ret = 1;
    for (int i = 0; (1LL << i) <= y; i++) {
        if (1LL << i & y) {
            ret = ret * p % MOD;
        }
        p = p * p % MOD;
    }
    return ret;
}

long long f[4000001];

long long inv(long long n) {
    return pow(f[n], MOD - 2);
}

void solve(long long n, long long k) {
    long long ret = f[n];
    ret = (ret * inv(k)) % MOD;
    ret = (ret * inv(n - k)) % MOD;
    cout << ret << "\n";
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    f[0] = 1;
    for (long long i = 1; i <= 4000000; i++) {
        f[i] = (i * f[i - 1]) % MOD;
    }
    long long n, k;
    cin >> n >> k;
    solve(n, k);
}
