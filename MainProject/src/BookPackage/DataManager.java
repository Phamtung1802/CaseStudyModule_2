package BookPackage;

import java.io.File;

public class DataManager {
    private static DataControl data=DataControl.getINSTANCE();
    private static BookList lib=new BookList();
    private static final DataManager dataManager= new DataManager();

    public static DataManager getINSTANCE() {
        return dataManager;
    }

    public void DataManager(){
        data=DataControl.getINSTANCE();
        lib=new BookList();
    }

    public BookList addBook(String id,String name,String lang, long price, String date, String author, String publisher, String category){
        this.lib.put(id,new Book(lang,name,price,date,author,publisher,category));
        DataControl.getINSTANCE().WriteFile(lib,false);
        return lib;
    }

    public void WriteFile(){
        DataControl.getINSTANCE().WriteFile(lib,false);
    }

    public void read(){
        lib=DataControl.getINSTANCE().loadList();
    }


    public BookList addBook(){
        return this.lib;
    }
    public BookList getLib() {
        return lib;
    }

    public void setLib(BookList lib) {
        this.lib = lib;
    }

    public DataControl getData() {
        return data;
    }

    public void setData(DataControl data) {
        this.data = data;
    }

    public void appendData(String csvFilePath){
        File csvFile=new File(csvFilePath);
        DataControl.getINSTANCE().AppendFile(csvFile,lib);
        read();
    }

}
