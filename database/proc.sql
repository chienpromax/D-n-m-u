create proc sp_BangDiem(@MaKH int)
as begin
	select
		nh.MaNH,
		nh.HoTen,
		hv.Diem
	from HocVien hv
		join NguoiHoc nh on nh.MaNH=hv.MaNH
		where hv.MaKH = @MaKH
		order by hv.Diem desc
end

go
create proc sp_DiemChuyenDe
as begin
	select
		TenCD ChuyenDe,
		Count(MaHV) SoHV,
		min(diem) ThapNhat,
		max(diem) CaoNhat,
		avg(diem) TrungBinh
	from KhoaHoc kh
		join HocVien hv on kh.MaKH=hv.MaKH
		join ChuyenDe cd on cd.MaCD=kh.MaCD
	group by TenCD
end

go
create proc sp_DoanhThu(@year int)
as begin
	select
		TenCD ChuyenDe,
		Count(Distinct kh.MaKH) SoHK,
		count(hv.MaKH) SoHV,
		sum(kh.HocPhi) DoanhThu,
		min(kh.HocPhi) ThapNhat,
		max(kh.HocPhi) CaoNhat,
		avg(kh.HocPhi) TrungBinh
	from KhoaHoc kh
		join HocVien hv on kh.MaKH=hv.MaKH
		join ChuyenDe cd on cd.MaCD=kh.MaCD
		where year(NgayKG) = @year
	group by TenCD
end

go
create proc sp_LuongNguoiHoc
as begin
	select
		YEAR(NgayDK) Nam,
		count(*) SoLuong,
		min(NgayDK) DauTien,
		max(NgayDK) CuoiCung
	from NguoiHoc
	group by year(NgayDK)
end
drop proc sp_LuongNguoiHoc