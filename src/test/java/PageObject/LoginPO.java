package PageObject;

public class LoginPO {

    private String emailInput = "email";
    private String passwordInput = "password";
    private String submitButton = "submit";
    private String toaster = "toast-container";
    private String invalidMessage = "//form/div[1]/mat-error/app-validation-message/div";

    private String goToRegister = "goToRegister";

    public String getGoToRegister() {
        return goToRegister;
    }

    public String getEmailInput() {
        return emailInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public String getSubmitButton() {
        return submitButton;
    }

    public String getToaster() {
        return toaster;
    }

    public String getInvalidMessage() {
        return invalidMessage;
    }
}
