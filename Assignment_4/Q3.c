# include <stdio.h>
# include <stdlib.h>

int* polyMult(int* a, int* b, n) {
	int* r = (int*)calloc(2 * n + 1, sizeof(int));
	int k = 0;
	if (n % 2 == 1) {
		k = 1;
	}
	int* a0 = a;
	int* a1 = a + (n + 1) / 2;
	int* b0 = b;
	int* b1 = b + (n + 1) / 2;
	int* U = polyMult(a0, b0, (n + 1) / 2);
	int* V = polyMult(a0, b1, (n + 1) / 2);
	int* W = polyMult(a1, b0, (n + 1) / 2);
	int* Z = polyMult(a1, b1, (n + 1) / 2);
	int i;
	for (i = 0; i < 2 * n + 1; i++) {
		if (i < n / 2) {
			r[i] = U[i];
		}
		else if (i < n) {
			r[i] = U[i] + V[i - n / 2] + W[i - n / 2];
		}
		else {
			r[i] = 
		}
	}
}


int main() {
	return 0;
}