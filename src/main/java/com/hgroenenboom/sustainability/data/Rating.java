package com.hgroenenboom.sustainability.data;

public class Rating {
    private String ipAdress;

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public Rating(String ipAdress) {
        this.ipAdress = ipAdress;
    }
}
