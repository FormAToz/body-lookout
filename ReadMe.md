# Приложение для ведения статистики здоровья

Приложение позволяет вносить замеры по весу, частям тела, тренировкам и получать некоторые расчеты.
Также доступно получение статистики по всем наблюдаемым параметрам.


## Функционал

- Регистрация
- Управление наблюдаемыми параметрами (добавление, редактирование, удаление):
  - тренировки и результаты тренировок
  - вес тела
  - параметры частей тела
  - добавление периодов приема БАД`ов
- Получение статистики


## Стэк

| **Описание**                | **Технологии и версии**                    |
|-----------------------------|--------------------------------------------|
| **Версия JDK**              | **12**                                     |
| **Сборщик проекта**         | **Maven**                                  |
| **Система контроля версий** | **git**                                    |
| **Spring Boot**             | **(2.6.5) Data, Web, Thymeleaf, Security** |
| **PostgreSQL**              | **14.2**                                   |
| **Lombok**                  | **1.18.22**                                |


## Запуск проекта

Для запуска проекта необходимо передать переменные окружения:
- **```SERVER_PORT```** - порт сервера
- **```DB_URL```** - url для подключения к базе данных PostgreSQL
- **```DB_USER```** - имя пользователя для базы данных
- **```DB_PASSWORD```** - пароль для базы данных

```Хост``` http://localhost:8080