package utils;

import org.testng.annotations.DataProvider;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.io.File;

public class LoginDataUtil {

    public static Object[][] getDataFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(filePath));
        Iterator<JsonNode> elements = root.elements();

        //Count the number of elements
        int size = 0;
        while (elements.hasNext()) {
            size++;
            elements.next();
        }

        Object[][] loginData = new Object[size][2];
        elements = root.elements();
        int i = 0;
        while (elements.hasNext()) {
            JsonNode node = elements.next();
            loginData[i][0] = node.get("username").asText();
            loginData[i][1] = node.get("password").asText();
            i++;
        }

        return loginData;
    }

    @DataProvider(name = "validLoginData")
    public static Object[][] getValidLoginData() throws IOException {
        return getDataFromJson("src/test/resources/test_data/validLoginCredentials.json");
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] getInvalidLoginData() throws IOException {
        return getDataFromJson("src/test/resources/test_data/invalidLoginCredentials.json");
    }
}
