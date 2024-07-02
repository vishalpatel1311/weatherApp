package mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public Myservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String city = request.getParameter("City");
		String apiKey = " Add your open weather API Key";
		// Create the URL for the OpenWeatherMap API request
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
		// doGet(request, response);
		
		URL url = new URL(apiUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		// System.out.println(reader);

		Scanner scanner = new Scanner(reader);
		StringBuilder responseContent = new StringBuilder();

		while (scanner.hasNext()) {
			responseContent.append(scanner.nextLine());
		}

		// System.out.println(responseContent);
		scanner.close();

		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
		

		// Date & Time
		long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
		String date = new Date(dateTimestamp).toString();

		// Temperature
		double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
		int temperatureCelsius = (int) (temperatureKelvin - 273.15);

		// Humidity
		int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();

		// Wind Speed
		double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();

		// Weather Condition
		String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main")
				.getAsString();
		
		request.setAttribute("date",date);
		request.setAttribute("temperatureCelsius",temperatureCelsius);
		request.setAttribute("humidity",humidity);
		request.setAttribute("windSpeed",windSpeed);
		request.setAttribute("weatherCondition",weatherCondition);
		request.setAttribute("city",city);
		
		connection.disconnect();
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
