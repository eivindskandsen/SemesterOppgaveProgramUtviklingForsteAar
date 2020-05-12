package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class ThreadLoad extends Task<ObservableList<Pc>>{
    private final ObservableList<Pc> inn;

    public ThreadLoad(ObservableList<Pc> inn) {this.inn = inn;}

    protected ObservableList<Pc> call(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        return inn;
    }
}
