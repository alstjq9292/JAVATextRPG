package semiproject;

import java.util.*;

public class Character {
	// 체력 마나 공격력 레벨 경험치 스킬 등에 대한 정보를 넣어야함
	int hp;
	int maxHp;
	int mp;
	int maxMp;
	int damage; // 공격력
	int lv; // 레벨
	int exp; // 현재 보유 경험치
	int needExp; // 필요 경험치
	// 등등

	// 생성자
	public Character(int maxHp, int maxMp, int lv, int needExp, int damage) {
		this.hp = maxHp;
		this.mp = maxMp;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.lv = lv;
		this.exp = 0;
		this.needExp = needExp;
		this.damage = damage;

	}

	// 기본적인 값 얻어오는 메소드
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void plusExp(int exp) {
		this.exp += exp;
	}

	public void levelUp() {
		maxHp += 50; // 레벨업 시 50증가(대충 정해놓음)
		hp = maxHp; // 레벨업하면 hp 최대로 초기화
		maxMp += 50;
		mp = maxMp;
	}

	public int getDamage() {
		return damage;
	}

	public void SetDamage(int damage) {
		this.damage = damage;
	}

	// 공격 메소드 현재 공격력 정보를 매개변수에 넣어서 몬스터 hp를 깎는 메소드

	public int attack() {
		Random critical = new Random(); // 크리티컬 시스템이 들어가야함 확률은 30%정도?로 높게해서
		// 자주보이게
		int tempDamage = 0;
		int cd = 0;

		cd = critical.nextInt(100);
		if (cd < 30) {
			System.out.println("크리티컬!!!");
			System.out.println("크리티컬!!!");
			System.out.println("크리티컬!!!");
			tempDamage += (this.damage * 2);
		} else {
			tempDamage = this.damage;
		}

		return tempDamage;
	}

	Monster orc = new Monster("오크", 100, 100, 40);// 그리고 공격을 하면 Monster의 attack
													// 메서드가 실행되게
	Monster ogre = new Monster("오우거", 900, 400, 100);
	Monster goblin = new Monster("고블린", 60, 20, 20);
	Monster golem = new Monster("골렘", 600, 300, 50);
	Monster ruin = new Monster("루인혼", 10000, 600, 300);

	// number에 따른 각각의 스킬을 만들어서 사용 switch문 or if문
	public int skill(int number) {
		// 스킬을 사용한 후에도 Monster의 attack 메서드를 실행
		// 스킬로 몬스터를 잡아도 경험치를 얻는 메소드(killMonster) 실행

		int sd = 0;
		Random skilldamage = new Random();
		String skillname;
		switch (number) {
		case 1:
			skillname = "파이어볼트";
			System.out.println(skillname + "스킬을 사용하였습니다.");
			this.mp -= 20;
			System.out.println(20 + "마나 소비");
			sd = skilldamage.nextInt(10) + 100;
			System.out.println(sd + "의 데미지를 주었습니다.");

			break;
		case 2:
			skillname = "아이스볼트";
			System.out.println(skillname + "스킬을 사용하였습니다.");
			this.mp -= 30;
			System.out.println(30 + "마나 소비");
			sd = skilldamage.nextInt(20) + 150;
			System.out.println(sd + "의 데미지를 주었습니다.");

			break;
		case 3:
			skillname = "에너지볼트";
			System.out.println(skillname + "스킬을 사용하였습니다.");
			this.mp -= 40;
			System.out.println(40 + "마나 소비");
			sd = skilldamage.nextInt(30) + 200;
			System.out.println(sd + "의 데미지를 주었습니다.");

			break;
		}
		return sd;
	}

	public int killMonster(String name) {

		return exp;
	}
	// 몬스터 처치 시 캐릭터의 경험치를 증가시키는 메소드 // name으로 몬스터 이름에 따른 처리

}
