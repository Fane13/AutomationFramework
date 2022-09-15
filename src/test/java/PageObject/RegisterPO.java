package PageObject;

public class RegisterPO {
    private final String emailInput = "email";
    private final String firstNameInput = "firstName";
    private final String lastNameInput = "lastName";
    private final String passwordInput = "password";
    private final String confirmPasswordInput = "repeatPassword";
    private final String registerButton = "submit";

    private final String donorTypeRadio = "//*[@name=\"userType\"][2]/label/span";
    private final String codeOfConductCheck = "codeOfConduct";
    private final String termsAndPrivacyCheck = "termsAndPrivacy";

    public String getDonorTypeRadio() {
        return donorTypeRadio;
    }

    public String getCodeOfConductCheck() {
        return codeOfConductCheck;
    }

    public String getTermsAndPrivacyCheck() {
        return termsAndPrivacyCheck;
    }

    public String getModalCompleteRegistration() {
        return modalCompleteRegistration;
    }

    private String modalCompleteRegistration = "complete-registration";

    public String getEmailInput() {
        return emailInput;
    }

    public String getFirstNameInput() {
        return firstNameInput;
    }

    public String getLastNameInput() {
        return lastNameInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public String getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    public String getRegisterButton() {
        return registerButton;
    }
}
