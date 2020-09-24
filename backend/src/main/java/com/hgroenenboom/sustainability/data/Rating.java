package com.hgroenenboom.sustainability.data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Rating {
    private String ipAdress;
    // TODO - all parameters that make a rating traceable to a REAL HUMAN! to remove rating forgery

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public Rating(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    protected Rating(){}
}
