# Project Version

Framework : SpringBoot -version '2.7.4'<br>
Source Compatibility : java -version '11'<br>
Annotation Processor : 'lombok'<br>
Test Framework : JUnit<br>
<br>

# Project Progression

10.7) 카카오톡 로그인 서비스 구현 시작<br>
      - OAuth2.0, JWT를 통한 로그인서비스 구현 - <br>
      OAuth2.0과 JWT에 대한 개념과 아키텍처 레퍼런스(References)<br> 
      1. https://velog.io/@max9106/OAuth<br> 
      2. https://mangkyu.tistory.com/56<br>
      <br> 
      - 카카오톡 로그인 API Docks - <br>
      1. https://developers.kakao.com/docs/latest/ko/kakaologin/common#intro-kakaologin<br>
      2. https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api<br>
      <br>
      - 로그인 서비스 아키텍처 및 흐름도- <br>
      ![KaKao Login Architecture](https://user-images.githubusercontent.com/71485411/194915042-f3b97ff7-793c-4570-b2df-7ccb86cb1197.jpeg)<br>
      <br>
      # * 프론트엔드 역할<br>
        - Kakao OAuth 서버로 로그인 요청 후, Authorization code 발급 받아, 백엔드에 전달<br>
        - 백엔드에서 응답 받은 access token, refresh token 저장해두기<br>
        - 권한이 필요한 요청마다 Authorization 헤더에 access token 같이 보내주기<br>
        - access token이 만료되었다면, refresh token 보내서 갱신하기(프론트에서 요청 날릴 때 access token이 만료됨을 미리 판별하여 갱신 요청을 보낼 수 있음)<br>
        - refresh token 만료 기간이 7일 이내면, refresh token 재발급 요청<br>
      <br>
      # * 백엔드 역할<br>
        - Authorization code로 Kakao OAuth 서버에 토큰 요청<br>
          (로그인 할 때 이외에 OAuth 서버와 통신이 필요한 경우 발급 받은 토큰 저장을 청량서버에 저장)<br>
        - Access token으로 이름, 이메일, 프로필 URL 정보 요청<br>
        - DB에 존재하지 않는 유저라면, 새로 등록. DB에 존재하는 유저라면 정보 업데이트<br>
        - 유저의 Primary Key 값으로 JWT 토큰(access token & refresh token)생성. 일반적으로 access token은 한 시간, refresh token은 대략 2주로 생성<br>
        - refresh token은 DB에 저장<br>
        - 유저 정보, access token, refresh token 프론트로 전달<br>
        - access token 만료시 refresh token 검증 후, 재발급<br>

