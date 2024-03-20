#include <iostream>
using namespace std;
void merge_sort(int* arr, int n);
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	int* arr = new int[n];
	int* count = new int[8001];
	for (int i = 0; i < 8001; i++) {
		count[i] = 0;
	}
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		count[arr[i] + 4000]++;
	}
	merge_sort(arr, n);
	int sum = 0;
	for (int i = 0; i < n; i++) {
		sum += arr[i];
	}
	int max = 0, index;
	for (int i = 0; i < 8001; i++) {
		if (count[i] > max) {
			max = count[i];
			index = i;
		}
	}
	int c = 0;
	for (int i = 0; i < 8001; i++) {
		if (count[i] == max) {
			c++;
			if (c == 2) {
				index = i;
				break;
			}
		}
	}
	if (sum < 0) {
		cout << (int)((double)sum / n - 0.5) << '\n';
	}
	else {
		cout << (int)((double)sum / n + 0.5) << '\n';
	}
	cout << arr[n / 2] << '\n' << index - 4000 << '\n' << arr[n - 1] - arr[0];
	delete[] arr;
	delete[] count;
	return 0;
}
void merge_sort(int* arr, int n) {
	if (n == 1) {
		return;
	}
	int* a = new int[n];
	int h = n / 2;
	for (int i = 0; i < n; i++) {
		a[i] = arr[i];
	}
	merge_sort(a, h);
	merge_sort(a + h, n - h);
	int i = 0, j = 0;
	for (int k = 0; k < n; k++) {
		if (i == h) {
			arr[k] = *(a + h + j++);
			continue;
		}
		if (j == n - h) {
			arr[k] = *(a + i++);
			continue;
		}
		if (*(a + i) > *(a + h + j)) {
			arr[k] = *(a + h + j++);
		}
		else {
			arr[k] = *(a + i++);
		}
	}
	delete[] a;
}