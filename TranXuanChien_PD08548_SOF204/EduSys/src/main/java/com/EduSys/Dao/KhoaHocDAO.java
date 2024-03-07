/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EduSys.Dao;

import com.EduSys.Entity.KhoaHoc;
import com.EduSys.Utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author balis
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer> {

    String INSERT_SQL = "INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=? WHERE MaKH=?";
    String DELETE_SQL = "DELETE FROM KhoaHoc WHERE MaKH=?";
    String SELECT_ALL_SQL = "SELECT * FROM KhoaHoc";
    String SELECT_BY_ID_SQL = "SELECT * FROM KhoaHoc WHERE MaKH=?";

    @Override
    public void insert(KhoaHoc entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getMaCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getNgayKG(),
                entity.getGhiChu(),
                entity.getMaNV());
    }

    @Override
    public void update(KhoaHoc entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getMaCD(),
                entity.getHocPhi(),
                entity.getThoiLuong(),
                entity.getNgayKG(),
                entity.getGhiChu(),
                entity.getMaNV(),
                entity.getMaKH());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public KhoaHoc selectById(Integer id) {
        List<KhoaHoc> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhoaHoc> selectBySQL(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                KhoaHoc entity = new KhoaHoc();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaCD(rs.getString("MaCD"));
                entity.setHocPhi(rs.getDouble("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setNgayKG(rs.getDate("NgayKG"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhoaHoc> selectByChuyenDe(String macd) {
        String SQL = "SELECT * FROM KhoaHoc WHERE MaCD = ?";
        return this.selectBySQL(SQL, macd);
    }

    public List<Integer> selectYears() {
        String SQL = "SELECT DISTINCT year(NgayKG) Year FROM KhoaHoc ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(SQL);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
