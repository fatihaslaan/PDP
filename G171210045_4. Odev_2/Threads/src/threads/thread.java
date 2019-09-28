/**
 * @author Fatih Aslan  
 * @since 01.05.2019
 * @No G171210045
 */ 
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class thread implements Runnable 
{
    int order;
    String array;
    int value;
    public thread(int o,String a)
    {
        order=o;
        array=a;
    }
    public void run()
    {
        for(int i=0;i<array.length()/4;i++)
        {
            value+=Character.getNumericValue(array.charAt(order+i*4));            
        }
    }
}