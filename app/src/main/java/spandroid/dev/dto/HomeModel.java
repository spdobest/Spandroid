package spandroid.dev.dto;

import java.util.List;

/**
 * Created by sibaprasad on 10/08/16.
 */
public class HomeModel {
    String id;
    String title;
    int bannerType;
    String productType;
    List<ImageModel> listImages;

    private String imageString;

    public HomeModel() {

    }


    public HomeModel(String id, String title, int bannerType, String productType, String images) {
        this.id = id;
        this.title = title;
        this.bannerType = bannerType;
        this.productType = productType;
        this.imageString = images;
    }

    public HomeModel(String id, String title, int bannerType, String productType, List<ImageModel> images) {
        this.id = id;
        this.title = title;
        this.bannerType = bannerType;
        this.productType = productType;
        this.listImages = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ImageModel> getListImages() {
        return listImages;
    }

    public void setListImages(List<ImageModel> listImages) {
        this.listImages = listImages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBannerType() {
        return bannerType;
    }

    public void setBannerType(int bannerType) {
        this.bannerType = bannerType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
