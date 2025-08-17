import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class WeatherAppCLI {
    private static final String API_KEY = "4727411a9b2ff8c052258497abb96301"; // OpenWeatherMap API key

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        scanner.close();

        try {
            // API URL
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + API_KEY + "&units=metric";

            // Use URI.create().toURL() (no deprecation warning)
            URL url = URI.create(urlString).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON
            JSONObject json = new JSONObject(response.toString());
            JSONObject main = json.getJSONObject("main");
            JSONObject weather = json.getJSONArray("weather").getJSONObject(0);
            JSONObject wind = json.getJSONObject("wind");
            JSONObject sys = json.getJSONObject("sys");
            JSONObject coord = json.getJSONObject("coord");

            double temp = main.getDouble("temp");
            double feelsLike = main.getDouble("feels_like");
            int humidity = main.getInt("humidity");
            int pressure = main.getInt("pressure");
            String description = weather.getString("description");
            double windSpeed = wind.getDouble("speed");
            String country = sys.getString("country");
            double lon = coord.getDouble("lon");
            double lat = coord.getDouble("lat");

            // Display result
            System.out.println("\n=== Weather Report ===");
            System.out.println("City: " + city);
            System.out.println("Country: " + country);
            System.out.println("Coordinates: " + lat + ", " + lon);
            System.out.println("Temperature: " + temp + " °C");
            System.out.println("Feels Like: " + feelsLike + " °C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Pressure: " + pressure + " hPa");
            System.out.println("Wind Speed: " + windSpeed + " m/s");
            System.out.println("Condition: " + description);

        } catch (Exception e) {
            System.out.println("Error: Could not retrieve weather data.");
            e.printStackTrace();
        }
    }
}
