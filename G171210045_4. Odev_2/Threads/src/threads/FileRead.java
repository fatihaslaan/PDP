/**
 * @author Fatih Aslan  
 * @since 01.05.2019
 * @No G171210045
 */ 
package threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead 
{
    StringBuilder sb=new StringBuilder(); //daha hızlı okuma
    String fileName = "Sayilar.txt";
    String Text="";
    String line="";
    public String read()
    {
        try                                                 //reading file
        {            
            FileReader fileReader =new FileReader(fileName);
            
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) 
            {
                sb.append(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + fileName + "'");
        }
        Text=sb.toString();
        return Text;
    }
}
