import javax.swing.SwingUtilities;

import gui.weatherGui;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable (){
            public void run (){
                new weatherGui ().setVisible (true);

                // testing: location geographical data from API
                //System.out.println(weatherApp.getLocationData("Tokyo"));
                //System.out.println(weatherApp.getCurrentTime ());
            }
        });
    }
}