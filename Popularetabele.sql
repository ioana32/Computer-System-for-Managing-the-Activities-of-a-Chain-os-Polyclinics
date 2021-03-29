INSERT INTO angajat VALUES 
(0001,'medic rezident ',5000,8),-- Ioana
(0020,'medic specialist',6000,8),
(0013,'medic generalist',1000,8),
(0014,'medic primar',8000,8),
(0002,'asistent interdependent',4000,8),
(0008,'asistent dependent',3500,8),

(0031,'medic rezident',5060,8),-- Ale
(0026,'administrator sef',7200,8),
(0010,'asistent interdependent',3800,8),
(0003,'asistent dependent',2500,6),
(0015,'asitent administrator resurse',3850,4),

(5,'superadministrator policlinica',2500,4),-- Pele
(6,'asistent administrator ',2000,4),
(7,'administrator economic',3000,8),
(9,'receptioner sef',2500,8),
(11,'receptioner zi',2500,8),
(12,'receptioner noapte',2500,8),
(16,' asistent resurse',3500,6);
INSERT INTO utilizatori VALUES
(1,'medic','medic1',2798521,'Popescu','Andrei','Iasi','078513699','dr_Popescu@yahoo.ro','3654298',1,'2007-4-8',NULL,NULL,'DA',0001),-- Ioana
(20,'medic','medic20',272721,'Grecu','Alexandra','Cluj','078513699','dr_Grecu@yahoo.ro','365782',20,'2010-3-8',NULL,NULL,'DA',0020),
(13,'medic','medic13',2638421,'Grigore','Maria','Tg. Mures','078513699','dr_Grigore@yahoo.ro','4521298',13,'2020-4-9',NULL,NULL,'NU',0013),
(14,'medic','medic14',1782021,'Popa','Ion','Bucuresti','078513699','dr_Popa@yahoo.ro','30472',14,'2015-12-12',NULL,NULL,'DA',0014),
(2,'asistent','ast1',30756258,'Grigore','Stefana','Iasi','0746201726','ast_Stefana@yahoo.ro','367528',2,'2007-10-11',NULL,NULL,'DA',0002),
(8,'asistent','ast8',54224,'Costin','Ilaria','Cluj','0744698786','ast_Ilaria@yahoo.ro','376318',8,'2020-10-11',NULL,NULL,'NU',0008),
(31,'medic','medic31',1632145,'Vascu','Tudor','Cluj','0745632159','VascuTudor@gmail.ro','6541234',31,'2010-4-18',NULL,NULL,'NU',0031),-- Ale
(26,'admin','medic26',2267453,'Alb','Teodora','Cluj','0772653988','Alb.Teodora@gmail.ro','4563552',26,'2009-12-3',NULL,NULL,'DA',0026),
(10,'asistent','asistent10',2311256,'Muresan','Ioana','Iasi','0732551012','MuresanIoana@yahoo.ro','3211085',10,'2015-7-10',NULL,NULL,'DA',0010),
(3,'asistent','asistent3',1051217,'Stoica','Alexandru','Bucuresti','0755123649','StoicaAlexandru@yahoo.ro','4011563',3,'2010-6-25',NULL,NULL,'DA',0003),
(15,'resurse','resurse15',11103540,'Toria','George','Cluj','0724523309','Toria.George@gmail.ro','3259770',15,'2009-2-20',NULL,NULL,'NU',0015),
(5,'superadmin','spadm5',1656698,'Pop','Tudor','Cluj','0745232159','PopTudor@gmail.ro','2312312',5,'2014-4-12',NULL,NULL,'DA',5),-- Pele
(6,'admin','adm6',2131231,'Moldovan','Alex','Bucuresti','0723232229','MoldovanAlex@gmail.ro','324234',6,'2016-5-12',NULL,NULL,'NU',6),
(7,'economic','eco7',2343234,'Coroian','Rebrca','Iasi','0745232121','CoroianR@gmail.ro','231123',7,'2013-2-19',NULL,NULL,'NU',7),
(9,'receptioner','recep9',123123,'Ferenc','Tudor','Cluj','0743423232','FerencTudor@gmail.ro','564564456',9,'2017-8-12',NULL,NULL,'NU',9),
(11,'receptioner','recep11',11241324,'Peles','Ioan','Bucuresti','0745277759','PelesIoan@gmail.ro','42234',11,'2013-4-12',NULL,NULL,'DA',11),
(12,'receptioner','recep12',1231246,'Chirtos','Mara','Iasi','0745232159','ChirtosMara@gmail.ro','45345232',12,'2012-6-13',NULL,NULL,'NU',12),
(16,'resurse','resurse16',345456,'Baum','Andreea','Cluj','0765232459','BaumAndreea@gmail.ro','9797862',16,'2018-5-15',NULL,NULL,'NU',16);

INSERT INTO medic VALUES
(1,'cardiologie','specialist',365,'chirurgie','DA','conferentiar',70.0,0001),-- Ioana
(20,'neurologie','primar',380,'explorare CT','DA','conferentiar',50.0,0020),
(13,'ortopedie','specialist',1250,'chirurgie','DA','profesor',60.0,0013),
(14,'pediatrie','primar',700,'oncologie pediadrica','DA','profesor',85.5,0014),
(31,'neurologie','specialist',315,'chirurgie','DA','conferentiar',81.0,0031); -- Ale

INSERT INTO asistent_medical VALUES 
(1,'generalist','secundar',0002,1),-- Ioana
(2,'laborator','principal',0008,20),
(10,'laborator','principal',0010,31),-- Ale
(3,'laborator','secundar',0003,31);

INSERT INTO pacienti VALUES
(9,'alergii de tipul 4','Rozaceea','Stanga','Robert','1998-9-17','m','Cluj','maghiara','NU'),
 (1,NULL,NULL,'Ionescu','Valentin','1970-02-05','m','Iasi','romana','DA'),-- Ioana
 (2,NULL,NULL,'Radu','Tudor','1963-09-18','m','Cluj','romana','DA'),
 (3,NULL,NULL,'Cristea','Rares','2000-12-05','f','Tg. Mures','romana','DA'),
 (4,NULL,NULL,'Berghi','Sofia','1999-02-10','f','Bucuresti','italiana','NU'),
(5,NULL,NULL,'Pop','Cosmin','1977-5-12','m','Cluj','romana','DA'),  -- Ale
(6,NULL,NULL,'Stanga','Robert','1980-9-17','m','Cluj','maghiara','NU'),
(7,NULL,NULL,'Serban','Casandra','1957-08-20','f','Bucuresti','romana','DA'),
(8,'alergii de tipul 1','insuficienta cardiaca','Albu','Cosmina','2002-7-13','f','Bistrita','romana','DA'),  -- Pele

(10,'alergii alimentare','hipertensiune arteriala','Sos','Maria','2003-10-20','f','Bucuresti','romana','DA');


INSERT INTO unitati_medicale VALUES -- Ioana
(1,'UnitASI','Iasi'),
(2,'UnitCLUJ','Cluj'),
(3,'UnitMures','Tg. Mures'),
(4,'UnitBuc','Bucuresti');

INSERT INTO program VALUES -- Ale
(1,'2021-01-01',8,22,1), -- unit 1
(2,'2021-01-02',8,22,1), 
(3,'2021-01-03',8,22,1), 
(4,'2021-01-04',8,22,1), 
(5,'2021-01-05',8,22,1), 
(6,'2021-01-06',8,22,1), 
(7,'2021-01-07',8,22,1), 
(8,'2021-01-08',9,22,1), 
(9,'2021-01-09',9,22,1), 
(10,'2021-01-10',8,22,1), 
(11,'2021-01-11',8,22,1), 
(12,'2021-01-12',8,22,1), 
(13,'2021-01-13',8,22,1), 
(14,'2021-01-14',8,22,1), 
(15,'2021-01-15',8,22,1), 
(16,'2021-01-16',8,22,1), 
(17,'2021-01-17',8,22,1), 
(18,'2021-01-18',8,22,1), 
(19,'2021-01-19',8,22,1), 
(20,'2021-01-20',8,22,1), 
(21,'2021-01-21',8,22,1), 
(22,'2021-01-22',8,22,1), 
(23,'2021-01-23',8,22,1), 
(24,'2021-01-24',8,22,1), 
(25,'2021-01-25',8,22,1), 
 (26,'2021-01-26',8,22,1), 
 (27,'2021-01-27',8,22,1), 
 (28,'2021-01-28',8,22,1), 
 (29,'2021-01-29',8,22,1), 
 (30,'2021-01-30',8,22,1), 
 (31,'2021-01-30',8,22,1), 
 
(32,'2021-01-01',8,16,2), -- unit 2
(33,'2021-01-02',8,16,2),
(34,'2021-01-03',8,16,2),
(35,'2021-01-04',8,16,2),
(36,'2021-01-05',8,16,2),
(37,'2021-01-06',8,16,2),
(38,'2021-01-07',8,16,2),
(39,'2021-01-08',8,16,2),
(40,'2021-01-09',8,16,2),
(41,'2021-01-10',8,16,2),
(42,'2021-01-11',8,16,2),
(43,'2021-01-12',8,16,2),
(44,'2021-01-13',8,16,2),
(45,'2021-01-14',8,16,2),
(46,'2021-01-15',8,16,2),
(47,'2021-01-16',8,16,2), 
(48,'2021-01-17',8,16,2),
(49,'2021-01-18',8,16,2),
(50,'2021-01-19',8,16,2),
(51,'2021-01-20',8,16,2),
(52,'2021-01-21',8,16,2),
(53,'2021-01-22',8,16,2),
(54,'2021-01-23',8,16,2),
(55,'2021-01-24',8,16,2),
(56,'2021-01-25',8,16,2),
(57,'2021-01-26',8,16,2),
(58,'2021-01-27',8,16,2),
(59,'2021-01-28',8,16,2),
(60,'2021-01-29',8,16,2),
(61,'2021-01-30',8,16,2),
(62,'2021-01-31',8,16,2),

(63,'2021-01-01',9,17,3), -- unit 3
(64,'2021-01-02',9,17,3),
(65,'2021-01-03',9,17,3),
(66,'2021-01-04',9,17,3),
(67,'2021-01-05',9,17,3),
(68,'2021-01-06',9,17,3),
(69,'2021-01-07',9,17,3),
(70,'2021-01-08',9,17,3),
(71,'2021-01-09',9,17,3),
(72,'2021-01-10',9,17,3),
(73,'2021-01-11',9,17,3),
(74,'2021-01-12',9,17,3),
(75,'2021-01-13',9,17,3),
(76,'2021-01-14',9,17,3),
 (77,'2021-01-15',10,15,3), 
 (78,'2021-01-16',10,15,3),
 (79,'2021-01-17',10,15,3),
 (80,'2021-01-18',10,15,3),
 (81,'2021-01-19',14,22,3),
 (82,'2021-01-20',14,22,3),
 (83,'2021-01-21',10,15,3),
 (84,'2021-01-22',9,15,3),
 (85,'2021-01-23',9,15,3),
 (86,'2021-01-24',10,15,3),
 (87,'2021-01-25',10,15,3),
 (88,'2021-01-26',14,22,3),
 (89,'2021-01-27',14,22,3),
 (90,'2021-01-28',14,22,3),
 (91,'2021-01-29',10,15,3),
 (92,'2021-01-30',10,23,3), 
 (93,'2021-01-31',10,23,3);

INSERT INTO programangajati VALUES
(1,0001,'2021-01-01',null,null,1,1), -- medic 1
(2,0001,'2021-01-02',8,16,1,0), 
(3,0001,'2021-01-03',8,16,1,0), 
(4,0001,'2021-01-04',8,16,1,0), 
(5,0001,'2021-01-04',18,22,1,0),
(6,0001,'2021-01-05',8,16,1,0),
(7,0001,'2021-01-06',8,16,1,0),
(8,0001,'2021-01-07',8,16,1,0),
(9,0001,'2021-01-08',8,16,1,0),
(10,0001,'2021-01-09',8,16,1,0),
(11,0001,'2021-01-10',8,16,1,0),
(12,0001,'2021-01-11',8,16,1,0),
(13,0001,'2021-01-12',8,16,1,0),
(14,0001,'2021-01-13',8,16,1,0),
(15,0001,'2021-01-14',8,16,1,0),
(16,0001,'2021-01-15',8,16,1,0),

(17,0020,'2021-01-01',8,16,2,0), -- medic 20
(18,0020,'2021-01-02',8,16,2,0),
(19,0020,'2021-01-03',8,16,2,0),
(20,0020,'2021-01-04',8,16,2,0),
(21,0020,'2021-01-05',8,16,2,0),
(22,0020,'2021-01-06',8,16,2,0),
(23,0020,'2021-01-07',8,16,2,0),
(24,0020,'2021-01-08',8,16,2,0),
(25,0020,'2021-01-09',8,16,2,0),
(26,0020,'2021-01-10',8,16,2,0),
(27,0020,'2021-01-11',8,16,2,0),
(28,0020,'2021-01-12',8,16,2,0),
(29,0020,'2021-01-13',8,16,2,0),
(30,0020,'2021-01-14',8,16,2,0),
(31,0020,'2021-01-15',8,16,2,0),

(32,0002,'2021-01-01',8,16,2,0), -- asistent 2
(33,0002,'2021-01-02',8,16,2,0),
(34,0002,'2021-01-03',8,16,2,0),
(35,0002,'2021-01-04',8,16,2,0),
(36,0002,'2021-01-05',8,16,2,0),
(37,0002,'2021-01-06',8,16,2,0),
(38,0002,'2021-01-07',8,16,2,0),
(39,0002,'2021-01-08',8,16,2,0),
(40,0002,'2021-01-09',8,16,2,0),
(41,0002,'2021-01-10',8,16,2,0),
(42,0002,'2021-01-11',8,16,2,0),
(43,0002,'2021-01-12',8,16,2,0),
(44,0002,'2021-01-13',8,16,2,0),
(45,0002,'2021-01-14',8,16,2,0),
(46,0002,'2021-01-15',8,16,2,0),

(47,0008,'2021-01-01',8,16,1,0), -- asistent 8
(48,0008,'2021-01-02',8,16,1,0),
(49,0008,'2021-01-03',8,16,1,0),
(50,0008,'2021-01-04',8,16,1,0),
(51,0008,'2021-01-05',8,16,1,0),
(52,0008,'2021-01-06',8,16,1,0),
(53,0008,'2021-01-07',8,16,1,0),
(54,0008,'2021-01-08',8,16,1,0),
(55,0008,'2021-01-09',8,16,1,0),
(56,0008,'2021-01-10',8,16,1,0),
(57,0008,'2021-01-11',8,16,1,0),
(58,0008,'2021-01-12',8,16,1,0),
(59,0008,'2021-01-13',8,16,1,0),
(60,0008,'2021-01-14',8,16,1,0),
(61,0008,'2021-01-15',8,16,1,0),

(62,0013,'2021-01-01',9,17,3,0), -- medic 13
(63,0013,'2021-01-02',9,17,3,0),
(64,0013,'2021-01-03',9,17,3,0),
(65,0013,'2021-01-04',9,17,3,0),
(66,0013,'2021-01-05',9,17,3,0),
(67,0013,'2021-01-06',9,17,3,0),
(68,0013,'2021-01-07',9,17,3,0),
(69,0013,'2021-01-08',9,17,3,0),
(70,0013,'2021-01-09',9,17,3,0),
(71,0013,'2021-01-10',9,17,3,0),
(72,0013,'2021-01-11',9,17,3,0),
(73,0013,'2021-01-12',9,17,3,0),
(74,0013,'2021-01-13',9,17,3,0),
(75,0013,'2021-01-14',9,17,3,0),
(76,0013,'2021-01-15',9,17,3,0),

 (77,0014,'2021-01-01',10,15,4,0), -- medic 14
 (78,0014,'2021-01-02',10,15,4,0),
 (79,0014,'2021-01-03',10,15,4,0),
 (80,0014,'2021-01-04',10,15,4,0),
 (81,0014,'2021-01-05',14,22,4,0),
 (82,0014,'2021-01-06',14,22,4,0),
 (83,0014,'2021-01-07',10,15,4,0),
 (84,0014,'2021-01-08',null,15,4,1),
 (85,0014,'2021-01-09',null,15,4,1),
 (86,0014,'2021-01-10',10,15,4,0),
 (87,0014,'2021-01-11',10,15,4,0),
 (88,0014,'2021-01-12',14,22,4,0),
 (89,0014,'2021-01-13',14,22,4,0),
 (90,0014,'2021-01-14',14,22,4,0),
 (91,0014,'2021-01-15',10,15,4,0),
 
 (92,0031,'2021-01-01',null,null,1,1), -- medic 31
 (93,0031,'2021-01-02',null,null,1,1),
 (94,0031,'2021-01-03',12,18,1,0),
 (95,0031,'2021-01-04',12,18,1,0),
 (96,0031,'2021-01-05',12,18,1,0),
 (97,0031,'2021-01-06',12,18,1,0),
 (98,0031,'2021-01-07',12,18,1,0),
 (99,0031,'2021-01-08',12,18,1,0),
 (100,0031,'2021-01-09',12,18,1,0),
 (101,0031,'2021-01-10',12,18,1,0),
 (102,0031,'2021-01-11',12,18,1,0),
 (103,0031,'2021-01-12',12,18,1,0),
 (104,0031,'2021-01-13',12,18,1,0),
 (105,0031,'2021-01-14',12,18,1,0),
 (106,0031,'2021-01-15',12,18,1,0),
 
 (107,0026,'2021-01-01',9,17,2,0), -- admin 26
 (108,0026,'2021-01-02',9,17,2,0),
 (109,0026,'2021-01-03',9,17,2,0),
 (110,0026,'2021-01-04',9,17,2,0),
 (111,0026,'2021-01-05',9,17,2,0),
 (112,0026,'2021-01-06',9,17,2,0),
 (113,0026,'2021-01-07',9,17,2,0),
 (114,0026,'2021-01-08',9,17,2,0),
 (115,0026,'2021-01-09',9,17,2,0),
 (116,0026,'2021-01-10',9,17,2,0),
 (117,0026,'2021-01-11',9,17,2,0),
 (118,0026,'2021-01-12',9,17,2,0),
 (119,0026,'2021-01-13',9,17,2,0),
 (120,0026,'2021-01-14',9,17,2,0),
 (121,0026,'2021-01-15',9,17,2,0),
 
 (122,0010,'2021-01-01',9,17,1,0), -- asistent 10
 (123,0010,'2021-01-02',9,17,1,0),
 (124,0010,'2021-01-03',9,17,1,0), 
 (125,0010,'2021-01-04',9,17,1,0),
 (126,0010,'2021-01-05',9,17,1,0),
 (127,0010,'2021-01-06',9,17,1,0),
 (128,0010,'2021-01-07',9,17,1,0),
 (129,0010,'2021-01-08',9,17,1,0),
 (130,0010,'2021-01-09',9,17,1,0),
 (131,0010,'2021-01-10',9,17,1,0),
 (132,0010,'2021-01-11',9,17,1,0),
 (133,0010,'2021-01-12',9,17,1,0),
 (134,0010,'2021-01-13',9,17,1,0),
 (135,0010,'2021-01-14',9,17,1,0),
 (136,0010,'2021-01-15',9,17,1,0),
 
 (137,0003,'2021-01-01',12,18,1,0), -- asistent 3
 (138,0003,'2021-01-02',12,18,1,0),
 (139,0003,'2021-01-03',12,18,1,0),
 (140,0003,'2021-01-04',12,18,1,0),
 (141,0003,'2021-01-05',12,18,1,0),
 (142,0003,'2021-01-06',12,18,1,0),
 (143,0003,'2021-01-07',12,18,1,0),
 (144,0003,'2021-01-08',12,18,1,0),
 (145,0003,'2021-01-09',12,18,1,0),
 (146,0003,'2021-01-10',12,18,1,0),
 (147,0003,'2021-01-11',12,18,1,0),
 (148,0003,'2021-01-12',12,18,1,0),
 (149,0003,'2021-01-13',12,18,1,0),
 (150,0003,'2021-01-14',12,18,1,0),
 (151,0003,'2021-01-15',12,18,1,0),
 
 (152,0015,'2021-01-01',8,12,3,0), -- resurse 15 inspector
 (153,0015,'2021-01-02',8,12,3,0),
 (154,0015,'2021-01-03',8,12,3,0),
 (155,0015,'2021-01-04',8,12,3,0),
 (156,0015,'2021-01-05',8,12,3,0),
 (157,0015,'2021-01-06',8,12,3,0),
 (158,0015,'2021-01-07',8,12,3,0),
 (159,0015,'2021-01-08',8,12,3,0),
 (160,0015,'2021-01-09',8,12,3,0),
 (161,0015,'2021-01-10',8,12,3,0),
 (162,0015,'2021-01-11',8,12,3,0),
 (163,0015,'2021-01-12',8,12,3,0),
 (164,0015,'2021-01-13',8,12,3,0),
 (165,0015,'2021-01-14',8,12,3,0),
 (166,0015,'2021-01-15',8,12,3,0),
 
 (167,5,'2021-01-01',10,14,4,0), -- super admin 5
 (168,5,'2021-01-02',10,14,4,0),
 (169,5,'2021-01-03',10,14,4,0),
 (170,5,'2021-01-04',10,14,4,0),
 (171,5,'2021-01-05',10,14,4,0),
 (172,5,'2021-01-06',10,14,4,0),
 (173,5,'2021-01-07',10,14,4,0),
 (174,5,'2021-01-08',10,14,4,0),
 (175,5,'2021-01-09',10,14,4,0),
 (176,5,'2021-01-10',10,14,4,0),
 (177,5,'2021-01-11',10,14,4,0),
 (178,5,'2021-01-12',10,14,4,0),
 (179,5,'2021-01-13',10,14,4,0),
 (180,5,'2021-01-14',10,14,4,0),
 (181,5,'2021-01-15',10,14,4,0),
 
 (182,6,'2021-01-01',10,16,3,0), -- admin 6
 (183,6,'2021-01-02',12,16,3,0),
 (184,6,'2021-01-03',12,16,3,0),
 (185,6,'2021-01-04',12,16,3,0),
 (186,6,'2021-01-05',12,16,3,0),
 (187,6,'2021-01-06',12,16,3,0),
 (188,6,'2021-01-07',12,16,3,0),
 (189,6,'2021-01-08',12,16,3,0),
 (190,6,'2021-01-09',12,16,3,0),
 (191,6,'2021-01-10',12,16,3,0),
 (192,6,'2021-01-11',12,16,3,0),
 (193,6,'2021-01-12',12,16,3,0),
 (194,6,'2021-01-13',12,16,3,0),
 (195,6,'2021-01-14',12,16,3,0),
 (196,6,'2021-01-15',12,16,3,0),
 
 (197,7,'2021-01-01',11,17,1,0), -- economic 7
 (198,7,'2021-01-02',11,17,1,0),
 (199,7,'2021-01-03',11,17,1,0),
 (200,7,'2021-01-04',11,17,1,0),
 (201,7,'2021-01-05',11,17,1,0),
 (202,7,'2021-01-06',11,17,1,0),
 (203,7,'2021-01-07',11,17,1,0),
 (204,7,'2021-01-08',11,17,1,0),
 (205,7,'2021-01-09',11,17,1,0),
 (206,7,'2021-01-10',11,17,1,0),
 (207,7,'2021-01-11',11,17,1,0),
 (208,7,'2021-01-12',11,17,1,0),
 (209,7,'2021-01-13',11,17,1,0),
 (210,7,'2021-01-14',11,17,1,0),
 (211,7,'2021-01-15',11,17,1,0),

 (212,9,'2021-01-01',08,16,2,0), -- receptioner 9
 (213,9,'2021-01-02',08,16,2,0),
 (214,9,'2021-01-03',08,16,2,0),
 (215,9,'2021-01-04',08,16,2,0),
 (216,9,'2021-01-05',08,16,2,0),
 (217,9,'2021-01-06',08,16,2,0),
 (218,9,'2021-01-07',08,16,2,0),
 (219,9,'2021-01-08',08,16,2,0),
 (220,9,'2021-01-09',08,16,2,0),
 (221,9,'2021-01-10',08,16,2,0),
 (222,9,'2021-01-11',08,16,2,0),
 (223,9,'2021-01-12',08,16,2,0),
 (224,9,'2021-01-13',08,16,2,0),
 (225,9,'2021-01-14',08,16,2,0),
 (226,9,'2021-01-15',08,16,2,0),
 
 (227,11,'2021-01-01',10,18,3,0), -- receptioner 11
 (228,11,'2021-01-02',10,18,3,0),
 (229,11,'2021-01-03',10,18,3,0),
 (230,11,'2021-01-04',10,18,3,0),
 (231,11,'2021-01-05',10,18,3,0),
 (232,11,'2021-01-06',10,18,3,0),
 (233,11,'2021-01-07',10,18,3,0),
 (234,11,'2021-01-08',10,18,3,0),
 (235,11,'2021-01-09',10,18,3,0),
 (236,11,'2021-01-10',10,18,3,0),
 (237,11,'2021-01-11',10,18,3,0),
 (238,11,'2021-01-12',10,18,3,0),
 (239,11,'2021-01-13',10,18,3,0),
 (240,11,'2021-01-14',10,18,3,0),
 (241,11,'2021-01-15',10,18,3,0),
 
 (242,12,'2021-01-01',11,19,4,0), -- receptioner 12 
 (243,12,'2021-01-02',11,19,4,0),
 (244,12,'2021-01-03',11,19,4,0),
 (245,12,'2021-01-04',11,19,4,0),
 (246,12,'2021-01-05',11,19,4,0),
 (247,12,'2021-01-06',11,19,4,0),
 (248,12,'2021-01-07',11,19,4,0),
 (249,12,'2021-01-08',11,19,4,0),
 (250,12,'2021-01-09',11,19,4,0),
 (251,12,'2021-01-10',11,19,4,0),
 (252,12,'2021-01-11',11,19,4,0),
 (253,12,'2021-01-12',11,19,4,0),
 (254,12,'2021-01-13',11,19,4,0),
 (255,12,'2021-01-14',11,19,4,0),
 (256,12,'2021-01-15',11,19,4,0),
 
 
 (257,16,'2021-01-01',14,20,1,0), -- resurse 16
 (258,16,'2021-01-02',14,20,1,0),
 (259,16,'2021-01-03',14,20,1,0),
 (260,16,'2021-01-04',14,20,1,0),
 (261,16,'2021-01-05',14,20,1,0),
 (262,16,'2021-01-06',14,20,1,0),
 (263,16,'2021-01-07',14,20,1,0),
 (264,16,'2021-01-08',14,20,1,0),
 (265,16,'2021-01-09',14,20,1,0),
 (266,16,'2021-01-10',14,20,1,0),
 (267,16,'2021-01-11',14,20,1,0),
 (268,16,'2021-01-12',14,20,1,0),
 (269,16,'2021-01-13',14,20,1,0),
 (270,16,'2021-01-14',14,20,1,0),
 (271,16,'2021-01-15',14,20,1,0);

INSERT INTO servicii VALUES
 (1,'cardiologie','specialist',100,60,'ecograf'), -- Ioana
 (2,'cardiologie','primar',200,60,'holter'),
 (3,'neurologie','specialist',100,60,'CT'),
 (4,'pediatrie','specialist',100,60,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (5,'ortopedie','primar',100,60,'punere ghips');

INSERT INTO cabinete VALUES 
 (1,1,1,'ecograf'), -- Ioana
 (2,2,1,'ecograf'),
 (3,1,1,'ecograf,holter'),
 (4,3,1,'ecograf'),
 (5,4,1,'ecograf'),
 (6,1,1,'holter'), -- Pele
 (7,1,20,'CT'),
 (8,1,13,'punere ghips'),
  (9,2,14,'holter'), 
 (10,2,20,'CT'),
 (11,2,13,'punere ghips'),
  (12,3,1,'holter'), 
 (13,3,31,'CT'),
 (14,3,13,'punere ghips'),
  (15,4,1,'holter'), 
 (16,4,31,'CT'),
 (17,1,14,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (18,2,14,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (19,3,14,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru'),
 (20,4,14,'Stetoscop si tensiometru,Ciocan reflexe,Oglinda frontala,Cantari pentru sugari,Pediometru,Taliometru');
INSERT INTO programari VALUES 
(1,1,1,0,0,8,9,'2020-10-12',1,1,1); -- Ioana

 

/*INSERT INTO istoricbonuri VALUES 
(1,1,100) -- Ioana
(2,2,100),
(3,3,100),
(4,4,100),
(5,5,100),
(6,6,200), -- Pele
(7,7,300),
(8,8,500)*/;

INSERT INTO istoric_salariu VALUES
(1,1,'2007-04-08',3000), (2,1,'2010-04-08',3500), (3,1,'2015-04-08',4250),(4,1,'2020-04-08',5000),
(5,2,'2007-10-11',1500), (6,2,'2014-10-11',3000), (7,2,'2020-10-11',4000),
(8,3,'2010-06-25',2500),
(9,5,'2014-04-12',2500),
(10,6,'2016-05-12',2000),
(11,7,'2013-02-19',3000),
(12,8,'2020-10-11',3500),
(13,9,'2017-08-12',2500),
(14,10,'2015-07-10',3800),
(15,11,'2013-04-12',2500),
(16,12,'2012-06-13',2500),
(17,13,'2020-04-09',1000),
(18,14,'2015-12-12',8000),
(19,15,'2009-02-20',3850),
(20,16,'2018-05-15',3500),
(21,20,'2010-03-08',6000),
(22,26,'2009-12-03',7200),
(23,31,'2018-11-01',5060);
/*INSERT INTO raport_medical VALUES 
(1,1,'programare holter- anemii?','anemie','concord'),-- Ioana
(2,2,'perfect sanatos','nu sunt','odihna, fara stres'),
(3,3,'se continua medicamentatia medicamentatie','nu sunt','concord'),
(4,4,'raceala','nu sunt','nurofen raceala si gripa + teraflu'),
(5,5,'revenire la control peste o luna','nu sunt','paduden(daca exist dureri)'),
(6,6,'totul a decors bine','nu sunt', 'nu sunt'), -- Pele
(7,7,'totul a decors bine','nu sunt', 'nu sunt'),
(8,8,'totul a decors bine','nu sunt', 'se recomanda sa stea o saptamana fara sa faca prea mult efort, iar dupa sa inceapa sa faca in fiecare zi miscare');*/