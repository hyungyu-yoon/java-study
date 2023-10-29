# Chapter 15 컬렉션 자료구조

### 15.1 컬렉션 프레임워크

- 객체들을 효율적으로 추가, 삭제, 검색 할 수 있는 인터페이스와 관련된 클래스들을 java.util 패키지에 포함시켜놓았다.
- 이를 컬렉션 프레임워크라고 부른다.
- 주요 인터페이스 List, Set, Map
- Collection
    - List (ArrayList, Vector, LinkedList ...): 순서를 유지하고 저장, 중복 저장 가능
    - Set (HashSet, TreeSet ...): 순서를 유지하지 않고 저장, 중복 저장 안됨
- Map (HashMap, HashTable, TreeMap, Properties): 키와 값으로 구성된 엔트리 저장, 키는 중복 저장 안됨

### 15.2 List 컬렉션

- List 컬렉션은 객체를 인덱스로 관리하기 때문에 객체를 저장하면 인덱스가 부여되고, 인덱스로 객체 검색, 삭제하는 기능 제공
- List 인터페이스 메소드
    - boolean add(E e) : 주어진 객체를 맨 끝에 추가
    - void add(int index, E element): 주어진 인덱스에 객체를 추가
    - set(int index, E element): 주어진 인덱스의 객체를 새로운 객체로 바꿈
    - ======
    - boolean contains(Object o): 주어진 객체가 저장되어 있는지 여부
    - E get(int index): 주어진 인덱스에 저장된 객체를 리턴
    - isEmpty(): 컬렉션이 비어 있는지 조사
    - int size(): 저장되어 있는 전체 객체 수 리턴
    - ======
    - void clear(): 저장된 모든 객체를 삭제
    - E remove(int index): 주어진 인덱스에 저장된 객체를 삭제
    - boolean remove(Object o): 주어진 객체를 삭제
- **ArrayList**
    - List 에서 가장 많이 사용하는 컬렉션
    - 객체를 추가하면 내부 배열에 객체가 저장
    - 일반 배열과 차이점은 제한없이 객체를 추가 할 수 있다.
    - 객체 자체를 저장하는 것이 아닌 객체의 번지 저장
    - 동일 객체를 중복 저장 가능 (동일 번지)
    - null 도 저장 가능
    - `List<E> list = new ArryaList<>();`
    - 타입 파라미터 E에 저장하고 싶은 객체 타입 지정
    - 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList 대신 LinkedList를 사용하는 것이 좋다.
- **Vector**
    - Vector는 ArrayList와 동일한 내부구조를 가진다.
    - Vector는 동기화(synchronized)된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Vector() 메소드를 실행할 수 없다.
    - 멀티 스레드 환경에서 안전하게 객체 추가, 삭제 가능
    - `List<E> list = new Vector<>();`
    - E에는 Vector 에 저장하고 싶은 타입 지정
- **LinkedList**
    - ArrayList와 사용 방법은 동일하지만 내부 구조는 완전히 다르다.
    - LinkedList 는 인접 객체를 체인처럼 연결해서 관리한다.
    - 특정 위치에서 객체를 삽입하거나 삭제하면 바로 앞뒤 링크만 변경하면 되므로 빈번한 삭제, 삽입이 일어나는 곳에서 ArrayList 보다 좋은 성능을 발휘
    - `List<E> list = new LinkedList<>();`

### 15.3 Set 컬렉션

- Set 은 저장 순서가 유지되지 않는다.
- 객체 중복 저장할 수 없다.
- 하나의 null 만 저장할 수 있다.
- Set 인터페이스 메소드
    - boolean add(E e): 주어진 객체를 성공적으로 저장 true, 중복객체 false
    - ===
    - boolean contains(Object o): 주어진 객체가 저장되어 있는지 여부
    - isEmpty(): 컬렉션이 비어있는지 조사
    - Iterator\<E\> iterator(): 저장된 객체를 한 번씩 가져오는 반복자 리턴
    - int size(): 저장되어 있는 전체 객체 수 리턴
    - ===
    - void clear(): 저장된 모든 객체를 삭제
    - boolean remove(Object o): 주어진 객체를 삭제
- **HashSet**
    - 가장 많이 사용되는 Set
    - `Set<E> Set = new HashSet<>();`
    - E에 저장하고 싶은 객체 타입 지정
    - HashSet은 다른 객체라도 hashCode(), equals() 메소드가 true를 리턴하면 동일한 객체라고 판단하고 중복 저장 하지 않음
    - Set 반복
        - `for(E e: set) {} ...`
        - `Iterator<E> iterator = set.iterator();`
            - `while(iterator.hasNext()) { E e = iterator.next();}`

### 15.4 Map 컬렉션

- Map 은 key와 value 로 구성된 엔트리 Entry 객체를 저장한다.
- 키는 중복 저장이 안되지만 값은 중복 저장할 수 있다.
- 기존의 키와 동일한 키로 값을 저장하면 새로 대치된다.
- Map 인터페이스 메소드
    - V put(K key, V value): 주어진 키와 값을 추가, 저장되면 값을 리턴
    - ===
    - boolean containsKey(Object key): 주어진 키가 있는지 여부
    - boolean containsValue(Object value): 주어진 값이 있는지 여부
    - Set\<Map.Entry\<K,V\>\> entrySet(): 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴
    - V get(Object key): 주어진 키의 값을 리턴
    - boolean isEmpty(): 컬렉션이 비어있는지 여부
    - Set\<K\> keySet(): 모든 키를 Set 객체에 담아서 리턴
    - int size(): 저장된 키의 총 수를 리턴
    - Collection\<V\> values(): 저장된 모든 값 Collection에 담아서 리턴
    - ===
    - void clear(): 모든 Map.Entry 를 삭제
    - V remove(Object key): 주어진 키와 일치하는 Map.Entry 삭제, 삭제가 되면 값을 리턴
- 타입 파라미터 K는 Key, V는 Value 를 의미
- **HashMap**
    - HashMap 은 키의 hashCode()가 같고, equals() 메소드가 true를 리턴하면 동일 키로 보고 중복 저장 허용하지 않음
- **HashTable**
    - HashTable 은 동기화(synchronized)된 메소드로 구성되어 있어, 멀티 스레드가 동시에 HashTable의 메소드를 실행할 수 없다.
    - 멀티 스레드 환경에서 사용 가능
- **Properties**
    - HashTable 의 자식 클래스로 HashTable 의 특징을 그대로 가지고 있다.
    - Properties 는 키와 값을 String 타입으로 제한한 컬렉션
    - 주로 .properties 인 프로퍼티 파일을 읽을 때 사용한다.

### 15.5 검색 기능을 강화시킨 컬렉션

- 검색 기능을 강화 시킨 TreeSet 과 TreeMap
- **TreeSet**
    - 이진 트리를 기반으로 한 Set 컬렉션
    - 이진 트리는 여러 개의 노드가 트리 형태로 연결된 구조, 루트 노드라고 불리는 하나의 노드에서 시작해 각 노드에 최대 2개의 노드를 연결할 수 있는 구조
    - TreeSet에 저장되면 자동 정렬된다.
    - TreeSet 검색 관련 메소드
        - E first(): 제일 낮은 객체를 리턴
        - E last(): 제일 높은 객체를 리턴
        - E lower(E e): 주어진 객체보다 바로 아래 객체를 리턴
        - E higher(E e): 주어진 객체보다 바로 위 객체를 리턴
        - E floor(E e): 주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체보다 바로 아래의 객체를 리턴
        - E ceiling(E e): 어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체보다 바로 위의 객체를 리턴
        - E pollFirst(): 제일 낮은 객체를 꺼내오고 컬렉션에서 제거함
        - E pollLast(): 제일 높은 객체를 꺼내오고 컬렉션에서 제거
        - Iterator\<E\> descendingIterator(): 내림 차순으로 정렬된 Iterator를 리턴
        - NavigableSet\<E\> descendingSet(): 내림차순으로 정렬된 NavigableSet을 리턴
        - NavigableSet\<E\> headSet(E toElement, boolean inclusive): 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두
          번째 매개값에 따라 달라짐
        - NavigableSet\<E\> tailSet(E toElement, boolean inclusive): 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두
          번째 매개값에 따라 달라짐
        - NavigableSet\<E\> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive): 시작과 끝으로 주어진
          객체 사이의 객체들을 NavigableSet 으로 리턴, 시작과 끝 객체의 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐
- **TreeMap**
    - 이진 트리를 기반으로 한 Map 컬렉션
    - 키와 값이 저장된 Entry를 저장
    - TreeMap 에 엔트리를 저장하면 키를 기준으로 자동 정렬되고, 부모 키 값과 비교해서 낮은 것은 왼쪽, 높은 것은 오른쪽 자식 노드에 Entry 객체를 저장
    - TreeMap 검색 관련 메소드
        - Map.Entry\<K,V\> firstEntry(): 제일 낮은 Map.Entry 를 리턴
        - Map.Entry\<K,V\> lastEntry(): 제일 높은 Map.Entry 를 리턴
        - Map.Entry\<K,V\> lowerEntry(K key): 주어진 키보다 바로 아래 Map.Entry 를 리턴
        - Map.Entry\<K,V\> higherEntry(K key): 주어진 키보다 바로 위 Map.Entry 를 리턴
        - Map.Entry\<K,V\> floorEntry(K key): 주어진 객체와 동등한 키가 있으면 해당 Map.Entry 리턴, 만약 없다면 주어진 키 바로 아래의 Map.Entry 를 리턴
        - Map.Entry\<K,V\> ceilingEntry(K key): 어진 객체와 동등한 키가 있으면 해당 Map.Entry 리턴, 만약 없다면 주어진 키 바로 위의 Map.Entry 를 리턴
        - Map.Entry\<K,V\> pollFirstEntry(): 제일 낮은 Map.Entry 를 꺼내오고 컬렉션에서 제거함
        - Map.Entry\<K,V\> pollLastEntry(): 제일 높은 Map.Entry 를 꺼내오고 컬렉션에서 제거
        - NavigableSet\<K\> descendingKeySet(): 내림 차순으로 정렬된 Map.Entry의 NavigableMap 을 리턴
        - NavigableMap\<K,V\> descendingMap(): 내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴
        - NavigableMap\<K,V\> headMap(E toKey, boolean inclusive): 주어진 키보다 낮은 Map.Entry 들을 NavigableMap으로 리턴, 주어진 키의
          Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐
        - NavigableMap\<K,V\> tailMap(E toKey, boolean inclusive): 주어진 키보다 높은 Map.Entry 들을 NavigableMap으로 리턴, 주어진 키의
          Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐
        - NavigableMap\<K,V\> subMap(E fromKey, boolean fromInclusive, E toKey, boolean toInclusive): 시작과 끝으로 주어진
          키 사이의 Map.Entry 들을 NavigableMap 컬렉션으로 반환, 시작과 끝 키의 Map.Entry 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐
- **Comparable과 Comparator**
    - TreeSet 에 저장되는 객체와 TreeMap 에 저장되는 키 객체는 저장과 동시에 오름차순으로 정렬되는데, Comparable 인터페이스를 구현하고 있어야 가능하다.
    - 사용자 정의 객체를 저장할 때는 반드시 Comparable 을 구현하고 있어야한다.
    - Comparable 인터페이스에는 compareTo() 메소드가 정의되어 있다.
        - int compareTo(T o): 주어진 객체와 같으면 0, 적으면 음수, 크면 양수
    - 비교 기능이 없는 Comparable 비구현 객체를 저장하고 싶다면 비교자 (Comparator) 를 같이 제공하면된다.
    - Comparator 인터페이스
        - int compare(T o1, T o2): o1, o2 가 동등하면 0, o1 이 앞에 오려면 음수, o1이 뒤게 오게하려면 양수

### 15.6 LIFO와 FIFO 컬렉션

- 후입선출 (LIFO: Last In First Out) 은 나중에 넣은 객체가 먼저 빠져나감
- 선입선출 (FIFO: First In First Out) 은 먼저 넣은 객체가 먼저 빠져나감
- 스택(Stack) 과 큐(Queue) 자료구조가 있다.
- JVM 스택 메모리
- **Stack**
    - LIFO 자료구조
    - `Stack<E> stack = new Stack();`
    - 주요 메소드
        - E push(E item): 주어진 객체를 스택에 넣는다.
        - E pop(): 스택의 맨 위 객체를 빼낸다.
- **Queue**
    - FIFO 자료구조
    - 주요 메소드
        - boolean offer(E e): 주어진 객체를 큐에 넣는다.
        - E poll(): 큐에서 객체를 빼낸다.
        - Queue 인터페이스를 구현한 대표적 클래스는 LinkedList
        - `Queue<E> queue = new LinkedList<>();`

### 15.7 동기화된 컬렉션

- 컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다.
- Vector와 HashTable 은 동기화된 메소드로 구성되어 있어 멀티 스레드 환경에서 안전하게 처리 가능
- ArrayList, HashSet, HashMap 은 동기화된 메소드로 구성되지 않아 멀티 스레드에서 안전하지 않다.
- 컬렉션 프레임워크는 비동기화된 메소드를 동기화된 메소드로 래핑하는 Collections 의 synchronizedXXX() 메소드를 제공
    - List\<T\> synchronizedList(List\<T\> list): List를 동기화된 List로 리턴
    - Map\<K,V\> synchronizedMap(Map\<K,V\> m): Map을 동기화된 Map으로 리턴
    - Set\<T\> synchronizedSet(Set\<T\> s): Set을 동기화된 Set으로 리턴
    - `List<T> list = Collections.syncronizedList(new ArrayList<T>());` <- 스레드 안전

### 15.8 수정할 수 없는 컬렉션

- 수정할 수 없는(unmodifiable) 컬렉션이란 요소를 추가, 삭제할 수 없는 컬렉션
- 컬렉션 생성 시 저장된 요소를 변경하고 싶지 않을 때 유용
- 생성 방법
    - 1 of
        - `List<E> immutableList = List.of(E... elements);`
        - `Set<E> immutableSet = Set.of(E... elements);`
        - `Map<K, V> immutableMap = Map.of(K k1, V v1, K k2, V v2, ...);`
    - 2 copyOf
        - `List<E> immutableList = List.copyOf(Collection<E> coll);`
        - `Set<E> immutableSet = Set.copyOf(Collection<E> coll);`
        - `Map<K, V> immutableMap = Map.copyOf(Map<K,V> map);`
    - 3 배열
        - `String[] arr = {"A", "B", "C"};`
        - `List<String> immutableList = Arrays.asList(arr);`
