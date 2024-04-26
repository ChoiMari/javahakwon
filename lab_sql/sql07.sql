/*
*alter 변경
*/

--1. 이름 변경 :
--(1) 테이블 이름 변경
select table_name from user_tables; -- 접속 계정의 테이블 이름

--ex_students 테이블을 students로 이름 변경
alter table ex_students rename to students;
--alter table 기존 테이블이름 rename to 변경할 테이블 이름;

--(2) 테이블 컬럼 이름 변경
describe students; --표준 sql은 아니고 오라클의 테이블 설명 명령어.
--테이블에 대한 설명을 프린트 해라.
--컬럼이름, 널 가능 여부, 데이터타입 이 3가지만 보여줌

--stuno 컬럼을 stuid로 이름 변경:
alter table students rename column stuno to stuid;
--alter table students 테이블을 변경한다 rename column stuno 을 to stuid으로 변경.
--단순하게 컬럼 이름만 변경하는 것.
--alter table 테이블이름 rename column 기존컬럼이름 to 바꿀컬럼이름;

--(3) 제약 조건 이름 변경
--제약 조건 이름 뽑기
select constraint_name from user_constraints;

--제약조건 ex_emp4_fk_deptno을 emp4_fk로 이름 변경
alter table ex_emp4 rename constraint ex_emp4_fk_deptno to emp4_fk;
--alter table 테이블이름 rename 기존제약조건이 to 바꿀제약조건이름;

--추가(add)
--(1) 제약조건 추가
describe students;

--students 테이블의 stuid 컬럼을 PK로 설정
alter table students add constraint students_pk primary key (stuid);
--alter table 테이블이름 add constraint 제약조건이름 제약조건 (컬럼이름);

--(2) 컬럼 추가
alter table students add department number(2);
--alter table 테이블 이름 add 컬럼이름 데이터타입;

--삭제(drop)
--(1) 제약조건 삭제
alter table students drop constraint students_pk;
--alter table 테이블 이름 drop constraint 제약조건이름;

--제약조건 추가
alter table students add constraint dept_nn check (department is not null);
--ORA-02293: (SCOTT.DEPT_NN)을 검증할 수 없습니다 - 잘못된 제약을 확인합니다
--컬럼에 제약조건에 위배되는 값들을 가지고 있다는 뜻.
--students테이블의 department컬럼의 기존에 가지고 있던 데이터(행)에 null값이 들어가 있어서
-- check (department is not null)조건을 주어 제약 조건을 추가할 수가 없다.
-- 해결 : insert로 값들을 채워주어서 null값을 없애야 추가 할 수 있음.

update students set department = 10;

select * from students;


--들어가 있는 데이터에 한해서 제약조건을 추가할 수도 있고 없을 수도 있다.
--기존에 들어가 있는 데이터가 제약 조건에 맞아야 함.

commit;

--(2) 컬럼 삭제
alter table students drop column department;

describe students;
-----------------------------------------------------------
--modify는 제약조건의 내용 변경 불가
--수정(midify) : 컬럼 정의(테이터 타입, 기본값, null 여부)를 수정.
--기존의 students 테이블의 stuname 컬럼의 데이터 타입을
--varchar2(4 char)에서 varchar2(40 char)로 변경하고 not null추가
-- 제약조건 삭제(alter table ...drop constraint ...)
-- 제약조건 추가(alter table ...add constraint ...)
alter table students modify stuname varchar2(40 char) not null;
--alter table 테이블이름 modify 컬럼이름 바꿀테이터타입 추가할 제약조건;
describe students;
---------------------------------------------------------

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

