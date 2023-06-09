## 💻 Calculator-Project
 - 안드로이드 계산기 프로젝트

## ⌚ Project execution period
  - 2023.05.23 ~ 2023.06.01

## 🛠 Development Environment
  - Tool : `Android Studio`
  - device : `Pixel 2 API 30`

## 📃 Main Composition

- 기본적인 기능
  
  - 숫자, 사칙연산, =, backspace 기능
   
<br>

- MainActivity 구성

| 메서드 | 내용 |
| ------ | --------- |
| onClick() | 클릭한 버튼 종류 버튼 (사칙 연산 / 숫자) |
| appendResult() | 클린한 버튼의 값 textView에 추가 |
| calculateResult() | = 버튼을 클릭했을 때 결과값 textView에 보여짐, ExpressionBuilder로 구현 |
| isWholeNumber() | Double / Long 중 결과값을 무엇으로 출력해야하는지 확인하는 메서드 |
| backspace() | 뒤로 가기 기능, substring() 사용 |

## 🎞 계산기 프로젝트

https://github.com/MsEmily1020/Calculator-Project/assets/121646949/256f11de-5d48-4f3e-a3ec-e856d444ef79


