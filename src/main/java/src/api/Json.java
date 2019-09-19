package src.api;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

	private ObjectMapper mapper;

	public Json() {
		this.mapper = new ObjectMapper();
	}

	public String pojoToJson(Object object) {

		String json = null;
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return json;

	}

	public Object jsonToPojo(String json) {

		Object object = null;

		try {
			object = mapper.readValue(json, ApiResponse.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
}
