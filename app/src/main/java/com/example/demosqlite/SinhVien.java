package com.example.demosqlite;

public class SinhVien {
    String masv,tensv,malop;

    public SinhVien(String masv, String tensv, String malop) {
        this.masv = masv;
        this.tensv = tensv;
        this.malop = malop;
    }

    @Override
    public String toString() {
        return "Mã sinh viên: "+masv+"\nTên: "+tensv+"\nLớp: "+malop;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }
}
