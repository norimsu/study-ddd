## 요구 사항

- 간단한 포켓몬 게임을 구현한다.
- 트레이너
  - [ ] 사용자는 트레이너라고 부른다.
  - [ ] 트레이너는 아이디를 등록할 수 있고 등록한 아이디로 로그인할 수 있어야 한다.
  - [ ] 트레이너는 레벨을 가지고 있으며 포켓몬을 잡을 때마다 레벨이 1씩 증가한다.
  - [ ] 레벨은 30까지 증가한다.
  - [ ] 최초 로그인 시 이상해씨, 파이리, 꼬부기 중 한 마리를 선택할 수 있다.
  - [ ] 가지고 있는 포켓몬 목록을 볼 수 있다.
  - [ ] 가지고 있는 아이템 목록을 볼 수 있다.
- 포켓몬
  - [ ] 전국 도감 번호 1번부터 151번까지의 포켓몬이 무작위로 등장한다.
  - [ ] 포켓몬은 고유의 포획률을 가지고 있다.
  - [ ] 트레이너는 가지고 있는 몬스터볼을 소비함으로써 포켓몬을 잡을 수 있다.
  - [ ] 포획률 = (포켓몬의 포획률 * 몬스터볼 보정 승수 * (레벨 11 이상의 트레이너 레벨 / 10)) * 100 / 255
  - [ ] 잡은 포켓몬은 닉네임을 지어 붙일 수 있다.
- 아이템
  - [ ] 몬스터볼은 고유의 보정 승수를 가지고 있다.  
  (몬스터볼: 1.0, 수퍼볼: 1.5, 하이퍼볼: 2.0, 마스터볼: 255)

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 포켓몬 | Pokemon | 몬스터볼에 넣어서 주머니에 간단하게 휴대하고 다닐 수 있는 몬스터 |
| 몬스터몰 | Poke ball | 포켓몬을 포확하고 운반할 때 사용하는 도구 |
| 트레이너 | Trainer | ~ |
| 레벨 | Level | ~ |
| 전국 도감 | National pokedex | ~ |
| 포획율 | Capture reta | ~ |
| 잡은 포켓폼 | Pokemon caught | ~ |
| 보정 승수 | Ball rate | ~ |

## 모델링

- `Trainer`는 아이디와 `Level`를 가진다.
- `Trainer`는 자신의 `Pokemon caught`를 볼 수 있다.
- `Trainer`는 자신의 아이템을 볼 수 있다.
- `Pokemon`은 이름과 `National Pokedex Number`와 `Pokemon Capture rate`를 가진다.
- `National Pokedex Number`는 1부터 151까지 존재한다.
- `Trainer`는 `Monster Ball`을 소비하여 `Capture rate`를 계산한다.
- `Pokemon Capture rate`은 3부터 255까지 존재한다.
- `Capture rate`가 `Pokemon Capture rate`보다 높을 때 `Pokemon caught`이 된다.
- `Pokemon caught`이 되면 `Trainer`의 `Level`이 1 증가한다. (이미 `Level`의 최대치라면 증가하지 않는다.)
- `Poke caught`는 닉네임을 가질 수 있다.
- `Poke Ball`의 종류는 `Monster Ball`, `Super Ball`, `Hyper Ball`, `Master Ball`이 있다.
- `Level`은 1부터 30까지 존재한다.
- `Monster Ball`의 `Ball rate`는 1.0
