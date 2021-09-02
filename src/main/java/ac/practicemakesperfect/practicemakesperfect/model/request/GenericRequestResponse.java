package ac.practicemakesperfect.practicemakesperfect.model.request;

public class GenericRequestResponse {
    boolean requestSuccesful;
    String message;


    public GenericRequestResponse() {
    }

    public GenericRequestResponse(boolean requestSuccesful, String message) {
        this.requestSuccesful = requestSuccesful;
        this.message = message;
    }

    public boolean isRequestSuccesful() {
        return this.requestSuccesful;
    }

    public boolean getRequestSuccesful() {
        return this.requestSuccesful;
    }

    public void setRequestSuccesful(boolean requestSuccesful) {
        this.requestSuccesful = requestSuccesful;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
