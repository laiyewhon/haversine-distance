create database postcode;

create user 'postcode'@'%' identified by '30TCnIUjKvsMdb5vduxREw==';

grant all privileges on postcode.* to 'postcode'@'%';
