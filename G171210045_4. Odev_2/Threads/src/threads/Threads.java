/**
 * @author Fatih Aslan  
 * @since 01.05.2019
 * @No G171210045
 */ 
package threads;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads 
{
    public static void main(String[] args) throws IOException 
    {
        //texturet a=new texturet();
        //a.text();    //büyük textler üretmek için, ben 20 mblık ürettim ödevi gönderebilmek için daha da yükseltilebiliyor
        String Text="";
        FileRead oku=new FileRead(); //texti aldık
        SeriHesapla seri=new SeriHesapla();
        Text=oku.read();
        
        seri.hesapla(Text);
        
        long baslangic = System.nanoTime();
        
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for(int i=0;i<4;i++)
            pool.execute(new thread(i,Text)); //sıralamayı for döngüsüyle havuza verdik           
        pool.shutdown();
        while(!pool.isTerminated()){            
        }
        
        long bitis = System.nanoTime();
        double sure = (bitis-baslangic)/1000000.0; 
        System.out.println("\nParalel Hesaplama Süresi " + String.format("%.2f", sure) + " milisaniye."); 
        
    }    
}
