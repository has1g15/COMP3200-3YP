import Model.DataHandler;
import Model.Progress;
import View.MainFrame;

public class Main {

    public static void main(String[] args)
    {
        DataHandler.dataHandler.init();
        MainFrame.mainFrame.start();
    }
}
