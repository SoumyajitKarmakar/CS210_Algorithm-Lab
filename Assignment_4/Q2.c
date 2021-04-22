# include <stdio.h>
# include <stdlib.h>

int power(int a, int n)
{
    if (n == 0)
        return 1;
    if (a == 0)
        return 0;
    if (n % 2 == 0)
        return power(a * a, n / 2);
    else
        return a * power(a * a, n / 2);
}

int main() {
    printf("Enter 2 numbers : ");
    int a, n;
    scanf("%d %d", &a, &n);
    printf("The power is : %d", power(a, n));
    return 0;
}