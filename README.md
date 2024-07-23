# 은행 계좌 관리 시스템

Java로 작성된 간단한 은행 계좌 관리 시스템입니다. 사용자는 계좌를 생성하고, 입금, 출금, 잔액 조회 등의 기본적인 은행 업무를 수행할 수 있습니다.

## 주요 기능

- 새 계좌 생성
- 계좌 선택 및 관리
- 입금 및 출금
- 잔액 조회
- 계좌 정보 표시
- 비밀번호 인증
- 파일 기반 계좌 정보 저장 및 로드

## 기술 스택

- **언어**
  img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
- **개발 환경**: 
  - JDK (Java Development Kit)
  - IDE (예: Eclipse, IntelliJ IDEA, 또는 사용한 IDE)
- **버전 관리**: Git
- **데이터 저장**: 파일 시스템 (텍스트 파일 기반)
- **사용자 인터페이스**: 콘솔 기반 CLI (Command Line Interface)
- **주요 Java 기능**:
  - 객체 지향 프로그래밍 (OOP)
  - 컬렉션 프레임워크 (HashMap)
  - 파일 입출력 (I/O)
  - 예외 처리
- **기타**: 
  - ANSI 이스케이프 코드 (콘솔 색상 출력)

## 사용 방법

1. 프로젝트를 컴파일합니다.
2. `AccountManager` 클래스의 `main` 메소드를 실행합니다.
3. 콘솔 메뉴를 통해 원하는 작업을 선택합니다:
   - 새 계좌 만들기
   - 기존 계좌 선택 및 관리
   - 프로그램 종료

## 디렉토리 구조
<img src="https://github.com/user-attachments/assets/346507d9-074b-49e1-889e-87b6fdf68749" width="400" alt="화면 캡처 2024-07-23 172746">


## 클래스 설명

- `Account.java`: 계좌 정보와 관련 메소드를 포함하는 클래스
- `AccountManager.java`: 메인 프로그램 로직과 사용자 인터페이스를 관리하는 클래스
- `ConsoleColors.java`: 콘솔 출력 스타일링을 위한 ANSI 색상 코드를 정의하는 클래스
