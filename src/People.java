package src;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class People
{
    public static void add(String firstname, String lastname, String books)
    {
        try
        {
            FileWriter out=new FileWriter("./data/list.csv",true);
            out.write(firstname.replaceAll(" ","_")+","+lastname.replaceAll(" ","_")+","+books.replaceAll(" ",",")+"\n");
            out.close();
        }
        catch(IOException e)
        {}
    }
    public static void show()
    {
        try
        {
            BufferedReader in=new BufferedReader(new FileReader("./data/list.csv"));
            String line;
            while((line=in.readLine())!=null)
                System.out.println(line.replaceAll(","," "));
            in.close();
        }
        catch(IOException e)
        {}
    }
    public static void show(int index)
    {
        try
        {
            int i=1;
            BufferedReader reader=new BufferedReader(new FileReader("./data/list.csv"));
            String currentLine;

            while((currentLine=reader.readLine())!=null&&i<=index)
            {
                String trimmedLine=currentLine.trim();
                if(index==i)
                    System.out.println(currentLine.replaceAll(","," ")+System.getProperty("line.separator"));
                ++i;
            }
            reader.close();
        }
        catch(IOException e)
        {}
    }
    public static void remove(int index)
    {
        try
        {
            int i=1;
            BufferedReader reader=new BufferedReader(new FileReader("./data/list.csv"));
            BufferedWriter writer=new BufferedWriter(new FileWriter("./data/temp.csv"));
            String currentLine;

            while((currentLine=reader.readLine())!=null)
            {
                String trimmedLine=currentLine.trim();
                if(index!=i)
                    writer.write(currentLine+System.getProperty("line.separator"));
                ++i;
            }
            writer.close(); 
            reader.close();
            File list=new File("./data/list.csv"),temp=new File("./data/temp.csv");

            Files.move(temp.toPath(),list.toPath(),StandardCopyOption.REPLACE_EXISTING);
        }
        catch(Exception e)
        {} 
    }
}