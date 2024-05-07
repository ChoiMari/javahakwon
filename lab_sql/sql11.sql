create table FROG_DRINK_MENU_TB (
DRINK_NAME          VARCHAR2(60)    PRIMARY KEY,
DRINK_PRICE         NUMBER(10)      CHECK (DRINK_PRICE >= 0), 
DRINK_KCAL          NUMBER(10,2)    CHECK (DRINK_KCAL >= 0), 
DRINK_POPULARITY    NUMBER(10)
);

commit;

insert into FROG_DRINK_MENU_TB (DRINK_NAME, drink_price, drink_kcal, drink_popularity)
values('개구리에이드', 10000,333,22);

insert into FROG_DRINK_MENU_TB (DRINK_NAME, drink_price, drink_kcal, drink_popularity)
values('콜라500ml',2000,216,150);

insert into FROG_DRINK_MENU_TB (DRINK_NAME, drink_price, drink_kcal, drink_popularity)
values('콜라제로500ml',2000,0,110);

insert into FROG_DRINK_MENU_TB (DRINK_NAME, drink_price, drink_kcal, drink_popularity)
values('스프라이트',2000,228,100);
------------------------------------------------
update  FROG_DRINK_MENU_TB
    set drink_popularity = 100
    where drink_name = '스프라이트';


---------------------------------------------------------------------------------------------------
--피자 메뉴 행 추가
insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('♡개구리피자♡',1000000,5000,'개구리',1);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('불고기피자',25000, 3840,'이검희',75);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('슈림프피자',33000,3670,'윤정이♡',80);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('포테이토피자',38000,3760,'불량감자',90);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('고구마피자',40000,3885,'민선이>_<',100);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('버섯피자',18000,2870,'양송이',22);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('토마토피자',18000,2680,'암예방',25);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('페퍼로니피자',21000, 3667,'김살라미',130);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('치즈피자',16000, 3010,'곰팡이',55);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('야채피자', 18000, 2577,'윤피망',60);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('파인애플피자', 18000, 2867,'박하와이',35);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('루꼴라피자', 20000, 2667,'김시금치',22);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('민초피자', 28000, 3995,'민치약',8);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('바나나피자', 27000, 3555,'미니언',30);

insert into frog_pizza_menu_tb (pizza_name, pizza_price, pizza_kcal,pizza_cook,pizza_popularity)
values('마라맛피자', 30000, 4005,'문다람쥐',80);
--------------------------------------------------------------------
update  FROG_PIZZA_MENU_TB
    set pizza_popularity = 22
    where pizza_name = '버섯피자';
    
update frog_pizza_menu_tb 
    set pizza_kcal = 3885
    where pizza_name = '고구마피자';

update frog_pizza_menu_tb 
    set pizza_name = '마라맛피자'
    where pizza_name = '떡볶이피자';    
    
    
    commit;
    
    
    create table FROG_PIZZA_ORDER_MENU_TB (
        GUEST_ID            varchar2(15),           
        GUEST_NAME          varchar2(21),   
        GUEST_PHONE         varchar2(25),
        PIZZA_NAME          varchar2(60),
        PIZZA_PRICE         number(10),
        DRINK_NAME          VARCHAR2(60), 
        DRINK_PRICE         NUMBER(10)      CHECK (DRINK_PRICE >= 0), 
        SIDE_NAME           VARCHAR2(60),
        SIDE_PRICE          NUMBER(10)      CHECK (SIDE_PRICE >= 0), 
        PIZZA_COOK          VARCHAR2(30),
        PIZZA_POPULARITY    NUMBER(10),
        ORDER_TIME          timestamp       default systimestamp, --주문시간
        PAYMENT_TIME        timestamp       default systimestamp --결제시간
    );
    
    
    
    
    
    
    
    
    