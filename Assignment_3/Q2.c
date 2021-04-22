# include <stdio.h>
# include <stdlib.h>
# include <limits.h>

int crossSubArray(int* a, int* l, int* r, int n) {
	int i, sum = 0;
	for (i = n / 2; i < n; i++) {
		sum += a[i];
		if (sum > * r) {
			* r = sum;
		}
	}
	sum = 0;
	for (i = n / 2 - 1; i >= 0; i--) {
		sum += a[i];
		if (sum > * l) {
			* l = sum;
		}
	}
	return 0;
}


int maxSubArray(int* a, int n) {

	if (n == 1) {
		return a[0];
	}

	int mid = n / 2;

	int leftM = maxSubArray(a, mid);
	int rightM = maxSubArray(a + mid, n - mid);

	int leftCross = INT_MIN;
	int rightCross = INT_MIN;

	crossSubArray(a, &leftCross, &rightCross, n);

	int cr = leftCross + rightCross;

	if (leftM >= rightM && leftM >= cr) {
		return leftM;
	}
	else if (rightM >= leftM && rightM >= cr) {
		return rightM;
	}
	else
		return cr;
}

int main() {
	int* a = (int*)calloc(8, sizeof(int));
	a[0] = 4;
	a[1] = -2;
	a[2] = -3;
	a[3] = 4;
	a[4] = -2;
	a[5] = 2;
	a[6] = -3;
	a[7] = 4;

	printf("%d", maxSubArray(a, 8));
	return 0;
}