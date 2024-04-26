/*
*DDL(Data Definifion Language) : cteate, alter, truncate, drop
*DML(Data Manipulation Language) : insert, update, delete
*
*/

--create table ...as select
--테이블 모양(컬럼이름, 데이터타입)과 데이터를 복사
--emp테이블을 ex_emp6으로 복사:
create table ex_emp6 as select * from emp;

select * from ex_emp6;

-- emp 테이블의 모양과 똑같은 테이블을 생성, 데이터(행)는 복사하지 않음.
create table ex_emp7
as select * from emp where empno = -1;

select * from ex_emp7;

-- truncate table: 테이블의 모든 행을 삭제하는 DDL
select * from ex_emp6;

truncate table ex_emp6;

-- drop table: 테이블을 삭제하는 DDL
drop table ex_emp7;


-- DML
-- insert into 테이블 (컬럼, ...) values (값, ...);
----> 테이블에 1개 행을 삽입(insert)
-- insert into 테이블 (컬럼, ...) select ...;
----> select 결과만큼 여러개의 행(들)을 삽입(insert)
select * from ex_emp6;

-- emp 테이블에서 부서번호가 10번인 행들을 ex_emp6에 삽입:
insert into ex_emp6
select * from emp where deptno = 10;

--emp 테이블에서 수당(comm)이 null이 아닌 행들을 bonus 테이블에 삽입:
insert into bonus
select ename, job, sal, comm from emp where comm is not null;

select * from bonus;

commit;

--------------------------------------------------

-- * update 문장 : 테이블의 데이터를 업데이트(수정)
--문법 : update 테이블이름 set 변수 = 값, ... where 조건식;
--update 테이블이름 set 변경할 컬럼 = 변경 값, ... where 바꿀 행을 선택할 조건식;
select * from emp;

-- emp 테이블에서 사번이 1004인 직원의 급여를 6000으로 변경하기
update emp set sal = 6000 -- 여기에서 끝내면 sal 컬럼에 있는 모든 값(행들) 전부 6000으로 변경됨.
where empno = 1004;

--where 조건식이 없으면 update 문장은 테이블의 모든 행의 값을 업데이트함.
--한꺼번에 업데이트 할경우가 아니고 특정 행만 값을 변경하려면 where절을 사용해야..!!
commit; -- 현재까지의 모든 변경 내용을 영구히 저장.

update emp set sal = 6000;

rollback; -- 직전의 commit 상태로 되돌림.(61번 상태로 돌아감)
--실제 업무에서의 활용 : 쇼핑몰 주문 동작에서 업데이트 중이었다가 
--결제 카드 부분에 실패하면 그동안의 업데이트 내용 원상태로 되돌릴때 명령.

select * from emp;

-- 사번이 1004인 직원의 업무를 'MANAGER', 입사날짜를 '2024/04/25'로 변경
update emp set job = 'MANAGER' , hiredate = '2024/04/25' -- 문자열로 써도 자동으로 변환해 줌. 더 정확히는 to_date함수 이용해야!
where empno = 1004;

select * from emp where empno = 1004; --수정 내용 확인

------------------------------------------------------------------------------
--문제
--'ACCOUNTING' 부서에서 일하는 직원들의 급여를 10% 인상:
update emp set sal = sal * 1.1 --sal + (sal * 0.1)
where deptno = (select deptno from dept where dname = 'ACCOUNTING');

select * from emp where deptno = (select deptno from dept where dname = 'ACCOUNTING');-- 확인

-- salgrade가 1인 직원들의 급여를 25% 인상:

update emp set sal = sal * 1.25 -- sal + (sal * 0.25) 
where sal between (select losal from salgrade where grade = 1) and (select hisal from salgrade where grade = 1);

select * 
    from emp 
    where sal between (select losal from salgrade where grade = 1) and (select hisal from salgrade where grade = 1);
-- 확인
-----------------------------------------------------------------------------------------

--* delete
--delete from 테이블이름 where 삭제할 행의 조건;

--emp 테이블에서 사번 1004인 직원 정보를 삭제:
delete from emp where empno = 1004;

select * from emp;
commit;

delete from emp; -- 모든 행 삭제
rollback; -- 되돌리기
------------------------------------------------------------------------------------

--연습 문제

--emp테이블에서 1987년에 입사한 사원들을 삭제:
delete from emp where to_char(hiredate,'YYYY') = '1987';
--to_char(hiredate,'YYYY') 날짜를 문자열로 변환 해서 년도 4자리만 가져와서 비교

select * 
    from emp
    order by hiredate desc;

rollback;
















