#ifndef Random_h
#define Random_h
#include <stdlib.h>
#include <stdio.h>


    struct Random
    {
        long nanotime;
        int delay; //maybe
        int (*randomnumberbetween)(struct Random*,int min,int max);
        int* (*randomnumber)(struct Random*);
        void (*randomyoket)(struct Random*);
    }; typedef struct Random *random; 


    random randomOlustur();
    int Randomnumberbetween(random,int min,int max);
    int Randomnumber(random);
    void Randomyoket(random);


#endif