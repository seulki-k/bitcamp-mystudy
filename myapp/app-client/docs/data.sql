

insert into myapp_users (user_id, name,email,pwd,tel)  values
(1,'admin', 'admin@test.com', sha1('1111'),'010'),
 (11,'user1', 'user1@test.com', sha1('1111'),'010'),
 (12,'user2', 'user2@test.com', sha1('1111'),'010'),
 (13,'user3', 'user3@test.com', sha1('1111'),'010'),
 (14,'user4', 'user4@test.com', sha1('1111'),'010'),
 (15,'user5', 'user5@test.com', sha1('1111'),'010'),
 (16,'user6', 'user6@test.com', sha1('1111'),'010'),
 (17,'user7', 'user7@test.com', sha1('1111'),'010'),
 (18,'user8', 'user8@test.com', sha1('1111'),'010'),
 (19,'user9', 'user9@test.com', sha1('1111'),'010'),
 (20,'user10', 'user10@test.com', sha1('1111'),'010');


 insert into myapp_boards (board_id, title, content, user_id) values
 (1,'제목 1','내용',11),
 (2,'제목 2','내용',11),
 (3,'제목 3','내용',13),
 (4,'제목 4','내용',16),
 (5,'제목 5','내용',19),
 (6,'제목 6','내용',20),
(7,'제목 7','내용',20);


insert into myapp_projects (project_id, title, description, start_date, end_date) values
(101,'프로젝트1', '설명', '2024-01-01','2024-02-15'),
(102,'프로젝트2', '설명', '2024-02-01','2024-03-15'),
(103,'프로젝트3', '설명', '2024-03-01','2024-04-15');

insert into myapp_project_members (project_id, user_id) values
    (101, 11), (101, 12), (101, 15),
    (102, 15), (102, 16), (102, 19),
    (103, 14), (103, 17), (103, 19);