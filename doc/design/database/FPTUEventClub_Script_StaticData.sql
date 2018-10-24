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

-- Insert Member
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`,`address`, `phone`, `position`, `status`, `point`) VALUES ('Vo Hoai Em', 'SE62399', '1997-12-22', 'Male', 'Long An', '1674656683', '9', '1', '100');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Nguyen Bach Toan', 'SE62398', '1997-12-23', 'Male', 'Quang Ngai', '1674656684', '8', '1', '99');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Vu Xuan Tri', 'SE62397', '1997-12-24', 'Male', 'Gia Lai', '1674656685', '7', '1', '98');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Le Trong Quang', 'SE62396', '1997-12-25', 'Male', 'Dong Nai', '1674656686', '6', '1', '97');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Nguyen Minh Chau', 'SE62395', '1997-12-26', 'Male', 'Dak Lak', '1674656687', '5', '1', '96');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Luong Nhat Tuan', 'SE62394', '1997-12-27', 'Male', 'TP.HCM', '1674656688', '4', '1', '95');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Tran Van Toan', 'SE62393', '1997-12-28', 'Male', 'TP.HCM', '1674656689', '3', '1', '94');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Pham Le Tan Thinh', 'SE62392', '1997-12-29', 'Male', 'Quang Nam', '1674656690', '2', '1', '96');
INSERT INTO `fptueventclub`.`fev_member` (`fullname`, `studentID`, `birthdate`, `sex`, `address`, `phone`, `position`, `status`, `point`) VALUES ('Thai Doan Duy Hoang', 'SE62391', '1997-12-30', 'Male', 'Tay ninh', '1674656691', '1', '1', '90');

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
