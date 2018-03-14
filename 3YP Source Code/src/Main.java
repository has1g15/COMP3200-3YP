import Model.DataHandler;
import View.MainFrame;

public class Main {

    public static void main(String[] args)
    {
        DataHandler.dataHandler.init();
        //load app data in order to populate menu progress bars
        MainFrame.mainFrame.start();
    }
}
