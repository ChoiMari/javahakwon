/*
*
*/

--모든 행의 문자열을 소문자로 바꾸기
select ename, lower(ename), job, lower(job)
    from emp;
    
--------------------------------------------

--to_char(...) : 다른 타입의 값을 문자열로 변환
--예) 날짜를 문자열로 변환 
-- 날짜 -> 문자열

--hiredate 출력 형식 바꾸기

select hiredate, to_char(hiredate, 'YYYY/MM/DD'),to_char(hiredate, 'MM-DD-YYYY')
    from emp;
------------------------------------------------------------------------------

--*nvl(변수, null일 때 대체해서 출력할 값):
-- 변수가 null이면 대체 값을 리턴하고,
-- null 아니면 원래 값을 리턴.
-- null아니면 원래값 나오고 null이면 대체값이 나옴.
select comm
    from emp;

select comm, nvl(comm,0) 
    from emp;
    
--nvl(변수,값1,값2) : 변수가 null이 아니면 값1을 리턴하고
--변수가 null이면 값 2를 리턴 하는 함수.
select comm, nvl(comm,0), nvl2(comm, comm, 0), nvl2(comm,'T','F')
    from emp;
--nvl2(comm,'T','F') :
--null이 아니면 값 1 리턴하고 null이면 값 2 리턴.
----------------------------------------------------------------
-- — 다중 행 함수

--예)
--count(컬럼) : null이 아닌 행의 개수를 리턴
select count(empno)
    from emp;
    
-- null은 빼고 세어줌 => 해결 count(nvl(mgr,0)) : null값을 0으로 대체해서 count   
select count(nvl(mgr,0))
    from emp;
    
--테이블의 행의 개수
select count(*) 
    from emp; --테이블에 있는 모든 행의 개수
    
----------------------------------------------------------------------

-- 직원 이름이(대/소문자 구분 없이) 'a'로 시작하는 직원들의 모든 정보

select *
    from emp
    where lower(ename) like 'a%';
----------------------------------------------------------------------

--사번, 이름, 급여, 수당 , 연봉을 검색
-- 연봉 = 급여 * 12 + 수당
select empno, ename, sal, comm, (sal * 12) + nvl(comm,0) as "연봉"
    from emp;
-- + nvl(comm,0) : 행에 null값이 있으면 0으로 대체 해서 계산.    
-- 계산식 중에 1개라도 null(값이 저장되지 않은 상태)인 경우에는 계산되지 않음. 
-----------------------------------------------------------------------
-- 전체 직원의 연봉의 합계 sum와 평균 avg, 최댓값 max, 최솟값 min
select sum(sal), avg(sal), max(sal), min(sal), variance(sal), stddev(sal)
    from emp;

----------------------------------------------------------------------

--from dual
-- 문법을 맞춰주기 위해서 dual : 실제로는 없는 가짜(더미)테이블 이름으로 사용하는 것이 dual;
select sysdate
    from dual;

select lower('Allen') 
    from dual;
-------------------------------------------------------------------------------------------

-- 단일 행 함수와 다중 행 함수는 함께 사용할 수 없음.
select sal, sum(sal)
    from emp;

select sum(comm)
    from emp;
    
select comm 
    from emp;
-- +더하기 연산 null이 들어가면 계산 안돼야 맞지만
--sum(comm)계산 잘 됨. => 이건 모든 통계함수가 다 잘 된다고..
-- null 제외하고 계산된다. 그래서 계산이 잘됨.
--결론 :  모든 통계 함수들은 null을 제외하고 계산을 한다.
    
------------------------------------------------------------------
--자습

select Instr('SMITH','M')
    from dual;

select rtrim(substr('abcdef@naver.com',instr('abcdef@naver.com','@')+1),'.com')
    from dual;

select ename, replace(sal,0,'*')
    from emp;
    
 select ename, lpad(sal,10,'*') as "salary1" , rpad(sal,10,'*') as "salary2" 
    from emp;
    
select ename, deptno, decode(deptno,10,300,20,400,0) as "보너스"
    from emp;
    
select ename, loc
    from emp, dept
    where emp.deptno = dept.deptno;

------------------------------------------------------------------------------
/*
* 그룹별 쿼리(query) -  그룹 별 select문장으로 생각하라고..
*/

--부서별 급여 평균

select deptno , round(avg(sal),2) as AVG_SAL
    from emp
    group by deptno;
    
-- 부서별 급여 평균, 표준 편차
select deptno, round(avg(sal),2) AVG_SAL, round(stddev(sal),2) STD_SAL
    from emp
    group by deptno
    order by deptno;
 
-- 모든 문제에서 소수점은 반올림해서 소수점 이하 2자리까지 표시.

-- Ex. 업무별 업무, 직원수, 급여 최댓값, 최솟값, 평균을 업무 오름차순으로 출력.
select job, count(*) count, max(sal) MAX_SAL, min(sal) MIN_SAL, round(avg(sal),2) AVG_SAL
    from emp
    group by job --업무별로 묶어서
    order by job;
-- Ex. 부서별/업무별로 부서번호, 업무, 직원수, 급여 평균을 검색.
--     정렬 순서: (1) 부서번호 (2) 업무
select deptno, job, count(*) count, round(avg(sal),2) AVG_SAL -- 3
    from emp --1
    group by deptno, job --2
    order by deptno, job; --4
 --부서별로 나누고 job별로 나눠서 계산해서 select
    
-- Ex. 입사연도별 사원수를 검색. (힌트) to_char(날짜, 포맷) 이용.
select to_char(hiredate, 'YYYY') YEAR, count(*) count
    from emp
    group by to_char(hiredate, 'YYYY') 
    order by YEAR; --year;--to_char(hiredate, 'YYYY');
    -- order by에 select에서 준 별명 YEAR 사용 가능. 
    --  select에서 준 별명은 order by에서만 가능하다
    -- 이유 : 실행 순서 때문에 
    -- 실행 순서 - from, group by, select, order by
    -- order by는 항상 마지막에 실행되기 때문에 가능.(select 한 뒤에 실행되는 거라 가능)
    
-- Ex. 부서별 급여 평균 검색. 급여 평균이 2000 이상인 부서만 검색.
select deptno, round(avg(sal),2) AVG_SAL
    from emp
    group by deptno
    having round(avg(sal),2) >= 2000 -- 그룹 조건. 조건에 해당하는 그룹만
    order by deptno;
-- Ex. mgr 컬럼이 null이 아닌 직원들 중에서 부서별 급여 평균을 검색.
--     정렬순서: 부서번호 오름차순.   
select deptno, round(avg(sal),2) AVG_SAL
    from emp
    where mgr is not null --그룹으로 묶기전에 조건에 해당하는 행들만 묶겠다는 뜻
    group by deptno
    order by deptno;
 ------------------------------------------------------------------------------
 -- 'PRESIDENT'는 제외한 업무별 사원수를 검색.
 -- 업무별 사원수가 3명 이상인 업무들만 검색
 -- 정렬 : 업무 오름차순
 select job, count(*) count -- 5. 검색, 추출 
    from emp -- 1. emp 테이블에서
    where job != 'PRESIDENT' --2. job이 'PRESIDENT'가 아닌것들만 
    group by job --3. job의 동일한 데이터 끼리 그룹으로 묶어서
    having count(*) >= 3 -- 4. 사원수가 3명인 업무들만
    order by job; --6. 업무를 기준으로 오름차순 정렬 -order by의 기본값 오름차순(asc)
    
--'PRESIDENT'는 제외한 조건은 where에 넣어도 되고, having 조건에 넣어도 됨. 결과 동일.
 select job, count(*) count -- 4.select(검색, 추출) 
    from emp -- 1. emp 테이블에서
    group by job --2. job의 동일한 데이터(행)끼리 그룹으로 묶어서
    having job != 'PRESIDENT' and count(*) >= 3 --3. job이 'PRESIDENT'가 아니고, 사원수가 3명인 업무들만
    order by job; --5. 업무를 기준으로 오름차순 정렬 -order by의 기본값 오름차순(asc)

-------------------------------------------------------------------------------
-- 입사년도와 부서별 사원수 검색
-- 1980년은 검색에서 제외 -- 그룹으로 묶기전에 제외해도 되고, 그룹으로 묶은 뒤에 제외해도 됨.
-- 년도별, 부서별 사원수가 2명 이상인 경우만 출력
-- 정렬 순서 : 1. 년도 오름차순 2. 부서 오름차순

select to_char(hiredate,'YYYY') YEAR, deptno, count(*) count
    from emp
    where to_char(hiredate,'YYYY') != '1980'
    group by to_char(hiredate,'YYYY'), deptno
    having count(*) >= 2
    order by YEAR, deptno;


select to_char(hiredate,'YYYY') YEAR, deptno, count(*) count
    from emp
    group by to_char(hiredate,'YYYY'), deptno
    having to_char(hiredate,'YYYY') != '1980' and count(*) >= 2
    order by YEAR, deptno;
-------------------------------------------------------------------------------
/* 서브쿼리
* 
*/

-- 급여가 평균 이상인 직원들?
-- select * from emp where sal >= 평균;
select avg(sal) 
    from emp;
    
select avg(sal)    
    from emp
    where sal >= 2073.21;

--select avg(sal)    
--    from emp
--    where sal >= avg(sal);    
--> 이거 안됨. sql에서는 함수 단독 사용 안됨. select from이 있어야 함
--> sql에서는 함수 호출 할 때 문장으로 만들어야 가져올 수 있음 -> 그래서 서브쿼리로 가져오는것

select *
    from emp
    where sal >= (
    select avg(sal) from emp
    );
 --서브 쿼리는 ()로 묶음.
 ----------------------------------------------------

-- ALLEN보다 더 적은 급여를 받는 직원들의 사번, 이름, 급여를 검색
select empno, ename, sal 
    from emp
    where sal < (
    select sal from emp where ename = 'ALLEN'
    );
-- 풀이
-- 1. ALLEN의 급여를 찾기 -> select sal from emp where ename = 'ALLEN'    
--> 이 문장이 서브 쿼리에 들어가는 것

    
-- ALLEN과 같은 업무를 담당하는 직원들의 사번, 이름, 부서번호, 업무, 급여 검색
select empno, ename, deptno, job, sal
    from emp
    where job = (
    select job from emp where ename='ALLEN'
    );

-- SALESMAN의 급여 최댓값 보다 더 많은 급여를 받는 직원들의 
-- 사번, 이름, 급여, 업무를 검색
select empno, ename, sal, job
    from emp
    where sal > (
    select max(sal) from emp where job = 'SALESMAN'
    );
    
---------------------------------------------------------------------------
-- Ex. WARD의 연봉보다 더 많은 연봉을 받는 직원들의 이름, 급여, 수당, 연봉을 검색.
-- 연봉 = sal * 12 + comm. comm(수당)이 null인 경우에는 0으로 계산.
-- 연봉 내림차순 정렬.
select ename, sal, comm, (sal * 12) + nvl(comm,0) ANNUAL_SAL
    from emp
    where (sal * 12) + nvl(comm,0) > (
        select sal from emp where ename = 'WARD' 
    )
    order by 4 desc; -- 별명을 써도 되고, 나열한 컬럼명 위치를 기준으로 해도 됨.
    
-- Ex. SCOTT과 같은 급여를 받는 직원들의 이름과 급여를 검색.
-- Ex. 위 결과에서 SCOTT은 제외하고 검색.
select ename, sal
    from emp
    where sal = (
      select sal from emp where ename = 'SCOTT'
    ) and ename != 'SCOTT';

-- Ex. ALLEN보다 늦게 입사한 직원들의 이름, 입사날짜를 최근입사일부터 출력.
select ename, to_char(hiredate,'YYYY/MM/DD') HIREDATE
    from emp
    where hiredate > (select hiredate from emp where ename = 'ALLEN')
    order by hiredate desc;

-- Ex. 매니저가 KING인 직원들의 사번, 이름, 매니저 사번을 검색.
select empno, ename, mgr
    from emp
    where mgr = (select empno from emp where ename ='KING');
    
-- Ex. ACCOUNTING 부서에 일하는 직원들의 이름, 급여, 부서번호를 검색.
--풀이 1
select ename, sal, deptno
    from emp
    where deptno = (select deptno from dept where dname = 'ACCOUNTING');

--풀이 2
select ename, sal, emp.deptno 
    from emp , dept
    where  emp.deptno = dept.deptno and dept.dname = 'ACCOUNTING';
    
select ename, sal, e.deptno, d.dname
    from emp e, dept d
    where  e.deptno = d.deptno and d.dname = 'ACCOUNTING';    
    
-- Ex. CHICAGO에서 근무하는 직원들의 이름, 급여, 부서 번호를 검색.
--풀이 1
select ename, sal, deptno
    from emp
    where deptno = (select deptno from dept where loc = 'CHICAGO');
    
--풀이 2
select ename, sal, emp.deptno
    from emp, dept
    where emp.deptno = dept.deptno and dept.loc = 'CHICAGO';

select ename, sal, e.deptno
    from emp e, dept d
    where e.deptno = d.deptno and d.loc = 'CHICAGO';
-- select에서 가져올때(검색, 추출 할 때)
-- 양쪽 테이블에서 겹치는(중복된) 컬럼은 어느 테이블의 컬럼을 select할 건지 명시를 해주어야지 select된다.
-- select e.deptno
-- 안그러면 어느 테이블에 있는 컬럼에서 select 하는지 몰라서 에러남. 
















