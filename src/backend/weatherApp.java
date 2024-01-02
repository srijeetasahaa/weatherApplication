/*package backend;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// retrieve weather data from API
public class weatherApp {
    // fetch weather data for a given location
    public static JSONObject getWeatherData(String locationName) {
        // get location coordinates using geolocation API
        JSONArray locationData = getLocationData(locationName);

        // to get weather forecast API we need to get the latitudes and longitudes of the location
        // which we get from the geological API
        if (locationData != null && locationData.size() > 0) {
            JSONObject location = (JSONObject) locationData.get(0);

            double latitude = (double) location.get("latitude");
            double longitude = (double) location.get("longitude");

            String urlString = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
                    + "&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m&timezone=Asia%2FTokyo";

            try {
                // call API and get response
                HttpURLConnection conn = fetchAPIresponse(urlString);

                // check the response status
                if (conn.getResponseCode() == 200) {
                    StringBuilder resultJson = new StringBuilder();
                    Scanner sc = new Scanner(conn.getInputStream());

                    while (sc.hasNext()) {
                        resultJson.append(sc.nextLine());
                    }

                    // close scanner
                    sc.close();

                    // close URL connection
                    conn.disconnect();

                    JSONParser parser = new JSONParser();
                    JSONObject resultJSONObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                    // retrieve hourly data
                    JSONObject hourly = (JSONObject) resultJSONObj.get("hourly");

                    // to get the current hour's data
                    // therefore, we need to get the index of the current hour
                    JSONArray time = (JSONArray) hourly.get("time");
                    int index = findIndexCurrentTime(time);

                    // get temperature
                    JSONArray temperatureData = (JSONArray) hourly.get("temperature_2m");
                    double temperature = (double) temperatureData.get(index);

                    // get weather code
                    // to find the weather description
                    JSONArray weatherCode = (JSONArray) hourly.get("weather_code");
                    String weatherCondition = convertWeatherCode((long) weatherCode.get(index));

                    // get humidity
                    JSONArray relativeHumidity = (JSONArray) hourly.get("relative_humidity_2m");
                    long humidity = (long) relativeHumidity.get(index);

                    // get wind speed
                    JSONArray windspeedData = (JSONArray) hourly.get("wind_speed_10m");
                    double windspeed = (double) windspeedData.get(index);

                    // build the weather json data object that we are going to access in our frontend
                    JSONObject weatherData = new JSONObject();
                    weatherData.put("temperature", temperature);
                    weatherData.put("weather_condition", weatherCondition);
                    weatherData.put("humidity", humidity);
                    weatherData.put("windspeed", windspeed);

                    return weatherData;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    // retrieves geographic coordinates for a given location name
    public static JSONArray getLocationData(String locationName) {
        // replace any white space in location name with + to add to API request format
        locationName = locationName.replaceAll(" ", "+");

        // build API URL with location as a parameter
        String urlName = "https://geocoding-api.open-meteo.com/v1/search?name=" + locationName
                + "&count=10&language=en&format=json";

        try {
            // call the API and get response
            // to make an HTTP request like our API call, we need an HTTP client like HttpURLConnection class

            HttpURLConnection conn = fetchAPIresponse(urlName); // separate method is created to instantiate it because we
                                                                 // will be doing it multiple times

            // check response status
            // 200 means successful connection
            if (conn.getResponseCode() == 200) {
                // store the response of API results
                StringBuilder resultJson = new StringBuilder();

                // we will use a scanner to read the data returned from our API call
                // this is done by using a while loop and hasNext()
                Scanner sc = new Scanner(conn.getInputStream());

                // read and store the resulting JSON data in the string builder
                // if there is JSON data to be read, then we store it in resultJson
                while (sc.hasNext()) {
                    resultJson.append(sc.nextLine());
                }

                // close scanner
                sc.close();

                // close URL connection
                conn.disconnect();

                // parse the json string into a json object
                // reason for parsing is so that we can access the data more properly
                JSONParser parser = new JSONParser();
                JSONObject resultJSONObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                // get the list of location data the API generated from the location name
                // when we are trying to get the "result" it will return us [data]
                // which is why we store it in a JSONArray

                JSONArray locationData = (JSONArray) resultJSONObj.get("results");
                return locationData;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // if location could not be found
        return null;
    }

    public static HttpURLConnection fetchAPIresponse(String urlName) {

        try {
            // attempt to create a connection
            URL url = new URL(urlName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set request method to get the response
            conn.setRequestMethod("GET");

            // connect to our API
            conn.connect();

            return conn;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int findIndexCurrentTime(JSONArray timeList) {
        String currentTime = getCurrentTime();

        // iterate through the time list and check which one matches the current time
        for (int i = 0; i < timeList.size(); i++) {
            String time = (String) timeList.get(i);
            if (time.equalsIgnoreCase(currentTime)) {
                return i;
            }
        }

        return 0;
    }

    public static String getCurrentTime() {
        // get current date and time
        LocalDateTime curDateTime = LocalDateTime.now();

        // format date to be 2023-12-19T00:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");

        String formateDateTime = curDateTime.format(formatter);

        return formateDateTime;
    }

    public static String convertWeatherCode(long weatherCode) {
        String weatherCondition = " ";
        if (weatherCode == 0L) {
            // clear
            weatherCondition = "Clear";
        } else if (weatherCode > 0L && weatherCode <= 3L) {
            // cloudy
            weatherCondition = "Cloudy";
        } else if ((weatherCode >= 51L && weatherCode <= 67L) || (weatherCode >= 80L && weatherCode <= 99L)) {
            // rain
            weatherCondition = "Rain";
        } else if (weatherCode >= 71L && weatherCode <= 77L) {
            // snow
            weatherCondition = "Snow";
        }

        return weatherCondition;
    }

}*/

package backend;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// retrieve weather data from API
public class weatherApp {
    // fetch weather data for a given location
    public static JSONObject getWeatherData(String locationName) {
        // get location coordinates using geolocation API
        JSONArray locationData = getLocationData(locationName);

        // print location data for troubleshooting
        System.out.println("Location Data: " + locationData);

        // to get weather forecast API we need to get the latitudes and longitudes of the location
        // which we get from the geological API
        if (locationData != null && locationData.size() > 0) {
            JSONObject location = (JSONObject) locationData.get(0);

            double latitude = (double) location.get("latitude");
            double longitude = (double) location.get("longitude");

            // print latitude and longitude for troubleshooting
            System.out.println("Latitude: " + latitude + ", Longitude: " + longitude);

            String urlString = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
                    + "&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m&timezone=Asia%2FTokyo";

            // print API URL for troubleshooting
            System.out.println("API URL: " + urlString);

            try {
                // call API and get response
                HttpURLConnection conn = fetchAPIresponse(urlString);

                // check the response status
                if (conn.getResponseCode() == 200) {
                    StringBuilder resultJson = new StringBuilder();
                    Scanner sc = new Scanner(conn.getInputStream());

                    while (sc.hasNext()) {
                        resultJson.append(sc.nextLine());
                    }

                    // close scanner
                    sc.close();

                    // close URL connection
                    conn.disconnect();

                    JSONParser parser = new JSONParser();
                    JSONObject resultJSONObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                    // retrieve hourly data
                    JSONObject hourly = (JSONObject) resultJSONObj.get("hourly");

                    // to get the current hour's data
                    // therefore, we need to get the index of the current hour
                    JSONArray time = (JSONArray) hourly.get("time");
                    int index = findIndexCurrentTime(time);

                    // get temperature
                    JSONArray temperatureData = (JSONArray) hourly.get("temperature_2m");
                    double temperature = (double) temperatureData.get(index);

                    // get weather code
                    // to find the weather description
                    JSONArray weatherCode = (JSONArray) hourly.get("weather_code");
                    String weatherCondition = convertWeatherCode((long) weatherCode.get(index));

                    // get humidity
                    JSONArray relativeHumidity = (JSONArray) hourly.get("relative_humidity_2m");
                    long humidity = (long) relativeHumidity.get(index);

                    // get wind speed
                    JSONArray windspeedData = (JSONArray) hourly.get("wind_speed_10m");
                    double windspeed = (double) windspeedData.get(index);

                    // build the weather json data object that we are going to access in our frontend
                    JSONObject weatherData = new JSONObject();
                    weatherData.put("temperature", temperature);
                    weatherData.put("weather_condition", weatherCondition);
                    weatherData.put("humidity", humidity);
                    weatherData.put("windspeed", windspeed);

                    return weatherData;
                } else {
                    // print API response code and message for troubleshooting
                    System.out.println("API Response Code: " + conn.getResponseCode());
                    System.out.println("API Response Message: " + conn.getResponseMessage());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    // retrieves geographic coordinates for a given location name
    public static JSONArray getLocationData(String locationName) {
        // replace any white space in location name with + to add to API request format
        locationName = locationName.replaceAll(" ", "+");

        // build API URL with location as a parameter
        String urlName = "https://geocoding-api.open-meteo.com/v1/search?name=" + locationName
                + "&count=10&language=en&format=json";

        try {
            // call the API and get response
            // to make an HTTP request like our API call, we need an HTTP client like HttpURLConnection class

            HttpURLConnection conn = fetchAPIresponse(urlName); // separate method is created to instantiate it because we
                                                                 // will be doing it multiple times

            // check response status
            // 200 means successful connection
            if (conn.getResponseCode() == 200) {
                // store the response of API results
                StringBuilder resultJson = new StringBuilder();

                // we will use a scanner to read the data returned from our API call
                // this is done by using a while loop and hasNext()
                Scanner sc = new Scanner(conn.getInputStream());

                // read and store the resulting JSON data in the string builder
                // if there is JSON data to be read, then we store it in resultJson
                while (sc.hasNext()) {
                    resultJson.append(sc.nextLine());
                }

                // close scanner
                sc.close();

                // close URL connection
                conn.disconnect();

                // parse the json string into a json object
                // reason for parsing is so that we can access the data more properly
                JSONParser parser = new JSONParser();
                JSONObject resultJSONObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                // get the list of location data the API generated from the location name
                // when we are trying to get the "result" it will return us [data]
                // which is why we store it in a JSONArray

                JSONArray locationData = (JSONArray) resultJSONObj.get("results");
                return locationData;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // if location could not be found
        return null;
    }

    public static HttpURLConnection fetchAPIresponse(String urlName) {

        try {
            // attempt to create a connection
            URL url = new URL(urlName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set request method to get the response
            conn.setRequestMethod("GET");

            // connect to our API
            conn.connect();

            return conn;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int findIndexCurrentTime(JSONArray timeList) {
        String currentTime = getCurrentTime();

        // iterate through the time list and check which one matches the current time
        for (int i = 0; i < timeList.size(); i++) {
            String time = (String) timeList.get(i);
            if (time.equalsIgnoreCase(currentTime)) {
                return i;
            }
        }

        return 0;
    }

    public static String getCurrentTime() {
        // get current date and time
        LocalDateTime curDateTime = LocalDateTime.now();

        // format date to be 2023-12-19T00:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");

        String formateDateTime = curDateTime.format(formatter);

        return formateDateTime;
    }

    public static String convertWeatherCode(long weatherCode) {
        String weatherCondition = " ";
        if (weatherCode == 0L) {
            // clear
            weatherCondition = "Clear";
        } else if (weatherCode > 0L && weatherCode <= 3L) {
            // cloudy
            weatherCondition = "Cloudy";
        } else if ((weatherCode >= 51L && weatherCode <= 67L) || (weatherCode >= 80L && weatherCode <= 99L)) {
            // rain
            weatherCondition = "Rain";
        } else if (weatherCode >= 71L && weatherCode <= 77L) {
            // snow
            weatherCondition = "Snow";
        }

        return weatherCondition;
    }

}

