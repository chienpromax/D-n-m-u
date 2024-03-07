/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EduSys.Entity;

/**
 *
 * @author xuanc
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private String matKhau;
    private boolean vaiTro;
    
    
    public NhanVien(String maNV, String hoTen, String matKhau, boolean vaiTro) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    

    @Override
    public String toString() {
        return this.hoTen;
    }
    
}
