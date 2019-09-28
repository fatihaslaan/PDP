#include "RastgeleKarakter.h"

int main()
{  
    rastgelekarakter rastgele=rastgeleOlustur();    

    printf("Rastgele karakter:\n");
    for (int i = 0; i < 60; i++)
    {
        printf("%c%c",rastgele->generateRandomChar(rastgele),',');
    }
    printf("\nVerilen miktar kadar rastgele karakter:\n");
    for (int i = 0; i < 20; i++)
    {
        printf(rastgele->generateRandomChars(rastgele,3));        
    }
    printf("\nVerilen iki karakter arasindan rastgele karakter:\n");
    for (int i = 0; i < 60; i++)
    {
        printf("%c", rastgele->generateRandomCharBetween(rastgele, 'a', 'z'));
    }
    printf("\nIstenen kelime sayinina gore cumle uretme:\n" );    
    printf(rastgele->generateText(rastgele));  
    rastgele->rastgeleyoket(rastgele);

    return 0;
}
