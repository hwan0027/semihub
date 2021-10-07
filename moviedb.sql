create table `employee_db`.`movie`(
`id` INT NOT NULL AUTO_INCREMENT primary KEY,
`title` VARCHAR(100) NOT NULL);


insert into movie values (0,"007 노 타임 투 다이"), (0,"수색자"), (0,"보이스"), (0,"기적"), (0,"모가디슈"), (0,"위플래쉬"), (0,"극장판 짱구는 못말려-격돌! 낙서왕국과 얼추 네 명의 용사들"), (0,"샹치와 텐링즈의 전설");

select * from movie;

CREATE TABLE `employee_db`.`cinema` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

insert into cinema values (0,"용산아이파크몰"),(0,"압구정"),(0,"송파"),(0,"영등포");
select * from cinema;
CREATE TABLE `employee_db`.`theater` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `theater` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

  insert into theater values (0,"BUSINESS"),(0,"PREMIUM"),(0,"GOLD CLASS"),(0,"4DX"),(0,"IMAX");
  
  select * from theater;
  
CREATE TABLE `employee_db`.`theater_price` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `age` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `theater_id` INT NULL,
  PRIMARY KEY (`id`));
  
  insert into theater_price values (0,"일반",13000,1),(0,"청소년",10000,1),(0,"경로",6000,1),(0,"우대",5000,1);
insert into theater_price values (0,"일반",25000,2),(0,"청소년",20000,2);
  insert into theater_price values (0,"일반",35000,3),(0,"청소년",30000,3);
   insert into theater_price values (0,"일반",20000,4),(0,"청소년",14000,4),(0,"경로",13000,4),(0,"우대",13000,4);
    insert into theater_price values (0,"일반",19000,5),(0,"청소년",15000,5);
    
    select * from theater_price;
    
    CREATE TABLE `employee_db`.`theater_time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `movie_id` INT NOT NULL,
  `theater_id` INT NOT NULL,
  `time` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
  
ALTER TABLE `employee_db`.`theater_time` 
ADD COLUMN `cinema_id` INT NOT NULL AFTER `id`;
select * from cinema;
select * from theater;
select m.title from employee_db.movie m join  theater_time tt on m.id = tt.movie_id join cinema c on c.id = tt.cinema_id where c.id = 1 group by m.title;
select tt.time from employee_db.movie m join  theater_time tt on m.id = tt.movie_id join cinema c on c.id = tt.cinema_id where c.id = 1;
select t.theater from employee_db.theater t join theater_time tt on t.id = tt.theater_id join cinema c on tt.cinema_id = c.id where c.id = 1 group by t.theater;
select * from theater_time;

	-- 용산 007
    insert into theater_time values (0,1,1,1,"12관 13:20"),(0,1,1,1,"13관 12:40"),(0,1,1,1,"13관 15:50"),(0,1,1,1,"13관 19:20"),(0,1,1,1,"17관 10:30"),(0,1,1,1,"17관 13:50");
	insert into theater_time values (0,1,1,2,"17관 10:30"),(0,1,1,2,"17관 13:50"),(0,1,1,2,"17관 17:00");
	insert into theater_time values (0,1,1,3,"GOLD CLASS 9:15"),(0,1,1,3,"GOLD CLASS 12:25"),(0,1,1,3,"GOLD CLASS 15:35"),(0,1,1,3,"GOLD CLASS 18:50");
	insert into theater_time values (0,1,1,4,"4DX 8:30"),(0,1,1,4,"4DX 11:50"),(0,1,1,4,"4DX 15:10"),(0,1,1,4,"4DX 18:30");
	insert into theater_time values (0,1,1,5,"IMAX 8:30"),(0,1,1,5,"IMAX 11:50"),(0,1,1,5,"IMAX 15:10"),(0,1,1,5,"IMAX 18:30");
-- 용산 수색자
insert into theater_time values (0,1,2,1,"2관 15:15"),(0,1,2,1,"2관 19:35"),(0,1,2,1,"6관 11:35"),(0,1,2,1,"6관 16:25");
-- 용산 보이스
insert into theater_time values (0,1,3,1,"1관 8:20"),(0,1,3,1,"1관 10:40"),(0,1,3,1,"1관 13:00"),(0,1,3,1,"1관 15:20"),(0,1,3,1,"1관 17:40");
-- 용산 기적
insert into theater_time values (0,1,4,1,"13관 19:40"),(0,1,4,1,"7관 8:00"),(0,1,4,1,"5관 8:50"),(0,1,4,1,"5관 11:15"),(0,1,4,1,"5관 16:05");
insert into theater_time values (0,1,4,2,"17관 8:00");
-- 용산 샹치
insert into theater_time values (0,1,5,1,"18관 10:15"),(0,1,5,1,"18관 16:55"),(0,1,5,1,"18관 19:35");
-- 용산 모가디슈
insert into theater_time values (0,1,6,1,"1관 8:20"),(0,1,6,1,"1관 10:40"),(0,1,6,1,"1관 13:00"),(0,1,6,1,"1관 15:20"),(0,1,6,1,"1관 17:40");
-- 용산 위플래쉬
insert into theater_time values (0,1,7,1,"1관 8:40"),(0,1,7,1,"1관 11:15"),(0,1,7,1,"1관 13:30"),(0,1,7,1,"6관 11:50"),(0,1,7,1,"6관 17:10");
-- 용산 짱구
insert into theater_time values (0,1,8,1,"1관 17:40"),(0,1,8,1,"6관 9:20"),(0,1,8,1,"6관 14:00");

-- 압구정 007
insert into theater_time values (0,2,1,1,"1관B2층 12:40"),(0,2,1,1,"1관B2층 15:50"),(0,2,1,1,"1관B2층 19:00"),(0,2,1,1,"2관B2층 10:40"),(0,2,1,1,"2관B2층 13:50");
insert into theater_time values (0,2,1,2,"1관B1층 12:40"),(0,2,1,2,"1관B1층 15:50"),(0,2,1,2,"1관B1층 19:00");
-- 압구정 보이스
insert into theater_time values (0,2,3,1,"1관B2층 10:20");
-- 압구정 기적
insert into theater_time values (0,2,4,1,"3관4층 11:40"),(0,2,4,1,"3관4층 15:30");
-- 압구정 모가디슈
insert into theater_time values (0,2,5,1,"3관 본관 4층 15:15");
-- 압구정 위플래쉬
insert into theater_time values (0,2,6,1,"ART1관 16:20"),(0,2,6,1,"ART3관 12:05");

-- id, cinema_id(용산, 압구정, 송파, 영등포), movie_id(1."007 노 타임 투 다이", 2."수색자", 3."보이스", 4."기적", 5."모가디슈", 6."위플래쉬", 7."극장판 짱구는 못말려-격돌! 낙서왕국과 얼추 네 명의 용사들", 8."샹치와 텐링즈의 전설")
-- theater_id(1.business, 2.premium, 3.gold class, 4.4dx, 5.imax), time(시간)

-- 송파 007
insert into theater_time values (0,3,1,1,"4관 10:10"),(0,3,1,1,"4관 13:20"),(0,3,1,1,"4관 16:30"),(0,3,1,1,"6관 9:00"),(0,3,1,1,"6관 17:30");
insert into theater_time values (0,3,1,4,"4DX 9:10"),(0,3,1,4,"4DX 12:20"),(0,3,1,4,"4DX 15:30"),(0,3,1,4,"4DX 18:40");
-- 송파 보이스
insert into theater_time values (0,3,3,1,"1관 9:00"),(0,3,3,1,"1관 11:20"),(0,3,3,1,"1관 20:00");
-- 송파 기적
insert into theater_time values (0,3,4,1,"2관 19:30");
-- 송파 샹치
insert into theater_time values (0,3,8,1,"2관 9:00"),(0,3,8,1,"2관 16:50");

-- 영등포 007
insert into theater_time values (0,4,1,1,"5관4층 8:25"),(0,4,1,1,"5관4층 11:35"),(0,4,1,1,"5관4층 14:45"),(0,4,1,1,"5관4층 17:55");
insert into theater_time values (0,4,1,4,"4DX 4층 9:20"),(0,4,1,4,"4DX 4층 12:30"),(0,4,1,4,"4DX 4층 15:40"),(0,4,1,4,"4DX 4층 18:50");
-- 영등포 수색자
insert into theater_time values (0,4,2,1,"9관4층 13:45");
-- 영등포 보이스
insert into theater_time values (0,4,3,1,"3관4층 8:45"),(0,4,3,1,"3관4층 11:00"),(0,4,3,1,"3관4층 13:15"),(0,4,3,1,"3관4층 15:30");
-- 영등포 기적
insert into theater_time values (0,4,4,1,"7관4층 13:20"),(0,4,4,1,"8관4층 9:55"),(0,4,4,1,"8관4층 12:20"),(0,4,4,1,"8관4층 14:45"),(0,4,4,1,"8관4층 17:10");
insert into theater_time values (0,4,4,2,"17관 8:00");
-- 영등포 모가디슈
insert into theater_time values (0,4,5,1,"1관 8:20"),(0,4,5,1,"1관 10:40"),(0,4,5,1,"1관 13:00"),(0,4,5,1,"1관 15:20"),(0,4,5,1,"6관 9:20");



select * from theater_time;
