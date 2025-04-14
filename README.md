### IntelliJ 단축키 기록

- command + shift + t : 테스트 파일 생성
- command + n : 생성자, getter, setter 등 생성
- command + ; : 프로젝트 structure 설정 (자바 버전 등)
- alt(option) + enter : 에러 해결 방법 제시
- command + shift + enter : 코드 자동 완성
    - `sout`, `soutv` 등 : 출력문 빠른생성

### lombok 설정법

- build.gradle 에 설정 및 라이브러리 추가 하기
- settings 에서 annotation processors 제일 위에 Enable로 체크 해주기
- @Getter @Setter @ToString @RequiredArgsConstructor 등 사용 가능
- 컴파일 시 코드가 자동생성되는 원리로 코드 작성을 깔끔하고 편리하게 가능

### 커스텀 어노테이션?

- `@Primary` 대신에 `@Qualifier`를 사용한다면, 커스텀 어노테이션을 적용하는 것도 방법이다.

### 웹 어플리캐이션을 만들 때

- implementation 'org.springframework.boot:spring-boot-starter-web' 추가
- 내장 Tomcat 서버 사용 가능