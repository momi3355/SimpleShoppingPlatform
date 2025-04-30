---
tags:
  - "#학원"
  - "#팀프로젝트"
start: 2025-04-14
due: 2025-04-23
GitHub: https://github.com/momi3355/SimpleShoppingPlatform
---

# 📘 프로젝트명: 왜않사

## 📖 프로젝트 개요

- **개발 목적:** 무엇을 만들까 고민을 했는데 무신사가 생각이 나서
  <u>핵심적인 것</u> 만 구현을 생각 했습니다.

---

## 🥕 개발인원

|   이름 | 깃 주소                                   | 역할                    |
| -----: | :---------------------------------------- | :---------------------- |
| 이창현 | [momi3355](https://github.com/momi3355)   | 구매 관련(총괄)         |
| 권민준 | [Nugulk](https://github.com/Nugulk)       | 메인 계열(CSS작업)      |
| 김다산 | [san8856](https://github.com/san8856)     | 회원/마이페이지(DB구축) |
| 최민혁 | [Shiratory](https://github.com/Shiratory) | 리뷰 관련               |

## 🔧 주요 페이지

| 페이지구문 | 페이지이름                           | 기능 설명                                                                        |
| ---------- | ------------------------------------ | -------------------------------------------------------------------------------- |
| 로그인     | 회원가입<br>로그인<br>마이페이지<br> | 회원 가입 및 로그인 기능 제공,<br>마이페이지에서 사용자 정보와<br>주문 내역 확인 |
| 상품       | 메인페이지(상품목록)<br>상품상세<br> | 전체 상품 목록 조회,<br>상품 클릭 시 이미지, 설명, 가격 등<br>상세 정보 제공     |
| 검색       | 검색결과                             | 입력한 키워드를 바탕으로 관련 상품들<br>검색하여 목록 형태로 출력                |
| 리뷰       | 리뷰작성<br>리뷰목록                 | 상품에 대한 리뷰 작성 기능,<br>다른 사용자들의 리뷰 및 별점 확인                 |
| 주문       | 주문내역<br>장바구니<br>결제페이지   | 장바구니에 상품 추가 및 관리,<br>결제 진행, 주문 내역 확인 가능                  |
| 배송       | 배송지                               | 사용자의 배송지를 추가하거나, 삭제 가능                                          |

---

## 🗂 개발 일정

| 기간               | 내용                 |
| ------------------ | -------------------- |
| 2025.04.14 ~ 04.14 | 요구사항 분석 / 기획 |
| 2025.04.14 ~ 04.15 | UI 디자인 / 설계     |
| 2025.04.15 ~ 04.21 | 본 개발              |
| 2025.04.21 ~ 04.22 | 테스트 및 디버깅     |
| 2025.04.23         | 배포 및 마무리       |

---

## 💻 개발 환경

- **개발 언어:** Java(v21.0.6)
- **프론트 엔드:** HTML / CSS / Javascript
- **백엔드:** JSP(v2.3) / Servlet(v4.0)
- **IDE:** Eclipse / VSCode
- **버전관리:** Git + GitHub

## 🚀 실행 / 배포 환경

- **서버:** Apache Tomcat 9.0
- **운영체제:** Windows 10
- **포트:** 80

---

## 🏗 데이터베이스

### 테이블

| 기능            | 필요한 데이터                                      | 테이블 이름 |
| --------------- | -------------------------------------------------- | ----------- |
| 회원가입/로그인 | 아이디, 비밀번호, 이름, 이메일, 전화번호, 가입일   | users       |
| 상품목록/상세   | 상품명, 가격, 설명, 이미지, 재고                   | products    |
| 장바구니        | 사용자ID, 상품ID, 수량, 선택한옵션                 | cart        |
| 주문            | 주문번호, 사용자ID, 주문일, 총금액                 | orders      |
| 상세주문        | 주문코드, 상품코드, 주문수량, 상품가격, 선택한옵션 | order_items |
| 리뷰            | 사용자ID, 상품ID, 내용, 별점, 날짜                 | reviews     |
| 배송지          | 이름, 전화번호, 우편번호, 주소                     | delivery    |

### 구조

```sql
-- 1. 사용자 테이블
CREATE TABLE users (
    user_code    INT            PRIMARY KEY,       -- 사용자 고유 코드 (PK)
    kakao_id     VARCHAR2(100),                    -- 카카오아이디
    user_id      VARCHAR2(100)  NOT NULL UNIQUE,   -- 사용자 ID (중복 불가)
    user_name    VARCHAR2(50)   NOT NULL,          -- 사용자 이름
    password     VARCHAR2(100)  NOT NULL,          -- 비밀번호
    email        VARCHAR2(100),                    -- 이메일
    phone        VARCHAR2(50),                     -- 전화번호
    user_date    TIMESTAMP      DEFAULT CURRENT_TIMESTAMP -- 가입일
);

-- 사용자 코드 시퀀스 생성
CREATE SEQUENCE user_code_seq
 START WITH 1
 INCREMENT BY 1;


-- 2. 상품 테이블
CREATE TABLE products (
    product_code      INT            PRIMARY KEY,  -- 상품 고유 코드 (PK)
    product_name      VARCHAR2(100)  NOT NULL,     -- 상품명
    original_price    INT            NOT NULL,     -- 원가
    price             INT            NOT NULL,     -- 판매가
    image_description VARCHAR2(255),               -- 이미지 설명
    image_url_fir     VARCHAR2(255)  NOT NULL,     -- 이미지 1
    image_url_se      VARCHAR2(255),               -- 이미지 2
    image_url_th      VARCHAR2(255),               -- 이미지 3
    stock             INT            DEFAULT 0,    -- 재고 수량
    sales_count       INT            DEFAULT 0,    -- 판매량
    product_gender    VARCHAR2(10),                -- 성별표기
    product_category  VARCHAR2(50),                -- 상품 분류(카테고리)
    product_option    VARCHAR2(100),               -- 옵션 정보(사이즈)
    product_date      TIMESTAMP      DEFAULT CURRENT_TIMESTAMP -- 상품 등록일
);

-- 상품 코드 시퀀스 생성
CREATE SEQUENCE product_code_seq
 START WITH 1
 INCREMENT BY 1;

-- 3. 상품정보 이미지 테이블
CREATE TABLE product_images (
  product_code   NUMBER        NOT NULL,  -- 상품 코드 (FK)
  image_url      VARCHAR2(400) NOT NULL,  -- 상품 상세 이미지
  sort_order     NUMBER        NOT NULL,  -- 이미지 순서
  CONSTRAINT fk_pi_product FOREIGN KEY(product_code) REFERENCES products(product_code)
);


-- 4. 장바구니 테이블
CREATE TABLE cart (
    cart_code      INT            PRIMARY KEY,  -- 장바구니 고유 코드 (PK)
    user_code      INT            NOT NULL,     -- 사용자 코드 (FK)
    product_code   INT            NOT NULL,     -- 상품 코드 (FK)
    quantity       INT            DEFAULT 1,    -- 수량
    product_option VARCHAR2(100),               -- 선택한 옵션
    FOREIGN KEY (user_code) REFERENCES users(user_code),
    FOREIGN KEY (product_code) REFERENCES products(product_code)
);

-- 장바구니 코드 시퀀스 생성
CREATE SEQUENCE cart_code_seq
 START WITH 1
 INCREMENT BY 1;


-- 5. 주문 테이블
CREATE TABLE orders (
    order_code  INT           PRIMARY KEY,  -- 주문 고유 코드 (PK)
    user_code   INT           NOT NULL,     -- 사용자 코드 (FK)
    user_name   VARCHAR2(50)  NOT NULL,     -- 주문자 이름
    phone       INT           NOT NULL,     -- 주문자 전화번호
    address     VARCHAR2(200) NOT NULL,     -- 배송 주소
    order_date  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP, -- 주문일
    FOREIGN KEY (user_code) REFERENCES users(user_code)
);

-- 주문 코드 시퀀스 생성
CREATE SEQUENCE order_code_seq
 START WITH 1
 INCREMENT BY 1;


-- 6. 주문 상세 테이블
CREATE TABLE order_items (
    order_item_code INT            PRIMARY KEY,  -- 주문 상세 고유 코드 (PK)
    order_code      INT            NOT NULL,     -- 주문 코드 (FK)
    product_code    INT            NOT NULL,     -- 상품 코드 (FK)
    quantity        INT            NOT NULL,     -- 주문 수량
    price           INT            NOT NULL,     -- 해당 상품 가격
    product_option  VARCHAR2(100),               -- 선택한 옵션
    FOREIGN KEY (order_code) REFERENCES orders(order_code),
    FOREIGN KEY (product_code) REFERENCES products(product_code)
);

-- 주문 상세 코드 시퀀스 생성
CREATE SEQUENCE order_item_code_seq
 START WITH 1
 INCREMENT BY 1;


-- 7. 리뷰 테이블
CREATE TABLE reviews (
    review_code   INT            PRIMARY KEY,  -- 리뷰 고유 코드 (PK)
    user_code     INT            NOT NULL,     -- 사용자 코드 (FK)
    product_code  INT            NOT NULL,     -- 상품 코드 (FK)
    rating        INT            CHECK (rating BETWEEN 1 AND 5), -- 평점(1~5)
    content       VARCHAR2(255),                -- 리뷰 내용
    write_date    TIMESTAMP      DEFAULT CURRENT_TIMESTAMP, -- 작성일
    FOREIGN KEY (user_code) REFERENCES users(user_code),
    FOREIGN KEY (product_code) REFERENCES products(product_code)
);

-- 리뷰 코드 시퀀스 생성
CREATE SEQUENCE review_code_seq
 START WITH 1
 INCREMENT BY 1;


-- 8. 배송 정보 테이블
CREATE TABLE delivery (
    delivery_code INT            PRIMARY KEY,  -- 배송 고유 코드 (PK)
    user_code     INT            NOT NULL,     -- 사용자 코드 (FK)
    post          INT            NOT NULL,     -- 우편번호
    address       VARCHAR2(200)  NOT NULL,     -- 주소
    request       VARCHAR2(200),               -- 배송 요청사항
    FOREIGN KEY (user_code) REFERENCES users(user_code)
);

-- 배송 정보 코드 시퀀스 생성
CREATE SEQUENCE delivery_code_seq
 START WITH 1
 INCREMENT BY 1;

-- 9. 공지사항
CREATE TABLE supportboard (
  board_code     INT            PRIMARY KEY,  -- 공지 고유 코드 (PK)
  board_title    VARCHAR2(500),               -- 공지 제목
  board_date     VARCHAR2(10),                -- 공지 날짜
  board_content  CLOB,                        -- 공지 내용
  board_category VARCHAR2(100)                -- 공지 종류
);

-- 공지 코드 시퀀스 생성
CREATE SEQUENCE board_code_seq
 START WITH 1
 INCREMENT BY 1;
```
