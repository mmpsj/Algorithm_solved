#include <iostream>
#include <cmath>
using namespace std;
void hanoi(int n, const int& from, const int& temp, const int& to);
int main() {
	int n;
	cin >> n;
	cout << (int)pow(2, n) - 1 << '\n';
	hanoi(n, 1, 2, 3);
	return 0;
}
void hanoi(int n, const int& from, const int& temp, const int& to) {
	if (n == 1) {
		cout << from << ' ' << to << '\n';
		return;
	}
	hanoi(n - 1, from, to, temp);
	cout << from << ' ' << to << '\n';
	hanoi(n - 1, temp, from, to);
}