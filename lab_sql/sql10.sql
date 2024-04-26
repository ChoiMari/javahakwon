create table blogs(
    id              number(6)       generated always as identity, --항상 as identity로 동작하게 하겠다 : 1씩 증가하면서 자동으로 숫자 들어간다고 함(오라클 버전업이 되면서 새로 생긴 문법)
    title           varchar2(100 char)  not null,--not null : insert시 반드시 넣어야 하는 컬럼들. 제약조건
    content         varchar2(1000 char) not null,
    writer          varchar2(100 char)  not null,
    created_time    timestamp           default systimestamp,  
    modified_time   timestamp           default systimestamp,
    constraint blogs_pk primary key (id)
);

insert into blogs (title, content, writer)
values ('안녕하세요','첫번째 블로그 테스트','admin'); --id 프라이머리키 : insert시 반드시 값을 넣어야함 안넣으면 제약조건 위배
--근데 성공함 이유: generated always as identity 해놓아서 insert할때마다 항상 자동으로 만들어 준다고
-- insert할 때마다 숫자들 1씩 자동으로 증가  generated always as identity
--주의. 오라클 12버전부터 가능한 문법.
--시간 자동으로 들어감 default로 설정해놓아서
insert into blogs (title, content, writer)
values ('test','두번째 블로그 테스트','guest');

select * from blogs;

commit;













