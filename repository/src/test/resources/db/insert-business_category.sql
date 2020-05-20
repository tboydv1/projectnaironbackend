SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE nairon_db.business_category;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO business_category(id, name)
VALUES (55, 'Fashion'),
       (54, 'Agriculture'),
       (53, 'E-Commerce');