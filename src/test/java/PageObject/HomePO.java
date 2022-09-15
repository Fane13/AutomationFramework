package PageObject;

public class HomePO {
    private final String adminButton = "admin";
    private final String groupsButton = "groupsMyGroupsOwnedGroups";
    private String signInButton = "signIn";

    public String getSignInButton() {
        return signInButton;
    }

    public String getAdminButton() {
        return adminButton;
    }

    public String getGroupsButton() {
        return groupsButton;
    }
}
