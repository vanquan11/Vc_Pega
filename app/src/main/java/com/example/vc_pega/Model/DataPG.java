package com.example.vc_pega.Model;

public class DataPG {
    public DomainPG domain;
    public String image;
    public int publishdate;
    public String sapo;
    public String title;
    public String url;
    public String toppicname;

    public DataPG(DomainPG domain, String image, int publishdate, String sapo, String title, String url, String toppicname) {
        this.domain = domain;
        this.image = image;
        this.publishdate = publishdate;
        this.sapo = sapo;
        this.title = title;
        this.url = url;
        this.toppicname = toppicname;
    }

    public DomainPG getDomain() {
        return domain;
    }

    public void setDomain(DomainPG domain) {
        this.domain = domain;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(int publishdate) {
        this.publishdate = publishdate;
    }

    public String getSapo() {
        return sapo;
    }

    public void setSapo(String sapo) {
        this.sapo = sapo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToppicname() {
        return toppicname;
    }

    public void setToppicname(String toppicname) {
        this.toppicname = toppicname;
    }
}
