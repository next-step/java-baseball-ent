# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/ent-precourse)

## 기능 요구사항
- 1~9 까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 것
  - 같은 수가 같은 자리 : 스트라이크
  - 같은 수가 다른 자리 : 볼
  - 같은 수 전혀 없으면 : 낫싱

## 구현할 기능 목록
- **Controller**
  - [x] View로 부터 Raw Integer를 넘겨받아 Model에게 전달
  - [x] Model로 부터 CompareResult를 넘겨받아 이를 Dto로 변환해 View에 전달

- **Model**
  - Game
    - [x] 게임에서 사용할 컴퓨터의 랜덤 번호 생성
    - [x] Controller로 부터 전달받은 Raw Integer를 BaseballNumber로 변환
    - [x] 게임 진행 여부를 저장하는 Boolean 있을 것
      - [x] 재시작이 가능해야 함
  - BaseballNumber
    - [x] 서로 다른 번호가 각 자릿수에 할당될 것
    - [x] 예외 처리 - single digit, 중복 방지
    - [x] 사용자가 입력한 번호를 해당 랜덤 번호와 비교할 수 있는 기능
  - RandomBaseballNumberGenerator 
    - [x] 랜덤하게 번호를 생성할 수 있을 것
  - StrikeBallResult
    - [x] 스트라이크와 볼이 총 몇개가 나왔는지를 담을 것

- **View**
  - [x] 숫자를 입력받아 Controller에게 전달
    - [x] 세자리 숫자로 치환 안되면 모두 예외처리할 것
  - [x] 결과 값을 Controller로 부터 넘겨받아 출력
  - [x] 3 스트라이크라면 재시작 옵션 View 출력

## 실행 예시
```
숫자를 입력해주세요 : 123 
1 스트라이크 1볼
숫자를 입력해주세요 : 145 
1볼
숫자를 입력해주세요 : 671 
2볼
숫자를 입력해주세요 : 216 
1 스트라이크
숫자를 입력해주세요 : 713
3 스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 1
숫자를 입력해주세요 : 123
1 스트라이크 1볼
```