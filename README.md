## **Описание проекта**

Проект представляет собой REST API для LMS (Learning Management System) — системы управления обучением. В системе предусмотрены роли пользователей (гости, студенты, преподаватели), которые могут взаимодействовать с курсами, темами и задачами.

- Запросы должны быть спроектированы в соответствии с принципами REST API. Thymeleaf использовать не нужно. 


- Ответы API должны быть в стандартной обёртке, которая содержит метаинформацию об ответе (статус-код, причина ошибки). 
- Введённые пользователями данные должны храниться в рамках жизненного цикла веб-приложения.

###  **Управление пользователями**

- POST /students — создание нового пользователя (регистрация) с передачей данных в теле запроса.
- PATCH /students — обновление информации о студенте (студент решил задачу). 
- GET /students/{id} — получение доступной информации о студенте.
- DELETE /students/{id} — удаление студента.

###  **Управление курсами**

- POST /courses — создание нового курса.
- GET /courses/{id} — получение курса.
- DELETE /courses/{id} — удаление курса.
- POST /courses/{courseId}/enroll/{studentId} — запись студента на курс.
- POST /courses/{idcourseId/unenroll/{studentId} — выход студента из курса.

###  **Управление темами**

- POST /courses/{id}/topics — добавление темы в курс.
- GET /topics/{id} — получение информации о конкретной теме.
- DELETE /topics/{id} — удаление темы.

### **Управление задачами**

- POST /topics/{id}/problems — добавление задачи в тему.
- GET /problems/{id} — получение информации о конкретной задаче.
- DELETE /problems/{id} — удаление задачи.

## **Структура сущностей**

```
Student
- Id
- Login
- FirstName
- LastName
- PhoneNumber
- SolvedProblems[] (список решённых задач)

Course
- Id
- Title
- Description
- Topics[] (список тем)
- Students[] (список студентов, записанных на курс)

Topic
- Id
- Title
- Text (текстовое описание темы)
- Problems[] (список задач)

Problem
- Id
- Title
- Description
```

## Пользовательские сценарии

1. Новый пользователь создаётся в системе при регистрации. После этого он может просматривать свою информацию и удалять учётную запись, если необходимо.
2. Преподаватель может создать или удалить курс. После создания студенты могут записаться на курс или выйти из него.
3. После создания курса преподаватель добавляет темы, которые связаны с учебными материалами, и может их удалять. Любой пользователь может просматривать информацию о конкретной теме.
4. В рамках темы преподаватель может добавлять и удалять задачи. 
5. Студенты могут получать информацию о задачах и решать их, при этом приложение должно фиксировать факт выполнения студентами конкретных задач.
