# Chapter 6 클래스

### 6.1 객체 지향 프로그래밍

- 객체(object) : 물리적으로 존재하거나 개념적인 것 중에서 다른 것과 식별 가능한 것
    - 자동차, 자전거, 책, 사람, 학과, 강의, 주문 등
- 객체는 속성(필드)과 동작(메서드)으로 구성
- 객체의 상호작용: 객체는 다른 객체와 서로 상호작용하며 동작, 상호작용의 수단은 메서드 호출
    - 호출 -> 동작 -> 결과 반환
    - 메서드(매개값1, ...);
- 객체 간의 관계
    - 집합 관계 (has-a)
        - 완성품과 부품 ex) 자동차 => 엔진, 타이어, 핸들
    - 사용 관계 (use-a)
        - 다른 객체의 필드를 읽고 변경하거나 메소드를 호출하는 관계
        - 메소드 인자로 받은 객체 사용, 메소드 내에서 객체 생성
    - 상속 관계 (is-a)
        - 부모와 자식 관계
- 객체 지향 프로그래밍의 특징
    - 캡슐화
        - 객체의 데이터(필드), 동작(메서드)을 하나로 묶고 구현 내용을 외부에 감추는 것
        - 외부 객체는 객체 내부의 구조를 알지 못하고, 객체가 제공하는 필드와 메서드만 사용 가능
        - 캡슐화하여 보호하는 이유는 외부의 잘못된 사용으로 객체 손상 방지
        - 접근 제한자 사용
    - 상속
        - 부모 객체의 필드와 메서드를 자식 객체에게 물려주어 사용할 수 있게 한다
            - 자식 객체의 별도 데이터 및 기능 확장 가능
            - 코드의 재사용성 높임
            - 유지 보수 시간을 최소화
    - 다형성
        - 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질
    - \+ 추상화
        - 불필요한 세부 사항들은 제거하고 가장 본질적이고 공통적인 부분만을 추출하여 표현
        - 객체 지향 프로그래밍에서 의미하는 추상화는 객체의 공통적인 속성과 기능을 추출하여 정의하는것
            - ex) 자동차, 오토바이, 트럭 등 / 공통 기능 - 전진, 후진 등 묶음 -> vehicle

### 6.2 객체와 클래스

- 객체의 설계도 -> 클래스
- 클래스로 부터 생성된 객체를 클래스의 인스턴스라고 부름

### 6.3 클래스 선언

```java
package aaa.bbb; // 패키지 

public class ClassName { // 공개 클래스 선언
    // 필드

    // 메서드
}
```

- 파일 하나 당 여러 개의 클래스를 선언 가능
- 파일 이름과 동일한 클래스만 공개(public) 클래스로 선언 가능
- 클래스 하나 선언하는 것이 좋음

### 6.4 객체 생성과 클래스 변수

- 객체 생성 방법 `클래스명 name = new 클래스명();`
- 클래스 2가지 용도
    - 라이브러리 클래스: 실행할 수 없으며 다른 클래스에서 이용하는 클래스
    - 실행 클래스: main() 메서드를 가지고 있는 실행 가능한 클래스

### 6.5 클래스의 구성 멤버

- 생성자 : 객체의 초기화 / 클래스명과 동일
- 필드 : 객체의 데이터 저장
- 메서드 : 객체가 수행할 동작 / 객체 간의 상호 작용을 위해 호출

### 6.6 필드 선언과 사용

- 객체의 데이터 = 필드
    - 고유 데이터, 현재 상태 데이터, 부품 데이터
        - ex) 자동차 객체 - 제작회사, 모델, 색깔, 최고속도는 고유 데이터, 현재 속도, 엔진 회전 수 상태 데이터, 차체, 엔진 타이어는 부품 데이터
- 필드와 로컬 변수 차이점
    - 로컬 변수는 생성자, 메서드 블록 내에서만 사용 가능
    - 클래스 내에서 어디든 사용 가능
- 필드는 객체 생성시 기본 값으로 초기화
- 필드 사용
    - 객체가 생성되어야 사용 가능
    - 필드를 사용한다는 것은 값을 읽거나 변경하는 것
    - 외부에서 메서드나 필드에 접근할 때 참조변수 뒤 도트(.) 으로 접근 가능

### 6.7 생성자 선언과 호출

- new 연산자는 객체를 생성한 후 연이어 생성자(constructor)를 호출하여 객체를 초기화하는 역할
    - 객체를 사용할 준비하는 것
    - 생성자가 수행되면 new 연산자는 객체의 주소를 반환
- 모든 클래스에는 기본 생성자가 존재(생성자가 없다면 선언하지 않아도 컴파일러가 자동으로 추가 시킴)
- 생성자 선언
    - `클래스(매개변수, ...) { //객체 초기화 코드 }`
    - 리턴 타입이 없고 클래스 이름과 동일
- 필드 초기화
    - 객체마다 동일한 값을 갖고 있다면 필드 선언시 초기값 대입하는 것이 좋음
    - 객체마다 다르다면 생성자에서 필드 초기화
- 생성자 오버로딩
    - 매개 값으로 객체의 필드를 다양하게 초기화하는 방법
    - 생성자를 매개 값을 달리하여 여러개 선언
    - 매개값 개수가 동일한 경우 타입이 달라야 함 / 타입이 같고 변수 이름만 다른 것은 오버로딩이 아님
    - 매개변수가 많다면?? 빌더 패턴 활용
- 다른 생성자 호출
    - this(...)를 사용하여 공통 초기화 코드 호출

### 6.8 메소드 선언과 호출

- 메소드 선언
    - 리턴타입 메소드명(매개변수,...) { // 실행블록 }
        - 리턴타입: 결과값의 타입 / 리턴이 없으면 void
        - 메소드명: 소문자 시작, 캐멀케이스
        - 매개변수: 메소드 호출시 전달할 매개값
        - 실행블록: 메소드 호출시 실행되는 블록
- 메소드 호출
    - 메소드 호출하기 위해 객체 생성 필요
    - 내부에서 호출시 메소드명 호출하면 되지만, 외부 객체에서 호출시 참조변수.메서드명(...); 으로 호출
    - 메서드가 리턴값이 있을 경우 변수에 저장 가능
        - `타입 변수 = 메소드();`
- 가변길이 매개변수
    - 매개값을 개수 상관없이 제공 가능
    - `메서드명(타입 ... 매개변수명);`
- return 문
    - 메서드의 실행을 강제 종료하고 호출부로 돌아감
    - `return [리턴값];`
- 메소드 오버로딩
    - 메소드 이름은 같고, 매개변수 타입, 개수, 순서가 다른 메소드를 여러 개 선언하는 것

### 6.9 인스턴스 멤버

- 인스턴스 멤버: 객체에 소속된 멤버
    - 객체 생성 필요
    - 필드와 메서드
    - 필드는 힙에 존재, 메서드는 메서드 영역에 존재(메모리 효율 위해 공유해서 사용)
- this 키워드
    - 객체 내부에서 인스턴스 멤버에 접근하기 위해 `this` 사용
    - 인스턴스 필드임을 강조할 때 주로 사용

### 6.10 정적 멤버

- 자바는 클래스 로더를 이용해 클래스를 메소드 영역에 저장하고 사용 (Static Area)
- 정적 멤버는 메소드 영역의 클래스에 고정적으로 위치하는 멤버
- 객체 생성 필요없이 사용 가능 / 어디서든 사용 가능
- 정적 멤버 선언
    - 필드와 메소드는 모두 정적 멤버 가능
    - static 키워드를 붙여 줌 `static 타입 필드;`
    - 객체마다 가지고 있을 필요성이 없는 공용적인 필드로 선언
- 정적 멤버 사용
    - 클래스이름.정적멤버
- 정적 블록
    - 정적블록은 클래스가 메모리에 로딩될 때 자동 실행
    - `static { ... }`
    - static 항목 초기화에 사용
- 인스턴스 멤버 사용 불가
    - 정적 메서드, 블록 내에서 인스턴스 필드, 인스턴스 메서드 사용 불가, this 사용 불가

### 6.11 final 필드와 상수

- 값을 변경하는 것을 막고, 읽기만 허용 하고자 할 때 final 필드, 상수 선언하여 사용
- final 필드 선언
    - 초기 값이 저장되면 최종 값이 된다.
- final 필드 초기화 방법
    - 필드 선언시 초기값 대입
    - 생성자에서 초기값 대입
- 상수 선언
    - `static final 타입 상수명 = 초기값;`
    - static 블록 내에서 초기화 가능
    - 상수변수 명은 대문자로 작성하는 것이 관례 혼합 단어시 언더바(_)로 구분

### 6.12 패키지

- 자바의 패키지는 단순히 디렉토리만을 의미하지 않음
- 패키지는 클래스의 일부분이고 클래스를 식별하는 용도로 사용
    - 클래스의 전체 이름에 포함
- 패키지명은 주로 개발 회사의 도메인 이름의 역순으로 만든다.
    - 전부 소문자가 관례이며, 회사 도메인 역순 + 프로젝트 명 ex) com.kurly.프로젝트명
- 상위 패키지와 하위패이지를 도트(.)로 구분, 도트는 물리적 디렉토리를 뜻함
- 패키지 선언
    - 클래스파일 최상단에 `package 상위패키지.하위패키지.~;`
- import 문
    - 같은 패키지에 있는 클래스는 바로 사용 가능
    - 다른 패키지에 있는 클래스를 사용하려면 import 문으로 어떤 패키지의 클래스를 사용할지 명시해야 함
        - `import com.hankook.Tire;`
        - 동일한 패키지 내에 포함된 다수의 클래스를 사용한다면 클래스이름 생략 후 *를 사용 가능
            - `import com.hankook.*;`
            - 하위 패키지는 포함시키지 않는다.
    - 각각 다른 패키지에 있는 동일한 클래스 이름의 파일을 import하고 사용하려면 컴파일 에러 발생
        - 클래스 전체 이름을 사용하여 구분을 해주어야 함
        - `com.hankook.Tire tire = new com.hankook.Tire();`

### 6.13 접근 제한자

- 경우에 따라 객체의 필드를 외부에서 변경하거나 메소드 호출을 막아야할 필요가 있다.
- 객체의 무결성을 유지하기 위함
- 접근 제한자(Access Modifier)를 사용
    - public, protected, (default) ,private

| 접근제한자     | 제한대상              | 제한범위              |
|-----------|-------------------|-------------------|
| public    | 클래스, 필드, 생성자, 메서드 | 없음                |
| protected | 필드, 생성자, 메서드      | 같은 패키지, 자식 객체(상속) |
| default   | 클래스, 필드, 생성자, 메서드 | 같은 패키지            |
| private   | 필드, 생성자, 메서드      | 객체 내부             |

- 클래스의 접근 제한
    - public, default 가능
    - public 접근 생략시 default 접근 제한, 같은 패키지 내에서만 사용 가능
- 생성자의 접근 제한
    - public(모든 패키지 생성 O), default(같은 패키지 생성 O), private(내부에서만 생성 O) 가능
- 필드와 메서드의 접근 제한
    - public(모든 패키지 O), default(같은 패키지 O), private(내부 O) 가능

### 6.14 Getter와 Setter

- 객체의 필드(데이터)를 외부에서 마음대로 읽고 변경할 경우 객체의 무결성이 깨질 수 있다.
- 객체지향 프로그래밍에서는 외부에서 직접적인 필드의 접근을 막고 메서드를 통해 필드 접근을 선호
- setter를 이용해 매개값을 검증 후 변경 가능
- getter를 이용해 외부 사용에 적절한 값으로 변경하여 리턴 가능
- getter와 setter 작성
    - 타입 getFieldName(), void setFieldName(타입 값)
    - boolean 필드의 경우 get 대신 is로 시작하는 것이 관례

### 6.15 싱글톤 패턴

- 애플리케이션 내에서 단 한개의 객체만 사용하고 싶은 경우 싱글톤 패턴 적용

```java

public class Single {
    private static Single instance = new Single();

    private Single() {
    }

    public static Single getInstance() {
        return instance;
    }
}
```

- [멀티스레드 환경에서의 싱글톤 패턴](https://jungwoon.github.io/java/2019/08/11/Singleton-Pattern-with-Multi-Thread.html)
- 단 하나의 항목만 갖는 Enum 클래스로 생성
