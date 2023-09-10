# Chapter 11 예외 처리

### 11.1 예외와 예외 클래스

- 에러(error): 컴퓨터 하드웨어의 고장으로 인해 응용프로그램 실행 오류가 발생하는 것
    - 개발자도 대처 불가한 에러
- 예외(exception): 잘못된 사용 또는 코딩으로 인한 오류
    - 예외가 발생되면 프로그램은 곧바로 종료된다는 점에서 에러와 동일하다.
    - 하지만, 예외 처리를 통해 계속 실행 상태를 유지할 수 있다.
- 예외 종류
    - 일반 예외(Exception)
        - 컴파일러가 예외 처리 코드 여부를 검사하는 예외
    - 실행 예외(Runtime Exception)
        - 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
- 자바의 모든 에러와 예외 클래스는 Throwable을 상속받아 만들어지고, 예외 클래스는 `java.lang.Exception` 클래스를 상속받는다.
- 실행 예외는 RuntimeException 과 그 자식 클래스에 해당

### 11.2 예외 처리 코드

- 예외가 발생했을 때 프로그램의 갑작스러운 종료를 막고 정상 실행을 유지할 수 있도록 처리하는 코드를 **예외 처리 코드** 라고 한다.
- 예외 처리 코드는 `try-catch-finally` 블록으로 구성된다.

```text
try {
    // ...
} catch (Exception e) {
    // ...
} finally{
    // ...
}
 ```

- try 블록 내에서 작성한 코드가 예외 없이 정상 실행되면 catch 블록은 실행되지 않고 finally 블록이 실행된다.
- try 블록에서 예외가 발생하면 catch 블록이 실행되고 finally 블록이 실행된다.
- finally 는 try, catch 문에서 return 으로 반환되더라도 항상 실행된다. (finally는 생략가능)
- 예외가 발생하면 catch 선언부의 예외 클래스 변수에 예외 객체 대입
    - e.getMessage() : 예외가 발생한 이유만 리턴
    - e.toString() : 예외의 종류도 리턴
    - e.printStackTrace() : 예외가 어디서 발생했는지 추적한 내용까지 출력

### 11.3 예외 종류에 따른 처리

- 다중 catch 를 사용하면 발생하는 예외에 따라 예외 처리 코드를 다르게 작성할 수 있다.
- catch 블록은 발생된 예외에 따라 선택된다.
- catch 블록은 단 하나만 실행된다.
- 처리해야 할 예외 클래스들이 상속 관계에 있을 때에는 하위 클래스 catch 블록을 먼저 작성하고 상위 클래스 catch 블록을 나중에 작성해야 한다.
- 예외가 발생하면 catch 블록 위에서부터 차례로 검사 대상이 된다.
- 두 개 이상의 예외를 하나의 catch 블록으로 처리하고 싶은 경우 `|` 기호로 연결
    - `catch (NullPointerException | NumberFormatException e) { System.out.println(e.getMessage()); }`

### 11.4 리소스 자동 닫기

- 리소스(Resource)란 데이터를 제공하는 객체를 말한다.
- 리소스는 사용하기 위해 열어야(open) 하며, 사용이 끝난 후에 닫아야(close) 한다. ex) 파일
- 리소스를 사용하다가 예외가 발생될 경우에도 안전하게 닫는 것이 중요하다.
- `try-with-resources` 블록 사용
    - 예외 발생 여부와 상관없이 리소스를 자동으로 닫아준다.
    - 자동으로 리소스의 close 메소드가 호출된다.
    - 사용하기 위해 리소스는 AutoCloseable 인터페이스를 구현하고 있어야 한다.
    - 복수의 리소스는 세미콜론(;)으로 구분해서 사용 가능

```text
try(
    FileInputStream fis1 = new FileInputStream("file1.txt");
    FileInputStream fis2 = new FileInputStream("file2.txt")
) {
    // ...
} catch (IOException e) {
    // ...
}
```

- 자바 9이후 부터는 외부 리소스를 try 괄호 안에 넣을 수 있다.

### 11.5 예외 떠넘기기

- 메소드 내부에서 예외가 발생할 때 try-catch 블록으로 예외를 처리하는 것이 기본이지만, 메소드를 호출한 곳으로 예외를 떠넘길 수도 있다.
- 이때 사용하는 키워드가 throws
- 메소드 선언부 끝에 작성 `리턴타입 메소드명(매개변수...) throws 예외클래스1, 예외클래스2... {}`
- 예외를 처리하지 않고 떠넘겼기 때문에 호출하는 곳에서 예외를 처리해야 한다.
- 나열해야 하는 예외 클래스가 많은 경우 throws Exception 또는 throws Thowable 만으로 모든 예외를 넘길 수 있다.
- main에서도 넘길 경우 JVM 이 최종적으로 예외 처리를 하게 된다.
    - JVM은 예외의 내용을 콘솔에 출력하는 것으로 예외처리를 한다.

### 11.6 사용자 정의 예외

- 자바 표준 라이브러리에 존재하지 않는 예외는 직접 예외 클래스를 정의하여 사용해야 한다.
- **사용자 정의 예외**
    - 통상적으로 일반 예외는 Exception 의 자식 클래스로 선언
    - 실행 예외는 RuntimeException 의 자식 클래스로 선언
- **에외 발생 시키기**
    - 자바에서 제공하는 표준 예외뿐만 아니라 사용자 정의 예외를 직접 코드에서 발생시키려면 throw 키워드와 함께 예외 객체를 제공하면 된다.
    - `throw new Exception("예외 메시지);`
    - `throw new RuntimeException("예외 메시지);`
    - `throw new InsufficientException("예외 메시지);`
