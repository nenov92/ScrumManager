--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.0
-- Started on 2016-04-27 01:50:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2005 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 173 (class 1259 OID 24640)
-- Name: blackboard_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE blackboard_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE blackboard_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 24634)
-- Name: blackboard; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE blackboard (
    id bigint DEFAULT nextval('blackboard_id_seq'::regclass) NOT NULL,
    name character varying,
    type character varying,
    current_value character varying
);


ALTER TABLE blackboard OWNER TO postgres;

--
-- TOC entry 1996 (class 0 OID 24634)
-- Dependencies: 172
-- Data for Name: blackboard; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY blackboard (id, name, type, current_value) FROM stdin;
3	condition3	bool	false
4	condition4	int	10
7	productTimeFrame	int	28
1	condition	bool	true
11	task2Assignees	int	0
12	task3Assignees	int	0
2	condition2	int	5
10	task1Assignees	int	1
14	taskAssignees	int	0
6	activeSprint	bool	true
5	checkRequirements	bool	false
8	groomingSession	bool	false
52	estimationChanged	bool	false
13	planningSession	bool	false
53	daily	bool	false
56	statusUpdated	bool	false
57	underFifteen	bool	false
55	retrospective	bool	false
41	scrumStart	bool	true
42	dodCompleted	bool	false
43	sprintLength	bool	false
44	planningSplit	bool	false
45	taskMetric	bool	false
46	backlog	bool	false
47	backlogSorted	bool	false
48	clarificationsAsked	bool	false
49	clarificationsGiven	bool	false
51	taskEstimation	bool	false
54	review	bool	false
58	demo	bool	false
59	feedbackGiven	bool	false
\.


--
-- TOC entry 2006 (class 0 OID 0)
-- Dependencies: 173
-- Name: blackboard_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('blackboard_id_seq', 77, true);


--
-- TOC entry 1884 (class 2606 OID 24647)
-- Name: name_constraint; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY blackboard
    ADD CONSTRAINT name_constraint UNIQUE (name);


--
-- TOC entry 1886 (class 2606 OID 24645)
-- Name: symbol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY blackboard
    ADD CONSTRAINT symbol_pkey PRIMARY KEY (id);


--
-- TOC entry 2004 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-27 01:50:22

--
-- PostgreSQL database dump complete
--

