#include "RastgeleKarakter.h"

    rastgelekarakter rastgeleOlustur()
    {
        rastgelekarakter rg;    
        rg=(rastgelekarakter)malloc(sizeof(struct RastgeleKarakter));
        rg->rand=randomOlustur();
        rg->generateRandomChar=&GenerateRandomChar;
        rg->generateRandomCharBetween=&GenerateRandomCharBetween;
        rg->generateRandomChars=&GenerateRandomChars;
        rg->generateText=&GenerateText;
        rg->rastgeleyoket=&Rastgeleyoket;         
    }

    char* GenerateRandomCharBetween(const rastgelekarakter rg,char min, char max) 
    {        

        free(rg->currentarray);
        int rand=rg->rand->randomnumberbetween(rg->rand,(int)min,(int)max);
        rg->currentarray=(char*)malloc(sizeof(char)* rand);
        for(int i=0;i<rand;i++)
        {
            int a=rg->rand->randomnumberbetween(rg->rand,(int)min,(int)max);
            rg->currentarray[i]=(char)a;            
        }
        return rg->currentarray;
    }
    char GenerateRandomChar(const rastgelekarakter rg) 
    {
        int max=0;
        int min=0;
        int a=rg->rand->randomnumber(rg->rand);
        if(a%2==0)
        {
            max=90;         //büyük yada küçük
            min=65;
        }
        else
        {
            max=122;
            min=97;
        }
        int b=rg->rand->randomnumberbetween(rg->rand,min,max);
        char tmp=(char)b;
        return tmp;        
    }
    
    
    char* GenerateRandomChars(const rastgelekarakter rg,int value)
    {
        free(rg->currentarray);
        if(value>0)
        {
            rg->currentarray=(char*)malloc(sizeof(char)* value);
            for(int i=0;i<value;i++)                
                rg->currentarray[i]=GenerateRandomChar(rg);           
        }
        return rg->currentarray;        
    }
    
    char* GenerateText(const rastgelekarakter rg)            
    {
        free(rg->currentarray);
        free(rg->currenttext);
        int wordc=(rg->rand->randomnumberbetween(rg->rand,2,9));  //rastgele kelime sayısı
        int ac=0;
        rg->currenttext=(char*)malloc(sizeof (char) * 100);; 
        int tc=0;
        for(int i=0;i<wordc;i++)
        {
            ac=rg->rand->randomnumberbetween(rg->rand,2,9); //rastgele kelimenin harf sayısı
            for(int j=0;j<ac;j++)
            {
                rg->currenttext[tc]=GenerateRandomChar(rg);
                tc++;
            }
            rg->currenttext[tc]=' ';
            tc++;
        }
        return rg->currenttext;
    }

    void Rastgeleyoket(rastgelekarakter rg)
    {
        if(rg == NULL) return;
        rg->rand->randomyoket(rg->rand);
        free(rg->currentarray);
        free(rg->currenttext);
        free(rg);
        rg=NULL;
    }
