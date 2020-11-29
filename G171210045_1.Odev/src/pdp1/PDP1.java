/**  *  *
 * @author Fatih 
 * @since 26.02.2018
 */ 
package pdp1;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class PDP1 
{
    public enum isspecial
    {
        nothing,
        singlequatation,
        quatation,
        slash
    } //checking if text starts with ",',/ 
    
    public static void main(String[] args) 
    {
        isspecial isspec=isspecial.nothing; 
        String Text=""; 
        String word="";
        
        String fileName = "Program.c"; //for read
        String line = null;   //for read
        
        int opc=0; //operator count
        int pc=0; //parameter count
        List<String> functions=new ArrayList<String>();  //functions
        String parameters="";
        boolean isfunccheck=false;  //checking for fucntions
        boolean isbracketcheck=false; //checking for brackets
        boolean ismorethanoneline=false;
        
        try                                                 //reading file
        {            
            FileReader fileReader =new FileReader(fileName);
            
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) 
            {
                Text+=line+"\n";
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + fileName + "'");
        }                                                   //until here
            
        for(int i=0;i<Text.length();i++)                    //checking file for operators,functions, parameters and others 
        {
            if(Text.charAt(i)==' '||Text.charAt(i)=='\n')
            {
                word="";
            }                
            else
            {
                word+=Text.charAt(i);               
            }
            word=word.trim();           //looking for fword by word
            if(ismorethanoneline)            //looking for is it code or not
                if(Text.charAt(i-1)=='*'&&Text.charAt(i)=='/')
                {
                    ismorethanoneline=false;
                    isspec=isspecial.nothing; 
                    opc--;
                }
            
            if(Text.charAt(i)=='\n'&&isspec==isspecial.slash&&!ismorethanoneline) //end of comment line
            {
                isspec=isspecial.nothing;                
            }
            
            if(Text.charAt(i)=='\''&&isspec!=isspecial.slash) //looking for is it code or not
            {
                if(isspec==isspecial.nothing)
                    isspec=isspecial.singlequatation;
                else if(isspec==isspecial.singlequatation)                    
                    isspec=isspecial.nothing;
            }
            else if(Text.charAt(i)=='\"'&&isspec!=isspecial.slash)
            {
                if(isspec==isspecial.nothing)
                    isspec=isspecial.quatation;
                else if(isspec==isspecial.quatation)                    
                    isspec=isspecial.nothing;
            }
            
            if((isspec==isspecial.nothing)&&(word.equals("int")||word.equals("void")||word.equals("string")||word.equals("float")||word.equals("double")||word.equals("long")||word.equals("byte")||word.equals("char")||word.equals("short")||word.equals("real")))
            {
                isfunccheck=true;  //looking for keywords for functions             
            }
            if(isfunccheck)
            {
                if(Text.charAt(i)=='(')
                {
                    word=word.substring(0,word.length()-1);
                    functions.add(word); //adding functions
                    isbracketcheck=true;  //looking for parameters
                }
                else if(Text.charAt(i)==';'||Text.charAt(i)=='='||Text.charAt(i)==')')
                    isfunccheck=false;
            }
            
            if(isbracketcheck)
            {
                if(Text.charAt(i)!=')')
                {
                    if(Text.charAt(i)=='('&&Text.charAt(i+1)!=')')  //counting parameters
                        pc++;
                    if(Text.charAt(i)==',')
                        pc++;
                    parameters+=Text.charAt(i);
                }
                else
                {                    
                    parameters+=")\n";
                    isbracketcheck=false;
                }               
            }            
            if((isspec==isspecial.nothing)&&(Text.charAt(i)=='+'||Text.charAt(i)=='='||Text.charAt(i)=='-'||Text.charAt(i)=='*'||Text.charAt(i)=='/'||Text.charAt(i)=='<'||Text.charAt(i)=='>'||Text.charAt(i)=='&'||Text.charAt(i)=='!'||Text.charAt(i)=='|'))
            {    
                if(Text.charAt(i-1)=='/'&&Text.charAt(i)=='*')
                {
                    opc=opc-2;
                    ismorethanoneline=true;    //is it comment line
                    isspec=isspecial.slash;
                }
                if(Text.charAt(i-1)==Text.charAt(i))
                {
                    if(Text.charAt(i)=='/')
                    {
                        opc--;
                        isspec=isspecial.slash;
                    }
                    opc--;                    
                }
                opc++;
            }
        }       
        System.out.print("Toplam Oparatör sayısı:");
        System.out.println(opc);
        System.out.print("Toplam Fonksiyon sayısı:");
        System.out.println(functions.size());       
        System.out.print("Toplam Parametre sayısı:");
        System.out.println(pc);
        System.out.println("Fonksiyon İsimleri:");
        for(int i=0;i<functions.size();i++)
        {
            System.out.print(functions.get(i)+"- Parametreler:");
            int a=0;
            while(parameters.charAt(a)!='\n')
            {
                System.out.print(parameters.charAt(a));
                a++;
            }         
            System.out.println("");
            parameters=parameters.substring(a+1,(parameters.length()));
        }
        
    }
    
}
