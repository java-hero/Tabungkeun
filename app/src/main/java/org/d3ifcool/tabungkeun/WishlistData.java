package org.d3ifcool.tabungkeun;

public class WishlistData {
    private String namaBarang;
    private String hargaBarang;
    private String jumlahNabung;
    private String desc;
    private String gambar;
    private String key;

    public WishlistData() {
    }

    public WishlistData(String namaBarang, String hargaBarang, String jumlahNabung, String desc) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahNabung = jumlahNabung;
        this.desc = desc;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getJumlahNabung() {
        return jumlahNabung;
    }

    public void setJumlahNabung(String jumlahNabung) {
        this.jumlahNabung = jumlahNabung;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
