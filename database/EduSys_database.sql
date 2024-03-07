create database EduSys

create table NhanVien(
	MaNV nvarchar(20) primary key NOT NULL,
	MatKhau nvarchar(50) not null,
	HoTen nvarchar(50) not null,
	VaiTro bit default 0
)
select * from NhanVien
create table NguoiHoc(
	MaNH nvarchar(7) primary key NOT NULL,
	HoTen nvarchar(50) not null,
	GioiTinh bit default 1,
	NgaySinh date not null,
	DienThoai nvarchar(24) not null,
	Email nvarchar(50) not null,
	GhiChu nvarchar(250) not null,
	MaNV nvarchar(20) not null,
	NgayDK date default getdate(),
	foreign key(MaNV) references NhanVien(MaNV) on update cascade
)
create table ChuyenDe(
	MaCD nchar(5) primary key NOT NULL,
	TenCD nvarchar(50) not null,
	HocPhi float not null,
	ThoiLuong int not null,
	Hinh nvarchar(50) not null,
	MoTa nvarchar(250) null,
	check (HocPhi>0 and ThoiLuong >0)
)

create table KhoaHoc(
	MaKH int primary key identity(1,1) NOT NULL,
	MaCD nchar(5) not null,
	HocPhi float not null,
	ThoiLuong int not null,
	NgayKG date not null,
	GhiChu nvarchar(250) not null,
	MaNV nvarchar(20) not null,
	NgayTao date default getdate(),
	check (HocPhi>0 and ThoiLuong >0),
	foreign key(MaCD) references ChuyenDe(MaCD) on update cascade,
	foreign key(MaNV) references NhanVien(MaNV) on update cascade,
)
create table HocVien(
	MaHV int primary key identity(1,1) NOT NULL,
	MaKH int not null,
	MaNH nvarchar(7) not null,
	Diem float default -1,
	check (Diem <10 and Diem >= -1),
	foreign key(MaNH) references NguoiHoc(MaNH),
	foreign key(MaKH) references KhoaHoc(MaKH)
)
GO
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'JAV01', N'Lập trình Java cơ bản', 300, 90, N'GAME.png', N'JAV01 - Lập trình Java cơ bản')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'JAV02', N'Lập trình Java nâng cao', 300, 90, N'HTCS.jpg', N'JAV02 - Lập trình Java nâng cao')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'JAV03', N'Lập trình mạng với Java', 200, 70, N'INMA.jpg', N'JAV03 - Lập trình mạng với Java')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'JAV04', N'Lập trình desktop với Swing', 200, 70, N'LAYO.jpg', N'JAV04 - Lập trình desktop với Swing')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'PRO01', N'Dự án với công nghệ MS.NET MVC', 300, 90, N'MOWE.png', N'PRO01 - Dự án với công nghệ MS.NET MVC')

SET IDENTITY_INSERT [dbo].[HocVien] ON 

INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (1, 2, N'PS01638', -1)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (2, 2, N'PS02037', -1)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (3, 2, N'PS02771', -1)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (5, 2, N'PS02930', -1)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Diem]) VALUES (7, 2, N'PS02979', -1)


SET IDENTITY_INSERT [dbo].[HocVien] OFF
SET IDENTITY_INSERT [dbo].[KhoaHoc] ON 

INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (1, N'PRO01', 300, 90, CAST(0xBF3D0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (2, N'PRO01', 300, 90, CAST(0xBF3D0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (3, N'JAV01', 100, 50, CAST(0xBF3D0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (4, N'JAV03', 250, 80, CAST(0xBF3D0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
SET IDENTITY_INSERT [dbo].[KhoaHoc] OFF
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS01638', N'LỮ HUY CƯỜNG', CAST(0xAF170B00 AS Date), 1, N'0928768265', N'PS01638@fpt.edu.vn', N'0928768265 - LỮ HUY CƯỜNG', N'PheoNC', CAST(0xAF170B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02037', N'ĐỖ VĂN MINH', CAST(0xC6190B00 AS Date), 1, N'0968095685', N'PS02037@fpt.edu.vn', N'0968095685 - ĐỖ VĂN MINH', N'PheoNC', CAST(0xC6190B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02771', N'NGUYỄN TẤN HIẾU', CAST(0x2E220B00 AS Date), 1, N'0927594734', N'PS02771@fpt.edu.vn', N'0927594734 - NGUYỄN TẤN HIẾU', N'PheoNC', CAST(0x2E220B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02867', N'NGUYỄN HỮU TRÍ', CAST(0xEB200B00 AS Date), 1, N'0946984711', N'PS02867@fpt.edu.vn', N'0946984711 - NGUYỄN HỮU TRÍ', N'TeoNV', CAST(0xEB200B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02930', N'TRẦN VĂN NAM', CAST(0xA1240B00 AS Date), 1, N'0924774498', N'PS02930@fpt.edu.vn', N'0924774498 - TRẦN VĂN NAM', N'TeoNV', CAST(0xA1240B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02979', N'ĐOÀN TRẦN NHẬT VŨ', CAST(0x671C0B00 AS Date), 1, N'0912374818', N'PS02979@fpt.edu.vn', N'0912374818 - ĐOÀN TRẦN NHẬT VŨ', N'TeoNV', CAST(0x671C0B00 AS Date))

INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro]) VALUES (N'NoPT', N'123456', N'Phạm Thị Nở', 0)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro]) VALUES (N'PheoNC', N'123456', N'Nguyễn Chí Phèo', 0)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro]) VALUES (N'TeoNV', N'123456', N'Nguyễn Văn Tèo', 1)
SET ANSI_PADDING ON
