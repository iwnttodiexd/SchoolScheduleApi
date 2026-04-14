# SchoolScheduleApi

### REST API для получения школьного расписания.
Проект реализован на Spring Boot, PostgreSQL и Docker.

###  Функциональные возможности
- Получение списка всех преподавателей
- Получение списка всех классов
- Получение расписания класса на выбранную дату (расписание определяется по дню недели)

###  Технологии
- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Docker / Docker Compose
- Maven
- MapStruct
- Lombok

###  Запуск проекта
#####  Предварительные требования

Убедитесь, что установлены:

- JDK 21
- Maven
- Docker
- Docker Compose

###  Шаг 1. Запуск базы данных (обязательно)

Приложение использует PostgreSQL в Docker-контейнере.

В корневой папке проекта выполните:
```
docker compose up 
```
Проверить, что контейнер запущен:
```
docker ps
```
Контейнер должен выглядеть примерно так:
```
schoolapi-db
```

###  Шаг 2. Запуск Spring Boot приложения

После запуска базы данных:
```
mvn clean install
```
или сразу:
```
mvn spring-boot:run
```
Приложение будет доступно:
```
http://localhost:8080
```
Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

##  Примеры запросов к API

Все запросы отправляются методом GET. Сервер возвращает ответы в формате JSON.

### 1. Получить список всех преподавателей

Запрос: http://localhost:8080/api/teachers

Пример ответа: 
```
{
  "content": [
    {
      "name": "Анна Петровна Иванова",
      "surname": "Иванова"
    },
    {
      "name": "Сергей Викторович Смирнов",
      "surname": "Смирнов"
    },
    {
      "name": "Елена Дмитриевна Козлова",
      "surname": "Козлова"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 3,
  "totalElements": 25,
  "last": false,
  "first": true,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "numberOfElements": 3,
  "empty": false
}
```
### 2. Получить список всех классов

Запрос: http://localhost:8080/api/classes. 

Пример ответа:
```
{
  "content": [
    {
      "groupIdentifier": "GROUP_A"
    },
    {
      "groupIdentifier": "GROUP_B"
    },
    {
      "groupIdentifier": "GROUP_C"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 2,
  "totalElements": 15,
  "last": false,
  "first": true,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "numberOfElements": 3,
  "empty": false
}
```
### 3. Получить расписание для класса на конкретную дату

Формат даты: YYYY-MM-DD (например, 2024-01-15).

Расписание определяется по дню недели переданной даты.

Запрос: http://localhost:8080/api/classes/{id}/schedule?date=2024-01-15.

Пример ответа:
```
[
  {
    "subject": "Математика",
    "dayOfWeek": "MONDAY",
    "startTime": "08:30",
    "endTime": "09:15",
    "schoolRoomNumber": 101
  },
  {
    "subject": "Физика",
    "dayOfWeek": "MONDAY",
    "startTime": "09:25",
    "endTime": "10:10",
    "schoolRoomNumber": 205
  }
]
```
