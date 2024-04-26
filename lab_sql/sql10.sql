create table blogs(
    id              number(6)       generated always as identity, --항상 as identity로 동작하게 하겠다 : 1씩 증가하면서 자동으로 숫자 들어간다고 함(오라클 버전업이 되면서 새로 생긴 문법)
    title           varchar2(100 char)  not null,--not null : insert시 반드시 넣어야 하는 컬럼들. 제약조건
    content         varchar2(1000 char) not null,
    writer          varchar2(100 char)  not null,
    created_time    timestamp           default systimestamp,  
    modified_time   timestamp           default systimestamp,
    constraint blogs_pk primary key (id)
);