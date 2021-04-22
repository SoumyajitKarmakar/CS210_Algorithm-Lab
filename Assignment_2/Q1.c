# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# define Data char

typedef struct Node{
    Data data;
    struct Node *next;
    struct Node *prev;
}node;

typedef struct Cursor{
    int key;
    node *loc;
}cursor;

typedef struct String{
    node *head;
    node *tail;
    cursor *cur;
    node *clip;
}string;

void printList(node* n) 
{ printf("<%d>", __LINE__);
    while (n != NULL) { printf("<%d>", __LINE__);
        printf("%c ", n->data); printf("<%d>", __LINE__);
        n = n->next; printf("<%d>", __LINE__);
    } 
} 

int printString(string *s){
    node *t = s->head;
    while(t != NULL){
        printf("%c", t->data);
        t = t->next;
    }
    printf("\n");
    return 0;
}

int printCursor(string *s){printf("<%d>", __LINE__);
    printf("%d", s->cur->key);printf("<%d>", __LINE__);
    return 0;
}

int printCurData(string *s){printf("<%d>", __LINE__);
    printf("%c", s->cur->loc->data);printf("<%d>", __LINE__);
    return 0;
}

string *initilise(){printf("<%d>", __LINE__);
    string *s = (string *)calloc(1, sizeof(string));printf("<%d>", __LINE__);
    cursor *c = (cursor *)calloc(1, sizeof(cursor));printf("<%d>", __LINE__);
    node *n = (node *)calloc(1, sizeof(node));printf("<%d>", __LINE__);
    n->data = 0;printf("<%d>", __LINE__);
    n->next = NULL;printf("<%d>", __LINE__);
    n->prev = NULL;printf("<%d>", __LINE__);
    s->cur = c;printf("<%d>", __LINE__);
    s->head = n;printf("<%d>", __LINE__);
    s->tail = n;printf("<%d>", __LINE__);
    s->clip = NULL;printf("<%d>", __LINE__);
    c->key = 0;printf("<%d>", __LINE__);
    c->loc = n;printf("<%d>", __LINE__);
    return s;
}

int insertClip(string *s, Data data){
    node *n = (node *)calloc(1, sizeof(node));
    node *t = s->clip;
    n->data = data;
    n->next = NULL;
    if(s->clip == NULL){
        s->clip = n;
        n->prev = NULL;
    }
    else{
        while(t->next != NULL){
            t = t->next;
        }
        t->next = n;
        n->prev = t;
    }
    return 0;
}

int insertAtCursor(string *s, Data data){printf("<%d>", __LINE__);
    if(s->head->data == 0){printf("<%d>", __LINE__);
        s->head->data = data;printf("<%d>", __LINE__);
    }
    else{printf("<%d>", __LINE__);
        node *n = (node *)calloc(1, sizeof(node));printf("<%d>", __LINE__);
        n->data = data;printf("<%d>", __LINE__);
        n->next = s->cur->loc;printf("<%d>", __LINE__);
        n->prev = s->cur->loc->prev;printf("<%d>", __LINE__);
        if(s->cur->loc->prev != NULL){printf("<%d>", __LINE__);
            s->cur->loc->prev->next = n;printf("<%d>", __LINE__);
        }
        s->cur->loc->prev = n;printf("<%d>", __LINE__);
        s->cur->key = s->cur->key + 1;printf("<%d>", __LINE__);
    }
    return 0;
}

int seek(string *s, int x){
    node *t = s->head;
    int j = 0;
    if(x == -1){
        while(t->next != NULL){
            t = t->next;
            j++;
        }
        s->cur->key = j;
        s->cur->loc = t;
    }
    else{
        s->cur->key = x;
        int i;
        for(i = 0; i < x; i++){
            t = t->next;
        }
        s->cur->loc = t;
    }
    return 0;
}

int delete(string *s, int x){
    if(x == 1){
        node *t = s->cur->loc;
        s->cur->loc->next->prev = s->cur->loc->prev;
        s->cur->loc->prev->next = s->cur->loc->next;
        s->cur->loc = s->cur->loc->next;
        free(t);
    }
    if(x == -1){
        node *t = s->cur->loc->prev;
        s->cur->key = s->cur->key - 1;
        s->cur->loc->prev->prev->next = s->cur->loc;
        s->cur->loc->prev = s->cur->loc->prev->prev;
        free(t);
    }
    return 0;
}

int clearClip(string *s){
    node* current = s->clip; 
    node* next;
    while (current != NULL){ 
       next = current->next; 
       free(current); 
       current = next; 
   }
   s->clip = NULL;
   return 0;
}

int copy(string *s, int x, int y){
    int i;
    if(s->clip != NULL){
        clearClip(s);
    }
    node *t = s->head;
    for(i = 0; i < x; i++){
        t = t->next;
    }
    for(i = x; i < y; i++){
        insertClip(s, t->data);
        t = t->next;
    }
    return 0;
}

int printClip(node *c){
    node *t = c;
    while(t->next != NULL){
        t = t->next;
        printf("%d", t->data);
    }
    printf("\n");
    return 0;
}

int cut(string *s, int x, int y){
    if(s->clip != NULL){
        clearClip(s);
    }
    copy(s, x, y);
    int i;
    node *t = s->head;
    for(i  = 0; i < x - 1; i++){
        t = t->next;
    }
    node* current = t->next; 
    node* next;
    for(i = x; i <= y; i++){ 
       next = current->next; 
       free(current); 
       current = next; 
   }
   t->next = current;
   current->prev = t;
   return 0;
}

int paste(string *s, int x){
    if(s->clip == NULL){
        return 0;
    }
    else{
        int i;
        node *t = s->head;
        for(i = 0; i < x; i++){
            t = t->next;
        }
        i = 1;
        node *o = s->clip;
        node *p = t->next;
        t->next = s->clip;
        s->clip->prev = t;
        while(o->next != NULL){
            o = o->next;
            i++;
        }
        o->next = p;
        p->prev = o;
        s->clip = NULL;
        seek(s, x + i);
        return 0;
    }
}

// int save(string *s, char *c)

// typedef union charAndInt{
//     char c;
//     int i;
// }charInt;

// int main(){
//     char *c = (char *)calloc(15, sizeof(char));
//     char x, y;
//     string *s = initilise();
//     while(1){
//         scanf("%s %c %c", c, x, y);
//         if(strcmp(c, "EXIT") == 0){
//         exit(0);
//         }
//         else if(strcmp(c, "PRINT") == 0){
//             printString(s);
//         }
//         else if(strcmp(c, "PRINT_CURSOR") == 0){
//             printCursor(s);
//         }
//         else if(strcmp(c, "INSERT") == 0){
//             insertAtCursor(s, x);
//         }
//         else if(strcmp(c, "SEEK") == 0){
//             seek(s, x - '0');
//         }
//         else if(strcmp(c, "DELETE") == 0){
//             delete(s, x - '0');
//         }
//         else if(strcmp(c, "COPY") == 0){
//             copy(s, x - '0', y - '0');
//         }
//         else if(strcmp(c, "PRINT_CLIPBOARD") == 0){
//             printClip(s->clip);
//         }
//         else if(strcmp(c, "CUT") == 0){
//             cut(s, x - '0', y - '0');
//         }
//         else if(strcmp(c, "PASTE") == 0){
//             paste(s, x - '0');
//         }
//     }
//     return 0;
// }


int main(){
    string *s = initilise();printf("<%d>", __LINE__);
    // char a;
    // scanf("%c ", &a);
    // insertAtCursor(s, a);
    // scanf("%c ", &a);
    // insertAtCursor(s, a);
    // scanf("%c ", &a);
    // insertAtCursor(s, a);
    insertAtCursor(s, 'a');printf("<%d>", __LINE__);
    printCurData(s);printf("<%d>", __LINE__);
    insertAtCursor(s, 'b');printf("<%d>", __LINE__);
    printList(s->head);printf("<%d>", __LINE__);
    insertAtCursor(s, 'c');printf("<%d>", __LINE__);
    printList(s->head);printf("<%d>", __LINE__);
    insertAtCursor(s, 'd');printf("<%d>", __LINE__);
    printCurData(s);printf("<%d>", __LINE__);
    printCursor(s);printf("<%d>", __LINE__);
    printList(s->head);printf("<%d>", __LINE__);
    return 0;
}

//printf("<%d>", __LINE__);