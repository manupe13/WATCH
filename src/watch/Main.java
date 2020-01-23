package watch;

import javax.swing.JFrame;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        init();
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay();
        WatchPresenter watchPresenter = new WatchPresenter(watch, watchDisplay);
        add(watchDisplay);          
    }
    
    

    private void execute() {
        setVisible(true);
    }

    private void init() {
        setTitle("Watch");
        setSize(477,477);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
