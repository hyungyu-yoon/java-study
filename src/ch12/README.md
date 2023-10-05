# Chapter 12 java.base 모듈

### 12.1 API 도큐먼트

- 라이브러리를 사용하기 위한 방법을 기술한 문서
- 자바 버전별 API 도큐먼트 `https://docs.oracle.com/en/java/javase/index.html`
- 도큐먼트 읽는 법
    - 클래스 선언부 보기: final, abstract 여부, 전체적인 상속관계 확인
    - 구성 멤버 보기: 라이브러리 클래스가 가지고 있는 멤버 확인 SUMMARY
    - 필드 보기: SUMMARY 에서 FIELD 링크 클릭 시 필드 목록 이동
    - 생성자 보기: SUMMARY 에서 CONSTR 링크 클릭시 생성자 목록 이동
    - 메소드 보기: SUMMARY 에서 METHOD 링크 클릭시 생성자 목록 이동
        - All Methods, Static Methods, Instance Methods, Deprecated Methods

### 12.2 java.base 모듈

- java.base 는 모든 모듈이 의존하는 기본 모듈, 유일하게 requires 하지 않아도 사용 가능하다.
- java.base 주요 패키지
    - java.lang: 자바 언어의 기본 클래스
        - String, System, Integer, Double, Exception, RuntimeException...
    - java.util: 자료 구조와 관련된 컬렉션 클래스
        - Scanner ...
    - java.text: 날짜 및 숫자를 원하는 형태의 문자열로 만들어 주는 포맷 클래스
    - java.time: 날짜 및 시간을 조작하거나 연산하는 클래스
    - java.io: 입출력 스트림 클래스
    - java.net: 네트워크 통신고 관련된 클래스
    - java.nio: 데이터 저장을 위한 Buffer 및 새로운 입출력 클래스
- java.lang 클래스
    - 자바 언어의 기본적인 클래스를 담고 있는 패키지로 import 없이 사용 가능
    - Object: 자바 클래스의 최상위 클래스
    - System: 키보드로부터 데이터 입력받음, 모니터(콘솔) 출력, 프로세스 종료, 진행시간, 시스템 속성(프로퍼티) 읽을 때
    - String, StringBuilder, StringTokenizer: 문자열 관련
    - Byte, Short, Character, Integer, Float, Double, Boolean: 기본 타입의 포장, 문자열을 기본 타입으로 변환
    - Math: 수학 계산
    - Class: 클래스의 메타 정보(이름, 구성멤버 등)을 조사

### 12.3 Object 클래스

- 클래스를 선언할 때 extends 로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속하게 된다.
- 자바의 모든 클래스는 Object 의 자식이거나 자손 클래스
- Object 가 가진 메소드는 모든 객체에서 사용 가능
    - equals: 객체의 번지를 비교하고 결과 리턴
    - hashCode: 객체의 해시코드 리턴
    - toString: 객체 문자 정보를 리턴
- **객체 동등 비교**
    - `public boolean equals(Object obj)`
    - equals의 매개변수 타입이 Object 이므로 자동 타입 변환에 의해 모든 객체가 매개값으로 대입될 수 있다.
    - 두 객체가 동일하면 true, 아니라면 false
    - 일반적으로 equals 를 재정의하여 동등 비교용으로 사용됨 (객체가 달라도 내부의 데이터가 같은지 비교)
- **객체 해시코드**
    - 객체 해시코드란 객체를 식별하는 정수를 말한다.
    - Object의 hashCode() 는 객체의 메모리 번지를 이용해서 해시코드를 생성하기 때문에 객체마다 다른 정수값을 리턴
    - 두 객체가 동등한지 비교할 때 주로 사용
    - `public int hashCode()`
    - hashCode도 일반적으로 재정의하여 새로운 정수값을 리턴하도록 한다.
    - 객체가 다르더라도 내부 데이터가 동일하면 같은 정수값을 리턴하기 위함
    - 자바는 두 객체가 동등함을 비교할 때 hashCode와 equals를 같이 사용하는 경우가 많다.
    - hashCode 확인 후 equals 로 동등 객체인지 판단
    - HashSet: 동등 객체를 중복 저장하지 않는 Set
        - equals와 hashCode 메소드로 동등 객체인지 판단한다.
        - hashCode 를 재정의 하지 않으면 매번 다른 객체로 판단한다.
- **객체 문자 정보**
    - toString() 메소드는 객체의 문자 정보를 리턴
    - 객체를 문자열로 표현한 값
    - 기본적으로 Object의 toString 은 `클래스명@16진수해시코드` 로 구성된 문자열 리턴
    - 객체의 문자 정보가 중요한 경우 재정의하려 간결하고 유익한 정보를 리턴해야 함
- **레코드 선언**
    - 데이터 전달을 위한 DTO(Data Transfer Object) 를 작성할 때 반복적으로 사용되는 코드를 줄이기 위해 Java 14 부터 레코드(record)가 도입
    - 레코드 소스를 컴파일하면 변수의 타입과 이름을 이용해서 private final 필드가 자동 생성되고, 생성자 및 Getter 메소드가 자동으로 추가된다.
    - 그리고 hashCode, equals, toString 메소드를 재정의한 코드도 자동으로 추가된다.
- **롬복 사용하기**
    - 표준 라이브러리는 아니지만 개발자들이 즐겨 쓰는 자동 코드 생성 라이브러리
    - DTO 클래스를 작성할 때 Getter, Setter, hashCode, equals, toString 메소드를 자동 생성하여 코드의 양을 줄여준다.
    - final 필드가 아니다. getXxx, setXxx
    - 세팅
        - Intellij Plugins > lombok 설치
        - Build, Execution, Deployment > Compiler > Annotation Processors | Enable annotation processing 체크
        - gradle dependency > `compileOnly 'org.projectlombok:lombok'` `annotationProcessor 'org.projectlombok:lombok'`
    - 롬복 어노테이션
        - @Data: 기본생성자, getter, setter, hashcode, equals, toString 자동 생성
        - @NoArgsConstructor: 기본 생성자 포함
        - @AllArgsConstructor: 모든 필드 초기화 시키는 생성자 포함
        - @RequiredArgsConstructor: 매개변수가 없는 생성자 포함, final, @NonNull 붙은 필드 초기화 생성자 포함
        - @Getter: Getter 메소드 포함
        - @Setter: Setter 메소드 포함
        - @EqualsAndHashCode: eqauls, hashCode 포함
        - @ToString: toString 포함

### 12.4 System 클래스

- java.lang 패키지의 System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.
- System 클래스의 정적 필드와 메소드를 이용하면 프로그램 종료, 키보드 입력, 콘솔 출력, 현재 시간 읽기, 시스템 프로퍼티 읽기 등이 가능하다.
- 필드
    - out: 콘솔에 문자 출력
    - err: 콘솔에 에러 내용 출력
    - in: 키보드 입력
- 메소드
    - exit(int status): 프로세스 종료
    - currentTimeMillis(): 현재 시간을 밀리초 단위의 long 값으로 리턴
    - nanoTime(): 현재 시간을 나노초 단위의 long 값으로 리턴
    - getProperty(): 운영체제와 사용자 정보 제공
    - getenv(): 운영체제의 환경 변수 정보 제공
- **콘솔 출력**
    - out, err 필드는 동일한 콘솔 출력이나 err 는 에러 내용이 빨간색으로 출력된다.
- **키보드 입력**
    - 키보드로 부터 입력된 키를 읽기 위해 System 클래스의 in 필드를 제공
    - `int keyCode = System.in.read();`
    - read 는 enter 키를 눌렀을 때 입력한 순으로 읽기 시작
- **프로세스 종료**
    - 운영체제는 실행 중인 프로그램은 프로세스로 관리
    - 자바 프로그램을 시작하면 JVM 프로세스가 생성되고, 이 프로세스가 main() 메소드를 호출한다.
    - 강제 종료 하고 싶다면 System.exit(int status) 사용
    - 어떤 값을 주더라도 종료되지만 정상 종료 0, 비정상 종료 1 or -1 주는 것이 관례
- **진행 시간 읽기**
    - currentTimeMillis()와 nanoTime() 은 1970년 1월 1일 0시부터 시작해서 현재까지 진행된 시간을 리턴
    - 프로그램 처리 시간을 측정하는데 주로 사용
- **시스템 프로퍼티 읽기**
    - 자바 프로그램이 시작될 때 자동 설정되는 시스템의 속성
    - 운영체제 종류 및 사용자 정보, 자바 버전 등 기본 사양 정보

### 12.5 문자열 클래스

- String: 문자열 저장, 조작할 때
- StringBuilder: 효율적인 문자열 조작 필요시
- StringTokenizer: 구분자로 연결된 문자열 분리할 때
- **String 클래스**
    - 문자 리터럴과 String 클래스의 다양한 생성ㅈ다를 이용해 객체 생성
    - byte 배열을 문자열 변환
    - `String str = new String(byte[] bytes);`
    - `String str = new String(byte[] bytes, String charsetName);`
- **StringBuilder 클래스**
    - String 내부 문자열은 수정할 수 없다.
    - 문자열 + 문자열 시 내부 문자열을 변경하는 것처럼 보이지만 새로운 String 객체를 생성하는 것 (불변 객체)
    - 잦은 문자열 변경 작업을 해야한다면 StringBuilder 사용
    - 내부 버퍼에 문자열을 저장해두고 그 안에서 수정, 삭제 작업을 하도록 설계되어 있다.
    - append, insert, delete, replace, toString
    - 메소드 체이닝
- **StringTokenizer 클래스**
    - 문자열이 구분자(delimiter) 로 연결되어 있을 경우, 구분자를 기준으로 문자열을 분리할 수 있다.
    - String 의 split 또는 java.util 패키지의 StringTokenizer 사용
    - split 은 정규표현식으로 구분, StringTokenizer 는 문자로 구분
    - 한 종류의 구분자만 있다면 StringTokenizer 사용
    - StringTokenizer 객체 메서드
        - int countTokens() 분리할 수 있는 문자열의 총 수
        - boolean hasMoreTokens() 남아 있는 문자열 존재 여부
        - String nextToken() 문자열 하나씩 가져옴

### 12.6 포장 클래스

- 자바 기본 타입의 값을 갖는 객체를 생성할 수 있다. wrapper 클래스
- 포장된 기본 타입의 값을 변경 불가
- 컬렉션 객체에서 사용 <= 객체만 저장 가능
- **박싱과 언박싱**
    - 기본 타입의 값을 포장 객체로 만드는 과정을 박싱(boxing)
    - 반대는 언박싱(unboxing)
    - `Integer obj = 100;` 박싱
    - `int value = obj;` 언박싱
    - `int value = obj + 50` 언박싱 후 연산
- **문자열을 기본 타입 값으로 변환**
    - 포장 클래스에는 parse(Type) 정적메소드로 문자열을 해당 기본 타입으로 변환
- **포장 값 비교**
    - 포장 클래스도 객체이기 때문에 equals로 비교해야 한다.
    - 포장 클래스마다 equals가 재정의 되어 있다.

### 12.7 수학 클래스

- Math 클래스는 수학 계산에 사용할 수 있는 메소드를 제공, 모두 정적 메소드
    - abs : 절대값
    - ceil : 올림값
    - floor : 버림값
    - max : 최대값
    - min : 최소값
    - random : 랜덤
    - round : 반올림
- random() 메소드는 0.0 과 1.0 사이의 double 타입 난수를 리턴
    - start 부터 n 개의 정수 `int num = (int) (Math.random() * n ) + start;`

### 12.8 날짜와 시간 클래스

- 컴퓨터의 날짜 및 시각을 읽을 수 있도록 java.util 패키지의 Date와 Calendar 클래스 제공
- Date : 날짜 정보 전달하기 위해 사용
- Calendar : 다양한 시간대별 날짜와 시간을 얻을 때 사용
- LocalDateTime : 날짜와 시간을 조작할 때 사용
- **Date 클래스**
    - 날짜를 표현하는 클래스로 날짜 정보를 주고 받을 때 사용
    - 원하는 문자열을 얻고 싶을때 SimpleDateFormat 클래스와 함께 사용
- **Calendar 클래스**
    - 달력을 표현하는 추상 클래스
    - Calendar 클래스의 정적 메소드 getInstance() 를 사용하면 컴퓨터에 설정되어 있는 시간대를 기준으로 Calendar 하위 객체 얻을 수 있다.
    - Calendar에 정의된 상수로 년도, 월, 일 등 정보 얻을 수 있다. ex) Calendar.YEAR
- **날짜와 시간 조작**
    - java.time 패키지의 LocalDateTime 클래스를 사용하면 쉽게 날짜와 시간을 조작할 수 있다.
    - 현재 날짜와 시간 `LocalDate.now()`
- **날짜와 시간 비교**
    - isAfter: 이후 날짜인지
    - isBefore: 이전 날짜인지
    - isEquals: 동일 날짜인지
    - until: 주어진 단위 차이 리턴

### 12.9 형식 클래스

- Format 클래스는 숫자 또는 날짜를 원하는 형태의 문자열로 변환해주는 기능을 한다.
- DecimalFormat : 숫자를 형식화된 문자열로 변환
- SimpleDateFormat : 날짜를 형식화된 문자열로 변환

### 12.10 정규 표현식 클래스

- 자바는 정규 표현식을 이용해 문자열이 올바르게 구성되었는지 검증
- **정규 표현식 작성 방법**
    - [] : 한개의 문자 ex) [abc] a,b,c 중 하나의 문자, [^abc] a,b,c 이외의 하나의 문자, [a-zA-Z] a~Z 중 하나의 문자
    - \d : 한개의 숫자 = [0-9]
    - \s : 공백
    - \w : 한 개의 알파벳 또는 한개의 숫자 = [a-zA-Z_0-9]
    - \. : .
    - . : 모든 문자 중 한 개의 문자
    - ? : 없음 또는 한 개
    - \* : 없음 또는 한 개 이상
    - \+ : 한 개 이상
    - {n} : 정확히 n개
    - {n,} : 최소한 n개
    - {n,m} : n개부터 m개까지
    - a | b : a 또는 b
    - () : 그룹핑
- ex) 전화번호 정규표현식 `(02|010)-\d{3,4}-\d{4}`
- **Pattern 클래스로 검증**
    - java.util.regex 패키지의 Pattern 클래스는 정규 표현식으로 문자열을 검증하는 matches() 를 제공

### 12.11 리플렉션

- 자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리한다.
- 메타 정보: 패키지 정보, 타입 정보, 멤버 정보 등을 말함
- 메타 정보를 프로그램에서 읽고 수정하는 행위를 리플렉션(reflection) 이라고 한다.
- 클래스 객체 얻는법
    - Class clazz = 클래스이름.class;
    - Class clazz = Class.forName("패키지...클래스이름");
    - Class clazz = 객체참조변수.getClass();
- **패키지와 타입 정보 얻기**
    - 패키지와 타입 이름 정보 얻기
        - Package getPackage()
        - String getSimpleName()
        - String getName()
- **멤버 정보 얻기**
    - 타입이 가지고 있는 멤버 정보
        - Constructor[] getDeclaredConstructors()
        - Field[] getDeclaredFields()
        - Method[] getDeclaredMethods()
    - 각각 배열을 리턴
- **리소스 경로 얻기**
    - 클래스 파일의 경로 기준으로 상대 경로에 있는 다른 리소스의 정보를 얻을 수 있다.
        - URL getResource(String name): 리소스 파일의 URL 리턴
        - InputStream getResourceAsStream(String name): 리소스 파일의 InputStream 리턴

### 12.12 어노테이션

- 코드에서 @ 으로 작성되는 요소를 어노테이션(Annotation) 이라고 한다.
- 클래스 또는 인터페이스를 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지 알려주는 설정 정보이다.
- 어노테이션 용도 3가지
    - 컴파일 시 사용하는 정보 전달
    - 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
    - 실행 시 특정 기능을 처리할 때 사용하는 정보 전달
- **어노테이션 타입 정의와 적용**
    - @interface 뒤에 사용할 어노테이션 이름
    - `public @interface AnnotationName {}`
    - @AnnotationName 으로 사용 가능
    - 어노테이션은 속성을 가질 수 있다.
    - 속성은 타입과 이름으로 구성, 이름 뒤에 괄호를 붙인다.
    - 속성의 기본값은 default 키워드로 지정 가능
    - 어노테이션은 기본 속성 value를 가질 수 있다.
    - value 는 속성 언급 없이 자동 대입 가능 `@Annotation("값");

```text
  public @interface AnnotationName {
    String prop1();
    int prop2() default 1;
  }
```

```text
@AnnotationName(prop1 = "값");
@AnnotationName(prop1 = "값", prop2 = 3);
```

- **어노테이션 적용 대상**
    - ElementType 열거 상수 대상
        - TYPE : 클래스, 인터페이스, 열거 타입
        - ANNOTATION_TYPE : 어노테이션
        - FILED : 필드
        - CONSTRUCTOR : 생성자
        - METHOD : 메소드
        - LOCAL_VARIABLE : 로컬 변수
        - PACKAGE : 패키지
    - 적용 대상 지정시 @Target 어노테이션 사용

```text
 @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
 public @interface AnnotationName {
 
 }
```

```text
@AnnotationName  // 클래스
public class ClassName {
    @AnnotationName // 필드
    private String fieldName;
    
    @AnnotationName   // 메소드
    public void methodName()
}
```

- **어노테이션 유지 정책**
    - 어노테이션을 정의할 때 언제까지 유지할 것인지도 정해야 한다.
    - RetentionPolicy 열거 상수
        - SOURCE : 컴파일 시점 / 컴파일된 후에 제거
        - CLASS : 메모리 로딩할 때 적용 / 메모리 로딩된 후 제거
        - RUNTIME : 실행할 때 적용 / 계속 유지

```text
 @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
 @Retention(RetentionPolicy.RUNTIME)
 public @interface AnnotationName {
 
 }
```

- **어노테이션 설정 정보 이용**
    - 리플렉션을 이용해서 적용 대상으로부터 어노테이션의 정보를 다음 메소드로 얻을 수 있다.
    - boolean isAnnotationPresent(AnnotationName.class) : 지정한 어노테이션이 적용되었는지 여부
    - Annotation getAnnotation?(AnnotationName.class) : 지정한 어노테이션이 적용되어 있으면 어노테이션을 리턴 아니면 null
    - Annotationp[] getDeclaredAnnotations() : 적용한 모든 어노테이션 리턴
- 
