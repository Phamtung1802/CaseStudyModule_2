package sample;

import BookPackage.Book;
import BookPackage.BookList;
import BookPackage.DataControl;
import BookPackage.DataManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        launch(args);
//        list.put("1",new Book("Cuon Sach 1",1000, "01/06/2007","Tac Gia 1","NXB Kim Dong","Giao Duc","001"));

//        System.out.println(DataManager.getINSTANCE().addBook("001","English","Cuon Sach 1",1000, "01/06/2007","Tac Gia 1","NXB Kim Dong","Giao Duc"));
//        System.out.println(DataManager.getINSTANCE().addBook("002","English","Cuon Sach 2",1000, "01/06/2007","Tac Gia 1","NXB Kim Dong","Giao Duc"));
        DataManager.getINSTANCE().read();
        System.out.println(DataManager.getINSTANCE().getLib().get("001"));
    }
}
