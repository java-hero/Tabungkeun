package org.d3ifcool.tabungkeun;

public class PemasukanData {
    private long id;
    private String Nama;
    private int Saldo;
    private String Tanggal;

    public PemasukanData() {
    }

    public PemasukanData(String nama, int saldo, String tanggal) {
        Nama = nama;
        Saldo = saldo;
        Tanggal = tanggal;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }
}
