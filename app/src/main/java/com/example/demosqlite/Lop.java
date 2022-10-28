package com.example.demosqlite;

public class Lop {
    String malop,tenlop;

    @Override
    public String toString() {
        return "Mã lớp: "+malop+ "| Tên lớp: "+tenlop;
    }

    public Lop(String malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }
}
