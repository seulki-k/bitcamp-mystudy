

insert into myapp_users (user_id, name,email,pwd)  values
 (1,'user1', 'user1@test.com', sha1('1111')),
 (2,'user2', 'user2@test.com', sha1('1111')),
 (3,'user3', 'user3@test.com', sha1('1111')),
 (4,'user4', 'user4@test.com', sha1('1111')),
 (5,'user5', 'user5@test.com', sha1('1111')),
 (6,'user6', 'user6@test.com', sha1('1111')),
 (7,'user7', 'user7@test.com', sha1('1111')),
 (8,'user8', 'user8@test.com', sha1('1111')),
 (9,'user9', 'user9@test.com', sha1('1111')),
 (10,'user10', 'user10@test.com', sha1('1111'));


 insert into myapp_boards (board_id, title, content) values
 (1,'제목 1','내용'),
 (2,'제목 2','내용'),
 (3,'제목 3','내용'),
 (4,'제목 4','내용'),
 (5,'제목 5','내용'),
 (6,'제목 6','내용'),
(7,'제목 7','내용');


insert into myapp_projects (project_id, title, description, start_date, end_date) values
(101,'프로젝트1', '설명', '2024-01-01','2024-02-15'),
(102,'프로젝트2', '설명', '2024-02-01','2024-03-15'),
(103,'프로젝트3', '설명', '2024-03-01','2024-04-15');

--프로젝트 멤버
insert into myapp_project_members (project_id, user_id) values
    (101, 1), (101, 2), (101, 5),
    (102, 5), (102, 6), (102, 9),
    (103, 4), (103, 7), (103, 9);