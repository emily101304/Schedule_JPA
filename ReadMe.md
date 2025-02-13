## 프로젝트 소개
[🗓️ CH.3 일정 관리 앱 만들기 🗓️](https://teamsparta.notion.site/Spring-5-CH-3-Develop-1912dc3ef51480d38f69ed0f0b7c5338)
<br><br>
🌑 `Lv.0` API명세서 및 ERD 작성 <br>
🌒 `Lv.1` 일정 CRUD <br>
🌓 `Lv.2` 유저 CRUD <br>
🌔 `Lv.3` 회원가입 <br>
🌕 `Lv.4` 로그인(인증) <br>
🌖 `Lv.5` `Challenge` 다양한 예외처리 적용하기 <br>
🌗 `Lv.6` `Challenge` 비밀번호 암호화 <br>
🌘 `Lv.7` `Challenge` 댓글 CRUD <br>
🌑 `Lv.8` `Challenge` 일정 페이징 조회 <br>

## Schedule API
|         Description         | Method |        Endpoint         |     Parameters     |                                        Request Body                                         |                                                  Response                                                   |  StatusCode   |
|:---------------------------:|:------:|:-----------------------:|:------------------:|:-------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------:|:-------------:|
|            일정 등록            |  POST  |       /schedules        |         -          | {"username" : String,<br/> "title" : String,<br/> "content" : String,<br/> "userId" : Long} | [{"id" : Long,<br/>"username" : String,<br/>"title" : String,<br/>"content" : String,<br/>"userId" : Long}] |      200      |
|        일정<br/>전체 조회         |  GET   |       /schedules/       |         -          |                                              -                                              |  [{"id" : Long,<br/>"username" : String,<br/>"title" : String,<br/>"content" : String,<br/>"userId" : Long}]  |      200      |
|        일정<br/>단건 조회         |  GET   | /schedules/{scheduleId} |     Path : id      |                                              -                                              |  [{"id" : Long,<br/>"username" : String,<br/>"title" : String,<br/>"content" : String,<br/>"userId" : Long}]  |      200      |
|        일정<br/>단건 수정         | PATCH  | /schedules/{scheduleId} |    Path : id       |                         {"title" : String,<br/>"content" : String}                          |  [{"id" : Long,<br/>"username" : String,<br/>"title" : String,<br/>"content" : String,<br/>"userId" : Long}]  |      200      |
|     일정<br/>단건 삭제            | DELETE | /schedules/{scheduleId} |     Path : id      |                                              -                                              |                                                      -                                                      |      200      |

## User API
| Description  | Method |       Endpoint       |           Parameters            |                            Request Body                            |                             Response                              |  StatusCode   |
|:------------:|:------:|:--------------------:|:-------------------------------:|:------------------------------------------------------------------:|:-----------------------------------------------------------------:|:-------------:|
|    유저 등록     |  POST  |        /users        |                -                | {"name" : String,<br/> "email" : String,<br/> "password" : String} |    [{"id" : Long,<br/>"name" : String,<br/>"email" : String}]     |      200      |
| 유저<br/>전체 조회 |  GET   |        /users        |                -                |                                 -                                  |    [{"id" : Long,<br/>"name" : String,<br/>"email" : String}]     |      200      |
| 유저<br/>단건 조회 |  GET   |   /users/{userId}    |            Path : id            |                                 -                                  |    [{"id" : Long,<br/>"name" : String,<br/>"email" : String}]     |      200      |
| 유저<br/>단건 수정 | PATCH  |   /users/{userId}    | Path : id,<br/>Query : password |              {"name" : String,<br/>"email" : String}               |    [{"id" : Long,<br/>"name" : String,<br/>"email" : String}]     |      200      |
| 유저<br/>단건 삭제 | DELETE |   /users/{userId}    | Path : id,<br/>Query : password |                                 -                                  |                   -                                               |      200      |

## ERD
![img_1.png](img_1.png)

## 개발 환경
* ![JAVA](https://camo.githubusercontent.com/457a848193ea3168ad5602c0096e9742da98988e1066f9b3125175a6a0f4f9c7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176612d3030373339363f267374796c653d666f722d7468652d6261646765266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465)
* <img src="https://blog.hyunsub.kim/covers/spring.png" width="57px"></img>