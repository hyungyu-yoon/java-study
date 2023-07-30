# Chapter 2 변수와 타입

### 변수 선언
- 데이터는 메모리에 저장되고, 변수는 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름이다. 
- 변수는 데이터의 타입과 이름을 정하여 사용한다.
- 자바에서는 캐멀(camel) 케이스 관례
  - 변수는 소문자 시작
- 로컬 변수 사용시 초기화 필수
  - 초기화 하지 않은 로컬 변수 사용은 컴파일 에러 발생
```java
int value = 10;
// or
int value;
value = 10;
```

## 타입
- 자바의 기본(primitive) 타입은 8개

### 정수 타입
- byte(1byte), char(2byte), short(2byte), int(4byte), long(8byte)
- 정수 타입은 메모리에 2진수로 표햔되며 맨 첫 번째 bit는 부호를 나타냄
  - ex) 0000 0011 -> 3,  1111 1101 -> -3
  - 2의 보수 = 1의 보수 + 1
- long 타입 초기화시 뒤에 L을 붙여줌 ex) 100000L
  - 정수 리터럴은 int 로 인식하기에 int 단위를 넘어가면 long 타입임을 알려주어야 함
### 문자 타입
- char 타입
- 작은 따옴표로 감싼 것을 문자 리터럴 ```'A'```
- 유니코드 0 ~ 65535
  - 문자 대입 or 직접 유니코드 숫자 대입 가능
### 실수 타입
- float(4byte) , double(8byte)
- IEEE 754 표준 부동 소수점 방식으로 메모리 저장
- 부호 | m (가수) x 10^n (지수)
- float bias 127 , double bias 1023
- 부호 | 지수 | 가수
  - float 1bit | 8bit | 23bit
  - double 1bit | 11bit | 52bit
### 논리 타입
- 참 거짓을 나타냄, 논리 리터럴 true, false
- boolean
- 조건문, 제어문의 실행 흐름 변경에 사용
### 문자열 타입
- 큰 따옴표 ("")로 감싼 문자열
- String 타입은 기본 타입이 아님
- java 13 ~ text block 사용 가능 ```"""" ~~~ """```
### 자동 타입 변환
- 자동 타입 변환은 값의 허용 범위가 작은 타입이 허용 범위가 큰 타입으로 대입될 때 발생
  - 역은 컴파일 에러
  - 큰 허용 범위 타입 = 작은 허용 범위 타입
  - byte < short, char < int < long < float < double
### 강제 타입 변환
- 큰 허용 범위 타입을 작은 허용 범위 타입으로 쪼개서 저장하는 것 casting
  - 작은 허용 범위 자리수 외에는 짤림
- 작은 허용 범위 타입 = (작은 허용 범위 타입) 큰 허용 범위 타입
```java
long longVal = 1000000L;
int intVal = (int) longVal;
```
### 연산식에서 자동 타입 변환
- 자바 컴파일러는 정수 리터럴 연산시 미리 연산 결과를 만들어 바이트코드로 생성
- 변수를 사용하여 피연산자로 사용되면 연산 수행
- 정수 연산시 int를 사용하면 타입 변환 안함
  - long이 있다면 long으로 타입 변환되어 연산 수행
- 실수 타입 연산시 큰 타입으로 변환되어 연산
  - double + float = double
- 작은 타입으로 변수 대입 할 경우 강제 캐스팅하여 연산
  - ex) int val = intVal + (int) doubleVal;
- 정수 연산의 결과는 항상 정수이므로 실수 계산시 double 로 강제 캐스팅하여 연산
### 문자열을 기본 타입으로 변환
- 타입.parse타입().. wrapper class 메서드 사용
- ex) Byte.parseByte(str), Integer.parseInt(str)..
- 기본 타입 to String : String.valueOf(기본타입값)
### 변수 사용 범위
- 중괄호 {} 블록 내에서만 사용가능
  - 선언된 지역 밖에서는 사용 불가
### 콘솔로 변수값 출력
- System.out.println(str);
- System.out.print(str);
- System.out.printf(str); 
- sout, souf, soutv ...
### 키보드 입력 데이터를 변수에 저장
- Scanner sc = new Scanner(System.in);
- sc.nextLine() ..


