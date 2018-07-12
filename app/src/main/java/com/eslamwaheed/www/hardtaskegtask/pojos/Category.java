package com.eslamwaheed.www.hardtaskegtask.pojos;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Serializable
{

    @SerializedName("Id")
    @Expose
    private long id;
    @SerializedName("TitleEN")
    @Expose
    private String titleEN;
    @SerializedName("TitleAR")
    @Expose
    private String titleAR;
    @SerializedName("Photo")
    @Expose
    private String photo;
    @SerializedName("ProductCount")
    @Expose
    private String productCount;
    @SerializedName("HaveModel")
    @Expose
    private String haveModel;
    @SerializedName("SubCategories")
    @Expose
    private List<SubCategory> subCategories = null;
    private final static long serialVersionUID = 84093387295828375L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Category() {
    }

    /**
     *
     * @param id
     * @param productCount
     * @param subCategories
     * @param titleAR
     * @param haveModel
     * @param titleEN
     * @param photo
     */
    public Category(long id, String titleEN, String titleAR, String photo, String productCount, String haveModel, List<SubCategory> subCategories) {
        super();
        this.id = id;
        this.titleEN = titleEN;
        this.titleAR = titleAR;
        this.photo = photo;
        this.productCount = productCount;
        this.haveModel = haveModel;
        this.subCategories = subCategories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitleEN() {
        return titleEN;
    }

    public void setTitleEN(String titleEN) {
        this.titleEN = titleEN;
    }

    public String getTitleAR() {
        return titleAR;
    }

    public void setTitleAR(String titleAR) {
        this.titleAR = titleAR;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getHaveModel() {
        return haveModel;
    }

    public void setHaveModel(String haveModel) {
        this.haveModel = haveModel;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

}