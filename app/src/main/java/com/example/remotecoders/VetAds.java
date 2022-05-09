package com.example.remotecoders;

public class VetAds extends Advertisements{
    private String bio;
    private String office;


    public VetAds() {
        super();
        this.bio = "";
        this.office = "";
    }

    public String getBio() { return bio; }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
