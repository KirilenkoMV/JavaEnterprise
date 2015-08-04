-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.25-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Дамп данных таблицы tablereverve.clients: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` (`id`, `name`, `surname`, `password`, `age`, `phone`) VALUES
	(1, 'Михаил', 'Кириленко', 'qwerty', 30, 1234567),
	(2, 'Иван', 'Спрессов', 'йцукен', 55, 7654321);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;

-- Дамп данных таблицы tablereverve.orders: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `date`, `client_id`, `table_id`) VALUES
	(1, '2015-08-02 14:24:03', 1, 5),
	(3, '2015-08-03 14:26:03', 2, 8);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп данных таблицы tablereverve.tables: ~13 rows (приблизительно)
/*!40000 ALTER TABLE `tables` DISABLE KEYS */;
INSERT INTO `tables` (`id`, `seats_number`, `place`, `cost`) VALUES
	(1, 5, 'first floor', 1000),
	(2, 8, 'first floor', 1500),
	(3, 2, 'first floor', 500),
	(4, 2, 'first floor', 500),
	(5, 2, 'first floor', 500),
	(6, 2, 'first floor,porch', 200),
	(7, 2, 'first floor,porch', 200),
	(8, 5, 'second floor', 800),
	(9, 5, 'second floor', 800),
	(10, 2, 'second floor', 300),
	(11, 2, 'second floor', 300),
	(12, 2, 'second floor,porch', 200),
	(13, 2, 'second floor,porch', 200);
/*!40000 ALTER TABLE `tables` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
