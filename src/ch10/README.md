# Chapter 10 라이브러리와 모듈

### 10.1 라이브러리

- 라이브러리(library): 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것
- JAR(Java ARchive) ~.jar 형태
    - JAR 파일에는 클래스와 인터페이스의 바이트코드 들이 압축되어 있다.
- 특정 클래스와 인터페이스가 여러 응용프로그램을 개발할 때 공통으로 자주 사용된다면 JAR 파일로 압축해서 라이브러리로 관리하는 것이 좋다.
- 인텔리제이 .jar 만드는법
    - Product Structure (cmd + ;)
    - Artifacts 탭
    -
        + 버튼 -> Jar -> From modules with dependencies..
    - jar 만들 module 선택 -> OK
- jar 라이브러리 추가
    - Product Structure (cmd + ;)
    - Libraries 탭
    -
        + 버튼 -> 생성된 jar 선택

### 10.2 모듈

- Java 9 부터 지원하는 모듈(module)은 패키지 관리 기능까지 포함된 라이브러리
- 모듈은 일부 패키지를 은닉하여 접근할 수 없게 할 수 있다.
- 모듈은 자신이 실행할 때 필요로 하는 의존 모듈을 모듈 기술자(module-info.java) 에 기술할 수 있기 때문에 모듈간의 의존 관계를 쉽게 파악할 수 있다.
- 모듈도 라이브러리이므로 JAR 형태로 배포할 수 있다.
- 대규모 응용프로그램은 기능별로 모듈화해서 개발할 수 있다.
    - 재사용성 및 유지보수에 유리

### 10.3 응용프로그램 모듈화

- 서브 프로젝트(모듈)로 쪼개고 조합해서 응용프로그램을 개발할 수 있다.
- 모듈용 프로젝트 생성
    - `module-info.java` 파일 생성

```text
module my_module_a {
    exports pack1;
    exports pack2;
}
```

- 모듈로 내보낼 패키지 exports ~

### 10.4 모듈 배포용 JAR 파일

- 다른 모듈에서 쉽게 사용할 수 있도록 배포용 JAR 파일 생성
- Project Structure
    - Modules
    -
        + JARs or Directories..

### 10.5 패키지 은닉

- 모듈은 모듈 기술자(module-info.java) 에서 exports 키워드를 사용해 내부 패키지 중 외부에서 사용할 패키지를 지정
- exports 되지 않은 패키지는 자동 은닉된다.

### 10.6 전이 의존

- my_application_2 의존관계
    - my_application_2 -> my_module_a, my_module_b

```text
module my_application_2 {
    requires my_module_a;
    requires my_module_b;  
}  
```

- 의존 관계 변경
    - my_application_2 -> my_module_a -> my_module_b

```text
module my_application_2 {
    requires my_module_a;
}  
```

```text
module my_module_a {
    exports pack1;
    requires my_module_b;
}  
```

- 위의 처럼 작성하면 my_application_2에서는 my_module_b 모듈을 사용할 수 없다.
- my_application_2에서 my_module_b를 사용하려면 my_module_a에서 my_module_b에 transtive를 추가로 붙여준다.

```text
module my_module_a {
    exports pack1;
    requires transitive my_module_b;
}  
```

### 10.7 집합 모듈

- 집합 모듈은 여러 모듈을 모아놓은 모듈
- 자주 사용되는 모듈들을 일일히 requires 하는 번거로움을 피하고 싶을 때 집합 모듈 생성하면 편리하다.
- 집합 모듈은 자체적인 패키지를 가지지 않고, 모듈 기술자에 전이 의존 설정만 한다.
```text
module my_module {
    requires transitive my_module_a;
    requires transitive my_module_b;
}
```

```text
module my_application_2 {
    requires my_module;
}  
```

### 10.8 리플렉션 허용
- 은닉된 패키지는 기본적으로 다른 모듈에 의해 리플렉션을 허용하지 않는다.
- 리플렉션(reflection) 이란 실행 도중에 타입(클래스, 인터페이스 등)을 검사하고 구성 멤버를 조사하는 것
- 경우에 따라서 은닉된 패키지도 리플렉션을 허용 할 때가 있다.
- 모듈은 모듈 전체 또는 지정된 패키지에 대해 리플렉션을 허용할 수 있고, 특정 외부 모듈에서만 리플렉션을 허용할 수도 있다.
##### 모듈 전체를 리플렉션 허용
```text
open module 모듈명 {
    ...
}
```
##### 지정된 패키지에 대해 리플렉션 허용
```text
module 모듈명 {
    ...
    opens 패키지1;
    opens 패키지2;
}
```

##### 지정된 패키지에 대해 특정 외부 모듈에서만 리플렉션 허용
```text
module 모듈명 {
    ...
    opens 패키지 to 외부모듈명, 외부모듈명, ...;
    opens 패키지2 to 외부모듈명;
}
```
- export 된 패키지는 언제든지 리플렉션 가능하므로 opens 지정 필요없다.
- opens는 은닉된 패키지 중에서 특정 패키지에 대한 리플렉션을 허용

### 10.9 자바 표준 모듈
- JDK 가 제공하는 표준 라이브러리
- 표준 라이브러리를 모듈화한 이유는 응용프로그램을 실행하는데 필요한 모듈만으로 구성된 작은 사이즈의 자바 실행 환경을 만들기 위해서이다.
  - 독립 실행형(응용프로그램 + 표준 라이브러리)으로 배포할 경우 표준 라이브러리의 크기가 작을수록 배포 사이즈가 줄어든다.
  - 제한된 자원만 가지고 있는 소형(임베디드) 기기에는 사이즈가 작은 자바 실행 환경이 필요하다.
