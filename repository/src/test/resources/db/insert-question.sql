SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE question;
TRUNCATE TABLE questionnaire;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO questionnaire(`questionnaire_id`, `max_pages`, type)
VALUES (200, 1, 'advert');



insert into question (question_id, question, `page_level`, `description`, `advert_property`, `choice`, `questionnaire_id`)
values (12, 'Ads title', 1,'','title','#',  200),
       (18, 'Gender', 6,'','gender','MALE#FEMALE',  200),
       (13, 'Age', 2, '', 'age', '#',200),
       (14, 'Where are you customers?', 3, 'Where do you want your ads to appear?','targetLocation','#', 200),
       (17, 'Devices', 4,'', 'devices','MOBILE DEVICES#DESKTOP DEVICES#', 200),
       (10, 'Set up business categories', 5,'Enter the products and services you offer', 'businessCategories','#', 200);







