package spandroid.dev.network.retrofit.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sibaprasad on 25/02/18.
 */

public class User {
    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
