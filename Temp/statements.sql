SELECT * FROM giang_vien 
INSERT INTO giang_vien(ma_gv, mat_khau, ho_ten, email, mobile) VALUES (?,?,?,?,?)
UPDATE giang_vien SET mat_khau=?,ho_ten=?,email=?,mobile=? WHERE ma_gv=?
DELETE FROM giang_vien WHERE ma_gv=?

SELECT * FROM hoc_ky
INSERT INTO hoc_ky(ma_hk, ten_hk, bat_dau, ket_thuc) VALUES (?,?,?,?)
UPDATE hoc_ky SET ten_hk=?,bat_dau=?,ket_thuc=? WHERE ma_hk=?
DELETE FROM hoc_ky WHERE ma_hk=?

SELECT * FROM hoc_vien
INSERT INTO hoc_vien(ma_hv, ma_sv, ma_lh, diem, nhan_xet) VALUES (?,?,?,?,?)
UPDATE hoc_vien SET ma_sv=?,ma_lh=?,diem=?,nhan_xet=? WHERE ma_hv=?
DELETE FROM hoc_vien WHERE ma_hv=?

SELECT * FROM lop_hoc
INSERT INTO lop_hoc(ma_lh, ma_mh, ma_gv, ma_hk) VALUES (?,?,?,?)
UPDATE lop_hoc SET ma_mh=?,ma_gv=?,ma_hk=? WHERE ma_lh=?
DELETE FROM lop_hoc WHERE ma_lh=?

SELECT * FROM mon_hoc
INSERT INTO mon_hoc(ma_mh, ten_mh, hinh, so_tc, mo_ta) VALUES (?,?,?,?,?)
UPDATE mon_hoc SET ten_mh=?,hinh=?,so_tc=?,mo_ta=? WHERE ma_mh=?
DELETE FROM mon_hoc WHERE ma_mh=?

SELECT * FROM nhan_vien
INSERT INTO nhan_vien(ma_nv, mat_khau, ho_ten) VALUES (?,?,?)
UPDATE nhan_vien SET mat_khau=?,ho_ten=? WHERE ma_nv=?
DELETE FROM nhan_vien WHERE ma_nv=?

SELECT * FROM sinh_vien
INSERT INTO sinh_vien(ma_sv, mat_khau, ho_ten, gioi_tinh, email, mobile) VALUES (?,?,?,?,?,?)
UPDATE sinh_vien SET mat_khau=?,ho_ten=?,gioi_tinh=?,email=?,mobile=? WHERE ma_sv=?
DELETE FROM sinh_vien WHERE ma_sv=?

