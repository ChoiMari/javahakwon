create table FROG_SIDE_MENU_TB (
SIDE_NAME          VARCHAR2(60)    PRIMARY KEY,
SIDE_PRICE         NUMBER(10)      CHECK (SIDE_PRICE >= 0), 
SIDE_KCAL          NUMBER(10,2)    CHECK (SIDE_KCAL >= 0), 
SIDE_COOK          VARCHAR2(30),
SIDE_POPULARITY    NUMBER(10)
);

commit;

insert into FROG_SIDE_MENU_TB 
(SIDE_name, SIDE_price, SIDE_kcal,SIDE_cook,SIDE_popularity)
values('페퍼로니가득파스타', 8800, 888,'김개구리',80);

insert into FROG_SIDE_MENU_TB 
(SIDE_name, SIDE_price, SIDE_kcal,SIDE_cook,SIDE_popularity)
values('베이컨크림까르보나라',6000, 765,'김개구리',55);

insert into FROG_SIDE_MENU_TB 
(SIDE_name, SIDE_price, SIDE_kcal,SIDE_cook,SIDE_popularity)
values('찰치즈볼',3000, 543,'김개구리',65);

insert into FROG_SIDE_MENU_TB 
(SIDE_name, SIDE_price, SIDE_kcal,SIDE_cook,SIDE_popularity)
values('콘소메양념감자',5000, 655,'김개구리',40);

insert into FROG_SIDE_MENU_TB 
(SIDE_name, SIDE_price, SIDE_kcal,SIDE_cook,SIDE_popularity)
values('개구리그린샐러드', 9000, 324,'김개구리',33);