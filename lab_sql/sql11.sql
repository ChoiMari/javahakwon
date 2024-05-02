create table FROG_DRINK_MENU_TB (
DRINK_NAME          VARCHAR2(60)    PRIMARY KEY,
DRINK_PRICE         NUMBER(10)      CHECK (DRINK_PRICE >= 0), 
DRINK_KCAL          NUMBER(10,2)    CHECK (DRINK_KCAL >= 0), 
DRINK_POPULARITY    NUMBER(10)
);

commit;


insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('♡개구리피자♡',1000000,5000,'개구리',1);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('불고기피자',25000,1200,'이검희',75);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('슈림프피자',33000,1500,'윤정이♡',80);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('슈림프피자',33000,1500,'윤정이♡',80);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('포테이토피자',38000,2300,'불량감자',90);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('고구마피자',40000,2800,'민선이>_<',100);