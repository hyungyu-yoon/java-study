# Chapter 8 인터페이스

### 8.1 인터페이스 역할

- 인터페이스(Interface)는 두 객체를 연결하는 역할
- 객체 A <=> 인터페이스 <=> 객체 B , 객체 C
- 객체 A에서 인터페이스의 메소드를 호출하면 실제 호출하는 코드는 B 또는 C를 교체하여 사용할 수 있다.
- 인터페이스가 없다면 객체 A에서 객체 B를 사용하는 코드를 객체 C로 교체해야만 사용할 수 있다.
- 인터페이스는 다형성 구현에 주된 기술로 이용된다.

### 8.2 인터페이스와 구현 클래스 선언

- **인터페이스 선언**
    - `class` 대신 `interface` 키워드 사용
    - 접근제한자 default, public 사용 가능
    - 인터페이스 멤버

```java
public interface 인터페이스 {
    // public 상수 필드
    // public 추상 메소드
    // public 디폴트 메소드
    // public 정적 메소드
    // private 메소드
    // private 정적 메소드
} 
```

- **구현 클래스 선언**
    - 인터페이스를 구현한 구현 클래스는 인터페이스에 선언된 추상 메소드와 동일한 선언부를 가진 메소드를 가지고 있어야 한다.
    - `public class B implements 인터페이스명 { ... }`
    - implements 키워드는 해당 클래스가 인터페이스를 통해 사용할 수 있다는 표시

- **변수 선언과 구현 객체 대입**
    - 인터페이스도 하나의 타입이므로 변수의 타입으로 사용 가능
    - 인터페이스는 참조 타입에 속하므로 null 대입 가능
    - 인터페이스를 통해 구현 객체를 사용하려면 변수에 구현 객체를 대입해야 한다.
    - `RemoteControl rc = new Television();`
    - rc 변수에는 RemoteControl 을 구현한 어떠한 객체든 대입 가능하다.

### 8.3 상수 필드

- 인터페이스에는 `public static final` 특성을 갖는 불변의 상수필드를 멤버로 가질 수 있다.
- 인터페이스에 선언된 필드는 모드 public static final 특성을 갖는다. (생략가능)

### 8.4 추상 메소드

- 인터페이스는 구현 클래스가 재정의해야 하는 public 추상 메소드를 멤버로 가질 수 있다.
- `[public abstract] 리턴타입 메소드명(매개변수,...);`
- 추상메소드는 객체 A가 인터페이스를 통해 어떻게 메소드를 호출할 수 있는지 방법을 알려주는 역할을 한다.
- 인터페이스 구현 객체 B는 추상 메소드의 실행부를 갖는 재정의된 메소드가 있어야 함
- 추상 메소드 기본적으로 public 접근 제한자이므로 구현한 메소드도 public

### 8.5 디폴트 메소드

- 인터페이스에 완전한 실행 코드를 가진 디폴트 메소드 선언 가능
- default 키워드가 리턴타입 앞에 붙는다.
- `[public] default 리턴타입 메소드명(매개변수,...){ ... }`
- 디폴트 메소드의 실행부에는 상수 필드를 읽거나 추상 메소드를 호출하는 코드를 작성할 수 있다.
- 디폴트 메소드는 구현 클래스에서 재정의하여 사용 가능 public 접근 제한자 필수, default 생략

### 8.6 정적 메소드

- 인터페이스에 정적 메소드 선언 가능
- 추상 메소드와 디폴트 메소드는 구현 객체가 필요하지만, 정적 메소드는 구현 객체 없이 인터페이스만으로 호출 가능
- `[public | private] static 리턴타입 메소드명(매개변수, ...) { ... }`
- 정적 메소드의 실행부에는 상수 필드를 제외한 추상 메소드, 디폴트 메소드, private 메소드 등을 호출할 수 없다. (객체 생성 필요하기 때문)

### 8.7 private 메소드

- 인터페이스의 멤버들은 public 은 생략하더라도 컴파일 과정에서 외부에서 접근 가능하도록 public 접근 제한자가 붙는다.
- 외부에서 접근할 수 없도록 private 메소드를 선언 가능하다.
- private 메소드는 구현 객체가 필요하고 private 정적 메소드는 구현 객체가 필요없다.

### 8.8 다중 인터페이스 구현

- 구현 객체는 여러 개의 인터페이스를 implements 할 수 있다.

```java
public class 구현클래스명 implements 인터페이스A, 인터페이스B {
    // ...
}
```

- 인터페이스 A와 B 를 구현한 객체는 두 인터페이스 타입의 변수에 각각 대입될 수 있다.
    - `인터페이스A 변수 = new 구현클래스명();`
    - `인터페이스B 변수 = new 구현클래스명();`

### 8.9 인터페이스 상속

- 인터페이스도 다른 인터페이스를 상속할 수 있으며, 클래스와 달리 다중 상속을 허용한다.
- `public interface 자식인터페이스 extends 부모인터페이스1, 부모인터페이스2 { ... }`
- 자식 인터페이스의 구현 클래스는 자식, 부모 인터페이스의 모든 추상 메소드를 재정의해야 한다.
- 구현 객체는 부모, 자식 인터페이스 변수에 대입될 수 있다.

### 8.10 타입 변환

- 인터페이스 타입 변환은 인터페이스와 구현 클래스간 발생한다.
- 인터페이스에 구현 클래스 대입은 자동 변환
- 구현 클래스에 인터페이스 대입은 강제 타입 변환
- **자동 타입 변환**
    - `인터페이스 변수 = 구현객체;`
    - 부모 클래스가 인터페이스를 구현하고 있다면 자식 클래스도 인터페이스 타입으로 자동 변환될 수 있다.
- **강제 타입 변환**
    - 강제 타입 변환은 캐스팅 기호를 사용해서 인터페이스 타입을 구현 클래스 타입으로 변환 시키는 것
    - `구현클래스 변수 = (구현클래스) 인터페이스변수;`

### 8.11 다형성

- 현업에서는 상속보다 인터페이스를 통해서 다형성을 구현하는 경우가 많다.
- **다형성** 이란 사용 방법은 동일하지만 다양한 결과가 나오는 성질
- 인터페이스의 추상 메소드는 구현 클래스에서 재정의를 해야 하며, 재정의되는 내용은 구현 클래스마다 다르다.
- 구현 객체는 인터페이스 타입으로 자동 타입 변환이 되고, 인터페이스 메소드 호출 시 구현 객체의 재정의된 메소드가 호출되어 다양한 실행 결과를 얻을 수 있다.
- **필드의 다형성**
    - 클래스의 필드를 인터페이스로 선언하면 인터페이스를 구현한 다양한 객체를 대입할 수 있다.

```java
public class Car {
    Tire tire1 = new HankookTire();
    Tire tire2 = new KumhoTire();
}
```

- **매개변수의 다형성**
    - 매개변수 타입을 인터페이스로 선언하면 메소드 호출 시 다양한 구현 객체를 대입할 수 있다.
    - 구현 객체마다 실행 결과가 다른 구현을 할 수 있다.

### 8.12 객체 타입 확인

- 인터페이스에서도 `instanceof` 연산자 사용
- `if (vehicle instanceof Bus) { ... }`
- 메소드의 매개변수가 인터페이스일 때 특정 구현 객체일때만 강제 타입 변환을 하고 싶다면 instanceof 연산자로 타입 검사
- Java 12 부터는 우측 타입 변수로 바로 할당 가능

### 8.13 봉인된 인터페이스

- Java 15 부터 무분별한 자식 인터페이스 생성을 방지하기 위해 봉인된(sealed) 인터페이스 사용 가능
- `public sealed interface InterfaceA permits InterfaceB { ... }`
- `public non-sealed interface InterfaceB extends InterfaceA { ... }` non-sealed 또는 sealed 로 봉인해야 됨
- `public interface InterfaceC extends InterfaceB { ... }` non-sealed 는 다른 자식 인터페이스 만들 수 있다.
