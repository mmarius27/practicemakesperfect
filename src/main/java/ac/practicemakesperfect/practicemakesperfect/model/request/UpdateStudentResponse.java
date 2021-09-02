package ac.practicemakesperfect.practicemakesperfect.model.request;

public class UpdateStudentResponse {
    boolean studentUpdateSuccesful;
    String message;

    public UpdateStudentResponse() {
    }

    public UpdateStudentResponse(boolean studentUpdateSuccesful, String message) {
        this.studentUpdateSuccesful = studentUpdateSuccesful;
        this.message = message;
    }

    public boolean isStudentUpdateSuccesful() {
        return this.studentUpdateSuccesful;
    }

    public boolean getStudentUpdateSuccesful() {
        return this.studentUpdateSuccesful;
    }

    public void setStudentUpdateSuccesful(boolean studentUpdateSuccesful) {
        this.studentUpdateSuccesful = studentUpdateSuccesful;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
