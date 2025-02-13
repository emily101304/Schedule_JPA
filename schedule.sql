CREATE TABLE schedule (
                          schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY,     -- Schedule ID, 자동으로 증가하는 기본 키
                          title VARCHAR NOT NULL,         -- 할 일, NULL을 허용하지 않음
                          content VARCHAR NOT NULL,          -- 비밀번호, NULL을 허용하지 않음
                          createdAt TIMESTAMP,                      -- 작성일
                          modifiedAt TIMESTAMP                -- 수정일
);
CREATE TABLE user (
                          user_id BIGINT AUTO_INCREMENT PRIMARY KEY,     -- Schedule ID, 자동으로 증가하는 기본 키
                          name VARCHAR NOT NULL,         -- 할 일, NULL을 허용하지 않음
                          email VARCHAR NOT NULL,
                          password VARCHAR NOT NULL,          -- 비밀번호, NULL을 허용하지 않음
                          createdAt TIMESTAMP,                      -- 작성일
                          modifiedAt TIMESTAMP                -- 수정일
);