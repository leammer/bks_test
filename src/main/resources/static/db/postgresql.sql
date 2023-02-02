-- PostgreSQL database

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

CREATE SCHEMA IF NOT EXISTS test;

SET search_path = test;

SET default_tablespace = '';

SET default_with_oids = false;

\c test

CREATE TABLE IF NOT EXISTS public.account (
	id bigserial NOT NULL,
	balance numeric(19, 2) NULL,
	CONSTRAINT account_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users (
	id bigserial NOT NULL,
	date_of_birth date NULL,
	"name" varchar(500) NULL,
	"password" varchar(500) NULL,
	account_id int8 NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES public.account(id)
);

CREATE TABLE IF NOT EXISTS public.email_data (
	id bigserial NOT NULL,
	email varchar(200) NULL,
	user_id int8 NOT NULL,
	CONSTRAINT email_data_pkey PRIMARY KEY (id),
	CONSTRAINT fk_email_user FOREIGN KEY (user_id) REFERENCES public.users(id)
);

CREATE TABLE IF NOT EXISTS public.phone_data (
	id bigserial NOT NULL,
	phone varchar(255) NULL,
	user_id int8 NOT NULL,
	CONSTRAINT phone_data_pkey PRIMARY KEY (id),
	CONSTRAINT fk_phone_user FOREIGN KEY (user_id) REFERENCES public.users(id)
);

INSERT INTO account VALUES (DEFAULT,  1000);
INSERT INTO account VALUES (DEFAULT,  2000);

INSERT INTO users VALUES (DEFAULT,  null, 'user1', '123', 1);
INSERT INTO users VALUES (DEFAULT,  null, 'user2', '321', 2);

INSERT INTO email_data VALUES (DEFAULT,  'mail1@bk.ru', 1);
INSERT INTO email_data VALUES (DEFAULT,  'mail2@bk.ru', 1);
INSERT INTO email_data VALUES (DEFAULT,  'mail3@bk.ru', 1);
INSERT INTO email_data VALUES (DEFAULT,  'mail4@bk.ru', 2);

INSERT INTO phone_data VALUES (DEFAULT,  '11111111111', 1);
INSERT INTO phone_data VALUES (DEFAULT,  '22222222222', 2);
INSERT INTO phone_data VALUES (DEFAULT,  '33333333333', 2);
INSERT INTO phone_data VALUES (DEFAULT,  '44444444444', 2);
