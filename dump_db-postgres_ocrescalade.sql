--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: commentaire; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    contenu character varying(255),
    creation_date timestamp without time zone,
    statut character varying(255),
    auteur_id bigint
);


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: privilege; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.privilege (
    id bigint NOT NULL,
    name character varying(255)
);


--
-- Name: role; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(255)
);


--
-- Name: roles_privileges; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.roles_privileges (
    role_id bigint NOT NULL,
    privilege_id bigint NOT NULL
);


--
-- Name: site; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.site (
    id integer NOT NULL,
    cotation_max character varying(255),
    cotation_min character varying(255),
    description text NOT NULL,
    hauteur integer,
    image1 character varying(255),
    image2 character varying(255),
    is_mis_en_avant boolean NOT NULL,
    nb_de_voies character varying(255),
    nom character varying(255) NOT NULL,
    orientation character varying(255),
    pays character varying(255),
    detail_id integer
);


--
-- Name: site_description; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.site_description (
    id integer NOT NULL,
    contenu1 text,
    contenu2 text,
    contenu3 text,
    latitude double precision,
    longitude double precision,
    titre1 character varying(255),
    titre2 character varying(255),
    titre3 character varying(255)
);


--
-- Name: site_description_commentaires; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.site_description_commentaires (
    site_description_id integer NOT NULL,
    commentaires_id integer NOT NULL
);


--
-- Name: site_detail; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.site_detail (
    id integer NOT NULL,
    desc_acces character varying(255),
    desc_autre character varying(255),
    desc_escalade character varying(255),
    desc_hebergement character varying(255),
    desc_moment character varying(255)
);


--
-- Name: topo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    date_emprunt timestamp without time zone,
    date_fin_emprunt timestamp without time zone,
    description text,
    image1 character varying(255),
    nom_ressource character varying(255),
    statut character varying(255),
    titre character varying(255),
    emprunteur_id bigint,
    preteur_id bigint
);


--
-- Name: topo_sites; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.topo_sites (
    topo_id integer NOT NULL,
    sites_id integer NOT NULL
);


--
-- Name: user_account; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_account (
    id bigint NOT NULL,
    email character varying(255),
    enabled boolean NOT NULL,
    first_name character varying(255),
    is_using2fa boolean NOT NULL,
    last_name character varying(255),
    password character varying(60)
);


--
-- Name: users_roles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


--
-- Name: verification_token; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.verification_token (
    token character varying(255) NOT NULL,
    expiry_date timestamp without time zone,
    commentaire_id integer,
    user_id bigint
);


--
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.commentaire (id, contenu, creation_date, statut, auteur_id) FROM stdin;
100	Super site. Je vous le recommande! J’y suis allé l’année dernière et c’était genial!	2019-01-10 10:00:00	valide	3
200	Je confirme!	2019-03-05 12:30:00	valide	3
\.


--
-- Data for Name: privilege; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.privilege (id, name) FROM stdin;
1	USER
2	ADMIN
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.role (id, name) FROM stdin;
1	visiteur
2	administrateur
\.


--
-- Data for Name: roles_privileges; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.roles_privileges (role_id, privilege_id) FROM stdin;
1	1
2	1
2	2
\.


--
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.site (id, cotation_max, cotation_min, description, hauteur, image1, image2, is_mis_en_avant, nb_de_voies, nom, orientation, pays, detail_id) FROM stdin;
1	9b	4a	Juste au-dessus de Menton, Castillon se classe haut la main parmi les sites majeurs des Alpes-Maritimes. On y trouve un rocher d’une raideur et d’une qualité exceptionnelles, du dévers jusqu’à plus soif, du dur, du dur et du dur, et pour en profiter jusqu’au bout, une orientation plein soleil jusqu’à la nuit, ce qui en fait un parfait spot d’hiver et de demi-saison. D’autant qu’il est assez fréquenté l’été. Mieux vaut avoir une bonne caisse physique pour aller grimper là-bas. Sinon, pas loin, il y a la mer, la plage et les parasols. Mais ça serait dommage, parce que même sans grimper, vous pouvez y croiser des vrais people de la grimpe internationale! La paternité de la falaise revient à Axel Franco et Philippe Maurel qui y ont ouvert une première ligne (Mortal Kombat) en 1997. Par la suite, d’autres talentueux équipeurs y ont ajouté leur signature, pour une œuvre collective de 55 voies du 6b au 8c+.	100	mont-blanc_720x160.jpg	mont-blanc_160x160.jpg	t	30	Vallée de Chamonix	Multiples	France	1
2	8a	3a	Rien à grimper dans l’ouest? Archifaux. La preuve, avec ce bon petit spot de bloc bien connu des grimpeurs nantais. Située au carrefour des trois anciennes provinces que formaient l’Anjou, le Poitou et la Bretagne, la vallée de Clisson se situe à vingt-cinq minutes au sud de Nantes. On trouve là de nombreux blocs, bordés d’une frange de forêt le long de la Sèvre, au pied du château de Clisson. Un petit spot pour les amoureux du granit et du bloc. Mieux encore, le site de Clisson est loin de se faire élitiste, bien au contraire. Accueillant sous tous rapports, il est même une bonne façon de sortir grimper entre potes ou en famille. Clisson est vraiment sorti de l’ombre en 2003, lorsque Loïc Fossard et Simon Lelardoux, tombés sous le charme, décident de dynamiser le site. Aidés de quelques acharnés, ils brossent l’ensemble des blocs, dévoilent la plupart des passages et mettent en place un nouveau topo qui attire rapidement bon nombre de grimpeurs. Avec ses jolis problèmes made on granit, Clisson offre des passages de tous niveaux dans un cadre très agréable	100	wadi-rum_jordanie_720x160.jpg	wadi-rum_jordanie_160x160.jpg	t	30	Wadi Rum	Multiples	Jordanie	2
3	9b	3a	« À Sainte-Croix, paye ta croix», dit le dicton du grimpeur autochtone… Une manière d’annoncer que si la falaise de Sainte-Croix est remarquable, c’est déjà par la difficulté de ses voies. En effet, sur ce petit site de couennes déversantes dans la haute difficulté, les croix ne se moissonnent pas dans les voies dont le style est exigeant dans la filière résistance courte, et intransigeant en lecture et en technique.Pour la petite histoire, la falaise de Sainte-Croix avait été pressentie pour organiser le championnat de France jeunes en 1995, mais en raison de sa trop petite taille, elle s’était fait piquer la vedette par le site de Baume Rousse (à Buis-les-Baronnies). Ainsi retoquée à la Nouvelle Star, elle n’est pas pour autant tombée dans l’oubli, grâce au flair d’infatigables et talentueux équipeurs, dont Jimmy Aunet, qui s’y sont consacrés dans les années 2000. Et le site devait vraiment avoir des atouts, car il s’est fait un nom en quelques années. Mais vu que ce n’est pas dû à la longueur des voies (réduite), ni à leur nombre (modeste), le vrai plus est ailleurs… Et hormis le rocher, la région du Diois risque fort de vous faire également succomber sous ses charmes dont le soleil, la douceur de vivre et la clairette ne sont pas des moindres.	100	turkey_720x160.jpg	turkey_160x160.jpg	t	30	Antalya	Multiples	Turquie	3
4	9b	3a	« À Sainte-Croix, paye ta croix», dit le dicton du grimpeur autochtone… Une manière d’annoncer que si la falaise de Sainte-Croix est remarquable, c’est déjà par la difficulté de ses voies. En effet, sur ce petit site de couennes déversantes dans la haute difficulté, les croix ne se moissonnent pas dans les voies dont le style est exigeant dans la filière résistance courte, et intransigeant en lecture et en technique.Pour la petite histoire, la falaise de Sainte-Croix avait été pressentie pour organiser le championnat de France jeunes en 1995, mais en raison de sa trop petite taille, elle s’était fait piquer la vedette par le site de Baume Rousse (à Buis-les-Baronnies). Ainsi retoquée à la Nouvelle Star, elle n’est pas pour autant tombée dans l’oubli, grâce au flair d’infatigables et talentueux équipeurs, dont Jimmy Aunet, qui s’y sont consacrés dans les années 2000. Et le site devait vraiment avoir des atouts, car il s’est fait un nom en quelques années. Mais vu que ce n’est pas dû à la longueur des voies (réduite), ni à leur nombre (modeste), le vrai plus est ailleurs… Et hormis le rocher, la région du Diois risque fort de vous faire également succomber sous ses charmes dont le soleil, la douceur de vivre et la clairette ne sont pas des moindres.	100	verdon_720x160.jpg	verdon_160x160.jpg	t	30	Gorges du Verdon	Multiples	France	4
5	7a	3a	Rien à grimper dans l’ouest? Archifaux. La preuve, avec ce bon petit spot de bloc bien connu des grimpeurs nantais. Située au carrefour des trois anciennes provinces que formaient l’Anjou, le Poitou et la Bretagne, la vallée de Clisson se situe à vingt-cinq minutes au sud de Nantes. On trouve là de nombreux blocs, bordés d’une frange de forêt le long de la Sèvre, au pied du château de Clisson. Un petit spot pour les amoureux du granit et du bloc. Mieux encore, le site de Clisson est loin de se faire élitiste, bien au contraire. Accueillant sous tous rapports, il est même une bonne façon de sortir grimper entre potes ou en famille. Clisson est vraiment sorti de l’ombre en 2003, lorsque Loïc Fossard et Simon Lelardoux, tombés sous le charme, décident de dynamiser le site. Aidés de quelques acharnés, ils brossent l’ensemble des blocs, dévoilent la plupart des passages et mettent en place un nouveau topo qui attire rapidement bon nombre de grimpeurs. Avec ses jolis problèmes made on granit, Clisson offre des passages de tous niveaux dans un cadre très agréable	100	pont d_espagne-France_720x160.png	pont d_espagne-France_160x160.jpg	t	20	Pont d’Espagne	Est	France	5
6	7a	3a	« À Sainte-Croix, paye ta croix», dit le dicton du grimpeur autochtone… Une manière d’annoncer que si la falaise de Sainte-Croix est remarquable, c’est déjà par la difficulté de ses voies. En effet, sur ce petit site de couennes déversantes dans la haute difficulté, les croix ne se moissonnent pas dans les voies dont le style est exigeant dans la filière résistance courte, et intransigeant en lecture et en technique.Pour la petite histoire, la falaise de Sainte-Croix avait été pressentie pour organiser le championnat de France jeunes en 1995, mais en raison de sa trop petite taille, elle s’était fait piquer la vedette par le site de Baume Rousse (à Buis-les-Baronnies). Ainsi retoquée à la Nouvelle Star, elle n’est pas pour autant tombée dans l’oubli, grâce au flair d’infatigables et talentueux équipeurs, dont Jimmy Aunet, qui s’y sont consacrés dans les années 2000. Et le site devait vraiment avoir des atouts, car il s’est fait un nom en quelques années. Mais vu que ce n’est pas dû à la longueur des voies (réduite), ni à leur nombre (modeste), le vrai plus est ailleurs… Et hormis le rocher, la région du Diois risque fort de vous faire également succomber sous ses charmes dont le soleil, la douceur de vivre et la clairette ne sont pas des moindres.	100	Kalymnos-Grece_720x160.png	Kalymnos-Grece_160x160.jpg	t	50	Kalymnos	Multiples	Grèce	6
7	4a	3a	Une magnifique région qui regorge de voies pour tous publics...	100	Siurana-Espagne_720x160.png	Siurana-Espagne_160x160.jpg	t	50	Siurana	Multiples	ESPAGNE	7
\.


--
-- Data for Name: site_description; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.site_description (id, contenu1, contenu2, contenu3, latitude, longitude, titre1, titre2, titre3) FROM stdin;
1	Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.\nBest of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>	Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.\nQuand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.	Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>	45.8326220000000006	6.86517499999999981	Caractéristiques techniques	Accès	Hébergement
2	Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.\nBest of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>	Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.\nQuand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.	Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>	29.572564376399999	35.4186216587999994	Caractéristiques techniques	Accès	Hébergement
3	Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.\nBest of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>	Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.\nQuand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.	Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>	36.9081199999999967	30.6955600000000004	Caractéristiques techniques	Accès	Hébergement
4	Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.\nBest of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>	Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.\nQuand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.	Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>	43.8226000000000013	6.4312699999999996	Caractéristiques techniques	Accès	Hébergement
5	Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.\nBest of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>	Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.\nQuand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.	Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>	42.8522200000000026	-0.145777999999999991	Caractéristiques techniques	Accès	Hébergement
6	Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.\nBest of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>	Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.\nQuand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.	Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>	36.9954469999999986	26.9970150000000011	Caractéristiques techniques	Accès	Hébergement
7	Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.\nBest of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>	Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.\nQuand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.	Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>	41.25	0.933300000000000018	Caractéristiques techniques	Accès	Hébergement
\.


--
-- Data for Name: site_description_commentaires; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.site_description_commentaires (site_description_id, commentaires_id) FROM stdin;
1	100
1	200
\.


--
-- Data for Name: site_detail; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.site_detail (id, desc_acces, desc_autre, desc_escalade, desc_hebergement, desc_moment) FROM stdin;
\.


--
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.topo (id, date_emprunt, date_fin_emprunt, description, image1, nom_ressource, statut, titre, emprunteur_id, preteur_id) FROM stdin;
1	\N	2019-04-24 00:00:00	Une sélection d’escalades de 4+ à 6a en Dauphiné	topo_1.jpg		libre	6a Max Dauphiné	4	3
2	\N	\N	Une sélection d’escalades de 4+ à 6a en Dauphiné	topo_2.jpg		libre	Avignon Soleil	\N	3
3	\N	\N	Une sélection d’escalades dans les pyrénées occidentales	topo_3.jpg		libre	El Pirineo Occidental	\N	3
4	\N	\N	Une sélection d’escalades en Corse	topo_4.jpg		libre	Corsica Bloc	\N	4
5	\N	2019-05-31 00:00:00	Une sélection d’escalades en Corse	topo_5.jpg		libre	Escalar en España	5	4
6	\N	\N	Une sélection d’escalades dans les Dolomites	topo_6.jpg		libre	Dolomites	\N	4
7	\N	\N	Les voies des Aiguilles Rouges	topo_7.jpg		libre	Envers des aiguilles	\N	5
8	\N	\N	Une sélection d’escalades en Corse	topo_8.jpg		libre	Escalada en Castelion	\N	5
\.


--
-- Data for Name: topo_sites; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.topo_sites (topo_id, sites_id) FROM stdin;
1	1
1	2
2	3
\.


--
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.user_account (id, email, enabled, first_name, is_using2fa, last_name, password) FROM stdin;
1	inferno@hell.com	t	Dr	f	Sam	$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq
3	user@hell.com	t	Jack	f	Bauer	$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq
4	arthur@hell.com	t	Arthur	f	Morgan	$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq
5	harry@hell.com	t	Harry	f	Callahan	$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq
\.


--
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.users_roles (user_id, role_id) FROM stdin;
1	2
3	1
4	1
5	1
\.


--
-- Data for Name: verification_token; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.verification_token (token, expiry_date, commentaire_id, user_id) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.hibernate_sequence', 123, false);


--
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- Name: privilege privilege_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.privilege
    ADD CONSTRAINT privilege_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: site_description site_description_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.site_description
    ADD CONSTRAINT site_description_pkey PRIMARY KEY (id);


--
-- Name: site_detail site_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.site_detail
    ADD CONSTRAINT site_detail_pkey PRIMARY KEY (id);


--
-- Name: site site_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pkey PRIMARY KEY (id);


--
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id);


--
-- Name: site_description_commentaires uk_8x9v6mjeg5sol19vpdtg9lyfj; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.site_description_commentaires
    ADD CONSTRAINT uk_8x9v6mjeg5sol19vpdtg9lyfj UNIQUE (commentaires_id);


--
-- Name: user_account user_account_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pkey PRIMARY KEY (id);


--
-- Name: verification_token verification_token_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.verification_token
    ADD CONSTRAINT verification_token_pkey PRIMARY KEY (token);


--
-- Name: site_description_commentaires fk14m9u4ltltyc48b8px10shg19; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.site_description_commentaires
    ADD CONSTRAINT fk14m9u4ltltyc48b8px10shg19 FOREIGN KEY (site_description_id) REFERENCES public.site_description(id);


--
-- Name: roles_privileges fk5yjwxw2gvfyu76j3rgqwo685u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles_privileges
    ADD CONSTRAINT fk5yjwxw2gvfyu76j3rgqwo685u FOREIGN KEY (privilege_id) REFERENCES public.privilege(id);


--
-- Name: topo_sites fk6rrpse282dpf1fot6ls7lg01y; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.topo_sites
    ADD CONSTRAINT fk6rrpse282dpf1fot6ls7lg01y FOREIGN KEY (sites_id) REFERENCES public.site(id);


--
-- Name: site_description_commentaires fk7hmrwc2fblh8tsgqkirujtqdf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.site_description_commentaires
    ADD CONSTRAINT fk7hmrwc2fblh8tsgqkirujtqdf FOREIGN KEY (commentaires_id) REFERENCES public.commentaire(id);


--
-- Name: site fk8i2717gm90b848d1kpljkmwjw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT fk8i2717gm90b848d1kpljkmwjw FOREIGN KEY (detail_id) REFERENCES public.site_description(id);


--
-- Name: roles_privileges fk9h2vewsqh8luhfq71xokh4who; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles_privileges
    ADD CONSTRAINT fk9h2vewsqh8luhfq71xokh4who FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: topo fkb9wlql4nd5benbiiuru250ff0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fkb9wlql4nd5benbiiuru250ff0 FOREIGN KEY (preteur_id) REFERENCES public.user_account(id);


--
-- Name: users_roles fkci4mdvg1fmo9eqmwno1y9o0fa; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkci4mdvg1fmo9eqmwno1y9o0fa FOREIGN KEY (user_id) REFERENCES public.user_account(id);


--
-- Name: verification_token fkcty5hs7owc9k44329hapyxi68; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.verification_token
    ADD CONSTRAINT fkcty5hs7owc9k44329hapyxi68 FOREIGN KEY (commentaire_id) REFERENCES public.commentaire(id);


--
-- Name: topo_sites fkerkey72bnjmk11sui00e84gex; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.topo_sites
    ADD CONSTRAINT fkerkey72bnjmk11sui00e84gex FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- Name: commentaire fkjauosgi8hpx3424b8ghl9eqxt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fkjauosgi8hpx3424b8ghl9eqxt FOREIGN KEY (auteur_id) REFERENCES public.user_account(id);


--
-- Name: verification_token fklrihnx4hd69b8ao34kof74j70; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.verification_token
    ADD CONSTRAINT fklrihnx4hd69b8ao34kof74j70 FOREIGN KEY (user_id) REFERENCES public.user_account(id);


--
-- Name: topo fknqk0xesrwkytbkxtcar1974c7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fknqk0xesrwkytbkxtcar1974c7 FOREIGN KEY (emprunteur_id) REFERENCES public.user_account(id);


--
-- Name: users_roles fkt4v0rrweyk393bdgt107vdx0x; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkt4v0rrweyk393bdgt107vdx0x FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- PostgreSQL database dump complete
--

