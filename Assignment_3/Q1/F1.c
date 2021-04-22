# include <stdio.h>
# include <stdlib.h>
# define s 2

int matMul1(int** a, int** b, int** r, int l) {
    int i, j, k;
    for (i = 0; i < l; i++)
    {
        for (j = 0; j < l; j++)
        {
            r[i][j] = 0;
            for (k = 0; k < l; k++)
            {
                r[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    return 0;
}

int printMat(int** r, int l) {
    int i, j;
    for (i = 0; i < l; i++)
    {
        for (j = 0; j < l; j++)
        {
            printf("%d\t", r[i][j]);
        }
        printf("\n");
    }
    return 0;
}

int main() {
    int i;

    int** a = (int**)calloc(s, sizeof(int*));
    int** b = (int**)calloc(s, sizeof(int*));
    int** r = (int**)calloc(s, sizeof(int*));

    for (i = 0; i < s; i++) {
        a[i] = (int*)calloc(2, sizeof(int));
        b[i] = (int*)calloc(2, sizeof(int));
        r[i] = (int*)calloc(2, sizeof(int));
    }

    a[0][1] = 2;
    a[1][1] = 4;
    a[1][0] = 5;
    a[1][1] = 7;
    b[0][0] = 8;
    b[0][1] = 1;
    b[1][0] = 3;
    b[1][1] = 5;

    matMul1(a, b, r, s);
    printMat(r, s);
    return 0;
}