SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE question;
TRUNCATE TABLE questionnaire;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO questionnaire(`questionnaire_id`, `max_pages`, type)
VALUES (200, 1, 'Basic Ads Campaign');


insert into q
values (212, 'Ads Campaign name', 1,'','campaign_name',  40),
       (213, 'What is your ads goal', 1,'','goal',  41),
       (214, 'Ads title', 1, 'Lets start with describing your business', 'title',200),
       (14, 'Landing page(Website)', 3, '','landing', 200),
       (17, 'Devices', 4,'', 'devices', 200),
       (10, 'Set up business categories', 5,'Enter the products and services you offer', 'businessCategories', 200);



INSERT INTO question_options(choice, question_id)
VALUES ('Get more website visits', 213),
       ('Get more app downloads', 213),
       ('Get more product sales', 213),
       ('MALE', 14),
       ('FEMALE', 14),
       ('MOBILE', 14),
       ('MALE', 14),
       ('FEMALE', 14),
       ('MOBILE', 14),
       ('MALE', 14),
       ('FEMALE', 14),
       ('MOBILE', 14),
       ('DESKTOP', 14);,



