/**
 * @author Fatih Aslan  
 * @since 01.05.2019
 * @No G171210045
 */ 
package threads;
public class SeriHesapla 
{
    int value;
    public void hesapla(String t)
    {
        long baslangic = System.nanoTime();
        for(int j=0;j<4;j++)
        {            
            for(int i=0;i<t.length()/4;i++)
            {
                value+=Character.getNumericValue(t.charAt(j+i*4));            
            }
            System.out.print(value);
            value=0;
        }
        long bitis = System.nanoTime();
        double sure = (bitis-baslangic)/1000000.0; 
        System.out.println("\nSeri Hesaplama Süresi " + String.format("%.2f", sure) + " milisaniye.");
    }
    
}
