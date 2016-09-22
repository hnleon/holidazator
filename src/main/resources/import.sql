
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `holidays` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `holi_date` date NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `holi_date` (`holi_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'first', '123456'),
(2, 'second', '123456'),
(3, 'third', '123456');

INSERT INTO `holidays` (`id`, `holi_date`, `name`) VALUES
(1, '2016-01-01', 'New Year\'s Day'),
(2, '2016-01-07', 'Christmas Day'),
(3, '2016-01-08', 'Christmas Day holiday'),
(4, '2016-01-14', 'Orthodox New Year'),
(5, '2016-01-16', 'Special Working Day'),
(6, '2016-01-22', 'Ukrainian Unity Day'),
(7, '2016-01-25', 'Tatiana Day'),
(8, '2016-02-14', 'Valentine\'s Day'),
(9, '2016-03-08', 'International Women\'s Day'),
(10, '2016-03-20', 'March equinox'),
(11, '2016-03-27', 'Daylight Saving Time starts'),
(12, '2016-04-01', 'April Fools'),
(13, '2016-05-01', 'Orthodox Easter Day'),
(14, '2016-05-02', 'Labor Day'),
(15, '2016-05-08', 'Mother\'s Day'),
(16, '2016-05-09', 'Victory Day / Memorial Day'),
(17, '2016-05-21', 'Europe Day'),
(18, '2016-05-22', 'Cultural Workers and Folk Artists Day'),
(19, '2016-05-29', 'Kiev Day'),
(20, '2016-06-19', 'Orthodox Pentecost'),
(21, '2016-06-20', 'Orthodox Pentecost holiday'),
(22, '2016-06-28', 'Constitution Day'),
(23, '2016-07-07', 'Kupala Night'),
(24, '2016-07-08', 'Family Day'),
(25, '2016-07-28', 'Baptism of Kyivan Rus'),
(26, '2016-07-31', 'Navy Day'),
(27, '2016-08-24', 'Independence Day'),
(28, '2016-09-22', 'September equinox'),
(29, '2016-10-02', 'Teacher\'s Day'),
(30, '2016-10-14', 'Defenders\' Day'),
(31, '2016-10-30', 'Daylight Saving Time ends'),
(32, '2016-11-21', 'Dignity and Freedom Day'),
(33, '2016-12-06', 'Army Day'),
(34, '2016-12-19', 'St. Nicholas Day'),
(35, '2016-12-21', 'December Solstice');
