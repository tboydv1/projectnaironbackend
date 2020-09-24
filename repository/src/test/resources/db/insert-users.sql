
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table `nairon_user`;
SET FOREIGN_KEY_CHECKS = 1;

insert into  nairon_user(`id`, `full_name`, `email`, `phone_number`, `password`)
values(45, 'Johnson remedy', 'rem@rema.mail.com', '07079689685','rem123'),
      (75, 'Mattew remedy', 'mat@rema.mail.com', '07079684585','mat123' ),
      (85, 'Covoski remedy', 'cov@rema.mail.com', '07079678685','cov123');
