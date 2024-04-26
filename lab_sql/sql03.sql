/*
* 조건 검색(where)
* select 컬럼명, … from 테이블명 where 조건식 [order by 컬럼명,…];
*/

--문제 
--1. 직원 테이블에서 10번 부서에서 근무하는 직원들의 부서번호, 사번, 이름을 출력
-- 정렬 기준 사번 오름차순
select deptno, empno, ename
    from emp
    where deptno = 10
    order by empno;
    
 -- 주의 : 자바는 == , sql은 = 
 -- 헷갈리지 않게 기억해 두기    
-----------------------------------------------------------------------------

--2. 직원 테이블에서 수당(comm)이 null이 아닌 직원들의
--사번, 부서번호, 이름, 급여, 수당을 출력
-- 정렬 사번 오름차순

select empno, deptno, ename, sal, comm
    from emp
    where comm is not null
    order by empno;

--> sql의 null 여부 비교 할 때는 =, != 사용 하면 안된다.
--문법 오류는 아니여서 실행은 되는데, 원하는 결과가 나오지 않는다.
--sql에서 null 여부 비교 할 때는 반드시 is null, is not null을 사용하자.
------------------------------------------------------------------------------

--3. 직원 테이블에서 급여가 2000 이상인 직원들의 
--이름, 업무, 급여를 출력
-- 정렬 급여 내림차순
select ename, job, sal
    from emp
    where sal >= 2000
    order by sal desc;

-----------------------------------------------------------------------------

--4. 직원 테이블에서 급여가 2000 이상 3000이하인 직원들의
--이름, 업무, 급여 검색
-- 정렬 급여 내림차순

--풀이 1
select ename, job, sal
    from emp
    where sal between 2000 and 3000
    order by sal desc;
    
--> 컬럼명 between A and B
-- 컬럼에서 A이상 B이하 사이에 있는 행
    
--풀이 2    
 select ename, job, sal
    from emp
    where sal >= 2000 and sal <= 3000
    order by sal desc;   
 
 -->흔히 하는 실수 2000 <= sal <= 3000 
 -- 이렇게 쓰면 틀림. 나눠서 써야 함.
 -- and 라고 써야지 자바처럼 && 논리 연산자 쓰면 안됨. 
 --------------------------------------------------------------------------
 
 --5.직원 테이블에서 10번 또는 20번 부서에서 근무하는 직원들의
 -- 부서번호, 이름, 급여를 검색
 -- 정렬 부서번호 오름차순
 
 select deptno, ename, sal
    from emp
    where deptno = 10 or deptno = 20
    order by deptno;
 
 -->흔히 하는 실수 
 -- where deptno = 10 or 20 
 -- 이렇게 하면 틀림. 문법 오류
 -- 비교식 or 비교식 이렇게 써야 함.
 -- 비교식 or 값 이건 안됨.
 
 --간단하게 쓰기
  select deptno, ename, sal
    from emp
    where deptno in(10,20)
    order by deptno;

 --> 부서번호가 in(값 나열)이런 값들 안에 있으면 true 
 --------------------------------------------------------------------------
 
 --직원 테이블에서 업무가 'CLERK'인 직원들의
 --업무, 이름, 급여를 출력. 정렬 순서 : 이름(언급 없으면 오름차순)
 select job, ename, sal
    from emp
    where job = 'CLERK'
    order by ename;
  -->'clerk'로 쓰면 값이 안 나옴. -> ''안에 감싸는 문자열은 대소문자를 구분한다.
  -->(주의) sql에서는 문자열에 ""사용 안함. as "별명"에만 사용.
  --> SQL에서는 문자열을 비교할 때 =,!= 연산자를 사용
  --> SQL에서 문자열을 작은 따옴표('')를 사용. 대/소문자 구분함
 
 -- 직원 테이블에서 업무가 'CLERK' 또는 'MANAGER'인 직원들의
 -- 업무, 이름, 급여를 검색. 정렬 순서 1. 업무, 2. 급여
 
 --풀이 1
 select job, ename, sal
    from emp
    where job = 'CLERK' or job = 'MANAGER'
    order by job, sal;
 --풀이 2   
 select job, ename, sal
    from emp
    where job in('CLERK','MANAGER')
    order by job, sal;    
    
 -- 직원 테이블에서 20번 부서에서 근무하는 CLERK의
 -- 모든 정보(컬럼)을 검색.
 select *
    from emp
    where deptno = 20 and job = 'CLERK';
    
 -- 직원 테이블에서 CLERK, ANALYST, MANAGER가 아닌 직원들의
 -- 사번, 이름, 업무, 급여를 검색. 정렬 순서: 사번
 
 --풀이 1
 select empno, ename, job, sal
    from emp
    where job not in ( 'CLERK', 'ANALYST', 'MANAGER')
    order by empno;
    
 --풀이 2   
  select empno, ename, job, sal
    from emp
    where job !='CLERK' and job != 'ANALYST' and job != 'MANAGER'
    order by empno;
 ------------------------------------------------------------------
 
 --'1987/01/01' 이후에 입사한 직원들의 모든 정보(컬럼) 출력. 정렬 : 입사일 오름차순
 select *
    from emp
    where hiredate > '1987/01/01'  
    order by hiredate;
    
 --hire고용하다 
 --hiredate 고용한 날짜(=입사일)
 --> '1987/01/01'는 ''로 묶여 있으니까 문자열. 암묵적 자동 변환
 --> 크기를 비교하려면 둘 다 타입을 맞춰놓고 비교해야 됨.
 --> hiredate는 날짜 타입
 --> '1987/01/01'는 문자열 타입
 -->  hiredate 날짜를 문자열 타입으로 변환해서 비교함.
 
 --> 암묵적(자동) 타입 변환:
 -- 오라클은 hiredate 컬럼(date 타입)과 문자열 '1987/01/01'의
 -- 크기를 비교할 때
 -- 날짜 타입을 문자열로 변환한 후 문자열의 크기 비교를 수행함.
 -------------------------------------------------------------------
 
 -- 문자열을 날짜로 타입 변환하여 대소비교
 select *
    from emp
    where hiredate > to_date('1987/01/01')
    order by hiredate;
 --> 명시적 타입 변환 :
 -- to_date('문자열') : '문자열'을 날짜(date) 타입으로 변환해주는 함수.
 -- 문자열 타입 '1987/01/01'을 to_date 함수를 사용해서 날짜 타입으로 변환해서 대소 비교.
 -------------------------------------------------------------------
-- * like 검색

--like검색 : 
--특정 문자열로 시작하거나, 특정 문자열이 포함된 값을 찾는 검색

 -- 이름이 'A'로 시작하는 직원들의 모든 정보:
 
 select *
    from emp
    where ename like 'A%';
 -- 첫글자가 A로 시작하고 % 뒤에 몇 글자가 와도 상관 없다는 뜻.
-- like 검색에서 사용하는 와일드 카드
-- 1. % : 와일드 카드. 글자 수 제한 없음
-- 2. _ : 언더스코어(underscore). 언더바가 있는 자리에 어떤 문자가 있어도 됨. 

select * 
    from emp
    where job like '_LERK';
    
 -- 직원 이름에 'A'가 포함된 직원들의 모든 정보
 select *
    from emp
    where ename like '%A%';
 -- A 앞 뒤로 몇글자가 와도 상관 없이 A가 포함된     
 
 ------------------------------------------------------------------------
 
 --30번 부서에 근무하고, 업무이름에 'SALES'가 포함되어 있는 직원들의
 -- 사번, 부서번호, 이름, 업무, 급여, 수당 출력
 -- 정렬 : 사번 오름차순
 select empno, deptno, ename, job, sal, comm
    from emp
    where deptno = 30 and job like '%SALES%'
    order by empno;
    
---------------------------------------------------------------------------







 