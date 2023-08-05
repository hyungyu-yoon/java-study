# Chapter 4 조건문과 반복문

### 코드 실행 흐름 제어

- 자바 프로그램은 main에서 시작하여 개발자가 제어문으로 실행흐름을 원하는 방향으로 바꾸며 흐름을 제어한다.
- if, switch, for, while, do-while

### if 문

- if (조건식 (true/false)) { true 일 때 실행문 }
- if (조건식) { true 실행문 } else { false 실행문 }
- if (조건식) { 조건식1 true 실행문 } else if(조건식2) {조건식2 true } else { false 실행문 }

### switch

- if문은 true, false 결과 두가지뿐으로 경우의 수가 많아질수록 else if 를 반복적으로 추가해야함
- switch 문은 변수의 값에 따라서 실행문을 결정하여 간결함
- 자바 12부터 적용된 switch expression 사용

```java
    switch(grade){
        case'a','A'->System.out.println("우수 회원");
        case'b','B'->System.out.println("일반 회원");
default ->System.out.println("회원");
        }
```

### for 문

- 동일한 실행문을 여러번 반복적으로 실행하는 경우에 사용
- for(초기화식; 조건식; 증감식) { 실행문 }
- 초기화식에 부동 소수점을 사용하는 float 사용하면 안 됨

### while 문

- for문은 정해진 회수대로 반복, while은 조건식이 true 일 경우 계속해서 반복 false에 종료
- while (조건식) { 실행문 }

### do while 문

- do while문은 처음에 한 번은 실행이 필요할 때 사용
- do { 실행문 } while( 조건문 )**;**

### break 문

- 반복문의 실행을 종료하거나 switch 문을 종료할 때 사용
- break; 반복문을 강제로 빠져나감
- Label: for ~ break Label;
    - 중첩된 반복문 종료시킬때 Label 사용

### continue 문

- 반복문에서 사용. continue 문 실행시 이후 실행문 무시하고 조건식으로 바로 이동 