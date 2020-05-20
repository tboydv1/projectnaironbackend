SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE nairon_db.location;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO location(id, country, city, state)
 VALUES (21, 'Nigeria', 'Yaba', 'Lagos'),
        (22, 'Nigeria', 'Mushin', 'Lagos'),
        (23, 'Nigeria', 'Gbagada', 'Lagos'),
        (24, 'Nigeria', 'Ebute metta', 'Lagos');