drop table if exists myapp_users restrict;
drop table if exists myapp_boards restrict;
drop table if exists myapp_projects restrict;
drop table if exists myapp_project_members restrict;

create table myapp_users (
     user_id int not null,
     name varchar(20) not null,
     email varchar(100) not null,
     pwd  varchar(100) not null,
     tel varchar(20)
);

alter table myapp_users
    add constraint primary key (user_id),
    modify column user_id int not null auto_increment,
    add constraint myapp_users_uk unique (email);


 create table myapp_boards(
    board_id int not null,
    title varchar(255) not null,
    content text not null,
    created_date datetime not null default now(),
    view_count int default 0
 );

 alter table myapp_boards
    add constraint primary key (board_id),
    modify column board_id int not null auto_increment;


create table myapp_projects(
    project_id int not null,
    title varchar(255) not null,
    description text not null,
    start_date date not null, -- 예) 'yyyy-MM-dd'
    end_date date not null -- 예 ) 'yyyy-MM-dd'
);

alter table myapp_projects
    add constraint primary key (project_id),
    modify column project_id int not null auto_increment;

    create table myapp_project_members (
    user_id int not null,
    project_id int not null
    );

alter table myapp_project_members
    add constraint myapp_project_members_fk1 foreign key(user_id) references myapp_users (user_id),
    add constraint myapp_project_members_fk2 foreign key(project_id) references myapp_projects (project_id),
    add constraint primary key (user_id,project_id);





