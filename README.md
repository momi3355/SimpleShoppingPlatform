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
- **개발 목적:**  무엇을 만들까 고민을 했는데 무신사가 생각이 나서
<u>핵심적인 것</u> 만 구현을 생각 했습니다.

---

## 🔧 주요 페이지

| 페이지구문 | 페이지이름                    | 기능 설명                                             |
| ----- | ------------------------ | ------------------------------------------------- |
| 로그인   | 회원가입<br>로그인<br>마이페이지<br> | 회원 가입 및 로그인 기능 제공,<br>마이페이지에서 사용자 정보와<br>주문 내역 확인 |
| 상품    | 메인페이지(상품목록)<br>상품상세<br>  | 전체 상품 목록 조회,<br>상품 클릭 시 이미지, 설명, 가격 등<br>상세 정보 제공 |
| 검색    | 검색결과                     | 입력한 키워드를 바탕으로 관련 상품들<br>검색하여 목록 형태로 출력            |
| 리뷰    | 리뷰작성<br>리뷰목록             | 상품에 대한 리뷰 작성 기능,<br>다른 사용자들의 리뷰 및 별점 확인           |
| 주문    | 주문내역<br>장바구니<br>결제페이지    | 장바구니에 상품 추가 및 관리,<br>결제 진행, 주문 내역 확인 가능           |

---

## 🗂 개발 일정

| 기간                   | 내용           |
| -------------------- | ------------ |
| 2025.04.14  ~  04.14 | 요구사항 분석 / 기획 |
| 2025.04.14  ~  04.15 | UI 디자인 / 설계  |
| 2025.04.15  ~  04.21 | 본 개발         |
| 2025.04.21  ~  04.22 | 테스트 및 디버깅    |
| 2025.04.23           | 배포 및 마무리     |

---

## 💻 개발 환경
- **개발 언어:** Java
- **프론트 엔드:**  HTML / CSS / Javascript
- **백엔드:** JSP / Servlet
- **IDE:** Eclipse / VSCode 
- **버전관리:** Git + GitHub

## 🚀 실행 / 배포 환경
- **서버:** Apache Tomcat 9.0
- **운영체제:** Windows 10
- **포트:** 80

---

## 🏗 데이터베이스
### 테이블
|기능|필요한 데이터|테이블 이름|
|-----|----------------|------------|
|회원가입/로그인|아이디, 비밀번호, 이름, 이메일, 가입일|users|
|상품목록/상세|상품명, 가격, 설명, 이미지, 재고|products|
|장바구니|사용자ID, 상품ID, 수량|cart|
|주문|주문번호, 사용자ID, 주문일, 총금액|orders|
|리뷰|사용자ID, 상품ID, 내용, 별점, 날짜|reviews|
### 구조
```sql
-- 1. 사용자 테이블
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 2. 상품 테이블
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    stock INT DEFAULT 0
);

-- 3. 장바구니 테이블
CREATE TABLE cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT DEFAULT 1,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 4. 주문 테이블
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_price INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 5. 주문 상세 (다대다 관계)
CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price INT NOT NULL, -- 주문 당시 가격
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 6. 리뷰 테이블
CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    content TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
```
