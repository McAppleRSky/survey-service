under develop !

Для запуска приложения необходим проперти файл (исключен из git репозитория)
  application-hide.properties
проперти:
  spring.datasource.username=
  spring.datasource.password=
  boot.security.user=
  boot.security.password=
  boot.security.role=
  spring.flyway.placeholders.person.login=
  spring.flyway.placeholders.person.password=

docker daemon start:
sudo /etc/init.d/docker start

Dockerfile - собирает образ приложения

Docker-compose ps - запускает контенеры, т.е. контейнер базы данных и контенер приложения в окружении bridge сети докера.

Для пропуска трафика в контейнер и из контейнера необходимо настройка NAT и MASQUERADE в iptables linux.
iptables -A PREROUTING -t nat -i enp2s0 -p tcp --dport 80 -j DNAT --to-destination 192.168.2.1
iptables -A POSTROUTING -t nat -s 192.168.2.0/24 -o enp2s0 -j MASQUERADE
Также настроить изоляцию инфраструктуры сети docker
iptables -L --line-numbers -v
iptables -D DOCKER-ISOLATION-STAGE-2 2
iptables -D DOCKER-ISOLATION-STAGE-1 2

Структура БД:
1. person -> role
2. survey _ 
            \_ -> question -> answer
   qtype  _/              \
                            -> qvariant
Документация по API:
мапинг приложения осуществляется на: /api/0.0.1/surveys, а также /api/0.0.1/login

Интерфейс администратора:

Логин - POST /api/0.0.1/login

Создание сущности "Опроса" - POST /api/0.0.1/surveys
  поля сущености - в теле запроса
  возврат созданной сущности - /api/0.0.1/surveys/{id}

Изменение Опроса - PATCH /api/0.0.1/surveys/{id}
  поля сущености - в теле запроса

Удаление Опроса - DELETE /api/0.0.1/surveys/{id}

Создание сущности "Вопроса" - POST /api/0.0.1/surveys/{id}/question
  id - опрос, к которому относится создаваемый вопрос
  поля сущености - в теле запроса
  возврат созданной сущности - /api/0.0.1/survey/{survey_id}/question/{question_id}

Изменение Вопроса - PATCH /api/0.0.1/surveys/{surveyId}/question/{questionId}
  поля сущености - в теле запроса

Удаление Вопроса - DELETE /api/0.0.1/surveys/{surveyId}/question/{questionId}


Пользовательский интерфейс:

Получение всех актуальных опросов - GET /api/0.0.1/surveys

Создание сущности "Ответа" - POST /api/0.0.1/surveys/{surveyId}/answer/{questionId}/user/{personId}

Получение всех ответов пользователя - GET /api/0.0.1/surveys/user/{personId}
