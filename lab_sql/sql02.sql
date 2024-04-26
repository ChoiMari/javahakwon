/*
* 기본 쿼리 문장:

* select 컬럼이름, ... from 테이블이름;

*테이블에서 모든 컬럼을 검색할 때 사용하는 문장
* select * from 테이블 이름;
*/

-- emp : 직원 테이블
-- dept : 부서 테이블
--직원 테이블에서 사번(empno)과 직원 이름(ename)을 검색:

--나열하는 컬럼 순서 대로 출력되서 보여준다.
select empno,ename from emp;
select ename,empno from emp;

-- 직원 테이블에서 모든 컬럼을 검색 :
select * from emp; --테이블에서 만들어진 순서 그대로 출력
-- 하나하나 컬럼 이름을 다 나열에서 출력 할 수도 있음 : 
-->이 경우에는 나열하는 순서에 따라서 출력 되는 컬럼의 위치가 따라 달라짐.

--컬럼 이름에 별명(alias) 주기:
--출력되는 것이 보고서라고 생각을 해보면
-- 컬럼 이름들이 테이블 만들때 지어진 것.-> 바꿀수가 없음
-- 컬럼 이름들이 약자로 표현 되서 의미가 불분명할때나 영어를 한글로 컬럼이름의 표시 방법을 바꿀 때
-- 사용 하는 방법.

-- 사용 방법:
-- as "별명" 
--('작은 따음표는 사용 불가)

--부서 테이블에서 부서번호, 부서이름을 검색 :
select deptno, dname from dept;

--별명 주기
select deptno as "부서번호", dname as "부서이름" from dept;
--별명에 공백이 없는 경우(한 단어인 경우)에는 큰따음표 생략 가능하다.
--별명에 공백을 포함하는 경우 큰따음표를 반드시 사용해야 한다.
--별명에는 큰따음표("")만 사용해야 한다. 작은 따음표는('')사용 불가함.
--별명에서만 큰 따음표 쓴다고 함
--오라클은 문자열을 ''작은 따음표를 쓴다고.
--(주의) SQL에서 문자열은 작은따옴표로 표시 : 예) 'SCOTT'

--부서 번호(deptno) 컬럼에만 별명 주기
select deptno as "부서 번호", dname from dept;

--**연결 연산자(||) : 
-- 2개 이상의 컬럼 또는 문자열을 합쳐서 하나의 컬럼으로 출력해준다.
select deptno || dname from dept;

select deptno || '-' ||dname from dept;
--큰따음표 쓰면 안됨 "-" 에러남. 
-- SQL에서 문자열은 '' 작은따옴표로 감싸야 한다.
--큰따음표는 as "별명" 별명 만들때만 사용

--'부서번호-부서이름' 형식의 문자열을 "부서"라는 컬럼으로 출력:
--묶어서 하나의 컬럼으로 출력.
select deptno || '-' ||dname as "부서" from dept;

--부서 테이블을 검색해서 'A부서는 B에 있습니다.' 형식으로 출력하기
select dname || '부서는 ' || loc || '에 있습니다.' as "부서정보" from dept;

-- 직원 테이블을 검색해서 'A의 급여는 B'형식으로 출력:
SELECT ename || '의 급여는 ' || sal as "직원 급여" from emp;
--여기까지는 지난 시간에 한 것.
---------------------------------------------------------------------
--여기서 부터 2024/04/22 수업
--검색 결과를 정렬해서 출력:
--문법 
--select 컬럼명,... from 테이블명 order by 컬럼명(정렬 기준이 되는) [asc/desc];
--실행 순서 1. from 테이블명 2. select 3.정렬(order by)
--asc 오름차순 정렬, desc는 내림차순 정렬.
--asc 오름차순 정렬이 정렬의 기본값(생략가능) 따로 안쓰면 기본적으로 오름차순 정렬됨.(작은 값이 맨위)

--부서 테이블에서 부서번호,부서이름을 출력하는데 부서 이름을 기준으로 오름차순 정렬.
select deptno, dname 
    from dept 
    order by dname asc; --asc는 생략 가능(안써도 기본값으로 오름차순 정렬 됨)

--부서 테이블에서 부서 번호,부서 이름을 출력하는데 부서 이름을 기준으로 내림차순 정렬
select deptno, dname
    from dept
    order by dname desc; --desc는 생략 불가능(안쓰면 기본값인 오름차순asc로 출력되서 나옴)
 --------------------------------------------------------------------------------------
 --문제 풀이
 --1. 직원테이블(emp)에서 사번,이름,급여를 검색. 사번을 기준으로 오름차순 정렬하기
 select empno, ename, sal
    from emp
    order by empno;
 
 --2. 직원테이블에서 사번,이름,급여를 검색. 급여를 기준으로 내림차순 정렬
 select empno, ename, sal
    from emp
    order by sal desc;
    
 --3. 직원 테이블에서 부서번호,사번,이름을 검색
 --(1) 정렬 순서 부서번호 기준 오름차순 하고 (2) 사번 기준 오름차순하기(정렬 2가지)
 select deptno, empno, ename
    from emp
    order by deptno, empno; --asc 생략 됨.나열하는 순서 대로 정렬 됨.
    
 --4. 직원테이블에서 부서번호,사번,이름,급여를 검색. 
 --(1) 부서 번호 기준으로 오름차순 하고 (2)급여 내림차순
select deptno, empno, ename, sal
    from emp
    order by deptno, sal desc; --deptno asc에서 asc는 생략 가능 

-------------------------------------------------------------------------------

--* <중복되지 않는 결과 출력하기>: distinct(다른 것과 구분이 되는)
select job 
    from emp; --> 14개 행(record)

select distinct job 
    from emp;

select distinct job
    from emp
    order by job;

-- 문제
-- 1. 중복되지 않는 부서번호, 업무를 출력. 부서번호 기준으로 오름차순 하기
select distinct deptno, job
 from emp
 order by deptno;
-->distinct 각각의 컬럼명 앞에 2번쓰면 오류남 
-- distinct deptno, distinct job 이렇게 쓰면 오류.
-- 두 개를 합쳤을 때 중복 값 안 나오게..

-- 2. 중복되지 않는 부서번호, 업무 출력 정렬 : (1)부서번호 오름차순 (2) 업무 오름차순

