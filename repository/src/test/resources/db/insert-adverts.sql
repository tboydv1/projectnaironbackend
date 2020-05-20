SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE advert;
TRUNCATE TABLE advert_budget;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO advert(advert_id, user_id, start_date, end_date, title, age_range,
                   gender,placement_type, created_on, headlines, image_url,
                   isp_technology, product_unique_desc, display_format, budget_id)
VALUES ();

INSERT INTO advert_budget(`budget_id`, `budget_amount`,`budget_balance`, `budget_per_day`)
VALUES (12, 2500.0,0.0, 20.0);