#include <iostream>
using namespace std;
void star(int** arr, int i, int j, int n);
int main() {
	int n;
	cin >> n;
	int** arr = new int* [n];
	for (int i = 0; i < n; i++) {
		arr[i] = new int[n];
		for (int j = 0; j < n; j++) {
			arr[i][j] = 0;
		}
	}
	star(arr, 0, 0, n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 1) {
				cout << '*';
			}
			else {
				cout << ' ';
			}
		}
		cout << '\n';
	}
	for (int i = 0; i < n; i++) {
		delete[] arr[i];
	}
	delete[] arr;
	return 0;
}
void star(int** arr, int i, int j, int n) {
	if (n > 3) {
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				if (!(a == 1 && b == 1)) {
					star(arr, i + a * n / 3, j + b * n / 3, n / 3);
				}
			}
		}
	}
	else {
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				if (!(a == 1 && b == 1)) {
					arr[i + a][j + b] = 1;
				}
			}
		}
	}
}