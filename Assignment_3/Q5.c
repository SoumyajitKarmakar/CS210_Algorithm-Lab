# include <stdio.h>
# include <stdlib.h>
# include <math.h>

long int karatsuba(long int x, long int y){
    if(x < 10 || y < 10){
        return x * y;
    }
    int o;
    int n = floor(log10(abs(x))) + 1;
    int m = floor(log10(abs(y))) + 1;
    o = m;
    if(n > m){
        o = n;
    }
    long int xh = x / pow(10, o / 2);
    long int xl = x % (long)pow(10, o / 2);
    long int yh = y / pow(10, o / 2);
    long int yl = y % (long)pow(10, o / 2);
    long int a = karatsuba(xh, yh);
    long int d = karatsuba(xl, yl);
    long int e = (xh + xl) * (yh + yl) - a - d;
    return a * pow(10, o) + e * pow(10, o / 2) + d;
}

int main(){
    long int a, b;
    printf("Enter first number : ");
    scanf("%ld", a);
    printf("\nEnter second number : ");
    scanf("%ld", b);
    printf("\nThe product is : %ld", karatsuba(a, b));
    return 0;
}