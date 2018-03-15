import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("organization.json"));


            JSONObject jsonObject = (JSONObject) obj;


            JSONArray emp = (JSONArray) jsonObject.get("Employees");
            for (Object projectObj : emp.toArray()) {
                JSONObject project = (JSONObject) projectObj;

                String empid = (String) project.get("id");
                System.out.println(empid);

                String ename = (String) project.get("name");
                System.out.println(ename);

                String  age = (String) project.get("age");
                System.out.println(age);

                String salary = (String) project.get("salary");
                System.out.println(salary);

                String emailId = (String) project.get("email");
                System.out.println(emailId);


                JSONObject empAddress=(JSONObject) project.get("address");

                System.out.println("City-> "+empAddress.get("city"));
                System.out.println("State-> "+empAddress.get("state"));

                System.out.println("------------------------------");

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
