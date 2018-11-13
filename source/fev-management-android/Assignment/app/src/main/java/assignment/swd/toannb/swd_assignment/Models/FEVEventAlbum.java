package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;

public class FEVEventAlbum implements Serializable {
    private int id;
    private String img;
    private FEVEvent fevEvent;

    public FEVEventAlbum() {
    }

    public FEVEventAlbum(int id, String img, FEVEvent fevEvent) {
        this.id = id;
        this.img = img;
        this.fevEvent = fevEvent;
    }
    public FEVEventAlbum(int id, String img) {
        this.id = id;
        this.img = img;
    }

    public FEVEventAlbum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public FEVEvent getFevEvent() {
        return fevEvent;
    }

    public void setFevEvent(FEVEvent fevEvent) {
        this.fevEvent = fevEvent;
    }

    @Override
    public String toString() {
        return "FEVEventAlbum{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", fevEvent=" + fevEvent +
                '}';
    }
}
