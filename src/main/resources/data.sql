
INSERT INTO commentaire (id, contenu, creation_date, auteur_id)
VALUES (1, 'Super site. Je vous le recommande! J y suis allé l année dernière et c etait genial!', '2019-01-10 10:00:00', 3);

INSERT INTO commentaire (id, contenu, creation_date, auteur_id)
VALUES (2, 'Je confirme!', '2019-01-01 10:00:00', 3);

INSERT INTO site_description (id) VALUES (1);
INSERT INTO site_description (id) VALUES (2);
INSERT INTO site_description (id) VALUES (3);
INSERT INTO site_description (id) VALUES (4);
INSERT INTO site_description (id) VALUES (5);
INSERT INTO site_description (id) VALUES (6);
INSERT INTO site_description (id) VALUES (7);

INSERT INTO site_description_commentaires (site_description_id, commentaires_id)
VALUES (1,1); 

INSERT INTO site_description_commentaires (site_description_id, commentaires_id)
VALUES (1,2); 



INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image_url, is_mis_en_avant, detail_id)
VALUES (1,'Vallée de Chamonix', 'Une magnifique région qui regorge de voies pour tous publics...', 'FRANCE', 100, '4a', '9b', '30', 'Multiples', 'mont-blanc_720x160.jpg', true,1);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image_url, is_mis_en_avant, detail_id)
VALUES (2,'Wadi Rum', 'Une magnifique région qui regorge de voies pour tous publics...', 'JORDANIE', 100, '3a', '8a', '30', 'Multiples', 'wadi-rum_jordanie_720x160.jpg', true,2);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image_url, is_mis_en_avant, detail_id)
VALUES (3,'Antalya', 'Une magnifique région qui regorge de voies pour tous publics...', 'TURQUIE', 100, '3a', '9b', '30', 'Multiples', 'turkey_720x160.jpg', true,3);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image_url, is_mis_en_avant, detail_id) 
VALUES (4,'Gorges du Verdon', 'Une magnifique région qui regorge de voies pour tous publics...', 'FRANCE', 100, '3a', '9b', '30', 'Multiples', 'verdon_720x160.jpg', true,4);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image_url, is_mis_en_avant, detail_id) 
VALUES (5,'Pont d\'Espagne', 'Une magnifique région qui regorge de voies pour tous publics...', 'FRANCE', 100, '3a', '7a', '20', 'Est', 'pont d\'espagne-France_720x160.png', true,5);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image_url, is_mis_en_avant, detail_id) 
VALUES (6,'Kalymnos', 'Une magnifique région qui regorge de voies pour tous publics...', 'GRECE', 100, '3a', '7a', '50', 'Multiples', 'kalymnos-grece_720x160.png', true,6);

INSERT INTO site (id, nom, description, pays, hauteur, cotation_min, cotation_max, nb_de_voies, orientation, image_url, is_mis_en_avant, detail_id) 
VALUES (7,'Siurana', 'Une magnifique région qui regorge de voies pour tous publics...', 'ESPAGNE', 100, '3a', '4a', '50', 'Multiples', 'siurana-espagne_720x160.png', true,7);







