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
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Mentor');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('None');
INSERT INTO `fptueventclub`.`fev_member_position` (`position`) VALUES ('Other');


-- Insert Member Status
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('Working');
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('Reserving');
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('Quit');
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('None');
INSERT INTO `fptueventclub`.`fev_member_status` (`status`) VALUES ('Other');

-- Insert Member Group
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Planning');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Implement');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Media');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Executive');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Director');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('None');
INSERT INTO `fptueventclub`.`fev_member_group` (`group`) VALUES ('Other');


-- Insert Member
INSERT INTO fptueventclub.fev_member VALUES
    (1,'Hồ Đắc Trung Kiên','GC60251','1993-07-29 00:00:00','K07','kienhdt297@gmail.com','',NULL,'Male',NULL,'976535125',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (2,'Hoàng Nhất Duy Tài','SB60751','1994-07-26 00:00:00','K07','taih9388@gmail.com','',NULL,'Male',NULL,'933634722',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (3,'Vũ Nhật Minh','SE61390','1993-06-01 00:00:00','K08','minhvnse61390@gmail.com','',NULL,'Male',NULL,'1692571346',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (4,'Nguyễn Võ Đoan Trang','SB60700','1994-04-20 00:00:00','K08','d.trang0494@gmail.com','',NULL,'Female',NULL,'902527224',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (5,'Hoàng Trọng Thanh Tùng','SE61694','1995-01-24 00:00:00','K08','hoangtung240195@gmail.com','',NULL,'Male',NULL,'905250314',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (6,'Trần Nho Hiếu','SE61591','1995-02-21 00:00:00','K09','hieutn212@gmail.com','',NULL,'Male',NULL,'975135995',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (7,'Trần Anh Kiệt','SE61469','1995-03-13 00:00:00','K09','kiettase61469@fpt.edu.vn','',NULL,'Male',NULL,'1234585756',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (8,'Tôn Thất Minh Nhật','SE61685','1994-02-11 00:00:00','K09','ttminhnhat94@gmail.com','',NULL,'Male',NULL,'1206149867',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (9,'Lý Phước Sang','SE61461','1995-09-12 00:00:00','K09','sanglp95@gmail.com','',NULL,'Male',NULL,'961564256',1,1,1,1,NULL,NULL,NULL,NULL,NULL),
    (10,'Thuyen To','SE61437','1995-11-12 00:00:00','K09','thuyenttse61437@fpt.edu.vn','',NULL,'Male',NULL,'1683524714',1,1,1,1,NULL,NULL,NULL,NULL,NULL);
    
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
INSERT INTO `fptueventclub`.`fev_vote_term` (`term`, `year`, `name`) VALUES ('Spring', '2019', 'Spring 2019');
INSERT INTO `fptueventclub`.`fev_vote_term` (`term`, `year`, `name`) VALUES ('Summer', '2019', 'Summer 2019');
INSERT INTO `fptueventclub`.`fev_vote_term` (`term`, `year`, `name`) VALUES ('Fall', '2019', 'Fall 2019');

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

ALTER TABLE `fptueventclub`.`fev_vote_key`
DROP COLUMN isActive;


