create table public."tn_role" (
    id int not null generated by default as identity,
    "name" varchar(100) null,
    created_at timestamp(0) null default now(),
    updated_at timestamp(0) null default now()
);

create table public."tn_user" (
    id int not null generated by default as identity ,
    email varchar(100) null,
    username varchar(100) null,
    "password" varchar(200) null,
    created_at timestamp(0) null default now(),
    updated_at timestamp(0) null default now()
);

create table public."tn_user_role" (
    user_id int not null,
    role_id int not null,
    created_at timestamp(0) null default now(),
    updated_at timestamp(0) null default now()
);

insert into tn_role (id, name) values (1, 'ROLE_USER');
insert into tn_role (id, name) values (2, 'ROLE_MODERATE');
insert into tn_role (id, name) values (3, 'ROLE_ADMIN');

insert into tn_user (id, email, username, "password") values (1, 'vpthanh@abc.com', 'vpthanh', '$2a$10$wQyK5mfXgqzwnrYFdMOe.EP');
insert into tn_user_role (user_id, role_id) values (1,1)