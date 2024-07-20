package bg.soft_uni.mobileleoffers.models.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class AddOfferDto {
    private String modelName;
    @Column
    @NotNull
    private long user;
    @Column
    @NotNull
    private long model;
    @Min(100)
    private int price;
    @NotNull
    private String engine;
    @NotNull
    @NotEmpty
    private String transmission;
    @Min(1900)
    private int year;
    @PositiveOrZero @NotNull
    private int mileage;
    @NotBlank
    private String description;
    @NotBlank
    private String url;

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getModel() {
        return model;
    }

    public void setModel(long model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
