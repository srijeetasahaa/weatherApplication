/*package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.json.simple.JSONObject;

import backend.weatherApp;

public class weatherGui extends JFrame {
    private JSONObject weatherData;

    public weatherGui() {
        // set the title of JFrame
        super("Weather app :)");

        // set the size of JFrame
        setSize(450, 700);

        // to open the JFrame in the center
        setLocationRelativeTo(null);

        // to close the JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // to stop resizing of JFrame
        setResizable(false);

        // to disable default layout
        setLayout(null);

        // add components to JFrame
        addComponents();
    }

    private void addComponents() {
        // weather image
        JLabel weatherImage=new JLabel(loadImage("src\\assets\\cloudy.png"));
        weatherImage.setBounds(75, 110, 300, 300);

        // temperature text
        JLabel tempText = new JLabel("10 C");
        tempText.setBounds(140, 360, 155, 70);
        tempText.setFont(new Font("Dialog", Font.BOLD, 45));
        tempText.setHorizontalAlignment(SwingConstants.CENTER);

        // temperature word
        JLabel tempWord = new JLabel("Cloudy");
        tempWord.setBounds(130, 390, 155, 70);
        tempWord.setFont(new Font("Dialog", Font.PLAIN, 20));
        tempWord.setHorizontalAlignment(SwingConstants.CENTER);

        // humidity image
        JLabel humidityImage = new JLabel(loadImage("src" + File.separator + "assets" + File.separator + "humidity1.png"));
        humidityImage.setBounds(20, 430, 50, 300);

        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 550, 70, 70);
        humidityText.setFont(new Font("Dialog", Font.BOLD, 15));

        JLabel windImage = new JLabel(loadImage("src" + File.separator + "assets" + File.separator + "windspeed.png"));
        windImage.setBounds(210, 430, 100, 300);

        // wind text
        JLabel windText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windText.setBounds(310, 550, 90, 70);
        windText.setFont(new Font("Dialog", Font.BOLD, 15));

        // search (text field)
        JTextField searchArea = new JTextField();
        searchArea.setBounds(13, 20, 350, 55);
        searchArea.setFont((new Font("Dialog", Font.PLAIN, 20)));

        // search icon button
        JButton searchButton = new JButton(loadImage("src" + File.separator + "assets" + File.separator + "search.png"));
        searchButton.setBounds(372, 20, 55, 55);
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get location from user
                String userInput = searchArea.getText();

                // validate input - remove white spaces
                if (userInput.replaceAll("\\s", " ").length() <= 0) {
                    return;
                }

                // retrieve weather data
                weatherData = weatherApp.getWeatherData(userInput);

                // -------------update-------------

                // update weather image
                if (weatherData != null) {
                    String weatherCondition = (String) weatherData.get("weather_condition");

                    // depending on the condition, we will update the weather image with the condition
                    switch (weatherCondition) {
                        case "Clear":
                            weatherImage.setIcon(loadImage("src" + File.separator + "assets" + File.separator + "clear.png"));
                            break;
                        case "Cloudy":
                            weatherImage.setIcon(loadImage("src" + File.separator + "assets" + File.separator + "cloudy.png"));
                            break;
                        case "Rain":
                            weatherImage.setIcon(loadImage("src" + File.separator + "assets" + File.separator + "rain.png"));
                            break;
                        case "Snow":
                            weatherImage.setIcon(loadImage("src" + File.separator + "assets" + File.separator + "snow.png"));
                            break;
                    }

                    // update temperature text
                    double temperature = (double) weatherData.get("temperature");
                    tempText.setText(temperature + " C");

                    // update weather condition text
                    tempWord.setText(weatherCondition);

                    // update humidity
                    long humidity = (long) weatherData.get("humidity");
                    humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

                    // update windspeed
                    long windspeed = (long) weatherData.get("windspeed");
                    windText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
                }
            }

        });

        // adding the components
        add(searchArea);
        add(searchButton);
        add(weatherImage);
        add(tempText);
        add(tempWord);
        add(humidityImage);
        add(humidityText);
        add(windImage);
        add(windText);
    }

    private ImageIcon loadImage(String resourcePath) {
        try {
            BufferedImage image = ImageIO.read(new File(resourcePath));

            // return the image icon so that component can render it
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new weatherGui().setVisible(true));
    }
}*/

package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.json.simple.JSONObject;

import backend.weatherApp;

public class weatherGui extends JFrame {
    private JSONObject weatherData;

    public weatherGui() {
        // set the title of JFrame
        super("Weather app :)");

        // set the size of JFrame
        setSize(450, 700);

        // to open the JFrame in the center
        setLocationRelativeTo(null);

        // to close the JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // to stop resizing of JFrame
        setResizable(false);

        // to disable default layout
        setLayout(null);

        // add components to JFrame
        addComponents();
    }

    private void addComponents() {
        // weather image
        JLabel weatherImage = new JLabel(loadImage("src" + File.separator + "assets" + File.separator + "cloudy.png"));
        weatherImage.setBounds(75, 110, 300, 300);

        // temperature text
        JLabel tempText = new JLabel("10 C");
        tempText.setBounds(140, 360, 155, 70);
        tempText.setFont(new Font("Dialog", Font.BOLD, 45));
        tempText.setHorizontalAlignment(SwingConstants.CENTER);

        // temperature word
        JLabel tempWord = new JLabel("Cloudy");
        tempWord.setBounds(130, 390, 155, 70);
        tempWord.setFont(new Font("Dialog", Font.PLAIN, 20));
        tempWord.setHorizontalAlignment(SwingConstants.CENTER);

        // humidity image
        JLabel humidityImage = new JLabel(
                loadImage("src" + File.separator + "assets" + File.separator + "humidity1.png"));
        humidityImage.setBounds(20, 430, 50, 300);

        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 550, 70, 70);
        humidityText.setFont(new Font("Dialog", Font.BOLD, 15));

        JLabel windImage = new JLabel(
                loadImage("src" + File.separator + "assets" + File.separator + "windspeed.png"));
        windImage.setBounds(210, 430, 100, 300);

        // wind text
        JLabel windText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windText.setBounds(310, 550, 90, 70);
        windText.setFont(new Font("Dialog", Font.BOLD, 15));

        // search (text field)
        JTextField searchArea = new JTextField();
        searchArea.setBounds(13, 20, 350, 55);
        searchArea.setFont((new Font("Dialog", Font.PLAIN, 20)));

        // search icon button
        JButton searchButton = new JButton(
                loadImage("src" + File.separator + "assets" + File.separator + "search.png"));
        searchButton.setBounds(372, 20, 55, 55);
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get location from user
                String userInput = searchArea.getText();

                // validate input - remove white spaces
                if (userInput.replaceAll("\\s", " ").length() <= 0) {
                    return;
                }

                // retrieve weather data
                weatherData = weatherApp.getWeatherData(userInput);

                // -------------update-------------

                // update weather image
                if (weatherData != null) {
                    String weatherCondition = (String) weatherData.get("weather_condition");

                    // depending on the condition, we will update the weather image with the condition
                    switch (weatherCondition) {
                        case "Clear":
                            weatherImage.setIcon(
                                    loadImage("src" + File.separator + "assets" + File.separator + "clear.png"));
                            break;
                        case "Cloudy":
                            weatherImage.setIcon(
                                    loadImage("src" + File.separator + "assets" + File.separator + "cloudy.png"));
                            break;
                        case "Rain":
                            weatherImage.setIcon(
                                    loadImage("src" + File.separator + "assets" + File.separator + "rain.png"));
                            break;
                        case "Snow":
                            weatherImage.setIcon(
                                    loadImage("src" + File.separator + "assets" + File.separator + "snow.png"));
                            break;
                    }

                    // update temperature text
                    double temperature = (double) weatherData.get("temperature");
                    tempText.setText(temperature + " C");

                    // update weather condition text
                    tempWord.setText(weatherCondition);

                    // update humidity
                    long humidity = (long) weatherData.get("humidity");
                    humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

                    // update windspeed
                    long windspeed = (long) weatherData.get("windspeed");
                    windText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
                }
            }

        });

        // adding the components
        add(searchArea);
        add(searchButton);
        add(weatherImage);
        add(tempText);
        add(tempWord);
        add(humidityImage);
        add(humidityText);
        add(windImage);
        add(windText);
    }

    private ImageIcon loadImage(String resourcePath) {
        try {
            BufferedImage image = ImageIO.read(new File(resourcePath));

            // return the image icon so that component can render it
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new weatherGui().setVisible(true));
    }
}

