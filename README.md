# liner-highlight
## DB 설계
![liner-highligt-DBschema](https://user-images.githubusercontent.com/24771844/210320522-525ec013-eafb-4d4b-96e0-c6ef3ebc27fc.png)
- USERS : THEME = 1 : N  (유저는 여러 테마를 가질 수 있다.)
- USERS 는 THEME_ID 컬럼을 가지며 유저가 가지는 여러 테마 중에 현재 사용중인 테마를 저장한다.
- THEME : COLOR = N : M (테마는 여러가지 색을 가지며 하나의 색은 여러 테마에 속할 수 있다.)
- THEME_COLOR 는 THEME과 COLOR 를 두 개의 1 : N 관계로 만들기 위한 중간 테이블이다. SEQUENCE 라는 테마 내 색의 순서 컬럼을 가진다.
- WEBPAGE : HIGHLIGHT = 1 : N (하나의 페이지에 여러 개의 하이라이트를 할 수 있다.)
- THEME_COLOR : HIGHLIGHT = 1 : N (유저의 테마 변경 시 하이라이트의 색을 변경하기 쉽게 HIGHLIGHT 에 THEME_COLOR_ID 를 포함하였다.)

## 사용 기술
Java 11 / Spring Boot / Spring Data JPA / Querydsl

## DB 설계 시 고민했던 점
1. 유저 생성 시 적용되는 두 가지 기본 테마 처리
  - 모든 유저에게 공통 적용되는 기본 테마 1, 2를 어떻게 처리하면 좋을지?
  => 테마 1, 2 는 최초에 DB insert 로 만들어놓고 유저 생성 시 마다 USERS.THEME_ID 는 1로 설정, 
  THEME 테이블에 USER_ID 와 테마 1,2 연관 row 추가하게 설계하였다.
2. 몇 만개씩 하이라이트한 유저가 테마를 변경했을 때
  - HIGHLIGHT 테이블이 단순히 색 정보를 가지고 있다면 위와 같은 경우 업데이트를 하는데 문제가 발생할 것으로 예상했다. 그래서 HIGHLIGHT 에는 테마, 색, 색의 순서 정보를 알고 있는 THEME_COLOR_ID 를 포함하여 업데이트를 좀 더 효율적으로 하고자 하였다.

## 구현한 것
1. 하이라이트 저장(Create)
2. 하이라이트 수정(Update)
3. 페이지 내 하이라이트 정보 가져오기(Read)

<img width="823" alt="Screenshot 2023-01-03 at 9 16 16 PM" src="https://user-images.githubusercontent.com/24771844/210355703-43b277dc-e783-4e94-b0e1-ff8e3f1d2b3c.png">


## 구현하지 못한 것
4. 유저가 하이라이트한 정보와 페이지 가져오기(Read)
  - DB 에서 조회할 때 페이지 정렬 (각 페이지 내 하이라이트 중 가장 최근의 업데이트 시간을 사용하여 역순으로 정렬) 까지 완료된 결과를 가져올 수 있는 방법이 있는지 찾아보는데 많은 시간을 소요했지만 결국 찾지 못했다. 그 후 Java stream 의 groupingBy collector 를 활용한 방법을 찾아 구현중이나 마감시간 전까지 완료하지 못했다.
5. 하이라이트 삭제(Delete)
6. 유저의 하이라이트 테마 변경(Update)
7. 유저의 하이라이트 테마 생성(Upsert)
  - 테마 변경과 생성에 대한 고민 때문에 DB 설계 과정에서 오랜 시간이 걸렸다. 아쉽게도 기한내에 구현하지 못했지만 계속 완성해 나갈 예정이다.
8. 유저의 하이라이트 테마 삭제(Delete)

## 아쉬운 점
어떻게 하면 효율적으로 DB를 설계할까를 너무 오래 고민했다. 테마가 별거 아닌거 같았는데 설계를 하면서 여러 번 수정할 정도로 많은 고민을 했다. 결과적으로 기능 구현에 쓸 시간을 너무 허비해 대부분의 구현을 완료하지 못하였다. 마감기한에 맞추어 스케쥴을 좀 더 잘 관리해야 하겠다.
이 과제 덕분에 오래간만에 자바로 코딩에 집중하는 시간을 가졌다. 유익한 시간이었다. 비록 마감기한까지 대부분의 기능 구현을 완료하지 못했지만 계속 이어서 구현해 나갈 예정이다.
