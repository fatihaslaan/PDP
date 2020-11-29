/**
 *
 *
 * @author Fatih Aslan
 *
 * @since 15.03.2019
 * <p>  
 *  No:G171210045
 *  RastgeleKarakterKütüphanesi
 * </p>
 */ 
package RastgeleKarakter;

public class RastgeleKarakter 
{
    int rd=(int)System.nanoTime()%10; //hızlı çalışmada nano time tekrar etmesin diye
    int generateRandomNumber(int min,int max)  //iki sayı arasında bir değeri rastgele üretiyor
    {           
        rd+=(int)System.nanoTime()%10;
        long a=System.nanoTime()*(System.nanoTime()%rd); //rastgeleliği kullanıcağımız değişken
        int tmp=(int)(a % (max+1));
        while(tmp<min)
        {
            tmp=(int)((System.nanoTime()) % (max+1));
        }
        return tmp;
    }
    public char[] generateRandomChar(char min, char max) 
    {
        int a=generateRandomNumber(1,3);
        char[] tmp=new char[a];
        for(int i=0;i<a;i++)
            tmp[i]=(char)generateRandomNumber((int)min,(int)max);
        return tmp;
    }
    public char generateRandomChar() 
    {
        int max=0;
        int min=0;
        if(System.nanoTime() %2==0)
        {
            max=90;         //büyük yada küçük
            min=65;
        }
        else
        {
            max=122;
            min=97;
        }
        char tmp=(char)generateRandomNumber(min,max);
        return tmp;        
    }
    
    
    public char[] generateRandomChar(int value)
    {
        if(value>0)
        {
            char[] txt=new char[value];  //sayı kadar char döner
            for(int i=0;i<value;i++)
                txt[i]=generateRandomChar();
            return txt;
        }
        return null;
    }
    
    public char[] takecharfrom(char... args) //girilen charlar arasından rastgele seçer
    {       
        int a=generateRandomNumber(1,2);
        char[] txt=new char[a];
        for (int i=0;i<a;i++)      
        {
            txt[i]=args[generateRandomNumber(0,args.length-1)];
        }
        return txt;
    }
    
    
    public char[] generateText()            
    {
        int wordc=generateRandomNumber(2,9);  //rastgele kelime sayısı
        int ac=0;
        char[] txt=new char[100]; 
        int tc=0;
        for(int i=0;i<wordc;i++)
        {
            ac=generateRandomNumber(2,9); //rastgele kelimenin harf sayısı
            for(int j=0;j<ac;j++)
            {
                txt[tc]=generateRandomChar();
                tc++;
            }
            txt[tc]=' ';
            tc++;
        }
        return txt;
    }
    
    
}
