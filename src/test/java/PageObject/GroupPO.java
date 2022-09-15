package PageObject;

public class GroupPO {
    private final String createGroupButton = "CREATE_GROUP";
    private final String groupName = "groupName";
    private final String groupDescription = "groupDescription";
    private final String groupMediaVideoUpload = "groupMediaVideoUpload";
    private final String uploadImageButton = "uploadImageButton";
    private final String submit = "submit";
    private final String submitEntity = "submitEntity";

    public final String approveGroup = "approveGroup";


    public String getCreateGroupButton() {
        return createGroupButton;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public String getGroupMediaVideoUpload() {
        return groupMediaVideoUpload;
    }

    public String getUploadImageButton() {
        return uploadImageButton;
    }

    public String getSubmit() {
        return submit;
    }

    public String getSubmitEntity() {
        return submitEntity;
    }

    public String getApproveGroup() {
        return approveGroup;
    }
}
