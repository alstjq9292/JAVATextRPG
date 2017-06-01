package semiproject;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Interface {
	/*
	 * 캐릭터, 몬스터, 맵 등을 종합해서 숫자를 입력받아 처리하는 클래스
	 */

	// 임시로 만든 객체들
	Character ch = new Character(1500, 1500, 1, 100, 80); // 캐릭터 초기값으로 생성 체력 /
	// 마력/ 레벨 / 필요경험치 /
	// 공격력
	Monster orc = new Monster("오크", 100, 100, 40); // 이름/ 체력/ 데미지/ 경험치
	Monster ogre = new Monster("오우거", 900, 400, 100);
	Monster goblin = new Monster("고블린", 60, 20, 20);
	Monster golem = new Monster("골렘", 600, 300, 50);
	Monster ruin = new Monster("루인혼", 10000, 600, 300); // 레이드 몬스터
	Monster tempMon = new Monster("템프", 0, 0, 0);
	HashMap<String, String[]> hm = new HashMap<String, String[]>();
	Map map = new Map();
	Scanner inObj = new Scanner(System.in);

	int mapNum = 0;
	// 생성자 여기서 첫 시작 이 생성자를 메인에서 실행하면서 게임이 시작된다.

	public Interface() {
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("☆★               게임을 시작합니다                ☆★");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		hm.putAll(map.hm);
		firstPage();
	}

	//
	public void firstPage() {
		System.out.print("| 1.맵선택  | 2.캐릭터정보  | 3.게임종료  :: ");
		int select = inObj.nextInt();

		switch (select) {
		case 1:
			selectMap();
			break;

		case 2:
			characterInfo();
			break;

		case 3:
			exit();
			break;
		}
	}

	// 맵선택 메소드 -> 맵을 나열해서 숫자를 입력받아서 몬스터 발견 페이지로 넘어가게
	public void selectMap() {
		System.out.println("맵을 선택합니다.");
		System.out.print("1.초원(오크, 오우거) || 2.정글(고블린, 골렘) || 3.루인혼의 동굴  ::");
		int select = inObj.nextInt();
		mapNum = select;

		Random random = new Random();
		int ran = random.nextInt(2);

		switch (select) {
		case 1: // 여기서 맵에따른 랜덤 값 0~1 해서 해쉬맵 hm 키값 벨류값 얻어오기
			// 1번맵 메소드
			String monArray[] = hm.get("map1");
			if (monArray[ran] == "오크") {
				tempMon = orc;
			} else if (monArray[ran] == "오우거") {
				tempMon = ogre;
			}
			attackPage(mapNum);
			break;

		case 2:
			// 2번맵 메소드
			String monArray2[] = hm.get("map2");
			if (monArray2[ran] == "고블린") {
				tempMon = goblin;
			} else if (monArray2[ran] == "골렘") {
				tempMon = golem;
			}
			attackPage(mapNum);
			break;

		case 3:
			// 3번맵 메소드
			tempMon = ruin;
			attackPage(mapNum);
			break;
		}
	}

	// 캐릭터 정보 확인 메소드
	public void characterInfo() {
		// 캐릭터 클래스에서 정보 출력
		System.out.println("캐릭터 정보창");
		System.out.println("레벨 : " + ch.getLv());
		System.out.println("경험치 : (" + ch.getExp() + "/" + ch.needExp + ")");
		System.out.println("체력 : " + ch.getHp());
		System.out.println("마력 : " + ch.getMp());
		System.out.println("공격력 : " + ch.getDamage());

		firstPage();

	}

	// 게임 종료 메소드
	public void exit() {
		// 게임을 종료하시겠습니까?
		System.out.println("게임을 종료하시겠습니까?(Y/N)");
		String select = inObj.next();

		switch (select) {
		case "Y":
			// y == 종료
			System.exit(0);

		case "N":
			// n == 다시 맵선택 정보확인 창으로 돌아가기
			firstPage();
		}

	}

	// 몬스터와 만났을 때 1 기본공격 2 스킬공격 3 체력회복 4 마력회복
	public void attackPage(int mapNum) {
		// System.out.println("몬스터 " + 맵에따른 랜덤 몬스터 + "(을)를 발견했다!!");

		System.out.println("몬스터와 전투중..!! 몬스터 이름 : " + tempMon.name);

		System.out.println("1.기본공격  | 2.스킬공격  | 3.체력회복  | 4.마력회복  :: ");
		int select = inObj.nextInt();

		switch (select) {
		case 1:
			// 기본공격 -> 캐릭터의 데미지만큼 몬스터의 체력을 깎는다.
			tempMon.hp -= ch.attack();
			System.out.println(ch.attack() + "만큼 공격!");

			if (tempMon.hp <= 0) {
				System.out.println("몬스터를 처치!!");
				ch.exp += killMonster(tempMon.name); // 몬스터 이름 배열로 받아오기
				if (ch.exp >= ch.needExp) {
					ch.levelUp();
				}
				firstPage();
			}

			break;

		case 2:
			// 스킬공격
			
			System.out.println("1.파이어볼트 | 2.아이스볼트 | 3.에너지볼트");
			int select2 = inObj.nextInt();
				if(select2 == 1){
					tempMon.hp -= ch.skill(1);
				}else if(select2 == 2){
					tempMon.hp -= ch.skill(2);
				}else{
					tempMon.hp -= ch.skill(3);
				}if (tempMon.hp <= 0) {
					System.out.println("몬스터를 처치!!");
					ch.exp += killMonster(tempMon.name); // 몬스터 이름 배열로 받아오기
					if (ch.exp >= ch.needExp) {
						ch.levelUp();
					}
					firstPage();
				}

			break;

		case 3:
			System.out.println("체력을 150회복합니다.");
			ch.hp += 150;
			if (ch.getHp() > ch.maxHp) {
				ch.setHp(ch.maxHp);
			}
			break;

		case 4:
			System.out.println("마력을 100 회복합니다.");
			ch.mp += 100;
			if (ch.getMp() > ch.maxMp) {
				ch.setMp(ch.maxMp);
			}
			break;

		}

		monsterPage();

	}

	public void status() {
		System.out.println("====현재 상태====");
		System.out.println("나의 체력 : (" + ch.getHp() + "/ " + ch.maxHp + ")");
		System.out.println("나의 마력 : (" + ch.getMp() + "/ " + ch.maxMp + ")");
		System.out.println("몬스터의 체력 : (" + tempMon.hp + "/ " + tempMon.maxHp + ")");

	}

	// 현재 몬스터가 무엇인지 판단하고 캐릭터에게 데메지를 주는 메소드
	public void monsterPage() {
		String monName = tempMon.name;

		switch (monName) {
		case "오크":
			int mdorc = tempMon.attack(orc);
			System.out.println("오크의 공격!! 체력이 " + mdorc + "감소하였습니다.");
			ch.hp -= mdorc;
			if (ch.hp <= 0) {
				System.out.println("캐릭터가 사망하였습니다. 게임을 종료합니다.");
				System.exit(0);
			}
			break;

		case "오우거":
			int mdogre = tempMon.attack(ogre);;
			System.out.println("오우거의 공격!! 체력이 " + mdogre + "감소하였습니다.");
			ch.hp -= mdogre;
			if (ch.hp <= 0) {
				System.out.println("캐릭터가 사망하였습니다. 게임을 종료합니다.");
				System.exit(0);
			}
			break;

		case "골렘":
			int mdgolem = tempMon.attack(golem);
			System.out.println("골렘의 공격!! 체력이 " + mdgolem + "감소하였습니다.");
			ch.hp -= mdgolem;
			if (ch.hp <= 0) {
				System.out.println("캐릭터가 사망하였습니다. 게임을 종료합니다.");
				System.exit(0);
			}
			break;

		case "고블린":
			int mdgoblin = tempMon.attack(goblin);
			System.out.println("고블린의 공격!! 체력이 " + mdgoblin + "감소하였습니다.");
			ch.hp -= mdgoblin;
			if (ch.hp <= 0) {
				System.out.println("캐릭터가 사망하였습니다. 게임을 종료합니다.");
				System.exit(0);
			}
			break;

		case "루인혼":
			int md = tempMon.attack(ruin);
			System.out.println("루인혼의 공격!! 체력이 " + md + "감소하였습니다.");
			ch.hp -= md;
			if (ch.hp <= 0) {
				System.out.println("캐릭터가 사망하였습니다. 게임을 종료합니다.");
				System.exit(0);
			}
			break;
		}
		status();
		attackPage(mapNum);
	}

	// 몬스터 처치 시 캐릭터의 경험치를 증가시키는 메소드 // name으로 몬스터 이름에 따른 처리
	public int killMonster(String name) {
		int tempExp = 0;
		switch (name) {
		case "오크":
			orc.setHp(orc.maxHp);
			tempExp = orc.exp;
			break;

		case "오우거":
			ogre.setHp(ogre.maxHp);
			tempExp = ogre.exp;
			break;

		case "고블린":
			goblin.setHp(goblin.maxHp);
			tempExp = goblin.exp;
			break;

		case "골렘":
			golem.setHp(golem.maxHp);
			tempExp = golem.exp;
			break;

		case "루인혼":
			ruin.setHp(ruin.maxHp);
			tempExp = ruin.exp;
			break;
		}
		return tempExp;

	}

	// 나머지 들어갈게 있는지 확인

	public static void main(String[] args) {

	}

}