import java.io.*;
import java.util.*;

/**
* @autor: gonephishing
* @contact: https://www.quora.com/Ritesh-Kumar-Singh-3
*/
class RegCheck
{
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader fr;
    public static BufferedReader fr2;
    public static BufferedWriter fw1;
    public static BufferedWriter fw2;

    RegCheck()
    {
        ////////////////// Entering Records to ArrayList ///////////////////
        ArrayList<String> al=new ArrayList<String>();
        ArrayList<String> bl=new ArrayList<String>();
        String str1="";
        try
        {
            fr=new BufferedReader(new FileReader("Registrations.txt"));
            int record_count=0;
            while((str1=fr.readLine())!=null)
            {
                String str2[]=str1.split("  ");
                al.add(str2[1]);
                record_count++;
            }
            write("Records counted: "+record_count+"\tArray size: "+al.size());
            fr.close();
        }
        catch(Exception ex1)
        {
            ex1.printStackTrace();
        }

        Set<String> ss=new HashSet<String>();
        //////////////////// Refreshing record list ///////////////////
        String str5="";
        int ref_count=0;
        try
        {
            fr2=new BufferedReader(new FileReader("scanned.txt"));
            int record_count=0;
            while((str5=fr2.readLine())!=null)
            {
                bl.add(str5);
                ss.add(str5);
                ref_count++;
            }
            write("Records after refresh counted: "+ref_count);
            fr2.close();
        }
        catch(Exception ex3)
        {
            ex3.printStackTrace();
        }
        /////////////////////// Starting check manual ///////////////////
        int count=0;
        String x="";
        try
        {
            fw1 = new BufferedWriter(new FileWriter("scanned.txt"));
            fw2 = new BufferedWriter(new FileWriter("new_reg.txt"));
            while(!(x.equals("exit")))
            {
                x=read();
                if(x.equals("exit"))
                {
                    continue;
                }
                if(ss.add(x))
                {
                    if(al.indexOf(x)>=0)
                    {
                        write("Pleze get in");
                        count++;                            //Counting normal users
                        bl.add(x);
                        fw1.write(x);                       //Adding to scanned.txt
                        fw1.newLine();
                    }
                    else
                    {
                        write("Not registered\nDo you want to register");
                        String ans=read();
                        if((ans.equals("y"))||(ans.equals("Y")))
                        {
                            fw1.write(x);                       //Adding new registration to scanned.txt
                            fw1.newLine();
                            fw2.write(x);                       //Adding new registration to new_reg.txt
                            fw2.newLine();
                            bl.add(x);                          //Adding new new registration to dumper list
                            count++;                            //Count users
                            write("Registered");
                        }
                        else if(ans.equals("n")|| ans.equals("N"))
                        {
                            write("Why u no register");
                        }
                    }
                }
                else
                {
                    if(al.indexOf(x)>=0)
                    {
                        write("Already scanned and Registered");
                    }
                    else
                    {
                        write("Already scanned and NOT registered");
                    }
                }
            }
            write(""+bl.toString());
            write("Count of users allowed: "+count);
            fw1.close();
            fw2.close();
        }
        catch(Exception ex2)
        {
            ex2.printStackTrace();
        }
    }
    
    public static String read()
    {
        String x="";
        try
        {
            x=br.readLine();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return x;
    }
    public static void write(String x)
    {
        try
        {
            bw.write(""+x+"\n");
            bw.flush();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String args[])
    {
        new RegCheck();
    }
}
