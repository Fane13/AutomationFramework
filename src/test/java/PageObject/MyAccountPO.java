package PageObject;

public class MyAccountPO {
    private final String cropModal = "openCropModal";
    private final String browseFile = "browseFiles";
    private final String uploadImageButton = "uploadImageButton";
    private final String adressInput = "addressInput";
    private final String jobTitleInput = "jobTitle";
    private final String bioInput = "bio";
    private final String saveProfileButton = "save-profile-changes";
    private final String completedProfileVisible = "completedProfileUninvitedUser";
    private final String completedProfileBanner = "completedProfileUser";

    public String getCropModal() {
        return cropModal;
    }

    public String getBrowseFile() {
        return browseFile;
    }

    public String getUploadImageButton() {
        return uploadImageButton;
    }

    public String getAdressInput() {
        return adressInput;
    }

    public String getJobTitleInput() {
        return jobTitleInput;
    }

    public String getBioInput() {
        return bioInput;
    }

    public String getSaveProfileButton() {
        return saveProfileButton;
    }

    public String getCompletedProfileVisible() {
        return completedProfileVisible;
    }

    public String getCompletedProfileBanner() {
        return completedProfileBanner;
    }
}
