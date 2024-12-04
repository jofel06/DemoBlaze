package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.io.File;

public class loginDataReader {
    //Method to read the login data from the JSON file
    public List<LoginData> readLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //this will read the JSON file and convert it to a List of LoginData objects
        List<LoginData> loginDataList = objectMapper.readValue(new File("src/test/resources/login_data.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, LoginData.class));
        return loginDataList;
    }
}
