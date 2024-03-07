/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EduSys.Dao;

import com.EduSys.Entity.HocVien;
import com.EduSys.Utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author balis
 */
public class HocVienDAO extends EduSysDAO<HocVien, Integer> {

    String INSERT_SQL = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
    String UPDATE_SQL = "UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MaHV=?";

    @Override
    public void insert(HocVien entity) {
        XJdbc.executeUpdate(INSERT_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem(),
                entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public HocVien selectById(Integer id) {
        List<HocVien> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<HocVien> selectBySQL(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("MaHV"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNH(rs.getString("MaNH"));
                entity.setDiem(rs.getDouble("Diem"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HocVien> selectByKhoaHoc(int makh) {
        String SQL = "SELECT * FROM HocVien WHERE MaKH = ?";
        return this.selectBySQL(SQL, makh);
    }

}
