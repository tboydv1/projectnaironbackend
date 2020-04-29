
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table `nairon_user`;
SET FOREIGN_KEY_CHECKS = 1;

insert into  nairon_user(`user_id`, `fullname`, `email`, `phone_number`, `password`, `role`)
values(45, 'Johnson remedy', 'rem@rema.mail.com', '07079689685','rem123', 'user'),
      (75, 'Mattew remedy', 'mat@rema.mail.com', '07079684585','mat123', 'user'),
      (85, 'Covoski remedy', 'cov@rema.mail.com', '07079678685','cov123', 'user');
