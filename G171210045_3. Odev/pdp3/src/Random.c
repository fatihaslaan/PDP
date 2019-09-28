#include <time.h>
#include <Windows.h>
#include "Random.h"

random randomOlustur()
{
    random rd;    
    rd=(random)malloc(sizeof(struct Random));
    rd->randomnumber=&Randomnumber;
    rd->randomnumberbetween=&Randomnumberbetween;
    rd->randomyoket=&Randomyoket;
}

int Randomnumberbetween(const random rd,int min,int max)
{
    FILETIME now;
    GetSystemTimeAsFileTime(&now);
    int a=(int)now.dwLowDateTime%(max+1);    
    a=abs(a); 
    Sleep(a/7); 
    while(a<min)
    {
        Sleep(a/8);
        a+=8;
    }
    return a; 
}
int Randomnumber(const random rd)
{
    FILETIME now;
    GetSystemTimeAsFileTime(&now);
    int a=(int)now.dwLowDateTime%10; 
    a=abs(a); 
    Sleep(a/9);
    return a; 
}

void Randomyoket(random rd)
{
      if(rd == NULL) return;
      free(rd);
}
          
