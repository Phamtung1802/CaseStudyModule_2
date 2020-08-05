package BookPackage;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class DataControl implements Serializable {
    HashMap lib;
    private static final DataControl INSTANCE=new DataControl();


    private DataControl()  {
    }
    private synchronized void IDGenerator(){

    }

    private static FileReader getReader(File getIDFile) {
        File IDcode=getIDFile;
        FileReader input = null;
        try {
            input=new FileReader(IDcode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    private static FileWriter getWriter(File getIDFile,boolean doesAppend) {
        File IDcode = getIDFile;
        FileWriter output=null;
        try {
            if(doesAppend==false) {
                output = new FileWriter(IDcode);
            }
            else {
                output=new FileWriter(IDcode,true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void WriteFile(BookList list,boolean doesAppend) {
        FileWriter writer=getWriter(getIDFile(),doesAppend);
        list.forEach((k, v) -> {
            System.out.format("key: %s ", k);
            try {
                writer.write(k+","+v.getName()+","+v.getLang()+","+v.getPrice()+","+v.getDate()+","+v.getAuthor()+","+v.getLang()+","+v.getPublisher()+","+v.getCategory()+"\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("loi");
            }
        });
        try {
            writer.close();
        }
        catch (IOException e) {
                e.printStackTrace();
                System.out.println("loi");
        }
    }



    public void AppendFile(File csvFile,BookList list)  {
        FileWriter writer=getWriter(getIDFile(),true);
        FileReader reader=getReader(csvFile);
        StringBuffer data=new StringBuffer("");
        int code=-1;
        try {
            while ((code =reader.read())!= -1) {
                data.append((char)code);
            }
            reader.close();
            System.out.println(data);
            writer.append(data);
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static BookList loadList()  {
        BookList list=new BookList();
        FileReader reader=getReader(getIDFile());
        StringBuffer data=new StringBuffer("");
        try {int a=-1;
            while((a=reader.read())!=-1) {
                data.append((char) a);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] newdata=data.toString().split("\n");
        if(newdata.length>1) {
            for (int i = 0; i < newdata.length; i++) {
                String[] tempstr = newdata[i].split(",");
                list.put(tempstr[0], new Book(tempstr[1], tempstr[2], Long.parseLong(tempstr[3]), tempstr[4], tempstr[5], tempstr[6], tempstr[7]));
            }
        }
        return list;
    }



    private static File getIDFile(){
        File IDcode=null;
        try {
            IDcode = new File("Lib.txt");
            if (!IDcode.exists()) {
                IDcode.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return IDcode;
    }


   public static synchronized DataControl getINSTANCE() {
            getIDFile();
        return INSTANCE;
   }
}
