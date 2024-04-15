package com.itwill.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

	public static void main(String[] args) {
		//사원(Employee)들의 리스트
		List<Employee> employees = Arrays.asList(
				new Employee(101, "김지현", "개발1팀", "과장", 700),
				new Employee(102, "이동준", "개발2팀", "부장", 800),
				new Employee(103, "이승행", "개발1팀", "대리", 500),
				new Employee(104, "정윤정", "개발2팀", "부장", 1_000),
				new Employee(105, "김동환", "인사팀", "회장", 30_000),
				new Employee(106, "노형진", "인사팀", "차장", 900),
				new Employee(107, "오쌤", "총무", "대리", 300)
				);

		//Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력
		// -람다,등 다른 방법 
		for(Employee e: employees) { //리스트 원소들을 하나씩 꺼내는 거니까 리스트 타입으로 변수 선언.
			System.out.println(e);
		}
		System.out.println("----------------------------------");
		
		//람다 이용
		employees.forEach((x) -> System.out.println(x)); //forEach는 리스트의 원소들을 순서대로 x로 줌 
		System.out.println("----------------------------------");
		
		// 메소드 참조 람다 - 반복되는 변수이름 x 지우고 
		employees.forEach(System.out::println);
		System.out.println("----------------------------------");
		
		//Ex2. 개발팀(1,2팀)에서 일하는 직원들의 급여 합계
		//Ex3. 개발팀에서 일하는 직원들의 급여 평균
		System.out.println("--- Ex2.Ex3. ---");
		double sum = 0.0; // 급여 합계를 저장하기 위한 지역 변수
		int count = 0; // 개발팀 직원 수를 저장하기 위한 변수
		
		for(Employee e : employees) {//리스트의 모든 직원들을 순서대로 반복
			if(e.getDept().contains("개발")) { //직원의 부서 이름이 "개발"을 포함하면 true
				// 부서이름(Dept)을 가져와서 e.getDept() "개발" 들어간걸 찾아야 .contains("개발")
				sum += e.getSalary(); //개발팀 직원의 급여를 더함
				count++; // 직원 수 증가
			}
		}
		System.out.println("합계=" + sum);
		System.out.println("평균=" + (sum/count));
		
		//Stream 사용
		sum = employees.stream()
				.filter((x) -> x.getDept().contains("개발"))
				.mapToDouble((x) -> x.getSalary()) //mapToDouble메서드 double타입으로 매핑시킴, 그래서 리턴값 항상 double
				.sum();
		System.out.println("sum=" + sum);
		// 리스트 employees에 .stream() 원소들이 하나 씩 지나가는 통로 만들고
		// 그 통로에 필터를 끼워서 검사 .filter((x) -> x.getDept().contains("개발"))
		// 그 부서의 직원 Dept가 "개발"이라는 문자를 가지고 있느냐 true면 통과 
		// 조건에 맞는 직원이 들어오면 그 직원의 급여 Salary를 Employee타입을 double 타입으로 매핑하겠다
		// .mapToDouble((x) -> x.getSalary())
		// sum()은 결과값을 다 더해서 더블타입으로 리턴해줌
		
		double mean = employees.stream()
				.filter((e) -> e.getDept().contains("개발"))
				.mapToDouble((e) -> e.getSalary()) // 필터에 통과한 데이터의 직원의 급여를 double로 매핑해줌.
				//.mapToDouble(Employee::getSalary) //메소드 참조 람다 표현식
				.average() //average()메서드는 OptionalDouble타입. 나눠지는 개수가 0이되면 평균 자체가 안되서
		// 선택적 double 타입이라고 함. double 타입 일 수도 있고, 아닐 수도 있고
				//0으로 나누는 경우는 어떻게 할래? 예외 상황 발생할 수 있는 메서드에 Optional타입인 경우가 종종 있다고 함.
		// 우리는 이걸 double로 만들어 주어야 한다고 함.
		// 그래서 orElse()메소드 사용. 아규먼트가 double인건 평균을 계산해 줄 수 없을 때 대신 줄 값을 아규먼트로 주면되고 아니면
		//orElseThrow()사용 - 예외 던짐.
				.orElseThrow(); //-> 평균을 계산할 수 있으면
		//double 값을 리턴해주고 그렇지 않으면 예외를 발생 시킨다.
		
		System.out.println("mean=" + mean);
		
		//밑에 주석은 내가 푼 것.
//		List<Employee> development12 = new ArrayList<>();
//		double salarysum = 0;
//		int count = 0;
//		for(Employee e : employees) { 
//			if(e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀") ) {
//				development12.add(e);
//				salarysum += e.getSalary();
//				count++;
//			}
//		}
//		System.out.println("개발팀 급여 합계 : " + salarysum);
		
		
//		double development12Av = 0; 
//		for(Employee x : employees) {
//			if(x.getDept().equals("개발1팀") || x.getDept().equals("개발2팀") ) {
//				development12Av = salarysum/count;
//			}
//		}
//		System.out.println("개발팀 급여 평균 : " + development12Av);
//		
		
		
		//Ex4. 직급이 부장인 직원들의 급여 합계
		//Ex5. 직급이 부장인 직원들의 급여 평균
		System.out.println("--- Ex4.Ex5. ---");
		sum = 0.0;
		mean = 0.0;
		count = 0;
		for(Employee e : employees) {
			if(e.getJobTitle().equals("부장")) {
				sum += e.getSalary();
				count++;
			}
		}
		System.out.println("합계=" + sum);
		
		mean = sum/count; //위험한 코드라고 함. 조건 만족 없으면 count가 0이니까 0으로 나눈 코드면 예외 발생.
		// 안전한 코드로 바꾸려면 count가 0인지 아닌지 체크 하면 됨.
		System.out.println("평균=" + mean);
		
		
		//Stream사용 하는 방법.
		sum = employees.stream()
				.filter((e) -> e.getJobTitle().equals("부장"))
				.mapToDouble((e)->e.getSalary())
				.sum();
		System.out.println("sum=" + sum);
		
		mean = employees.stream()
				.filter((e) -> e.getJobTitle().equals("부장"))
				.mapToDouble((e)->e.getSalary())
				.average()
				.orElseThrow();
		System.out.println("mean=" + mean);
		
		//내가 푼 것 
//		//Ex4. 직급이 부장인 직원들의 급여 합계
//		double jobTitleBujangSum = 0;
//		int count2 = 0;
//		for(Employee x : employees) {
//			if(x.getJobTitle().equals("부장")) {
//				jobTitleBujangSum += x.getSalary();
//				count2++;
//			}
//		}
//		System.out.println("부장 급여 합계 : " + jobTitleBujangSum);
//		
//		//Ex5. 직급이 부장인 직원들의 급여 평균
//		double jobTitleBujangAv = 0;
//		
//		for(Employee x : employees) {
//			if(x.getJobTitle().equals("부장")) {
//				jobTitleBujangAv = jobTitleBujangSum/count2;
//			}
//		}
//		System.out.println("부장 급여 평균 : " + jobTitleBujangAv);
//		
		
		//Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력
		System.out.println("--- Ex6. ---");
		employees.stream()
		.filter((e)-> e.getSalary() >= 1_000)
		.forEach(System.out::println); //e -> System.out.println(e);
		

		//Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 급여의 평균
		System.out.println("--- Ex7. ---");
		sum = 0.0; //개발 1팀 직원들의 (10% 인상한) 급여 합계
		count = 0; // 직원 수
		for(Employee e : employees) {
			if(e.getDept().equals("개발1팀")) {
				sum += e.getSalary() * 1.1;
				count++;
			}
		}
		mean = sum / count;
		System.out.println("평균=" + mean);
		
		//람다 표현식
		mean = employees.stream()
				.filter((e) -> e.getDept().equals("개발1팀"))
				.mapToDouble((e) -> e.getSalary() * 1.1) //이건 메서드 참조 못한다고 함 *1.1 해야 되서
				.average()
				.orElseThrow();
		System.out.println("mean=" + mean);
		
		
		//내가 푼 것
//		//Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력
//		for(Employee x : employees) {
//			if(x.getSalary() >= 1000) {
//				System.out.println("급여 1,000 이상 : " + x);
//			}
//		}
		// 내가 풀 다 만 것.
		//Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 급여의 평균
//		for(Employee x : employees) {
//			if(x.getDept().equals("개발1팀")) {
//				x.setSalary((x.getSalary() + x.getSalary() * 0.1));
//				
//			}
//		}
		
	}

}
