#ifndef RastgeleKarakter_h
#define RastgeleKarakter_h
#include "Random.h"

    struct RastgeleKarakter
    {
        random rand;
        char *currentarray;
        char *currenttext;
        char* (*generateRandomCharBetween)(struct RastgeleKarakter*,char min, char max);
        char (*generateRandomChar)(struct RastgeleKarakter*);
    
        char* (*generateRandomChars)(struct RastgeleKarakter*,int value);
    
        //char* (*takecharfrom)(struct RastgeleKarakter); //dinamik olucak
    
    
        char* (*generateText)(struct RastgeleKarakter*);
        void (*rastgeleyoket)(struct RastgeleKarakter*);
    };typedef struct RastgeleKarakter *rastgelekarakter;

    rastgelekarakter rastgeleOlustur();
    char* GenerateRandomCharBetween(rastgelekarakter,char min,char max);
    char GenerateRandomChar(rastgelekarakter);
    char* GenerateRandomChars(rastgelekarakter,int value);
    char* GenerateText(rastgelekarakter);
    void Rastgeleyoket(rastgelekarakter);


#endif    
    

