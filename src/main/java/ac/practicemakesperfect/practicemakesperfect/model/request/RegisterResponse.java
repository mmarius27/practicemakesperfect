package ac.practicemakesperfect.practicemakesperfect.model.request;

public class RegisterResponse {
    boolean registerSuccesful;
    String message;

    public RegisterResponse(boolean registerSuccesful, String message) {
        this.registerSuccesful = registerSuccesful;
        this.message = message;
    }

    public boolean isRegisterSuccesful() {
        return this.registerSuccesful;
    }

    public boolean getRegisterSuccesful() {
        return this.registerSuccesful;
    }

    public void setRegisterSuccesful(boolean registerSuccesful) {
        this.registerSuccesful = registerSuccesful;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
