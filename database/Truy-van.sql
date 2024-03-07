insert into NhanVien (MaNV,HoTen,MatKhau,VaiTro) values('NV01','Trần Xuân Chiến','123','true')
update NhanVien set HoTen ='qưe',MatKhau ='xxx',VaiTro ='false'  where MaNV = 'NV01'
delete from NhanVien where MaNV = 'NV01'
select * from NhanVien
select * from NhanVien where MaNV = 'NV01'

insert into ChuyenDe (MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) values('CD02','Trần Xuân Chiến',123,123,'xxx','ggg')
update ChuyenDe set TenCD ='qưe',HocPhi =1232, ThoiLuong =23, Hinh='qưeq', MoTa='án' where MaCD = 'CD01'
delete from ChuyenDe where MaCD = 'CD01'
select * from ChuyenDe
select * from ChuyenDe where MaCD = 'CD01'

insert into NguoiHoc (MaNH,HoTen,GioiTinh,NgaySinh,DienThoai,Email,GhiChu,MaNV,NgayDK) 
values('NH01','trần xuân chiến',1,'2004-02-20','123456789','chien@gmail.com','haha','NV01','2019-12-12')
update NguoiHoc set HoTen ='chiến', GioiTinh= 0, NgaySinh ='2004-02-20', DienThoai='4576435', Email='chien@gmail.com', GhiChu='sdf',MaNV='NV01', NgayDK='2019-12-16' where MaNH = 'NH01'
delete from NguoiHoc where MaNH = 'NH01'
select * from NguoiHoc
select * from NguoiHoc where MaNH = 'NH01'

insert into KhoaHoc (MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) 
values('CD01',1123,24,'2004-02-20','haha','NV01','2019-12-12')
update KhoaHoc set MaCD ='CD01', HocPhi= 1110, ThoiLuong = 20, NgayKG='2004-02-20', GhiChu='hahi', MaNV='NV02', NgayTao='2019-12-16' where MaKH = '1'
delete from KhoaHoc where MaKH = '1'
select * from KhoaHoc
select * from KhoaHoc where MaKH = '1'

insert into HocVien(MaKH,MaNH,Diem) 
values('1','NH01',4)
update HocVien set MaKH ='2', MaNH='NH01', Diem=1 where MaHV = '2'
delete from HocVien where MaHV = 'HV01'
select * from HocVien
select * from HocVien where MaHV = 'HV01'