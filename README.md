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

## 고민했던 점
1. 유저 생성 시 적용되는 두 가지 기본 테마 처리
  - 모든 유저에게 공통 적용되는 기본 테마 1, 2를 어떻게 처리하면 좋을지?
  => 테마 1, 2 는 최초에 DB insert 로 만들어놓고 유저 생성 시 마다 USERS.THEME_ID 는 1로 설정, 
  THEME 테이블에 USER_ID 와 테마 1,2 연관 row 추가하게 설계하였다.
