package spandroid.dev.dto;

/**
 * Created by sibaprasad on 10/08/16.
 */
public class ImageModel {
    String id;
    String url;

    public ImageModel(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
