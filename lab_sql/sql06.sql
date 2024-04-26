/*
*테이블 생성
*/

-- 테이블 이름 : ex_students
-- 컬럼 :
-- 1. 컬럼이름 : stuno 학생 번호(학번), 데이터 타입 : 숫자 6자리
-- 2. stuname 학생이름, 문자열(4글자)
-- 3. birthday 생일, 날짜

create table ex_students(
    stuno        number(6),
    stuname      varchar2(4 char), --4 char 4글자, 4byte라고 쓰면 한글은 1글자 UTF-8 한글은 1글자에 3byte사용. 유니코드는 한글 1글자가 2byte
    birthday     date
);

--같은 이름으로 테이블 못 만듬. 문법 오류 없으면 생성이 됨. 2번째 실행시 실패 - 같은 이름으로는 테이블을 못 만들어서..
-- DB에서 객체라고 하면 주로 테이블이라고.. 
--SQL에서는 컬럼 이름부터 먼저 나열하고 뒤에 데이터 타입을 쓴다.

--* insert 행 삽입
--테이블의 삽입하는 값의 개수가 컬럼의 개수와 같고,
--값들의 순서가 테이블 생성 시의 컬럼 순서와 같으면 
-- insert into 테이블 values(값, ...);

select * from ex_students;

insert into ex_students 
values (241001, '홍길동', '2000/12/31'); 
--'2000/12/31' 문자열이 자동으로 날짜타입으로 변환되서 행이 삽입됨.

insert into ex_students (stuno,stuname)
VALUES (241002,'오쌤');

--insert할 때 에러나는 경우
insert into ex_students values ('abcd', 1, sysdate); 
-- 안됨. 
-- 실행 중 오류 : 'abcd' 문자열은 학번(숫자 타입)이 될 수 없기 때문.

insert into ex_students VALUES (1,'abcd');
-- 실행 중 오류 : 테이블의 컬럼 개수와 values에서 ()안에 나열한 값들의 개수가 다르기 때문에 오류

--에러 안나게 수정
insert into ex_students (stuname, stuno, birthday)
values ('abcd', 1, sysdate);
--컬럼 이름에 들어갈 값의 순서만 잘 지켜주면 된다.
--> 테이블 이름 뒤에 컬럼 이름을 쓰는 경우 컬럼 순서를 지킬 필요는 없음.
--> 테이블 이름 뒤에 ()에 나열한 컬럼 이름 순서와 values ()안에 넣는 값의 순서를 맞춰서 타입을 일치시키면 된다.

insert into ex_students (stuno) values(1234567);
--stuno number(6) 6자리로 설정했는데 7자리로 값을 써서 오류
--실행 중 오류 : stuno 컬럼의 숫자 자리수 보다 큰 값이기 때문에 

insert into ex_students (stuname) values ('가나다라마');
--> 실행 중 오류 : stuname 컬럼은 최대 4글자(4char)로 설정해서 테이블을 생성 했기 때문에
--> 그 이상의 크기를 저장할 수 없다.

commit; --> 현재까지의 insert 내용을 DB 테이브에 영구 저장.

--한글 vs 영문자 byte 비교
-- 테이블 생성 
create table ex_test_byte(
    ctest varchar2(4 byte)
);

--insert 행 삽입
insert into ex_test_byte values ('abcd'); --> 성공
insert into ex_test_byte values ('한글'); --> 실패
--> 열에 대한 값이 너무 큼(실제: 6, 최대값: 4)
--> varchar2(4 byte)로 설정해서 테이블을 만들었는데 '한글' 이건 6byte라는 의미 
--> 그래서 설정해 놓은 값보다 큰 값이라 행 삽입 실패.
--> UTF-8일 때, 영문자/숫자/특수기호는 1byte, 한글은 3byte.
--결론 : 그래서 문자열을 byte로 할건지 char로 할건지 생각을 해야.. 
--byte는 인코딩에 따라서 달라짐. 유니코드는 한글이 2byte라고 함.
--------------------------------------------------------------------

--테이블을 생성할 때 컬럼에 기본값 설정하기:
create table ex_test_default (
    tno     number(4), 
    tdate   date default sysdate 
    --default sysdate [기본값] 설정 부분 . 시스템 현재 날짜를 기본값으로 설정함.
    -- 타입이 timestamp로 했으면 systimestamp로하면 된다고..??
);

insert into ex_test_default values(
    1,
    '2024-03-14'
);

insert into ex_test_default (tdate) values ('2024-03-15');

insert into ex_test_default (tno) values (1234);

select * from ex_test_default;

/*
*제약조건
*/

-- 테이블 생성할 때 제약 조건 만들기 1 :
-- 제약조건 이름을 설정하지 않기

create table ex_emp1(
    eno     number(4)       primary key, -- 사번, 고유키
    ename   varchar2(10)    not null, -- ()안에 단위를 안쓰면 byte단위로 만들어짐
    email   varchar2(100)   unique, -- 이메일
    age     number(3)       check (age >= 0), -- 나이 음수 나오지 않도록 제약
    memo    varchar(1000)
);

insert into ex_emp1
values (1001, '홍길동', 'hdg@itwill.com', 16, '안녕하세요');

insert into ex_emp1(eno,ename)
values (1002, '허균');

insert into ex_emp1 (eno, ename)
values (1002, 'abc'); -- 오류 발생 : 무결성 제약 조건(SCOTT.SYS_C008318)에 위배됩니다
--SCOTT계정이름 SYS_C008318는 제약 조건의 이름 PK 위배

insert into ex_emp1 (eno) values (1003);
--오류 발생 ORA-01400 : NULL을 ("SCOTT"."EX_EMP1"."ENAME") 안에 삽입할 수 없습니다
--ENAME 컬럼에 notnull 제약 조건 위배.
--"SCOTT"계정에 "EX_EMP1"테이블의 "ENAME" 컬럼안에 null 불가능.
--번역 매끄럽지 않으면 ORA-01400 에러코드 검색해보기.

insert into ex_emp1 (eno, ename, email)
values (1003, 'Johne Doe', 'hdg@itwill.com');
--오류발생 : ORA-00001: 무결성 제약 조건(SCOTT.SYS_C008319)에 위배됩니다
-- unique 제약 조건 위배

insert into ex_emp1 (eno, ename, age)
values (1005, 'Scott', -1);
--오류 발생 : ORA-02290: 체크 제약조건(SCOTT.SYS_C008317)이 위배되었습니다
--check (age >= 0) 제약 조건 위배. age 음수 못 들어감


select * from ex_emp1;
commit;


--제약 조건 만들기 2 : 제약 조건 이름 설정 O
-- constraint 제약조건이름(테이블이름_제약조건약자_컬럼이름)
create table ex_emp2 (
    id      number(4)       
            constraint  ex_emp2_pk_id       primary key,
    ename   varchar2(10)    
            constraint  ex_emp2_nn_ename    not null,
    email   varchar2(100)   
            constraint  ex_emp2_uq_email    unique,
    age     number(3)      
            constraint  ex_emp2_ck_age      check  (age >= 0),
    meno    varchar2(1000)
);

--test

insert into ex_emp2(id, ename)
values (1, '홍길동'); --행 삽입 성공

insert into ex_emp2(id, ename)
values (1,'오쌤');
--오류 ORA-00001: 무결성 제약 조건(SCOTT.EX_EMP2_PK_ID)에 위배됩니다

select * from ex_emp2;

commit;

-----------------------------------------------------------------------

--제약 조건 만들기 3 : 컬럼 정의 따로(데이터 타입 선언), 제약 조건 정의 따로

create table ex_emp3 (
    --컬럼 정의 : 컬럼이름 데이터 타입
    id          number(4),
    ename       varchar2(10),
    email       varchar2(100),
    age         number(3),
    meno        varchar2(1000),
    --제약 조건 정의 :constraint 제약조건이름 제약조건(제약조건을 줄 컬럼이름)
    constraint  ex_emp3_pk_id       primary key (id), 
    constraint  ex_emp3_nn_ename    check (ename is not null),-->주의 not null(ename) 안됨 : not null제약 조건은 정의가 끝난 뒤에는 못 씀.
    constraint  ex_emp3_uq_email    unique (email),
    constraint  ex_emp3_ck_age      check (age>=0)
);


insert into ex_emp3 (id)
values (1234);
--체크 제약조건(SCOTT.EX_EMP3_NN_ENAME)이 위배되었습니다
--check(not null) 위배.
----------------------------------------------------------------------------------------

-- * FK(Foreign Key, 외래키) : 다른 테이블의 PK를 참조하는 제약조건.
-- 데이터를 insert할 때, 다른 테이블의 PK에 없는 값이 삽입되지 않도록 하기 위한 제약조건(데이터의 무결성 위해 방지)
-- FK를 설정하기 전에, 먼저 다른 테이블에서 PK 설정이 되어있어야 함. 
-- 테이블을 만들 때, FK를 설정하려면, PK가 설정된 다른 테이블이 먼저 생성 되어 있어야 함.
-- 실제 현장에서는 직원테이블 먼저 만든다고 함. 부서는 나중에. 그런 경우가 종종..

create table ex_dept (
    deptno      number(2)       
    constraint  ex_dept_pk_deptno   primary key,
    dname       varchar2(10)    
    constraint  ex_dept_nn_dname    not null
);

create table ex_emp4 (
    empno       number(4)       
    constraint  ex_emp4_pk_empno    primary key,
    ename       varchar(10)     
    constraint  ex_emp4_nn_ename    not null,
    deptno      number(2)       
    constraint  ex_emp4_fk_deptno   references  ex_dept (deptno)
); --references 참조한다  ex_dept테이블의 (deptno) 컬럼을
--references  참조테이블이름 (PK로 설정된 참조할 컬럼이름)

insert into ex_emp4 values (1200,'오쌤',10);-- 오류
--ORA-02291: 무결성 제약조건(SCOTT.EX_EMP4_FK_DEPTNO)이 위배되었습니다- 부모 키가 없습니다
-- 이유 : 10번 부서가 ex_dept 테이블에 없는 경우에는 insert실패. PK위배
-- 10번 부서가 ex_dept 테이블에 있는 경우에는 insert 성공.
-- 참조하는 테이블의 PK로 설정되어있는 참조컬럼에 동일한 값이 저장 되어있어야 행 삽입 성공함.
-- null이나 중복된 값은 가능하다.

insert into ex_dept values (10,'개발1팀');

insert into ex_emp4 (empno, ename) values(1300,'홍길동');
-->FK 제약 조건이 있는 컬럼에는 null 삽입 될 수도 있음.

insert into ex_emp4 values (1400,'Jake',10);
-->FK 제약 조건이 있는 컬럼에는 중복된 값이 삽입될 수도 있음.

select * from ex_dept;
select * from ex_emp4;

----------------------------------------------------------------------

-- 컬럼 정의 따로, FK 제약조건 설정 따로
create table ex_emp05 (
    --컬럼 정의:
    empno       number(4),
    ename       varchar2(10),
    deptno      number(2),
    --제약 조건 정의:
    constraint ex_emp5_pk_empno  primary key (empno),
    constraint ex_emp5_nn_ename  check (ename is not null),
    constraint ex_emp5_fk_deptno foreign key (deptno) references ex_dept (deptno)
); --foreign key (컬럼이름) references 참조하는 테이블이름 (PK로 제약된 참조하는 컬럼이름)

-------------------------------------------------------------------------
--오라클은 테이블들을 관리하기 위한 테이블(user_tables)을 가지고 있음.
select * from user_tables;
select table_name from user_tables;

--오라클은 제약 조건들을 관리하기 위한 테이블(user_constraints)을 가지고 있음.
select * from user_constraints;
select constraint_name from user_constraints;



















