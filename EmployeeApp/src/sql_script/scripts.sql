CREATE TABLE `emp_db`.`employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_name` VARCHAR(100) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `pf` TINYINT(1) NOT NULL,
  `meal_card` TINYINT(1) NOT NULL,
  `garduity` TINYINT(1) NOT NULL,
  `nps` TINYINT(1) NOT NULL,
  `medical_claim` TINYINT(1) NOT NULL,
  `location` VARCHAR(100) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `salary` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)) ENGINE=InnoDB;
