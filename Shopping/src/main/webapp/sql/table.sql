-- 1. 사용자 테이블
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    username VARCHAR2(50) NOT NULL UNIQUE,
    password VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) NOT NULL UNIQUE,
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 사용자 ID 시퀀스 생성
CREATE SEQUENCE user_id_seq
START WITH 1
INCREMENT BY 1;

-- 2. 상품 테이블
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    price INT NOT NULL,
    description CLOB,
    image_url VARCHAR2(255),
    stock INT DEFAULT 0
);

-- 상품 ID 시퀀스 생성
CREATE SEQUENCE product_id_seq
START WITH 1
INCREMENT BY 1;

-- 3. 장바구니 테이블
CREATE TABLE cart (
    cart_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT DEFAULT 1,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 장바구니 ID 시퀀스 생성
CREATE SEQUENCE cart_id_seq
START WITH 1
INCREMENT BY 1;

-- 4. 주문 테이블
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_price INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 주문 ID 시퀀스 생성
CREATE SEQUENCE order_id_seq
START WITH 1
INCREMENT BY 1;

-- 5. 주문 상세 (다대다 관계)
CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price INT NOT NULL, -- 주문 당시 가격
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 주문 상세 ID 시퀀스 생성
CREATE SEQUENCE order_item_id_seq
START WITH 1
INCREMENT BY 1;

-- 6. 리뷰 테이블
CREATE TABLE reviews (
    review_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    content CLOB,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 리뷰 ID 시퀀스 생성
CREATE SEQUENCE review_id_seq
START WITH 1
INCREMENT BY 1;