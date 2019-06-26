use fptueventclub;
-- Insert Account Role
INSERT INTO `fptueventclub`.`fev_account_role` (`role`) VALUES ('Admin');
INSERT INTO `fptueventclub`.`fev_account_role` (`role`) VALUES ('User');

-- Insert Account
INSERT INTO `fptueventclub`.`fev_account` (`username`, `password`, `role`) VALUES ('sa', '123', '1');
INSERT INTO `fptueventclub`.`fev_account` (`username`, `password`, `role`) VALUES ('hoaiem', '123', '2');
INSERT INTO `fptueventclub`.`fev_account` (`username`, `password`, `role`) VALUES ('bachtoan', '123', '2');

-- Insert Member Position
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Collaborator');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Member');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Vice Chief');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Chief');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Human Resource');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Finacial Management');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Adviser');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Vice President');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('President');

-- Insert Member Status
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('Working');
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('Reserving');
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('Other');

-- Insert Member Group
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Planning');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Implement');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Media');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Executive');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Director');

-- Insert Member
use fptueventclub;
INSERT INTO fptueventclub.fev_member VALUES
    (1,'Hồ Đắc Trung Kiên','GC60251','1993-07-29 00:00:00','K07','kienhdt297@gmail.com',NULL,'Male',NULL,'976535125',1,1,1,1,NULL),
    (2,'Hoàng Nhất Duy Tài','SB60751','1994-07-26 00:00:00','K07','taih9388@gmail.com',NULL,'Male',NULL,'933634722',1,1,1,1,NULL),
    (3,'Vũ Nhật Minh','SE61390','1993-06-01 00:00:00','K08','minhvnse61390@gmail.com',NULL,'Male',NULL,'1692571346',1,1,1,1,NULL),
    (4,'Nguyễn Võ Đoan Trang','SB60700','1994-04-20 00:00:00','K08','d.trang0494@gmail.com',NULL,'Female',NULL,'902527224',1,1,1,1,NULL),
    (5,'Hoàng Trọng Thanh Tùng','SE61694','1995-01-24 00:00:00','K08','hoangtung240195@gmail.com',NULL,'Male',NULL,'905250314',1,1,1,1,NULL),
    (6,'Trần Nho Hiếu','SE61591','1995-02-21 00:00:00','K09','hieutn212@gmail.com',NULL,'Male',NULL,'975135995',1,1,1,1,NULL),
    (7,'Trần Anh Kiệt','SE61469','1995-03-13 00:00:00','K09','kiettase61469@fpt.edu.vn',NULL,'Male',NULL,'1234585756',1,1,1,1,NULL),
    (8,'Tôn Thất Minh Nhật','SE61685','1994-02-11 00:00:00','K09','ttminhnhat94@gmail.com',NULL,'Male',NULL,'1206149867',1,1,1,1,NULL),
    (9,'Lý Phước Sang','SE61461','1995-09-12 00:00:00','K09','sanglp95@gmail.com',NULL,'Male',NULL,'961564256',1,1,1,1,NULL),
    (10,'Thuyen To','SE61437','1995-11-12 00:00:00','K09','thuyenttse61437@fpt.edu.vn',NULL,'Male',NULL,'1683524714',1,1,1,1,NULL),
    (11,'Nguyễn Khai Trí','SE61538','1995-02-27 00:00:00','K09','khaitri15@gmail.com',NULL,'Male',NULL,'1667676119',1,1,1,1,NULL),
    (12,'Lê Huỳnh Duy Anh','SE62084','1996-11-10 00:00:00','K10','anhlhd10@gmail.com',NULL,'Male',NULL,'917933937',1,1,1,1,NULL),
    (13,'Nguyễn Dương Yến Nhi','SB60959','1996-09-19 00:00:00','K10','anhanhi.hyenie@gmail.com',NULL,'Female',NULL,'967924567',1,1,1,1,NULL),
    (14,'Diệp Phương Thanh','SB60999','1996-01-01 00:00:00','K10','thanhdpsb60999@fpt.edu.vn',NULL,'Female',NULL,'903821941',1,1,1,1,NULL),
    (15,'Lê Phúc Thịnh','SE61759','1996-08-20 00:00:00','K10','thinhlp208@gmail.com',NULL,'Male',NULL,'961173093',1,1,1,1,NULL),
    (16,'Nguyễn Hồng Anh','SE62597','1997-03-11 00:00:00','K11','anhnhse62597@fpt.edu.vn',NULL,'Male',NULL,'981874764',1,1,1,1,NULL),
    (17,'Bull','SB61159','1997-04-30 00:00:00','K11','vealmam@gmail.com',NULL,'Female',NULL,'981874676',1,1,1,1,NULL),
    (18,'Nguyễn Huỳnh Chiêu','SE62604','1997-11-09 00:00:00','K11','chieunhsb61529@fpt.edu.vn',NULL,'Other',NULL,'95053649',1,1,1,1,NULL),
    (19,'Võ Hoài Em','SE62399','1997-12-22 00:00:00','K11','hoaiem.heli22@gmail.com',NULL,'Male',NULL,'374676683',1,1,1,1,NULL),
    (20,'Nguyễn Ân Thiện Hải','SE62324','1997-03-04 00:00:00','K11','hai7f2009@gmail.com',NULL,'Male',NULL,'1682523475',1,1,1,1,NULL),
    (21,'Lưu Thị Thúy Hằng','SB61153','1997-09-30 00:00:00','K11','hangluu3009@gmail.com',NULL,'Female',NULL,'905069504',1,1,1,1,NULL),
    (22,'Phạm Hoàng Hiệp','SE62601','1997-05-06 00:00:00','K11','phamhiep6597@gmail.com',NULL,'Male',NULL,'906734342',1,1,1,1,NULL),
    (23,'Nguyễn Huy Hoàng','SE62442','1997-03-11 00:00:00','K11','nhheminem@gmail.com',NULL,'Male',NULL,'976433009',1,1,1,1,NULL),
    (24,'Bùi Đặng Thạnh Hưng','SE62454','1997-11-25 00:00:00','K11','bdth2511hcm@gmail.com',NULL,'Male',NULL,'935803488',1,1,1,1,NULL),
    (25,'Phương Gia Khải','SE62465','1997-04-02 00:00:00','K11','pphuonggiakhai@gmail.com',NULL,'Male',NULL,'1208487536',1,1,1,1,NULL),
    (26,'Đào Quốc Khang','SE62188','1997-07-11 00:00:00','K11','khangdqse62188@fpt.edu.vn',NULL,'Male',NULL,'981874737',1,1,1,1,NULL),
    (27,'Phạm Thành Khang','SB61134','1996-02-26 00:00:00','K11','khangptsb61134@fpt.edu.vn',NULL,'Male',NULL,'1649110715',1,1,1,1,NULL),
    (28,'Lý Kiều Linh','SB61147','1997-10-24 00:00:00','K11','linhlksb61147@fpt.edu.vn',NULL,'Female',NULL,'948600847',1,1,1,1,NULL),
    (29,'Nguyễn Minh Luận','SE62431','1997-09-21 00:00:00','K11','vnproben@gmail.com',NULL,'Male',NULL,'1636808288',1,1,1,1,NULL),
    (30,'Trần Cao Minh','SE62417','1997-01-01 00:00:00','K11','t.trancaominh95@gmail.com',NULL,'Khác',NULL,'1204548815',1,1,1,1,NULL),
    (31,'Hoàng Thị Thanh Nhi','SB61106','1996-07-11 00:00:00','K11','hoangnhistar@gmail.com',NULL,'Female',NULL,'1202054711',1,1,1,1,NULL),
    (32,'Lê Thịnh Phát','SB61096','1997-05-24 00:00:00','K11','phatltsb61096@fpt.edu.vn',NULL,'Male',NULL,'914961235',1,1,1,1,NULL),
    (33,'Nguyễn Thành Phát','SB61037','1997-05-11 00:00:00','K11','phatntsb61037@gmail.com',NULL,'Male',NULL,'989401725',1,1,1,1,NULL),
    (34,'Dương Vũ Anh Phúc','SB61099','1997-08-17 00:00:00','K11','outsoulz@gmail.com',NULL,'Male',NULL,'909951969',1,1,1,1,NULL),
    (35,'Nguyễn Danh Đắc Sang','SE62608','1997-10-26 00:00:00','K11','sangnddse62608@fpt.edu.vn',NULL,'Male',NULL,'1293248526',1,1,1,1,NULL),
    (36,'Trần Công Sinh','SE62637','1997-05-16 00:00:00','K11','sinhtcse62637@fpt.edu.vn',NULL,'Male',NULL,'938186097',1,1,1,1,NULL),
    (37,'Cao Hoàng Thái','SE62651','1995-10-09 00:00:00','K11','jacks109cao@gmail.com',NULL,'Male',NULL,'981874746',1,1,1,1,NULL),
    (38,'Nguyễn Hữu Thuận','SE62363','1997-05-05 00:00:00','K11','thuanhuu064@gmail.com',NULL,'Male',NULL,'2649799908',1,1,1,1,NULL),
    (39,'Nguyễn Mai Phương Trâm','SE62537','1997-11-21 00:00:00','K11','nguyenmaiphuongtram@gmail.com',NULL,'Male',NULL,'1657947347',1,1,1,1,NULL),
    (40,'Phạm Thị Tường Vi','SE62436','1997-04-12 00:00:00','K11','phamthituongvi0511@gmail.com',NULL,'Female',NULL,'901125212',1,1,1,1,NULL),
    (41,'Trần Nguyễn Khánh Vy','SE62670','1997-11-07 00:00:00','K11','vivavivutt@gmail.com',NULL,'Female',NULL,'937314588',1,1,1,1,NULL),
    (42,'Vũ Ngọc An','SE63231','1997-12-14 00:00:00','K12','mapan113@gmail.com',NULL,'Male',NULL,'981331289',1,1,1,1,NULL),
    (43,'Văn Đức Quốc Anh','SE62841','1998-05-05 00:00:00','K12','daszelos008@gmail.com',NULL,'Male',NULL,'1687304646',1,1,1,1,NULL),
    (44,'Nguyễn Văn Chiến','SE63206','1996-12-06 00:00:00','K12','chien061296@gmail.com',NULL,'Male',NULL,'989549168',1,1,1,1,NULL),
    (45,'Huỳnh Đạt','SE63263','1998-03-02 00:00:00','K12','dathatse63263@fpt.edu.vn',NULL,'Male',NULL,'1627883456',1,1,1,1,NULL),
    (46,'Trần Huỳnh Đức','SB61474','1998-01-01 00:00:00','K12','boss.eleven.98@gmail.com',NULL,'Male',NULL,'1656695500',1,1,1,1,NULL),
    (47,'Dương Trùng Dương','SB61226','1998-11-28 00:00:00','K12','duongdtsb61226@fpt.edu.vn',NULL,'Male',NULL,'1636561470',1,1,1,1,NULL),
    (48,'Cao Trọng Duy','SE63385','1998-10-17 00:00:00','K12','duyctse63385@fpt.edu.vn',NULL,'Male',NULL,'933729786',1,1,1,1,NULL),
    (49,'Nguyễn Đức Duy','SB61414','1998-10-31 00:00:00','K12','ducduynguyen3110@gmail.com',NULL,'Khác',NULL,'902352184',1,1,1,1,NULL),
    (50,'Cao Thanh Mỹ Duyên','SB61270','1996-09-03 00:00:00','K12','duyenctmsb61270@fpt.edu.vn',NULL,'Female',NULL,'944772498',1,1,1,1,NULL),
    (51,'Nguyễn Hương Giang','SB61269','1998-10-06 00:00:00','K12','hươnggiang061098@gmail.com',NULL,'Female',NULL,'938152948',1,1,1,1,NULL),
    (52,'Nguyễn Thị Thu Hà','SB61407','1998-09-23 00:00:00','K12','hanttsb61407@fpt.edu.vn',NULL,'Female',NULL,'1644004379',1,1,1,1,NULL),
    (53,'Trương Thị Mỹ Hiếu','SB61462','1998-06-30 00:00:00','K12','hieuttmsb61462@fpt.edu.vn',NULL,'Female',NULL,'974258183',1,1,1,1,NULL),
    (54,'Đoàn Thanh Kim Hoàng','SE62982','1998-04-17 00:00:00','K12','hoangdtkse62982@fpt.edu.vn',NULL,'Female',NULL,'981804584',1,1,1,1,NULL),
    (55,'Võ Tiến Hưng','SE63354','1998-12-05 00:00:00','K12','hungvtse63354@gmail.com',NULL,'Male',NULL,'1663654509',1,1,1,1,NULL),
    (56,'Lê Thị Thu Hường','SB61465','1996-05-22 00:00:00','K12','lethuhuongstudent@gmail.com ',NULL,'Female',NULL,'1693396262',1,1,1,1,NULL),
    (57,'Đỗ Ngọc Huy','SE62833','1998-04-27 00:00:00','K12','huydnse62833@fpt.edu.vn',NULL,'Male',NULL,'967406340',1,1,1,1,NULL),
    (58,'Đậu Thuý My','SB61397','1998-09-22 00:00:00','K12','mydtsb61397@fpt.edu.vn',NULL,'Female',NULL,'1666809549',1,1,1,1,NULL),
    (59,'Nguyễn Thị Kim Bích Ngân','SE63240','1998-10-01 00:00:00','K12','ginnygreen110@gmail.com',NULL,'Female',NULL,'(+1)7147240866',1,1,1,1,NULL),
    (60,'Hồ Thanh Nhàn','SB61251','1998-06-30 00:00:00','K12','hothanhnhan306@gmail.com',NULL,'Female',NULL,'985695700',1,1,1,1,NULL),
    (61,'Hồ Nguyễn Yến Nhi','SB61440','1998-10-13 00:00:00','K12','nhihnysb61440@fpt.edu.vn',NULL,'Female',NULL,'969538500',1,1,1,1,NULL),
    (62,'Nguyễn Hồng Thu Phương','SE63330','1998-05-16 00:00:00','K12','phuongnhtse63330@fpt.edu.vn',NULL,'Female',NULL,'1689216507',1,1,1,1,NULL),
    (63,'Phạm Lê Uyên Phương','SB61260','1998-04-25 00:00:00','K12','phamleuyenphuong8155@gmail.com',NULL,'Female',NULL,'1204438155',1,1,1,1,NULL),
    (64,'Lê Trọng Quảng','SE62994','1998-07-27 00:00:00','K12','quanghs33@gmail.com',NULL,'Male',NULL,'971371587',1,1,1,1,NULL),
    (65,'Trần Thiên Quý','SE63199','1998-11-08 00:00:00','K12','tranthienquy98@gmail.com',NULL,'Male',NULL,'335657532',1,1,1,1,NULL),
    (66,'Bùi Thị Xuân Quỳnh','SB61460','1997-12-20 00:00:00','K12','utxuanquynh2012@gmail.com',NULL,'Female',NULL,'1672231423',1,1,1,1,NULL),
    (67,'Phan Minh Sung','SE63244','1998-06-02 00:00:00','K12','sungpmse63244@fpt.edu.vn',NULL,'Male',NULL,'1689786763',1,1,1,1,NULL),
    (68,'Nguyễn Thanh Tân','SE63184','1998-05-29 00:00:00','K12','tanntse63184@fpt.edu.vn',NULL,'Male',NULL,'937881834',1,1,1,1,NULL),
    (69,'Phan Thị Diễm Thắm','SB61466','1998-02-25 00:00:00','K12','thamptdsb61466@fpt.edu.vn',NULL,'Female',NULL,'907114433',1,1,1,1,NULL),
    (70,'Trần Văn Toàn','SE05696','1996-05-15 00:00:00','K12','toantvse05696@fpt.edu.vn',NULL,'Male',NULL,'962717348',1,1,1,1,NULL),
    (71,'Lê Thị Thu Trang','SB61497','1998-05-12 00:00:00','K12','tranglttsb614@gmail.com',NULL,'Female',NULL,'1634020868',1,1,1,1,NULL),
    (72,'Nguyễn Hồng Anh Tuấn','SE62901','1998-02-12 00:00:00','K12','tuannhase62901@fpt.edu.vn',NULL,'Male',NULL,'932703410',1,1,1,1,NULL),
    (73,'Nguyễn Cảnh Xuân','SE63368','1998-10-21 00:00:00','K12','nguyencanhxuan2110@gmail.com',NULL,'Male',NULL,'1688593636',1,1,1,1,NULL),
    (74,'Nguyễn Thị Thảo An','SA130259','1999-06-23 00:00:00','K13','thaoan230699@gmail.com',NULL,'Female',NULL,'917859666',1,1,1,1,NULL),
    (75,'Bùi Vũ Quỳnh Anh','SA130039','1999-08-04 00:00:00','K13','quyliem2014@gmail.com',NULL,'Female',NULL,'868456284',1,1,1,1,NULL),
    (76,'Trương Quốc Bảo','SA130055','1999-09-23 00:00:00','K13','baobao23091999@gmail.com',NULL,'Male',NULL,'1224929919',1,1,1,1,NULL),
    (77,'Nguyễn Minh Châu','SE130650','1999-04-28 00:00:00','K13','chauabc99@gmail.com',NULL,'Male',NULL,'1687885160',1,1,1,1,NULL),
    (78,'Nguyễn Hoàng Phương Dung','SA130281','1999-11-05 00:00:00','K13','phuongdungnguyen12315@gmail.com',NULL,'Female',NULL,'975362230',1,1,1,1,NULL),
    (79,'Nguyễn Đức Bảo Duy','SE130490','1999-07-29 00:00:00','K13','nguyenducbaoduy@gmail.com',NULL,'Khác',NULL,'1678104700',1,1,1,1,NULL),
    (80,'Phạm Thị Mỹ Hảo','SE130700','1999-11-12 00:00:00','K13','haoptmse130700@fpt.edu.vn',NULL,'Female',NULL,'1257642661',1,1,1,1,NULL),
    (81,'Phùng Đò Hạo','SS130101','2018-05-22 00:00:00','K13','aratakagumi@gmail.com',NULL,'Male',NULL,'983139618',1,1,1,1,NULL),
    (82,'Lê Hoàng Hiệp','SE130384','1999-06-30 00:00:00','K13','lehiep99992@gmail.com',NULL,'Male',NULL,'948778578',1,1,1,1,NULL),
    (83,'Thái Doãn Huy Hoàng','SE130554','1999-11-23 00:00:00','K13','yohsamabaobinh@gmail.com',NULL,'Male',NULL,'1632442041',1,1,1,1,NULL),
    (84,'Phạm Việt Hoàng','SE130667','1999-04-03 00:00:00','K13','phoang341999@gmail.com',NULL,'Male',NULL,'1667704428',1,1,1,1,NULL),
    (85,'Phạm Thị Hồng Huê','SS130190','1999-11-10 00:00:00','K13','huepthss130190@fpt.edu. vn',NULL,'Female',NULL,'1664105766',1,1,1,1,NULL),
    (86,'Nguyễn Công Khánh','SE130527','1999-06-28 00:00:00','K13','congkhanhnguyen1999@gmail.com',NULL,'Male',NULL,'1648322114',1,1,1,1,NULL),
    (87,'Nguyễn Văn Lợi','SE130734','1999-04-25 00:00:00','K13','loinguyen.hg.n@gmail.com',NULL,'Male',NULL,'868608230',1,1,1,1,NULL),
    (88,'Trần Hồ Thảo My','SA130249','1999-04-06 00:00:00','K13','thaomy060499@gmail.com',NULL,'Female',NULL,'1886533780',1,1,1,1,NULL),
    (89,'Phạm Văn Mỹ','SS130163','1999-04-27 00:00:00','K13','phamvanmy274@gmail.com',NULL,'Male',NULL,'1234485696',1,1,1,1,NULL),
    (90,'Phan Trường Phước','SE130324','1999-10-30 00:00:00','K13','dragon120_58@yahoo.com',NULL,'Male',NULL,'1268689909',1,1,1,1,NULL),
    (91,'Nguyễn Anh Quân','SE130105','1999-12-25 00:00:00','K13','quannase130105@fpt.edu.vn',NULL,'Male',NULL,'1687824877',1,1,1,1,NULL),
    (92,'Nguyễn Hoàng Linh Thi','SA130245','2018-11-02 00:00:00','K13','linhthinguyen211@gmail.com',NULL,'Female',NULL,'947156979',1,1,1,1,NULL),
    (93,'Phạm Lê Tấn Thịnh','SE130687','1999-05-01 00:00:00','K13','phamletanthinh999@gmail.com',NULL,'Male',NULL,'1639244255',1,1,1,1,NULL),
    (94,'Nguyễn Thị Thanh Thuý','SE130310','1999-04-17 00:00:00','K13','thanhthuy1765@gmail.com',NULL,'Female',NULL,'1636188917',1,1,1,1,NULL),
    (95,'Nguyễn Trường Phúc Toàn','SE130023','2018-07-12 00:00:00','K13','ng.tptoan@gmail.com',NULL,'Male',NULL,'1632603636',1,1,1,1,NULL),
    (96,'Phạm Ngọc Bảo Trâm','SA130207','1999-08-26 00:00:00','K13','karenpham12@gmail.com',NULL,'Female',NULL,'933513197',1,1,1,1,NULL),
    (97,'Nguyễn Thị Diễm Trinh','SA130083','1999-06-01 00:00:00','K13','ntrinh387@gmail.com',NULL,'Female',NULL,'1656268136',1,1,1,1,NULL),
    (98,'Lương Nhật Tuấn','SS130135','1999-08-18 00:00:00','K13','tuannth2014@gmail.com',NULL,'Male',NULL,'984014267',1,1,1,1,NULL),
    (99,'Trần Thanh Tùng','SA130176','1999-11-05 00:00:00','K13','trantung051199@gmail.com',NULL,'Male',NULL,'906332791',1,1,1,1,NULL),
    (100,'Vương Hoàng Nữ Uyên','SS130213','1999-10-01 00:00:00','K13','vuonghoangnuuyen99@gmail.com',NULL,'Female',NULL,'1655326556',1,1,1,1,NULL),
    (101,'Nguyễn Thị Cẩm Yến','SA130021','1999-01-27 00:00:00','K13','yenntcsa130021@fpt.edu.vn',NULL,'Female',NULL,'933278102',1,1,1,1,NULL),
    (102,'Từ Mỹ Ân','SS140214','2000-04-23 00:00:00','K14','myan00423@gmail.com',NULL,'Female',NULL,'902567802',1,1,1,1,NULL),
    (103,'Nguyễn Xuân Anh','SS140226','2000-07-02 00:00:00','K14','wedu2373@gmail.com',NULL,'Male',NULL,'336115029',1,1,1,1,NULL),
    (104,'Trần Duy Đan','SE141055','2000-06-27 00:00:00','K14','duydan272000@gmail.com',NULL,'Male',NULL,'374650379',1,1,1,1,NULL),
    (105,'Đỗ Dương Tâm Đăng','SE140993','2000-07-15 00:00:00','K14','jacob15072000@gmail.com',NULL,'Male',NULL,'768812692',1,1,1,1,NULL),
    (106,'Đặng Hoàng Duy','SA140363','2000-10-18 00:00:00','K14','danghoangduy92@gmail.com',NULL,'Male',NULL,'905707380',1,1,1,1,NULL),
    (107,'Nguyễn Nữ Kỳ Duyên','SA1403533','1999-01-10 00:00:00','K14','cassaoi0110@gmail.com',NULL,'Female',NULL,'95229125',1,1,1,1,NULL),
    (108,'Nguyễn Lê Hoài Hảo','SE140285','2000-12-20 00:00:00','K14','hoaihaopro@gmail.com',NULL,'Male',NULL,'977014975',1,1,1,1,NULL),
    (109,'Bùi Trần Minh Hoàng','SE141126','2000-02-13 00:00:00','K14','buiminhhoang1302@gmail.com',NULL,'Male',NULL,'945120067',1,1,1,1,NULL),
    (110,'Đinh Lê Minh Hoàng','SS140329','2000-01-30 00:00:00','K14','minhhoang072000@gmail.com',NULL,'Male',NULL,'949938527',1,1,1,1,NULL),
    (111,'Nguyễn Huy Hoàng','SE140230','1998-09-04 00:00:00','K14','nguyenhuyhoanghoang01@gmail.com',NULL,'Male',NULL,'822432776',1,1,1,1,NULL),
    (112,'Lê Như Thiên Hương','SS140053','2000-09-22 00:00:00','K14','thienhuonglti@gmail.com',NULL,'Female',NULL,'933590473',1,1,1,1,NULL),
    (113,'Hoàng Thiên Kim','SS140023','2000-04-19 00:00:00','K14','hoangthienkim1904@gmail.com',NULL,'Female',NULL,'938385172',1,1,1,1,NULL),
    (114,'Nguyễn Khánh Linh','SS140238','2000-06-06 00:00:00','K14','ngkhanhlinh66@gmail.com',NULL,'Other',NULL,'379263953',1,1,1,1,NULL),
    (115,'Nguyễn Ngọc Phương Linh','SA140165','2000-09-27 00:00:00','K14','linh279279@gmail.com',NULL,'Female',NULL,'906568035',1,1,1,1,NULL),
    (116,'Vũ Phi Long','SS140438','2000-12-24 00:00:00','K14','vuphilong0410@gmail.com',NULL,'Male',NULL,'981241220',1,1,1,1,NULL),
    (117,'Nguyễn Trần Kiều Mỹ','SS140357','2000-05-12 00:00:00','K14','kieumy808@gmail.com',NULL,'Female',NULL,'855506490',1,1,1,1,NULL),
    (118,'Lê Thanh Ngân','SA140232','2000-08-08 00:00:00','K14','nganthanhle333@gmail.com',NULL,'Female',NULL,'868341256',1,1,1,1,NULL),
    (119,'Phạm Hữu Nghĩa','SE140472','2000-04-27 00:00:00','K14','nghiapham2704@gmail.com',NULL,'Male',NULL,'387778910',1,1,1,1,NULL),
    (120,'Nguyễn Khánh Ngọc','SA140139','2000-02-06 00:00:00','K14','ngocnguyen5200@gmail.com',NULL,'Female',NULL,'905569380',1,1,1,1,NULL),
    (121,'Chề Ngọc Nguyên','SS140394','2000-03-24 00:00:00','k14','chengocnguyen.pt03@gmail.com',NULL,'Female',NULL,'908269701',1,1,1,1,NULL),
    (122,'Hồ Lam Nhật','SA140303','2000-01-05 00:00:00','K14','nhatholam@gmail.com',NULL,'Male',NULL,'814055868',1,1,1,1,NULL),
    (123,'Nguyễn Thị Tuyết Nhi','SA140339','2000-08-25 00:00:00','K14','doraemon25082000@gmail.com',NULL,'Female',NULL,'345480215',1,1,1,1,NULL),
    (124,'Triệu Yến Nhi','SS140210','2000-09-13 00:00:00','k14','trieuyennhi13900@gmail.com',NULL,'Female',NULL,'383254008',1,1,1,1,NULL),
    (125,'Hồ Thị Quỳnh Như','SS140050','2000-01-20 00:00:00','K14','hothiquynhnhu20012000@gmail.com',NULL,'Female',NULL,'346799271',1,1,1,1,NULL),
    (126,'Quân Bảo Hoàng Phú','SE140579','2000-11-11 00:00:00','K14','nickyromelno123@gmail.com',NULL,'Male',NULL,'326554476',1,1,1,1,NULL),
    (127,'Lê Nguyễn Xuân Diệu Phúc','SA140007','2000-01-29 00:00:00','K14','phuclnxd@gmail.com',NULL,'Female',NULL,'933354624',1,1,1,1,NULL),
    (128,'Phạm Duy Phương','SE140481','2000-05-10 00:00:00','K14','duyphuong2000.dpp@gmail.com',NULL,'Male',NULL,'352262703',1,1,1,1,NULL),
    (129,'Bảo Quốc','SE140751','2000-03-22 00:00:00','k14','diceq2203@gmail.com',NULL,'Male',NULL,'938196994',1,1,1,1,NULL),
    (130,'Đặng Ngọc Thẩm','SS140161','2000-08-24 00:00:00','K14','thamdang978@gmail.com',NULL,'Male',NULL,'918159698',1,1,1,1,NULL),
    (131,'Dương Ngọc Thanh Thanh','SS140066','2000-03-19 00:00:00','K14','duongngocthanhthanh2717@gmail.com',NULL,'Female',NULL,'908767551',1,1,1,1,NULL),
    (132,'Thái Ngọc Thiện','SE140167','2000-05-20 00:00:00','K14','ngocthienthai07@gmail.com',NULL,'Male',NULL,'834562000',1,1,1,1,NULL),
    (133,'Nguyễn Trường Thịnh','SE140571','1999-12-01 00:00:00','K14','truongthinhnguyen36@gmail.com',NULL,'Male',NULL,'938468057',1,1,1,1,NULL),
    (134,'Phạm Tiến','SA140046','2000-05-24 00:00:00','K14','phamtien24052000@gmail.com',NULL,'Male',NULL,'335577801',1,1,1,1,NULL),
    (135,'Trương Ngọc Trân','SE141018','2000-07-08 00:00:00','K14','truongngoctran92@gmail.com',NULL,'Female',NULL,'396007622',1,1,1,1,NULL),
    (136,'Nguyễn Thanh Trúc','SA140141','2000-06-06 00:00:00','K14','truct044@gmail.com',NULL,'Other',NULL,'583874777',1,1,1,1,NULL),
    (137,'Nguyễn Thanh Mỹ Uyên','SS140031','2000-09-18 00:00:00','K14','uyennguyen18092000@gmail.com',NULL,'Female',NULL,'901619249',1,1,1,1,NULL),
    (138,'Nguyễn Thị Thảo Vân','SS140255','2000-05-27 00:00:00','K14','thaovan0961@gmail.com',NULL,'Female',NULL,'961818575',1,1,1,1,NULL);
    
-- Insert Event
INSERT INTO `fptueventclub`.`fev_event` (`name`, `start`, `end`, `time`, `place`, `leader`) VALUES ('FPTU First Step', '2018-10-20', '2018-11-20', '2018-11-11', 'Quang Trung Software City', '8');
INSERT INTO `fptueventclub`.`fev_event` (`name`, `start`, `end`, `time`, `place`, `leader`) VALUES ('Trung Thu Am Ap', '2018-09-20', '2018-10-20', '2018-10-17', 'Hoc Mon', '7');
INSERT INTO `fptueventclub`.`fev_event` (`name`, `start`, `end`, `time`, `place`, `leader`) VALUES ('Vietnames Teacher Day', '2018-10-20', '2018-11-25', '2018-11-20', 'Innovation Building', '6');

-- Insert Event Member
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('1', '1');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('1', '2');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('1', '3');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('1', '4');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('1', '5');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('2', '3');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('2', '5');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('2', '7');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('3', '1');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('3', '2');
INSERT INTO `fptueventclub`.`fev_event_member` (`event`, `member`) VALUES ('3', '3');

-- Insert Feedback Status
INSERT INTO `fptueventclub`.`fev_feedback_status` (`status`) VALUES ('Read');
INSERT INTO `fptueventclub`.`fev_feedback_status` (`status`) VALUES ('Draf');
INSERT INTO `fptueventclub`.`fev_feedback_status` (`status`) VALUES ('Review');

-- Insert Feedback
INSERT INTO `fptueventclub`.`fev_feedback` (`content`, `status`) VALUES ('Your club so good', '1');
INSERT INTO `fptueventclub`.`fev_feedback` (`content`, `status`) VALUES ('How to regist  ?', '2');
INSERT INTO `fptueventclub`.`fev_feedback` (`content`, `status`) VALUES ('What is FEV stand for ?', '3');

-- Insert Transaction Type
INSERT INTO `fptueventclub`.`fev_transaction_type` (`type`) VALUES ('Withdraw');
INSERT INTO `fptueventclub`.`fev_transaction_type` (`type`) VALUES ('Deposit');
INSERT INTO `fptueventclub`.`fev_transaction_type` (`type`) VALUES ('Donate');
INSERT INTO `fptueventclub`.`fev_transaction_type` (`type`) VALUES ('Other');

-- Insert Transaction 
INSERT INTO `fptueventclub`.`fev_transaction` (`type`, `content`, `money`, `burden`) VALUES ('2', 'June Support Money', '500000', '2');
INSERT INTO `fptueventclub`.`fev_transaction` (`type`, `content`, `money`, `burden`) VALUES ('2', 'August Support Money', '500000', '2');
INSERT INTO `fptueventclub`.`fev_transaction` (`type`, `content`, `money`, `burden`) VALUES ('2', 'Set up', '650000', '2');
INSERT INTO `fptueventclub`.`fev_transaction` (`type`, `content`, `money`, `burden`) VALUES ('1', 'Club Meeting', '350000', '1');
INSERT INTO `fptueventclub`.`fev_transaction` (`type`, `content`, `money`, `burden`) VALUES ('1', 'Capstone Project', '600000', '1');


-- Insert Iventory Status
INSERT INTO `fptueventclub`.`fev_inventory_status` (`status`) VALUES ('Borrowed');
INSERT INTO `fptueventclub`.`fev_inventory_status` (`status`) VALUES ('Free');
INSERT INTO `fptueventclub`.`fev_inventory_status` (`status`) VALUES ('Unknow');
INSERT INTO `fptueventclub`.`fev_inventory_status` (`status`) VALUES ('Other');

-- Insert Inventory Item
INSERT INTO `fptueventclub`.`fev_inventory_item` (`name`) VALUES ('Teambuilding Banner');
INSERT INTO `fptueventclub`.`fev_inventory_item` (`name`) VALUES ('Bucket');
INSERT INTO `fptueventclub`.`fev_inventory_item` (`name`) VALUES ('Logo');
INSERT INTO `fptueventclub`.`fev_inventory_item` (`name`) VALUES ('Sticker');

-- Insert Inventory
INSERT INTO `fptueventclub`.`fev_inventory` (`item`, `quantity`, `holder`, `status`) VALUES ('1', '2', '1', '1');
INSERT INTO `fptueventclub`.`fev_inventory` (`item`, `quantity`, `holder`, `status`) VALUES ('2', '1', '2', '2');
INSERT INTO `fptueventclub`.`fev_inventory` (`item`, `quantity`, `holder`, `status`) VALUES ('3', '1', '3', '3');
INSERT INTO `fptueventclub`.`fev_inventory` (`item`, `quantity`, `holder`, `status`) VALUES ('4', '1', '4', '4');


-- Insert Vote Key
INSERT INTO `fptueventclub`.`fev_vote_key` (`key`, `priority`, `isActive`) VALUES ('BTH', '1', b'1');
INSERT INTO `fptueventclub`.`fev_vote_key` (`key`, `priority`, `isActive`) VALUES ('BTT', '1', b'1');
INSERT INTO `fptueventclub`.`fev_vote_key` (`key`, `priority`, `isActive`) VALUES ('BKH', '1', b'1');
INSERT INTO `fptueventclub`.`fev_vote_key` (`key`, `priority`, `isActive`) VALUES ('BDH', '2', b'1');
INSERT INTO `fptueventclub`.`fev_vote_key` (`key`, `priority`, `isActive`) VALUES ('BCN', '3', b'1');
INSERT INTO `fptueventclub`.`fev_vote_key` (`key`, `priority`, `isActive`) VALUES ('BCV', '2', b'1');

-- Insert Vote Term
INSERT INTO `fptueventclub`.`fev_vote_term` (`term`, `year`) VALUES ('Spring', '2019');
INSERT INTO `fptueventclub`.`fev_vote_term` (`term`, `year`) VALUES ('Summer', '2019');
INSERT INTO `fptueventclub`.`fev_vote_term` (`term`, `year`) VALUES ('Fall', '2019');

-- Insert Vote Candidate
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('1', '4', '1', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('2', '4', '2', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('3', '4', '3', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('4', '4', '1', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('5', '4', '1', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('6', '4', '2', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('7', '4', '2', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('8', '4', '3', '1', '0');
INSERT INTO `fptueventclub`.`fev_vote_candidate` (`member`, `position`, `group`, `term`, `total`) VALUES ('9', '4', '3', '1', '0');

-- Insert Vote
-- INSERT INTO `fptueventclub`.`fev_vote` (`candidate`, `key`) VALUES ('1', '1');
-- INSERT INTO `fptueventclub`.`fev_vote` (`candidate`, `key`) VALUES ('2', '1');
-- INSERT INTO `fptueventclub`.`fev_vote` (`candidate`, `key`) VALUES ('3', '1');
-- INSERT INTO `fptueventclub`.`fev_vote` (`candidate`, `key`) VALUES ('2', '2');
-- INSERT INTO `fptueventclub`.`fev_vote` (`candidate`, `key`) VALUES ('4', '2');
-- INSERT INTO `fptueventclub`.`fev_vote` (`candidate`, `key`) VALUES ('7', '2');

-- Update isActive
UPDATE `fptueventclub`.`fev_vote_key` SET `is_active`=1 WHERE `id`='1';
UPDATE `fptueventclub`.`fev_vote_key` SET `is_active`=1 WHERE `id`='2';
UPDATE `fptueventclub`.`fev_vote_key` SET `is_active`=1 WHERE `id`='3';
UPDATE `fptueventclub`.`fev_vote_key` SET `is_active`=1 WHERE `id`='4';
UPDATE `fptueventclub`.`fev_vote_key` SET `is_active`=1 WHERE `id`='5';
UPDATE `fptueventclub`.`fev_vote_key` SET `is_active`=1 WHERE `id`='6';



