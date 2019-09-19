package src.api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {

	private static String url = null;

	public Api(String url) {
		Api.url = url;
	}

	public String getURL() {
		return url;
	}

	public String requestByPost(String json) {

		HttpURLConnection httpCon;
		String body = "";

		try {
			URL url = new URL(this.getURL());
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("POST");
			httpCon.setUseCaches(false);
			httpCon.setDoOutput(true);
			httpCon.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			OutputStreamWriter outStreamWriter = new OutputStreamWriter(new BufferedOutputStream(httpCon.getOutputStream()));
			outStreamWriter.write(json);
			outStreamWriter.close();

			BufferedReader bufReader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			String line = bufReader.readLine();
			while (line != null) {
				body = body + line;
				line = bufReader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return body;
	}

}
