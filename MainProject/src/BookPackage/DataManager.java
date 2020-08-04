package BookPackage;

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
        return lib;
    }

    public void WriteFile(){
        DataControl.getINSTANCE().WriteFile(lib);
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

}
