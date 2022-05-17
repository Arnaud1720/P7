--
-- PostgreSQL database dump
--

-- Dumped from database version 13.5
-- Dumped by pg_dump version 13.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.account (
    id integer NOT NULL,
    city character varying(255),
    frist_name character varying(255),
    last_name character varying(255),
    mail character varying(255),
    password character varying(255),
    phone_number character varying(255),
    postal_adress character varying(255),
    pseudo character varying(255)
);


ALTER TABLE public.account OWNER TO "Admin";

--
-- Name: blibliotheque; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.blibliotheque (
    id integer NOT NULL,
    city character varying(255),
    name character varying(255),
    streetnumber character varying(255),
    surface integer
);


ALTER TABLE public.blibliotheque OWNER TO "Admin";

--
-- Name: book; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.book (
    book_id integer NOT NULL,
    book_available boolean,
    author character varying(255),
    editor character varying(255),
    kind character varying(255),
    ref character varying(255),
    synopsis character varying(255),
    title character varying(255),
    id_examplary bigint
);


ALTER TABLE public.book OWNER TO "Admin";

--
-- Name: borrowing; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.borrowing (
    id integer NOT NULL,
    date_reservation timestamp without time zone,
    date_limite_retour timestamp without time zone,
    cmpt integer,
    out_of_time boolean DEFAULT false,
    total integer,
    account_id integer,
    book_id integer,
    exemplary_id_id bigint
);


ALTER TABLE public.borrowing OWNER TO "Admin";

--
-- Name: exemplary; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.exemplary (
    id bigint NOT NULL,
    exemplairenumber integer,
    total_exemplary_number integer,
    remainingexemplary integer,
    id_blibliotheque integer
);


ALTER TABLE public.exemplary OWNER TO "Admin";

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: Admin
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO "Admin";

--
-- Name: loan; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.loan (
    loan_id integer NOT NULL,
    end_date timestamp without time zone,
    extension boolean,
    start_date timestamp without time zone,
    accountid integer,
    id_exemplaire bigint
);


ALTER TABLE public.loan OWNER TO "Admin";

--
-- Name: roles; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    rolename character varying(255),
    id_account integer
);


ALTER TABLE public.roles OWNER TO "Admin";

--
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- Name: blibliotheque blibliotheque_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.blibliotheque
    ADD CONSTRAINT blibliotheque_pkey PRIMARY KEY (id);


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (book_id);


--
-- Name: borrowing borrowing_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.borrowing
    ADD CONSTRAINT borrowing_pkey PRIMARY KEY (id);


--
-- Name: exemplary exemplary_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.exemplary
    ADD CONSTRAINT exemplary_pkey PRIMARY KEY (id);


--
-- Name: loan loan_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT loan_pkey PRIMARY KEY (loan_id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: account uk9dy9mm9w0y2fdi25288gv4c8j; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT uk9dy9mm9w0y2fdi25288gv4c8j UNIQUE (last_name);


--
-- Name: account uki1gawxnhd94ot5ascbjggmaew; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT uki1gawxnhd94ot5ascbjggmaew UNIQUE (pseudo);


--
-- Name: account ukm93yt13m0ygub63ig996dudgo; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT ukm93yt13m0ygub63ig996dudgo UNIQUE (mail);


--
-- Name: book fk1dx4be18tqs53v3dks5yyk9id; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT fk1dx4be18tqs53v3dks5yyk9id FOREIGN KEY (id_examplary) REFERENCES public.exemplary(id);


--
-- Name: roles fk2gea6ik9rkf6bs6jliputhbbc; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT fk2gea6ik9rkf6bs6jliputhbbc FOREIGN KEY (id_account) REFERENCES public.account(id);


--
-- Name: borrowing fk5ok6v9x0u59fhsruew6iep4i3; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.borrowing
    ADD CONSTRAINT fk5ok6v9x0u59fhsruew6iep4i3 FOREIGN KEY (account_id) REFERENCES public.account(id);


--
-- Name: borrowing fk7mbvr08aidpsr2i2mk3ajk97t; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.borrowing
    ADD CONSTRAINT fk7mbvr08aidpsr2i2mk3ajk97t FOREIGN KEY (exemplary_id_id) REFERENCES public.exemplary(id);


--
-- Name: loan fkj8nn1mb7g4l9twimxae91m7hp; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT fkj8nn1mb7g4l9twimxae91m7hp FOREIGN KEY (accountid) REFERENCES public.account(id);


--
-- Name: exemplary fkks8dmw9xirs8bge0ib6mkseca; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.exemplary
    ADD CONSTRAINT fkks8dmw9xirs8bge0ib6mkseca FOREIGN KEY (id_blibliotheque) REFERENCES public.blibliotheque(id);


--
-- Name: loan fkno5frjh1akcsjasgyxfhfluey; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT fkno5frjh1akcsjasgyxfhfluey FOREIGN KEY (id_exemplaire) REFERENCES public.exemplary(id);


--
-- Name: borrowing fkpgw9do56tnua1aepwswrbwifh; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.borrowing
    ADD CONSTRAINT fkpgw9do56tnua1aepwswrbwifh FOREIGN KEY (book_id) REFERENCES public.book(book_id);


--
-- PostgreSQL database dump complete
--

