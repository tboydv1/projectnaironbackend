SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE nairon_db.device;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO device(id, type, brand_name, version)
VALUES (31, 'Mobile', 'Samsung', 'S10'),
       (32, 'Mobile', 'Techno', 'Aqua'),
       (33, 'Desktop', 'HP', 'h1.0'),
       (34, 'Desktop', 'Dell', 'd1.2');