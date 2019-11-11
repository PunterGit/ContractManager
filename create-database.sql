-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Ноя 11 2019 г., 19:09
-- Версия сервера: 5.7.25
-- Версия PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `contract`
--

-- --------------------------------------------------------

--
-- Структура таблицы `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `surname` text NOT NULL,
  `middlename` text NOT NULL,
  `birth_date` date NOT NULL,
  `passport_id_series` int(4) NOT NULL,
  `passport_id_number` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `client`
--

INSERT INTO `client` (`id`, `name`, `surname`, `middlename`, `birth_date`, `passport_id_series`, `passport_id_number`) VALUES
(1, 'Иван', 'Курочкин', 'Васильевич', '1998-10-23', 2345, 435612);

-- --------------------------------------------------------

--
-- Структура таблицы `contract`
--

CREATE TABLE `contract` (
  `id` int(11) NOT NULL,
  `postcode` int(11) NOT NULL,
  `construction_year` int(11) NOT NULL,
  `insurance_sum` float NOT NULL,
  `insurance_premium` float NOT NULL,
  `area` float NOT NULL,
  `insurance_start_date` date NOT NULL,
  `insurance_end_date` date NOT NULL,
  `computation_date` date NOT NULL,
  `contract_date` date NOT NULL,
  `property` text NOT NULL,
  `country` text NOT NULL,
  `republic` text,
  `region` text,
  `locality` text NOT NULL,
  `street` text NOT NULL,
  `house` text NOT NULL,
  `housing` text,
  `building` text,
  `apartment` text,
  `comment` text,
  `client_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `contract`
--

INSERT INTO `contract` (`id`, `postcode`, `construction_year`, `insurance_sum`, `insurance_premium`, `area`, `insurance_start_date`, `insurance_end_date`, `computation_date`, `contract_date`, `property`, `country`, `republic`, `region`, `locality`, `street`, `house`, `housing`, `building`, `apartment`, `comment`, `client_id`) VALUES
(1, 643134, 1999, 100100, 1186.17, 100, '2018-11-01', '2019-11-09', '2019-11-11', '2019-11-10', 'Квартира', 'Россия', 'Пермский край', 'Свердловский', 'Пермь', 'Шоссе космонавтов', '33', 'Б', 'Дом', '64', 'Комментарий к договору', 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `contract`
--
ALTER TABLE `contract`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
