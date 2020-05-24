SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE ref_device_versions;
TRUNCATE TABLE ref_mobile_devices;
TRUNCATE TABLE ref_business_category;
TRUNCATE TABLE ref_ad_creation;
TRUNCATE TABLE ref_desktop_devices;
TRUNCATE TABLE ref_desktop_versions;
TRUNCATE TABLE ref_isp;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO ref_ad_creation(id) VALUE (500);

INSERT INTO ref_business_category(category_name, ref_ad_creation_id)
VALUES('Arts & Entertainment', 500),
        ('Automotive', 500),
        ('Business', 500),
        ('Careers', 500),
        ('Education', 500),
        ('Family & Parenting', 500),
        ('Health & Fitness', 500),
        ('Food & Drink',500),
        ('Hobbies & Interests',500),
        ('Home & Garden', 500),
        ('Law, Government & Politics', 500),
        ('News',500),
        ('Personal Finance', 500),
        ('Society', 500),
        ('Science', 500),
        ('Pets', 500),
        ('Sports', 500),
        ('Style & Fashion',500),
        ('Technology & Computing',500),
        ('Travel',500),
        ('Real Estate', 500),
        ('Shopping', 500),
        ('Religion & Spirituality', 500);



INSERT INTO ref_desktop_devices(id,  brand_name, ref_ad_creation_id)
VALUES(400,'Apple', 500),
        (401, 'Hewlett-Packard (HP)', 500),
        (402, 'Dell', 500),
        (403, 'Lenovo', 500),
        (404, 'Asus', 500),
        (405, 'Acer', 500),
        (406, 'Toshiba', 500),
        (407, 'Samsung', 500),
        (408, 'LG', 500),
        (409, 'Sony', 500),
        (410, 'Others', 500);

INSERT INTO ref_desktop_versions(version, ref_desktop_devices_id)
VALUES('Leopard', 400),
       ('Snow Leopard', 400),
        ('Lion', 400),
        ('Mountain Lion', 400),
        ('Mavericks', 400),
        ('Yosemite', 400),
        ('El Capitan', 400),
        ('Sierra', 400),
        ('High Sierra', 400),
        ('Mojave', 400),
        ('Catalina', 400);

INSERT INTO ref_mobile_devices(id,brand_name, ref_ad_creation_id)
VALUES(601,'Apple iOS', 500);
#
# INSERT INTO ref_device_versions(version, device_id) VALUES
#        ('Android 4.4 and above', 600),
#         ('Android 4.0 Ice Cream', 600),
#         ('Android 4.1 Jelly Bean', 600),
#         ('Android 4.4 KitKat', 600),
#         ('Android 5.0 Lollipop', 600),
#         ('Android 6.0 Marshmallow', 600),
#         ('Android 7.0 Nougat', 600),
#         ('Android 8.0 Oreo', 600),
#         ('Android 9 Pie', 600),
#         ('Android 10', 600),
#         ('Android 11', 600);
#
INSERT INTO ref_device_versions(version, device_id)
VALUES
        ('iOS 8 and above',601),
        ('iOS 7', 601),
        ('iOS 8', 601),
        ('iOS 9', 601),
        ('iOS 10', 601),
        ('iOS 11', 601),
        ('iOS 12', 601),
        ('iOS 13', 601);


INSERT INTO ref_isp(isp_name, ref_ad_creation_id)
VALUES ('MTN', 500),
       ('Airtel', 500),
       ('GLO', 500),
       ('9Mobile',500);

