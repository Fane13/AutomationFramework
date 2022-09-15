package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Configuration {
    private final String username;
    private final String password;
    private final String url;
    private final String url2;
    private final String url3;

    private final String profilePicture;

    private final String organizationLogo;
    private final String organizationImage;
    private final String organizationLeaderImage;
    private final String groupImage;

    public Configuration() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(
                new FileReader("C:\\Users\\stefa\\Desktop\\GivingSpace2\\src\\test\\resources\\data.JSON"));
        username = (String) data.get("username");
        password = (String) data.get("password");
        url = (String) data.get("url");
        url2 = (String) data.get("url2");
        url3 = (String) data.get("url3");
        profilePicture = (String) data.get("profile-picture");
        organizationLogo = (String) data.get("organization-logo");
        organizationImage = (String) data.get("organization-image");
        organizationLeaderImage = (String) data.get("organization-leader-image");
        groupImage = (String) data.get("group-image");

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getUrl2() {
        return url2;
    }

    public String getUrl3() {
        return url3;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getOrganizationLogo() {
        return organizationLogo;
    }

    public String getOrganizationImage() {
        return organizationImage;
    }

    public String getOrganizationLeaderImage() {
        return organizationLeaderImage;
    }

    public String getGroupImage() {
        return groupImage;
    }
}
