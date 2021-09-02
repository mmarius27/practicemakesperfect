package ac.practicemakesperfect.practicemakesperfect.model.request;

public class ApplyToPostRequest {
    String postId;

    public ApplyToPostRequest() {
    }
    
    public ApplyToPostRequest(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
