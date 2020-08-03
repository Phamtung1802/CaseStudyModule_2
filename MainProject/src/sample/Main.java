package sample;

import BookPackage.Book;
import BookPackage.BookList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        BookList list=new BookList();
        list.add(new Book("Cuon Sach 1",1000, "01/06/2007","Tac Gia 1","NXB Kim Dong","Giao Duc","001"));
        System.out.println(list.get(0));
    }
}
