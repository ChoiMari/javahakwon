/**
 * function.html 문서에 포함 시킴.
 */

//console.log('Function');//브라우저의 개발자 도구(F12)의 콘솔에 출력. 브라우저 개발자 도구 콘솔창 보면 출력되서 보임
 
 // 함수 만듬. 함수이름 add, 파라미터는 x, y
 function add(x, y) { //파라미터 선언은 파라미터이름만 ,로 구분해서 나열. x,y가 파라미터선언이고 이름만 나열함
    console.log(`x = ${x}, y = ${y}`); //콘솔에 출력 결과. x = 1, y = 2 
    return x + y;//-> 호출한 곳으로 리턴 값을 보내줌
 }//-> 숫자를 아규먼트로 보내면 + 연산 해서 리턴값을 보내주고, 
 //문자열을 아규먼트로 보내주면 보내준 두 개의 문자열을 붙여줘서 리턴값을 보내줌.
 
 //함수 호출
 let result = add(1 , 2); //add함수 호출 아규먼트로 1,2를 보냄. -> x + y; -> 1 + 2값을 리턴해서 보내줌.
 // x -> 1, y -> 2 대입
 
 //브라우저의 개발자 도구 콘솔에 출력되서 보임.
 console.log(`result = ${result}`);
//콘솔에 출력 결과 :
// result = 3

//-----------------------------------------------

// 자바스크립트의 함수는 파라미터의 타입을 검사하지 않음.
result = add('Hello','JavaScript'); //-> 문자열 2개를 아규먼트로 보내서 문자열 2개를 붙이는 값으로 리턴값을 돌려받음.
console.log(`result = ${result}`); //-> 개발자 도구 콘솔에 출력 result = HelloJavaScript

//자바스크립트의 함수는 파라미터의 개수를 검사하지 않음.
result = add(1,2,3); //-> 선언된 파라미터 보다 더 많은 아규먼트를 전달한 경우.
//-> 문법적으로도, 프로그램 실행 중에도 에러가 나지 않는다.
//->아규먼트로 쓴 1,2 만 보내져서 함수가 실행됨. 아규먼트로 준 3은 버려짐.
console.log(`result = ${result};`);

//함수에 선언된 파라미터 보다 적은 개수의 아규먼트를 전달한 경우
result = add(1); //아규먼트로 1값을 넣어서 위의 코드에서 만든 함수 add를 호출

//개발자 도구 콘솔에 출력해봄..
console.log(`result = ${result};`);
//-> 콘솔 출력 결과
// x = 1, y = undefined
// result = NaN;

//자바스크립트에서 undefined의 의미는 초기화 되지 않은 변수를 말함(값이 할당 되어 있지 않은 변수)
//add함수에 선언된 파라미터 y값으로 보내준 아규먼트가 없음. 
// 파라미터를 선언 했는데 y에는 값이 할당되지 않아서 undefined라고 출력 됨.
// 리턴값은 1 + undefined; 가 되는데,
// NaN 로 출력. NaN의 의미는 숫자가 아니다라는 뜻.Nan (Not a Number)


//자바스크립트의 특징.
// 자바스크립트의 모든 함수는 아규먼츠(arguments)속성(property)을 가지고 있음
function testArgs(){
    console.log(arguments);
}

//함수 호출
testArgs();
// 출력 -> Arguments [callee: ƒ, Symbol(Symbol.iterator): ƒ]
//[]는 배열이라는 뜻.
//length: 0 아이템이 하나도 없는 배열

testArgs('hello');
//Arguments ['hello', callee: ƒ, Symbol(Symbol.iterator): ƒ]
//length:1

testArgs(1,'안녕');
//Arguments(2) [1, '안녕', callee: ƒ, Symbol(Symbol.iterator): ƒ]
//length:2

//Arguments는 배열.


function testArgs(){
    console.log(arguments);
    for (let arg of arguments) {
        console.log(arg)
    }
}
testArgs();
testArgs('hello');
testArgs(1,'안녕');

//연습 문제 : 
// 숫자 2개를 아규먼트로 전달 받아서 뺄셈 결과를 리턴하는 함수 만들기.
// 함수를 호출해서 결과 확인까지 해보기.

function minus(x, y){
    return x - y;
}

result = minus(1,2);
console.log(`result = ${result}`); 
//출력 결과 result = -1


