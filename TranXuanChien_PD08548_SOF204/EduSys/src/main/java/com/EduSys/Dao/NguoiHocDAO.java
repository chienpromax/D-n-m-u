/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EduSys.Dao;

import com.EduSys.Entity.NguoiHoc;
import com.EduSys.Utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author balis
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String> {

    String INSERT_SQL = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?,MaNV=? WHERE MaNH=?";
    String DELETE_SQL = "DELETE FROM NguoiHoc WHERE MaNH=?";
    String SELECT_ALL_SQL = "SELECT * FROM NguoiHoc";
    String SELECT_BY_ID_SQL = "SELECT * FROM NguoiHoc WHERE MaNH=?";
    

    @Override
    public void insert(NguoiHoc entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getMaNH(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.isGioiTinh(),
                entity.getDienThoai(),
                entity.getEmail(),
                entity.getGhiChu(),
                entity.getMaNV());
    }

    @Override
    public void update(NguoiHoc entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.isGioiTinh(),
                entity.getDienThoai(),
                entity.getEmail(),
                entity.getGhiChu(),
                entity.getMaNV(),
                entity.getMaNH());
    }

    @Override
    public void delete(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public NguoiHoc selectById(String id) {
        List<NguoiHoc> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }
    
   

    @Override
    protected List<NguoiHoc> selectBySQL(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("MaNH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setEmail(rs.getString("Email"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NguoiHoc> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
        return this.selectBySQL(SQL, "%" + keyword + "%");
    }

    public List<NguoiHoc> selectNotInCourse(int makh, String keyword) {
        String SQL = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ? AND "
                + "MaNH NOT IN(SELECT MaNH FROM HocVien WHERE MaKH = ?)";
        return this.selectBySQL(SQL, "%" + keyword + "%", makh);
    }
    public List<Object[]> getNguoiHoc(int maKH) {
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols = {"MaHV", "MaNH", "HoTen", "Diem"};
        return this.getListOfArray(sql, cols, maKH);
    }
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
