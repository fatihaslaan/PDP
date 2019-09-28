/**
 * @author Fatih Aslan  
 * @since 01.05.2019
 * @No G171210045
 */ 
package threads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class texturet 
{
    public void text() throws IOException
    {
        String str = "";

        File file = new File("Sayilar.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        for(int i=0;i<3500000;i++)  //şu an 20 mblık dosya üretiyor 
        {
            Random rand=new Random();
            int n=rand.nextInt(8999);
            n+=1000;
            str=""+n;
            if(i!=0)
                bWriter.newLine();
            bWriter.write(str);
           
        }
        bWriter.close();

    }
}
