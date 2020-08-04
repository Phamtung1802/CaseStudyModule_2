package BookPackage;

import java.io.*;
import java.util.HashMap;

public class IDGenerator implements Serializable {
    HashMap code;
    private static final IDGenerator INSTANCE=new IDGenerator();
    private IDGenerator()  {
        code=new HashMap();

    }
    private synchronized void IDGenerator(){

    }

    private void addIDCode() {
        File IDcode=getIDFile();
        try {
            FileReader input=new FileReader(IDcode);
            try {
                FileWriter output=new FileWriter(IDcode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static File getIDFile(){
        File IDcode=null;
        try {
            IDcode = new File("IDCode.txt");
            if (!IDcode.exists()) {
                IDcode.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return IDcode;
    }
   public static synchronized IDGenerator getINSTANCE() {
            getIDFile();

        return INSTANCE;
   }
}
