package amcode.consolui.view.data;

import java.util.Scanner;

public abstract class DataView<T> {
    private Scanner scanner = new Scanner(System.in);
    private T t;

    public DataView(T t) {
        this.t = t;
    }

    protected abstract void returnToMainMenu();
}
