<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fashion Shop</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .header {
                background: #333;
                color: #fff;
                padding: 20px 0;
                text-align: center;
            }
            .product {
                border: 1px solid #ddd;
                padding: 15px;
                margin: 15px;
                text-align: center;
            }
            .product img {
                max-width: 100%;
                height: auto;
            }
        </style>
    </head>
    <body>
    
        <div class="header">
            <h1>Fashion Shop</h1>
            <p>Trendy Styles Just for You</p>
        </div>
    
        <div class="container">
            <div class="row">
                <div class="col-md-4 product">
                    <img src="https://via.placeholder.com/300" alt="Product 1">
                    <h3>상품명 1</h3>
                    <p>₩ 가격</p>
                    <button class="btn btn-primary">장바구니에 담기</button>
                </div>
                <div class="col-md-4 product">
                    <img src="https://via.placeholder.com/300" alt="Product 2">
                    <h3>상품명 2</h3>
                    <p>₩ 가격</p>
                    <button class="btn btn-primary">장바구니에 담기</button>
                </div>
                <div class="col-md-4 product">
                    <img src="https://via.placeholder.com/300" alt="Product 3">
                    <h3>상품명 3</h3>
                    <p>₩ 가격</p>
                    <button class="btn btn-primary">장바구니에 담기</button>
                </div>
            </div>
        </div>
    
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
    </html>