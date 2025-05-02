CREATE TABLE `poder` (
  `poder_id` bigint NOT NULL AUTO_INCREMENT,
  `name_poder` varchar(255) DEFAULT NULL,
  `total_value_spent` double NOT NULL,
  `percentage_of_total` double NOT NULL,
  PRIMARY KEY (`poder_id`)
);
CREATE TABLE `ministerio` (
  `ministerio_id` bigint NOT NULL AUTO_INCREMENT,
  `name_ministerio` varchar(255) DEFAULT NULL,
  `poder_id` bigint DEFAULT NULL,
  `total_value_spent` double NOT NULL,
  `percentage_of_total` double NOT NULL,
  PRIMARY KEY (`ministerio_id`),
  KEY `poder_id` (`poder_id`),
  CONSTRAINT `ministerio_ibfk_1` FOREIGN KEY (`poder_id`) REFERENCES `poder` (`poder_id`)
);
CREATE TABLE `orgao` (
  `orgao_id` bigint NOT NULL AUTO_INCREMENT,
  `name_orgao` varchar(255) DEFAULT NULL,
  `ministerio_id` bigint DEFAULT NULL,
  `total_value_spent` double NOT NULL,
  `percentage_of_total` double NOT NULL,
  PRIMARY KEY (`orgao_id`),
  KEY `ministerio_id` (`ministerio_id`),
  CONSTRAINT `orgao_ibfk_1` FOREIGN KEY (`ministerio_id`) REFERENCES `ministerio` (`ministerio_id`)
);
CREATE TABLE `unidade_gestora` (
  `unidade_gestora_id` bigint NOT NULL AUTO_INCREMENT,
  `name_unidade_gestora` varchar(255) DEFAULT NULL,
  `orgao_id` bigint DEFAULT NULL,
  `total_value_spent` double NOT NULL,
  `percentage_of_total` double NOT NULL,
  PRIMARY KEY (`unidade_gestora_id`),
  KEY `orgao_id` (`orgao_id`),
  CONSTRAINT `unidade_gestora_ibfk_1` FOREIGN KEY (`orgao_id`) REFERENCES `orgao` (`orgao_id`)
);
CREATE TABLE `elemento_despesa` (
  `elemento_despesa_id` bigint NOT NULL AUTO_INCREMENT,
  `name_elemento_despesa` varchar(255) DEFAULT NULL,
  `unidade_gestora_id` bigint DEFAULT NULL,
  `total_value_spent` double NOT NULL,
  `percentage_of_total` double NOT NULL,
  PRIMARY KEY (`elemento_despesa_id`),
  KEY `unidade_gestora_id` (`unidade_gestora_id`),
  CONSTRAINT `elemento_despesa_ibfk_1` FOREIGN KEY (`unidade_gestora_id`) REFERENCES `unidade_gestora` (`unidade_gestora_id`)
);
CREATE TABLE `gasto_total` (
  `gasto_total_id` bigint NOT NULL AUTO_INCREMENT,
  `gasto_total_value` double NOT NULL,
  PRIMARY KEY (`gasto_total_id`)
);
CREATE TABLE `despesa_simplificada` (
  `despesa_simplificada_id` bigint NOT NULL AUTO_INCREMENT,
  `despesa_simplificada_name` varchar(255) DEFAULT NULL,
  `despesa_simplificada_total_value` double NOT NULL,
  `despesa_simplificada_percentage_of_total` double NOT NULL,
  PRIMARY KEY (`despesa_simplificada_id`)
);
