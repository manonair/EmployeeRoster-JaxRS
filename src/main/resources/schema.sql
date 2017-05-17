
CREATE TABLE address (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  city varchar(255) DEFAULT NULL,
  door_no varchar(255) DEFAULT NULL,
  location varchar(255) DEFAULT NULL,
  street varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;


CREATE TABLE employee (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  designation varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  salary double DEFAULT NULL,
  address_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

ALTER TABLE employee ADD FOREIGN KEY (address_id) REFERENCES address (id);
