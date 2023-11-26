# Chapter 18 데이터 입출력

### 18.1 입출력 스트림

- 데이터는 키보드를 통해 입력될 수 있고, 파일 또는 프로그램으로 부터 입력될 수 있다.
- 데이터는 모니터로 출력될 수도 있고, 파일에 저장되거나 다른 프로그램에 전송될 수 있다.
- 이것을 총칭해 데이터 입출력이라고 한다.
- 자바는 입력 스트림과 출력 스트림을 통해 데이터를 입출력한다.
- 스트림은 방향으로 데이터가 흐르는 것을 말하는데, 데이터는 출발지에서 나와 도착지로 흘러들어간다.
- 프로그램 기준 데이터가 들어오면 입력 스트리ㅁ, 데이터가 나가면 출력 스트림이 된다.
- 데이터 스트림 두 종류
    - 바이트 스트림: 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 입출력할 때 사용
    - 문자 스트림: 문자만 입출력할 때 사용
- 자바 데이터 입출력 라이브러리 java.io 패키지
    - 최상위 바이트 스트림 클래스 InputStream, OutputStream => 상속 FileInputStream, FileOutputStream...
    - 최상위 문자 스트림 클래스 Reader, Writer => 상속 FileReader, FileWriter ...

### 18.2 바이트 출력 스트림

- OutputStream 은 바이트 출력 스트림의 최상위 클래스로 추상 클래스
- 모든 바이트 출력 스트림 클래스는 OutputStream 을 상속받아 만들어진다.
- **1 바이트 출력**
    - write(int b) 메소드는 매개값 int(4byte) 에서 끝 1byte 만 출력한다.
    - 매개변수가 int 타입이므로 4byte 모두를 보내는 것은 아니다.
    - OutputStream 은 내부에 작은 버퍼(buffer) 를 가지고 있다. write() 메소드가 호출되면 버퍼에 바이트를 우선 저장하고 버퍼가 차면 순서대로 바이트 출력한다.
    - flush() 메소드는 내부 버퍼에 잔류하는 모든 바이트를 출력하고 버퍼를 비우는 역할을 한다.
    - 내부 버퍼를 사용하는 이유는 출력 성능을 향상하기 위함
    - 출력 스트림을 사용하지 않으면 close() 를 호출해 메모리 해제
- **바이트 배열 출력**
    - write(byte[] b) 메소드는 매개값으로 주어진 배열의 모든 바이트를 출력한다.
    - 배열의 일부분을 출력하고 싶다면 write(byte[] b, int off, int len) 메소드를 사용

### 18.3 바이트 입력 스트림

- InputStream은 바이트 입력 스트림의 최상위 클래스로 추상 클래스
- 모든 바이트 입력 스트림은 InputStream 을 상속받아 만들어진다.
- **1 바이트 읽기**
    - read() 메소드는 입력 스트림으로부터 1byte 를 읽고 int(4byte) 타입으로 리턴
    - 4byte 중 끝에 1byte 에만 데이터가 들어 있다.
    - 읽을 수 없다면 read() 는 -1 을 리턴
- **바이트 배열로 읽기**
    - read(byte[] b) 메소드는 입력 스트림으로부터 주어진 배열의 길이만큼 바이트를 읽고 배열에 저장한 다음 읽은 바이트 수를 리턴
    - 많은 양의 바이트를 읽을 때는 read(byte[] b) 메소드를 사용하는 것이 좋다.
- Java 9 부터 편리하게 입력 스트림에서 출력 스트림으로 바이트를 복사하는 transferTo() 메소드가 InputStream 에 추가되었다.

### 18.4 문자 입출력 스트림

- 바이트 입출력 스트림인 InputStream 과 OutputStream 에 대응하는 입출력 스트림으로 Reader 와 Writer 가 있다.
- 입출력 단위가 되는 것을 제외하고는 바이트 입출력과 스트림과 사용 방법은 동일
- **문자 출력**
    - Writer 는 문자 출력 스트림의 최상위 클래스로 추상 클래스
    - 모든 문자 출력 스트림 클래스는 Wirter 클래스를 상속 받아서 만들어진다.
    - Writer 는 OutputStream 과 사용 방법은 동일하지만 출력 단위가 문자(char) 이다.
    - 문자열을 출력하는 write(String str) 메소드를 추가로 제공
- **문자 읽기**
    - Reader 는 문자 입력 스트림의 최상위 클래스로 추상 클래스
    - 모든 문자 입력 스트림 클래스는 Reader 클래스를 상속받아 만들어진다.

### 18.5 보조 스트림

- 보조 스트림이란 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림을 말한다.
- 보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에 입출력 소스로부터 직접 생성된 입출력 스트림에 연결해서 사용해야 한다.
- 입출력 스트림에 보조 스트림을 연결하려면 보조 스트림을 생성할 때 생성자 매개값으로 입출력 스트림을 제공하면 된다.
    - `보조스트림 변수 = new 보조스트림(입출력스트림);`
- 보조 스트림은 또 다른 보조 스트림과 연결되어 스트림 체인으로 구성할 수 있다.
    - `보조스트림2 변수 = new 보조스트림2(보조스트림1);`

### 18.6 문자 변환 스트림

- 바이트 스트림(InputStream, OutputStream) 에서 입출력할 데이터가 문자라면 문자 스트림 (Reader 와 Writer)로 변환해서 사용하는 것이 좋다.
- 문자로 바로 입출력하는 편리함이 있고, 문자셋의 종류를 지정할 수 있다.
- **InputStream을 Reader로 변환**
    - InputStream 을 Reader 로 변환하려면 InputStreamReader 보조 스트림을 연결하면 된다.
    - `Reader reader = new InputStreamReader(new FileInputStream("path~));`

> **FileReader 의 원리**
>> FileInputStream 에 InputStreamReader 를 연결하지 않고 FileReader 를 직접 생성할 수 있다.
> > FilerReader 는 InputStreamReader 의 자식 클래스
> > FileReader 가 내부적으로 FileInputStream 에 InputStreamReader 보조 스트림을 연결한 것

- **OutputStream을 Writer로 변환**
    - OutputStream 을 Writer 로 변환하려면 OutputStreamWriter 보조 스트림을 연결하면 된다.
    - `Writer writer = new OutputStreamWriter(new FileOutputStream("path"));`

> **FileWriter의 원리**
>> FileOutputStream 에 OutputStreamWriter 를 연결하지 않고 FileWriter 를 직접 생성할 수 있다.
> > FilerWriter 는 OutputStreamWriter 의 자식 클래스
> > FileWriter 가 내부적으로 FileOutputStream 에 OutputStreamWriter 보조 스트림을 연결한 것

### 18.7 성능 향상 스트림

- 프로그램이 입출력 소스와 직접 작업하지 않고 중간에 메모리 버퍼와 작업함으로써 실행 성능을 향상시킬 수 있다.
- 출력 스트림의 경우 직접 하드 디스크에 데이터를 보내지 않고 메모리 버퍼에 데이터를 보냄으로써 출력 속도를 향상 시킬 수 있다.
- 버퍼는 데이터가 쌓이기를 기다렸다가 꽉 차게 되면 데이터를 한꺼번에 하드 디스크로 보냄으로써 출력 횟수를 줄여준다.
- 입력 스트림에서도 버퍼를 사용하면 읽기 성능이 좋아진다.
- 버퍼를 사용하여 성능을 향상시키는 보조 스트림
    - BufferedInputStream, BufferedOutputStream
        - `BufferedInputStream bis = new BufferedInputStream(바이트 입력 스트림);`
        - `BufferedOutputStream bos = new BufferedOutputStream(바이트 출력 스트림);`
    - BufferedReader, BufferedWriter
        - `BufferedReader br = new BufferedReader(문자 입력 스트림);`
        - `BufferedWriter bw = new BufferedWriter(문자 출력 스트림);`
- 문자 입력 스트림 Reader 에 BufferedReader 를 연결하면 성능 향상뿐 아니라 행 단위로 문자열을 읽는 매우 편한 readLine() 메소드를 제공한다.

### 18.8 기본 타입 스트림

- 바이트 스트림에 DataInputStream 과 DataOutputStream 보조 스트림을 연결하면 기본 타입인 boolean, char, short, int, long, float, double 값을 입출력
  할 수 있다.
- `DataInputStream dis = new DataInputStream(바이트 입력 스트림);`
- `DataOutputStream dis = new DataOutputStream(바이트 출 스트림);`
- 데이터 타입의 크기가 모두 다르므로 DataOutputStream 으로 출력한 데이터를 DataInputStream 으로 읽어 올 때에는 출력한 순서와 동일한 순서로 읽어야 한다.

### 18.9 프린트 스트림

- PrintStream 과 PrintWriter 는 프린터와 유사하게 출력하는 print(), println(), printf() 메소드를 가지고 있는 보조 스트림이다.
- 콘솔에 출력하는 System.out.println() 은 out 이 PrintStream 타입이다.
- PrintStream 은 바이트 출력 스트림과 연결되고, PrintWriter 는 문자 출력 스트림과 연결된다.
- `PrintStream ps = new PrintStream(바이트 출력 스트림);`
- `PrintWriter pw = new PrintWriter(문자 출력 스트림);`
- println() 메소드는 출력할 데이터 끝에 줄바꿈 문자인 `\n` 을 추가시켜 줄바꿈이 일어난다.

### 18.10 객체 스트림

- 자바는 메모리에 생성된 객체를 파일 또는 네트워크로 출력할 수 있다.
- 객체를 출력하려면 필드값을 일렬로 늘어선 바이트로 변경해야 하는데, 이것을 직렬화(serialization) 라고 한다.
- 직렬화된 바이트 객체를 필드값으로 복원하는 것을 역직렬화(deserialization) 라고 한다.
- ObjectInputStream과 ObjectOutputStream 은 객체를 입출력 할 수 있는 보조 스트림이다.
- ObjectOutputStream 은 바이트 출력 스트림과 연결되어 객체를 직렬화 한다.
- ObjectInputStream 은 바이트 입력 스트림과 연결되어 객체로 복원하는 역직렬화를 한다.
- `ObjectInputStream ois = new ObjectInputStream(바이트 입력 스트림);`
- `ObjectOutputStream oos = new ObjectOutputStream(바이트 출력 스트림);`
- ObjectOutputStream 으로 객체를 직렬화 하기 위해서 writeObject() 메소드를 사용
- ObjectInputStream 으로 바이트를 역직렬화 해서 객체를 만들기 위해 readObject() 메소드를 사용
- 복수의 객체를 저장할 경우 출력된 객체 순서와 동일한 순서로 객체를 읽어야 한다.
- **Serializable 인터페이스**
    - 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화할 수 있도록 제한한다.
    - Serializable 인터페이스는 멤버가 없는 빈 인터페이스이지만, 객체를 직렬화 할 수 있다고 표시하는 역할
    - 객체가 직렬화될 때 인스턴스 필드값은 직렬화 대상이지만 정적 필드값과 transient로 선언된 필드 값은 직렬화 객체에서 제외되므로 출력되지 않는다.
- **serialVersionUID 필드**
    - 직렬화할 때 사용된 클래스와 역직렬화할 때 사용된 클래스는 기본적으로 동일한 클래스여야 한다.
    - 만약 클래스 이름이 같더라도 클래스의 내용이 다르면 역직렬화에 실패한다.
    - 클래스 내용이 다르다 할지라도 직렬화된 필드를 공통으로 포함하고 있다면 역직렬화할 수 있는 방법이 있다.
    - 두 클래스가 동일한 serialVersionUID 상수값을 가지고 있으면 된다.
    - serialVersionUID 값은 개발자가 임의로 줄 수 있지만 가능하다면 클래스마다 다른 유일한 값을 갖도록 하는 것이 좋다.

### 18.11 File과 Files 클래스
- java.io 패키지와 java.nio.file 패키지는 파일과 디렉토리 정보를 가지고 있는 File과 Files 클래스를 제공한다.
- **File 클래스**
  - File 클래스로 부터 File을 생성하는 방법
  - `File file = new File("경로");`
  - File 객체를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다.
  - 경로에 실제 파일이나 디렉토리가 없더라도 예외가 발생하지 않는다.
  - 실제 존재 여부는 File 객체를 생성하고 나서 exists() 메소드를 호출해본다.
    - createNewFile(), mkdir(), mkdirs() 메소드를 활용해 파일, 디렉토리를 생성할 수 있다.
- **Files 클래스**
  - Files 클래스는 정적 메소드로 구성되어 있기 때문에 File 클래스처럼 객체로 만들 필요가 없다.
  - Files 의 정적 메소드는 운영체제의 파일 시스템에게 파일 작업을 수행하도록 위임한다.
  - copy, createDirectories, createDirectory, createFile, move, delete, exists ...
  - 메소드들은 매개값으로 Path 객체를 받는다. 
    - Path 객체는 파일이나 디렉토리를 찾기 위한 경로 정보를 갖고 있는데, 정적 메소드인 get() 메소드로 얻을 수 있다.
    - `Path path = Paths.get(String first, String... more);`
  - 

