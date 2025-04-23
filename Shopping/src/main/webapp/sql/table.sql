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