# include <stdio.h>
# include <stdlib.h>

typedef struct Num{
    int min;
    int max;
}num;

num *newNum(int min, int max){
    num *n = (num *)calloc(1, sizeof(num));
    n->max = max;
    n->min = min;
    return n;
}

num *findMinMax(int *a, int l){
    num *n = newNum(0, 0);
    if(l == 2){
        if(a[0] > a[1]){
            n->max  = a[0];
            n->min = a[1];
            return n;
        }
        else{
            n->max = a[1];
            n->min = a[0];
            return n;
        }
    }
    if(l == 1){
        n->max = a[0];
        n->min = a[0];
        return n;
    }
    int i;
    int b[l/2], c[l - l/2];
    for(i = 0; i < l/2; i++){
        b[i] = a[i];
    }
    for(i = 0; i < l - l/2; i++){
        c[i] = a[i + l - l/2 - 1];
    }
    num *f = findMinMax(b, l/2);
    num *g = findMinMax(c, l - l/2);
    if(f->max > g->max){
        n->max = f->max;
    }
    else{
        n->max = g->max;
    }
    if(f->min < g->min){
        n->min = f->min;
    }
    else{
        n->min = g->min;
    }
    return n;
}

int main(){
    int n[] = {10, 2, 3, 4, 90, 23, 1, 24, 84};
    num *z = findMinMax(n, 9);
    printf("%d %d", z->max, z->min);
    return 0;
}