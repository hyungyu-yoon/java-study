# Chapter 20 데이터베이스 입출력

### 20.1 JDBC 개요

- 자바는 DB 와 연결해서 데이터 입출력 작업을 할 수 있도록 JDBC(Java Database Connectivity) 라이브러리를 제공
- JDBC 는 DBMS 의 종류와 상관없이 동일하게 사용할 수 있는 클래스와 인터페이스로 구성
- JDBC 인터페이스를 통해 실제 DB와 작업하는 것은 JDBC Driver
    - application <-> JDBC Driver <-> oracle, mysql, maria db, sql servier ...
    - **DriverManager**
        - JDBC Driver 관리하여 DB 와 연결해서 Connection 구현 객체 생성
    - **Connection**
        - Statement, PreparedStatement, CallableStatement 구현 객체 생성, 트랜잭선 처리 및 DB 연결 끊을 때 사용
    - **Statement**
        - SQL 의 DDL 과 DML 을 실행할 때 사용. 주로 변경되지 않는 정적 SQL 문을 실행할 때 사용
    - **PreparedStatement**
        - Statement 와 동일하게 SQL의 DDL, DML 문을 실행할 때 사용, 매개변수화된 SQL 문을 사용할 수 있어 편리성과 보안성이 좋다.
    - **CallableStatement**
        - DB 에 저장되어 있는 프로시져(Procedure) 와 함수(function) 을 호출할 때 사용
    - **ResultSet**
        - DB에서 가져온 데이터를 읽을 때 사용

### 20.2 DBMS 설치

- docker mysql 활용

### 20.3 Client Tool 설치

- Datagrip, DBeaver, mysql workbench ...

### 20.4 DB 구성

**table**

```text
create table users(
	userid varchar(50) primary key,
	username varchar(50) not null,
	userpassword varchar(50) not null,
	userage numeric(50) not null,
	useremail varchar(50) not null
);
```

### 20.5 DB 연결

- 클라이언트에서 DB 에 연결하기 위해서는 해당 DBMS 의 JDBC가 필요하다.
- 접속 정보
    - DBMS IP
    - DBMS port
    - 사용자 계정 및 비밀번호
    - 사용하고자 하는 DB 이름
- JDBC Driver 설치
- https://mvnrepository.com/artifact/mysql/mysql-connector-java
- **DB 연결**
    - 클라이언트 프로그램을 DB 와 연결하기 위해 가장 먼저 해야할 것은 JDBC Driver를 메모리로 로딩하는 것
    - `Class.forName("com.mysql.cj.jdbc.Driver");`
    - JDBC Driver 의 static 블록이 실행되면서 DriverManager에 JDBC Driver 객체를 등록하게 된다.
    - DriverManager 에 Driver 가 등록되면 getConnection() 메소드로 db 와 연결할 수 있다.
        - `Connection conn = DriverManager.getConnection("연결 문자열", "사용자", "비밀번호");`
        - mysql url : `jdbc:mysql://localhost:3306/thisisjava`
        - DB 연결을 끊을 때 close() 메소드 호출

### 20.6 데이터 저장

- JDBC를 이용해 INSERT 문 실행

```java
    String sql=new StringBuilder()
        .append("INSERT INTO users (userid, username, userpassword, userage, useremail) ").append("VALUES (?, ?, ?, ?, ?)")
        .toString();

        String sql=""+
        "INSERT INTO users (userid, username, userpassword, userage, useremail) "+"VALUES (?, ?, ?, ?, ?)";
```

- 매개변수화된 SQL 문을 실행하려면 PreparedStatement 가 필요하다.

```java
        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,"winter");
        pstmt.setString(2,"한겨울");
        pstmt.setString(3,"12345");
        pstmt.setInt(4,25);
        pstmt.setString(5,"winter@mycompany.com");
```

- executeUpdate() 메소드 호출하면 SQL 문 실행되면서 users 테이블에 1개의 행이 저장
- `int rows = pstmt.executeUpdate();`
- PreparedStatement 를 더 이상 사용하지 않으면 close 로 해제
- Board 저장

```text
String sql = "" +
"INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " + "VALUES (?, ?, ?, now(), ?, ?)";

PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
```

- 두 번째 인자 insert 문이 실행된 후 생성된 키 값을 가져온다.

### 20.7 데이터 수정

- JDBC UPDATE 문

```text

String sql = new StringBuilder()
 .append("UPDATE boards SET ")
 .append("btitle = ?, ")
 .append("bcontent = ?, ")
 .append("bfilename = ?, ")
 .append("bfiledata=? ")
 .append("WHERE bno=?")
 .toString();
 
  PreparedStatement pstmt = conn.prepareStatement(sql); pstmt.setString(1, "눈사람");
    pstmt.setString(2, "눈으로 만든 사람");
    pstmt.setString(3, "snowman.jpg");
    pstmt.setBlob(4, new FileInputStream("src/ch20/mysql/sec07/snowman.jpg")); pstmt.setInt(5, 3);
```

- Insert와 동일하게 PreparedStatement 를 얻고, 업데이트는 executeUpdate() 실행
- 성공적으로 실행되면 수정된 행의 수가 리턴
    - `int rows = pstmt.executeUpdate();`
- 0이 리턴되면 조건에 맞는 행이 없어 수정된 내용이 없음을 의미

### 20.8 데이터 삭제

- JDBC DELETE 문 실행

```text
String sql = "DELETE FROM boards WHERE bwriter=?"; 
PreparedStatement pstmt = conn.prepareStatement(sql); 
pstmt.setString(1, "winter");
int rows = pstmt.executeUpdate();
```

- Delete sql 작성 후 executeUpdate 로 실행
- 리턴 값은 삭제된 행 수

### 20.9 데이터 읽기

- PreparedStatement 를 생성할 때 SQL 문이 INSERT, UPDATE, DELETE 일 경우에는 executeUpdate() 메소드를 호출하지만,
- 데이터를 가져오는 SELECT 문 일 경우에는 executeQuery() 메소드를 호출해야 한다.
- executeQuery() 는 가져온 데이터를 ResultSet 에 저장하고 리턴
- `ResultSet rs = pstmt.executeQuery();`
- **ResultSet 구조**
    - ResultSet 은 SELECT 문에 기술된 컬럼으로 구성된 행(row) 의 집합
    - ResultSet 의 특징은 커서가 있는 행의 데이터만 읽을 수 있다.
    - ResultSet 은 실제 가져온 데이터 행의 앞과 뒤에 beforeFirst 행과 afterLast 행이 붙는데, 최초 커서는 beforeFirst 를 가리킨다.
    - 첫 번째 데이터 행인 first 행을 읽으려면 커서를 이동시켜야 한다. 이때 next() 메소드 사용
    - `boolea result = rs.nest();`
    - next() 메소드는 커서를 다음 행으로 이동시키고, 이동한 행에 데이터가 있으면 true, 없으면 false 리턴
    - 1개 일 때 if문, n개 일 때 while 문으로 반복하며 행을 가져옴
    - ResultSet을 더 이상 사용하지 않는다면 close() 로 메모리 해제
- **데이터 행 읽기**
    - 커서가 있는 데이터 행에서 각 컬럼은 Getter 메소드로 읽을 수 있다.
    - 컬럼의 데이터 타입에 따라 getXxx() 메소드 사용하고, 매개값으로 컬럼의 이름 또는 컬럼 순번을 줄 수 있다.
- **사용자 정보 읽기**
    - boards

### 20.10 트랜잭션 처리

- 트랜잭션(transaction) 은 기능 처리의 최소 단위를 말한다.
- 하나의 기능은 여러 가지 소작업들로 구성될 수 있다.
- 최소 단위 란 것은 이 소작업들을 분리할 수 없으며, 전체를 하나로 본다는 개념
- 트랜잭션은 소작업들이 모두 성공하거나 모두 실패해야 한다.
- 계좌 이체의 출금, 입금 작업으로 구성된 트랜잭션
- DB는 트랜잭션을 처리하기 위해 커밋(commit) 과 롤백(rollback) 을 제공
- 커밋은 내부 작업을 모두 성공 처리하고, 롤백은 실행 전으로 돌아간다는 의미에서 모두 실패 처리
- JDBC 는 INSERT, UPDATE, DELETE 문을 실행할 때 마다 자동 커밋이 일어남
- JDBC 에서 트랜잭션을 코드로 제어하려면 자동 커밋 기능을 꺼야 한다.
- `conn.setAutoCommit(false);` 자동 커밋 설정 여부 off
- `conn.commit();` 커밋
- `conn.rollback();` 롤백
- 트랜잭션을 처리한 이후에는 원래대로 자동 커밋을 켜두어야 한다.
- 커넥션풀 사용 시 주의해야할 부분
- **커넥션 풀**
    - 다수의 클라이언트의 요청을 처리하는 서버 프로그램은 대부분 커넥션 풀을 사용한다.
    - 커넥션 풀은 일정량의 Connection 을 미리 생성시켜놓고, 서버에서 클라이언트의 요청을 처리할 때 Connection 을 제공해주고 다시 반환받는 역할 수행
    - 커넥션 풀을 사용하면 Connection 을 재사용할 수 있기 때문에 DB 연결 시간을 줄일 수 있고, 전체 Connection 수를 관리할 수 있다.
    - 불특정 다수의 클라이언트 요청을 처리하는 서버 프로그램에서는 필수 기능 중 하나이다.

### 20.11 게시판 구현
- 게시물 생성
- 게시물 읽기
- 게시물 수정
- 게시물 삭제
- 게시물 전체 삭제
- 종료