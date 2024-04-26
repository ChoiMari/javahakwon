/*
* join
*/

-- inner join과 outer join의 차이점을 설명하기 위해서 추가
insert into emp (empno, ename, sal, deptno)
values (1004,'오쌤', 3500, 50);

-- emp 테이블에 insert 행 추가 ()에만 넣은 컬럼에만 자료들을 넣겠다.
-- values()행에 들어갈 데이터 값.

commit; -- 테이블의 변경 내용을 영구히 저장한다는 뜻.

--rollback 변경사항 되돌림.

-- 사번, 이름, 부서번호, 부서이름 검색
-- * inner join 

--표준 문법
select empno, ename, emp.deptno, dname 
    from emp 
    inner join dept on emp.deptno = dept.deptno;
-- from emp inner join dept //from emp 테이블과 합친다 inner join dept테이블을
-- on 뒤에 조건 
-- inner join에서 inner은 생략 가능.
select empno, ename, emp.deptno, dname 
    from emp join dept 
    on emp.deptno = dept.deptno;

--오라클 문법
select empno, ename, emp.deptno, dname
    from emp , dept
    where emp.deptno = dept.deptno;
    
-- 테이블 이름 각각 붙이기 귀찮음... -> 테이블에 별명주기 가능
select empno, ename, e.deptno, dname
    from emp e, dept d
    where e.deptno = d.deptno;
-----------------------------------------------------------------------------   
-- * left (outer) join 

--표준 문법 left (outer) join
select e.empno, e.ename, e.deptno, d.dname
    from emp e 
        left outer join dept d 
        on e.deptno = d.deptno;
-- 양쪽 테이블에 교집합(공통)이 아닌 데이터(행)도 가져오는데 
-- 그중에 왼쪽 테이블에 있는 겹치지 않는 행을 결과로 가져오는 것(오른쪽 테이블 바깥 행은 결과에 안 가져옴)
-- left outer join에서 outer는 생략 가능.

--오라클 문법 left (outer) join
select e.empno, e.ename, e.deptno, d.dname
    from emp e, dept d
    where e.deptno = d.deptno(+);

select e.empno, e.ename, e.deptno, d.dname
    from emp e, dept d --> 여기에 쓴 위치로 왼쪽, 오른쪽 생각하고 +붙여야
    where d.deptno(+) = e.deptno; ---> 이것도 left join이라고..
 ----------------------------------------------------------------------------------
 -- * right (outer) join 

--표준 문법 right (outer) join
select e.empno, e.ename, d.deptno, d.dname
    from emp e
        right outer join dept d 
        on e.deptno = d.deptno;
 
 
 --오라클 문법 right (outer) join
select e.empno, e.ename, d.deptno, d.dname
    from emp e, dept d
    where e.deptno(+) = d.deptno;
 
 ------------------------------------------------------------------
 --full (outer) join
 select e.empno, e.ename, e.deptno, d.deptno, d.dname
    from emp e 
        full join dept d 
        on e.deptno = d.deptno;
 
 -- full outer join에서 outer은 생략가능
 -- 오라클은 full outer join 문법은 제공하지 않음.
 -- 대신, 집합연산이 있다고..
 -- 집합연산(합집합 union, 교집합 intersection, 차집합)
 -- full outer join => 오라클에서 합집합.
 select e.empno, e.empno, e.deptno, d.deptno, d.dname 
    from emp e, dept d
    where e.deptno = d.deptno(+)
    union
select e.empno, e.empno, e.deptno, d.deptno, d.dname 
    from emp e, dept d
    where e.deptno(+) = d.deptno;
 ---------------------------------------------------------------------------
 
 -- equi - join : 조인의 조건식이 = 연산자를 사용해서 만들어진 경우
 -- non - equi join : join의 조건식이 부등호를 사용해서 만들어진 경우

-- 사번, 이름, 급여, 급여등급(호봉. salgrade) 검색.
--표준 문법 non - equi join
select e.empno, e.ename, e.sal, s.grade
    from emp e
    join salgrade s 
    on e.sal between s.losal and s.hisal;
  --on e.sal >= s.losal and e.sal <= s.hisal;  

--오라클 문법 non - equi join
select e.empno, e.ename, e.sal, s.grade
    from emp e, salgrade s
    where e.sal between s.losal and s.hisal;
  --where e.sal >= s.losal and e.sal <= s.hisal; 
 --------------------------------------------------------------
 
 --self join : 같은 테이블에서 join하는 것.
 
 --사번, 이름, 매니저 사번, 매니저 이름을 검색
 --표준 문법
select e1.empno, e1.ename, e2.empno, e1.mgr MGR_NO, e2.ename MGR_NAME 
    from emp e1
    join emp e2
    on e1.mgr = e2.empno;

 --오라클 문법
select e1.empno, e1.ename, e1.mgr, e2.ename MGR_NAME
    from emp e1, emp e2
    where e1.mgr = e2.empno;

 --left (outer) join + self join 표준 문법
select e1.empno, e1.ename, e1.mgr, e2.ename MGR_NAME
    from emp e1
    left join emp e2 
    on e1.mgr = e2.empno;    
    
 --left (outer) join + self 오라클 표준 문법    
select e1.empno, e1.ename, e1.mgr, e2.ename MGR_NAME
    from emp e1, emp e2
    where e1.mgr = e2.empno(+);
-------------------------------------------------------------------
-- 문제 5번까지 inner join으로 생각하기
-- ex1. 직원 이름, 직원 근무 도시를 검색. 근무 도시 오름차순 정렬.

--표준 문법
select e.ename, d.loc
    from emp e
    join dept d
    on e.deptno = d.deptno
    order by d.loc;

--오라클 문법
select e.ename, d.loc
    from emp e, dept d
    where e.deptno = d.deptno -- where e.deptno = d.deptno(+)
    order by d.loc;
    
-- ex2. 직원 이름, 매니저 이름, 급여, 급여 등급을 검색.
--      정렬순서: (1)매니저, (2)급여 등급

--표준 문법
select e1.ename, e2.ename MGR_NAME, e1.sal, s.grade 
    from emp e1
    join emp e2 
    on e1.mgr = e2.empno
    join salgrade s
    on e1.sal between s.losal and s.hisal -- e1.sal >= s.losal and e1.sal <= s.hisal
    order by MGR_NAME, s.grade;
    
--오라클 문법
select e1.ename, e2.ename MGR_NAME, e1.sal, s.grade 
    from emp e1, emp e2, salgrade s
    where e1.mgr = e2.empno and e1.sal between s.losal and s.hisal
    -- e1.sal >= s.losal and e1.sal <= s.hisal
    order by MGR_NAME, s.grade;
--
select e.*, d.*
    from emp e 
    join dept d 
    on e.deptno = d.deptno;
--
select e1.*, e2.*
    from emp e1 
    join emp e2  
    on e1.mgr = e2.empno;
--
select e1.*, e2.*, s.*
    from emp e1 
    join emp e2  
    on e1.mgr = e2.empno
    join salgrade s
    on e1.sal between s.losal and s.hisal;
--
select e1.*, e2.*, s.*
    from emp e1 
    left join emp e2  
    on e1.mgr = e2.empno
    join salgrade s
    on e1.sal between s.losal and s.hisal;

-- ex3. 직원 이름, 부서 이름, 급여, 급여 등급을 검색.
--      정렬 순서: (1)부서 이름, (2)급여 등급

--표준 문법
select e.ename, d.dname, e.sal, s.grade
    from emp e 
    join dept d on e.deptno = d.deptno
    join salgrade s
    on e.sal between s.losal and s.hisal -- e.sal >= s.losal and e.sal <= s.hisal
    order by d.dname, s.grade;
    
--오라클 문법
select e.ename, d.dname, e.sal, s.grade
    from emp e, dept d, salgrade s
    where e.deptno = d.deptno and e.sal between s.losal and s.hisal 
    -- e.sal >= s.losal and e.sal <= s.hisal
    order by d.dname, s.grade;

-- ex4. 부서 이름, 부서 위치, 부서의 직원수를 검색. 부서 번호 오름 차순.
--표준 문법
select d.dname, d.loc, count(e.deptno) COUNT 
--count(*)는 행만있으면 무조건 counting 그래서 null도 셈.count(컬럼이름)->null제외하고 세준다. count(*)안되고,
--count(d.deptno)도 안됨. 부서번호 40번인 사원 없는데 count(d.deptno)는 40번이 있어서..
--count(e.deptno)에 40번인 사원 없으니까 40번은 null이여서 부서의 직원수를 제대로 세줌.
    from emp e
    right join dept d  
    on d.deptno = e.deptno
    group by d.dname, d.loc, d.deptno --count하려고 그룹으로 묶음 
    order by d.deptno; -->이렇게 정렬해야 돼서 group by에 d.deptno 추가함.
    -- 이유 : 통계함수 count사용. 그룹으로 묶어진 것들만 order by와 select 할 수 있음. 
    -- 단일행 함수와 다중행 함수 같이 쓸 수 없는 이유와 비슷하다고..
    
    ---
    select e.*, d.*
        from emp e 
        right join dept d
        on e.deptno = d.deptno;
    
    
    
--오라클 문법
select d.dname, d.loc, count(e.deptno) COUNT
    from emp e, dept d 
    where e.deptno(+) = d.deptno
    group by d.deptno, d.dname, d.loc
    order by d.deptno;
    
-- ex5. 부서 번호, 부서 이름, 부서 직원수, 부서의 급여 최솟값, 
--      부서의 급여 최댓값 검색. 부서 번호 오름 차순.

--표준 문법
select d.deptno, d.dname, count(e.deptno) COUNT, min(e.sal) MIN_SAL, max(e.sal) MAX_SAL
    from emp e 
    join dept d
    on e.deptno = d.deptno
    group by d.deptno, d.dname
    order by d.deptno;
    
--오라클 문법
select d.deptno, d.dname, count(e.deptno) COUNT, min(e.sal) MIN_SAL, max(e.sal) MAX_SAL
    from emp e, dept d
    where e.deptno = d.deptno
    group by d.deptno, d.dname
    order by d.deptno;
    

-- ex6. 부서 번호, 부서 이름, 사번, 이름, 매니저 사번, 매니저 이름, 
--      급여, 급여 등급을 검색. 급여가 3000 이상인 직원들만 검색.
--      정렬 순서: (1) 부서 번호, (2) 사번 오름차순.

--표준 문법
select e1.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename MGR_NAME, e1.sal, s.grade
    from emp e1 
    full join dept d 
    on e1.deptno = d.deptno
    full join emp e2
    on e1.mgr = e2.empno
    join salgrade s
    on e1.sal between s.losal and s.hisal
    where e1.sal >= 3000 
    order by e1.deptno, e1.empno;
    
--오라클 문법    
select e1.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename MGR_NAME, e1.sal, s.grade
    from emp e1, emp e2, dept d , salgrade s
    where e1.deptno = d.deptno(+) 
    and e1.mgr = e2.empno(+)
    and e1.sal between s.losal and s.hisal
    and e1.sal >= 3000 
    order by e1.deptno, e1.empno;    
------------------------------------------------------------------------------



    

 
 
 
