INSERT INTO privilege (id, name)
VALUES (1, 'USER');

INSERT INTO privilege (id, name)
VALUES (2, 'ADMIN');

INSERT INTO role (id, name)
VALUES (1, 'visiteur');

INSERT INTO role (id, name)
VALUES (2, 'administrateur');

INSERT INTO roles_privileges (role_id, privilege_id)
VALUES (1, 1);

INSERT INTO roles_privileges (role_id, privilege_id)
VALUES (2, 1);

INSERT INTO roles_privileges (role_id, privilege_id)
VALUES (2, 2);

INSERT INTO user_account (id,email,first_name, last_name,password, secret, enabled, is_using2fa)
VALUES (1, 'inferno@hell.com', 'Dr', 'Sam', '$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq','secret!', TRUE, FALSE);

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 2);

INSERT INTO user_account (id,email,first_name, last_name,password, secret, enabled, is_using2fa)
VALUES (3, 'user@hell.com', 'Jack', 'Bauer', '$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq','secret!', TRUE, FALSE);
INSERT INTO user_account (id,email,first_name, last_name,password, secret, enabled, is_using2fa)
VALUES (4, 'arthur@hell.com', 'Arthur', 'Morgan', '$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq','secret!', TRUE, FALSE);
INSERT INTO user_account (id,email,first_name, last_name,password, secret, enabled, is_using2fa)
VALUES (5, 'harry@hell.com', 'Harry', 'Callahan', '$2a$11$xc8x65LwMEFB2zugF8h5vOHWojwGpp3Om9OXVw1YJWvckR1uyXrVq','secret!', TRUE, FALSE);


INSERT INTO users_roles (user_id, role_id)
VALUES (3, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (4, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (5, 1);


INSERT INTO commentaire (id, contenu, creation_date, auteur_id)
VALUES (100, 'Super site. Je vous le recommande! J y suis allé l année dernière et c etait genial!', '2019-01-10 10:00:00', 3);

INSERT INTO commentaire (id, contenu, creation_date, auteur_id)
VALUES (200, 'Je confirme!', '2019-01-01 10:00:00', 3);


INSERT INTO site_description (id) VALUES (1);
INSERT INTO site_description (id) VALUES (2);
INSERT INTO site_description (id) VALUES (3);
INSERT INTO site_description (id) VALUES (4);
INSERT INTO site_description (id) VALUES (5);
INSERT INTO site_description (id) VALUES (6);
INSERT INTO site_description (id) VALUES (7);

INSERT INTO site_description_commentaires (site_description_id, commentaires_id)
VALUES (1,100);

INSERT INTO site_description_commentaires (site_description_id, commentaires_id)
VALUES (1,200);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image1, image2, is_mis_en_avant, detail_id)
VALUES (1,'Vallée de Chamonix', 'Juste au-dessus de Menton, Castillon se classe haut la main parmi les sites majeurs des Alpes-Maritimes. On y trouve un rocher d’une raideur et d’une qualité exceptionnelles, du dévers jusqu’à plus soif, du dur, du dur et du dur, et pour en profiter jusqu’au bout, une orientation plein soleil jusqu’à la nuit, ce qui en fait un parfait spot d’hiver et de demi-saison. D’autant qu’il est assez fréquenté l’été. Mieux vaut avoir une bonne caisse physique pour aller grimper là-bas. Sinon, pas loin, il y a la mer, la plage et les parasols. Mais ça serait dommage, parce que même sans grimper, vous pouvez y croiser des vrais people de la grimpe internationale! La paternité de la falaise revient à Axel Franco et Philippe Maurel qui y ont ouvert une première ligne (Mortal Kombat) en 1997. Par la suite, d’autres talentueux équipeurs y ont ajouté leur signature, pour une œuvre collective de 55 voies du 6b au 8c+.', 'France', 100, '4a', '9b', '30', 'Multiples', 'mont-blanc_720x160.jpg', 'mont-blanc_160x160.jpg', true,1);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image1, image2, is_mis_en_avant, detail_id)
VALUES (2,'Wadi Rum', 'Rien à grimper dans l’ouest? Archifaux. La preuve, avec ce bon petit spot de bloc bien connu des grimpeurs nantais. Située au carrefour des trois anciennes provinces que formaient l’Anjou, le Poitou et la Bretagne, la vallée de Clisson se situe à vingt-cinq minutes au sud de Nantes. On trouve là de nombreux blocs, bordés d’une frange de forêt le long de la Sèvre, au pied du château de Clisson. Un petit spot pour les amoureux du granit et du bloc. Mieux encore, le site de Clisson est loin de se faire élitiste, bien au contraire. Accueillant sous tous rapports, il est même une bonne façon de sortir grimper entre potes ou en famille. Clisson est vraiment sorti de l’ombre en 2003, lorsque Loïc Fossard et Simon Lelardoux, tombés sous le charme, décident de dynamiser le site. Aidés de quelques acharnés, ils brossent l’ensemble des blocs, dévoilent la plupart des passages et mettent en place un nouveau topo qui attire rapidement bon nombre de grimpeurs. Avec ses jolis problèmes made on granit, Clisson offre des passages de tous niveaux dans un cadre très agréable', 'Jordanie', 100, '3a', '8a', '30', 'Multiples', 'wadi-rum_jordanie_720x160.jpg', 'wadi-rum_jordanie_160x160.jpg', true,2);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image1, image2, is_mis_en_avant, detail_id)
VALUES (3,'Antalya', '« À Sainte-Croix, paye ta croix», dit le dicton du grimpeur autochtone… Une manière d’annoncer que si la falaise de Sainte-Croix est remarquable, c’est déjà par la difficulté de ses voies. En effet, sur ce petit site de couennes déversantes dans la haute difficulté, les croix ne se moissonnent pas dans les voies dont le style est exigeant dans la filière résistance courte, et intransigeant en lecture et en technique.Pour la petite histoire, la falaise de Sainte-Croix avait été pressentie pour organiser le championnat de France jeunes en 1995, mais en raison de sa trop petite taille, elle s’était fait piquer la vedette par le site de Baume Rousse (à Buis-les-Baronnies). Ainsi retoquée à la Nouvelle Star, elle n’est pas pour autant tombée dans l’oubli, grâce au flair d’infatigables et talentueux équipeurs, dont Jimmy Aunet, qui s’y sont consacrés dans les années 2000. Et le site devait vraiment avoir des atouts, car il s’est fait un nom en quelques années. Mais vu que ce n’est pas dû à la longueur des voies (réduite), ni à leur nombre (modeste), le vrai plus est ailleurs… Et hormis le rocher, la région du Diois risque fort de vous faire également succomber sous ses charmes dont le soleil, la douceur de vivre et la clairette ne sont pas des moindres.', 'Turquie', 100, '3a', '9b', '30', 'Multiples', 'turkey_720x160.jpg', 'turkey_160x160.jpg', true,3);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image1, image2, is_mis_en_avant, detail_id)
VALUES (4,'Gorges du Verdon', '« À Sainte-Croix, paye ta croix», dit le dicton du grimpeur autochtone… Une manière d’annoncer que si la falaise de Sainte-Croix est remarquable, c’est déjà par la difficulté de ses voies. En effet, sur ce petit site de couennes déversantes dans la haute difficulté, les croix ne se moissonnent pas dans les voies dont le style est exigeant dans la filière résistance courte, et intransigeant en lecture et en technique.Pour la petite histoire, la falaise de Sainte-Croix avait été pressentie pour organiser le championnat de France jeunes en 1995, mais en raison de sa trop petite taille, elle s’était fait piquer la vedette par le site de Baume Rousse (à Buis-les-Baronnies). Ainsi retoquée à la Nouvelle Star, elle n’est pas pour autant tombée dans l’oubli, grâce au flair d’infatigables et talentueux équipeurs, dont Jimmy Aunet, qui s’y sont consacrés dans les années 2000. Et le site devait vraiment avoir des atouts, car il s’est fait un nom en quelques années. Mais vu que ce n’est pas dû à la longueur des voies (réduite), ni à leur nombre (modeste), le vrai plus est ailleurs… Et hormis le rocher, la région du Diois risque fort de vous faire également succomber sous ses charmes dont le soleil, la douceur de vivre et la clairette ne sont pas des moindres.', 'France', 100, '3a', '9b', '30', 'Multiples', 'verdon_720x160.jpg', 'verdon_160x160.jpg', true,4);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image1, image2, is_mis_en_avant, detail_id)
VALUES (5,'Pont d’Espagne', 'Rien à grimper dans l’ouest? Archifaux. La preuve, avec ce bon petit spot de bloc bien connu des grimpeurs nantais. Située au carrefour des trois anciennes provinces que formaient l’Anjou, le Poitou et la Bretagne, la vallée de Clisson se situe à vingt-cinq minutes au sud de Nantes. On trouve là de nombreux blocs, bordés d’une frange de forêt le long de la Sèvre, au pied du château de Clisson. Un petit spot pour les amoureux du granit et du bloc. Mieux encore, le site de Clisson est loin de se faire élitiste, bien au contraire. Accueillant sous tous rapports, il est même une bonne façon de sortir grimper entre potes ou en famille. Clisson est vraiment sorti de l’ombre en 2003, lorsque Loïc Fossard et Simon Lelardoux, tombés sous le charme, décident de dynamiser le site. Aidés de quelques acharnés, ils brossent l’ensemble des blocs, dévoilent la plupart des passages et mettent en place un nouveau topo qui attire rapidement bon nombre de grimpeurs. Avec ses jolis problèmes made on granit, Clisson offre des passages de tous niveaux dans un cadre très agréable', 'France', 100, '3a', '7a', '20', 'Est', 'pont d_espagne-France_720x160.png', 'pont d_espagne-France_160x160.jpg', true,5);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image1, image2, is_mis_en_avant, detail_id)
VALUES (6,'Kalymnos', '« À Sainte-Croix, paye ta croix», dit le dicton du grimpeur autochtone… Une manière d’annoncer que si la falaise de Sainte-Croix est remarquable, c’est déjà par la difficulté de ses voies. En effet, sur ce petit site de couennes déversantes dans la haute difficulté, les croix ne se moissonnent pas dans les voies dont le style est exigeant dans la filière résistance courte, et intransigeant en lecture et en technique.Pour la petite histoire, la falaise de Sainte-Croix avait été pressentie pour organiser le championnat de France jeunes en 1995, mais en raison de sa trop petite taille, elle s’était fait piquer la vedette par le site de Baume Rousse (à Buis-les-Baronnies). Ainsi retoquée à la Nouvelle Star, elle n’est pas pour autant tombée dans l’oubli, grâce au flair d’infatigables et talentueux équipeurs, dont Jimmy Aunet, qui s’y sont consacrés dans les années 2000. Et le site devait vraiment avoir des atouts, car il s’est fait un nom en quelques années. Mais vu que ce n’est pas dû à la longueur des voies (réduite), ni à leur nombre (modeste), le vrai plus est ailleurs… Et hormis le rocher, la région du Diois risque fort de vous faire également succomber sous ses charmes dont le soleil, la douceur de vivre et la clairette ne sont pas des moindres.', 'Grèce', 100, '3a', '7a', '50', 'Multiples', 'kalymnos-grece_720x160.png', 'kalymnos-grece_160x160.jpg', true,6);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image1, image2, is_mis_en_avant, detail_id)
VALUES (7,'Siurana', 'Une magnifique région qui regorge de voies pour tous publics...', 'ESPAGNE', 100, '3a', '4a', '50', 'Multiples', 'siurana-espagne_720x160.png', 'siurana-espagne_160x160.jpg', true,7);

UPDATE site_description SET
latitude=45.832622,
longitude=6.865175,
titre1='Caractéristiques techniques',
contenu1='Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.
Best of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>',
titre2='Accès',
contenu2='Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.
Quand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.',
titre3 = 'Hébergement',
contenu3='Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>'
WHERE id=1;

UPDATE site_description SET
latitude=29.5725643764,
longitude=35.4186216588,
titre1='Caractéristiques techniques',
contenu1='Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.
Best of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>',
titre2='Accès',
contenu2='Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.
Quand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.',
titre3 = 'Hébergement',
contenu3='Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>'
WHERE id=2;

 UPDATE site_description SET
titre1='Caractéristiques techniques',
contenu1='Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.
Best of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>',
titre2='Accès',
contenu2='Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.
Quand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.',
titre3 = 'Hébergement',
contenu3='Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>'
WHERE id=3;

UPDATE site_description SET
titre1='Caractéristiques techniques',
contenu1='Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.
Best of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>',
titre2='Accès',
contenu2='Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.
Quand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.',
titre3 = 'Hébergement',
contenu3='Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>'
WHERE id=4;

UPDATE site_description SET
latitude=42.85222,
longitude=-0.145778,
titre1='Caractéristiques techniques',
contenu1='Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.
Best of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>',
titre2='Accès',
contenu2='Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.
Quand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.',
titre3 = 'Hébergement',
contenu3='Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>'
WHERE id=5;

UPDATE site_description SET
titre1='Caractéristiques techniques',
contenu1='Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.
Best of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>',
titre2='Accès',
contenu2='Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.
Quand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.',
titre3 = 'Hébergement',
contenu3='Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>'
WHERE id=6;

UPDATE site_description SET
titre1='Caractéristiques techniques',
contenu1='Granit de très bonne qualité, avec un grain de folie qui a conservé toute sa matière: des gros cristaux parfois, mais aussi du grain plus fin à d’autres endroits. Aucun bloc patiné, le granit est flambant neuf. Tout cela est parsemé de réglettes caractéristiques (de la très grosse à la minuscule, avec ou sans grain), plats (surtout dans les sorties), bacs, grosses écailles, knobs, fentes et grattons. Une bonne partie des blocs offre un profil situé entre vertical et léger dévers. <p>Il y a aussi quelques toits caractéristiques, surtout dans le 8, des dalles retorses, bien représentées dans le 7, et quelques jetés sympas. La grande variété de prises et de styles d’escalade permet de varier les préhensions à l’infini, selon les envies (ou possibilités physiques…) du moment.</p> Les blocs sont répartis en dix-sept secteurs presque tous regroupés sur quatre kilomètres de long, avec une concentration de blocs déments impressionnante, et ce dans tous les niveaux. Un grand nombre de (vrais) blocs faciles (400 passages entre 4+ et 6b), pour l’échauffement, le projet du jour ou l’initiation.
Best of Toits en 8: «I shot Sarconasy», «Psoas mole», «Le tombeau». Dalles en 7: «Loby One», «Flagellum daemonium». Blocs faciles mais intéressants: «Hey Yop», 5+ / « Ambiance montagne», 6a+. <p>Les classiques réputées (parce qu’elles le valent bien, comme le shampoing): «La baleine», 7a / « Rébellion», 6c / « Bottant Botton», 7b / « Nazgul», 7c / « Sdabaow», 8a+</p>',
titre2='Accès',
contenu2='Le spot est situé dans les Pyrénées Orientales, près de la station de Font-Romeu, à quinze minutes de l’Espagne. Compter 3h depuis Montpellier, 2h 30 depuis Toulouse, 1h 30 depuis Perpignan. Entre cinq et quinze minutes maximum de marche, les premiers blocs sont juste à côté de la voiture.
Quand y aller? Meilleure période: On peut grimper toute l’année, bien se renseigner entre janvier et mars sur l’état de l’enneigement. Le chaos est un site d’altitude, on peut donc y trouver des conditions correctes les soirs d’été, mais préférez globalement les mois d’avril, mai, septembre et octobre pour des températures plus propices à l’escalade.',
titre3 = 'Hébergement',
contenu3='Ce n’est pas ce qui manque dans la vallée de Chamonix. Campings, hôtels, chambres d’hôtes, meublés à louer en passant par les restos, sandwicheries, McDo… Et selon l’endroit, vous pourrez même prendre des cours d’anglais avec la réceptionniste. De tout à tous les prix, mais réservation quasi impérative pour la saison estivale. <a href="http://www.chamonix.com">Office de tourisme de Chamonix</a>'
WHERE id=7;


INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, '6a Max Dauphiné', 'Une sélection d’escalades de 4+ à 6a en Dauphiné', '', 'libre', 'topo_1.jpg', 3);

INSERT INTO topo_sites (topo_id, sites_id)
VALUES (1, 1);

INSERT INTO topo_sites (topo_id, sites_id)
VALUES (1, 2);


INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, 'Avignon Soleil', 'Une sélection d’escalades de 4+ à 6a en Dauphiné', '', 'libre', 'topo_2.jpg', 3);

INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, 'El Pirineo Occidental', 'Une sélection d’escalades deans les pyrénées occidentales', '', 'libre', 'topo_3.jpg', 3);

INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, 'Corsica Bloc', 'Une sélection d’escalades en Corse', '', 'libre', 'topo_4.jpg', 4);

INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, 'Escalar en España', 'Une sélection d’escalades en Corse', '', 'libre', 'topo_5.jpg', 4);

INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, 'Dolomites', 'Une sélection d’escalades dans les Dolomites', '', 'libre', 'topo_6.jpg', 4);

INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, 'Envers des aiguilles', 'Les voies des Aiguilles Rouges', '', 'libre', 'topo_7.jpg', 5);

INSERT INTO topo (id, titre, description, nom_ressource, statut, image1, preteur_id)
VALUES (hibernate_sequence.nextval, 'Escalada en Castelion', 'Une sélection d’escalades en Corse', '', 'libre', 'topo_8.jpg', 5);