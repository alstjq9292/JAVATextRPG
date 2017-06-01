package semiproject;

import java.util.*;

public class Character {
	// ü�� ���� ���ݷ� ���� ����ġ ��ų � ���� ������ �־����
	int hp;
	int maxHp;
	int mp;
	int maxMp;
	int damage; // ���ݷ�
	int lv; // ����
	int exp; // ���� ���� ����ġ
	int needExp; // �ʿ� ����ġ
	// ���

	// ������
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

	// �⺻���� �� ������ �޼ҵ�
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
		maxHp += 50; // ������ �� 50����(���� ���س���)
		hp = maxHp; // �������ϸ� hp �ִ�� �ʱ�ȭ
		maxMp += 50;
		mp = maxMp;
	}

	public int getDamage() {
		return damage;
	}

	public void SetDamage(int damage) {
		this.damage = damage;
	}

	// ���� �޼ҵ� ���� ���ݷ� ������ �Ű������� �־ ���� hp�� ��� �޼ҵ�

	public int attack() {
		Random critical = new Random(); // ũ��Ƽ�� �ý����� ������ Ȯ���� 30%����?�� �����ؼ�
		// ���ֺ��̰�
		int tempDamage = 0;
		int cd = 0;

		cd = critical.nextInt(100);
		if (cd < 30) {
			System.out.println("ũ��Ƽ��!!!");
			System.out.println("ũ��Ƽ��!!!");
			System.out.println("ũ��Ƽ��!!!");
			tempDamage += (this.damage * 2);
		} else {
			tempDamage = this.damage;
		}

		return tempDamage;
	}

	Monster orc = new Monster("��ũ", 100, 100, 40);// �׸��� ������ �ϸ� Monster�� attack
													// �޼��尡 ����ǰ�
	Monster ogre = new Monster("�����", 900, 400, 100);
	Monster goblin = new Monster("���", 60, 20, 20);
	Monster golem = new Monster("��", 600, 300, 50);
	Monster ruin = new Monster("����ȥ", 10000, 600, 300);

	// number�� ���� ������ ��ų�� ���� ��� switch�� or if��
	public int skill(int number) {
		// ��ų�� ����� �Ŀ��� Monster�� attack �޼��带 ����
		// ��ų�� ���͸� ��Ƶ� ����ġ�� ��� �޼ҵ�(killMonster) ����

		int sd = 0;
		Random skilldamage = new Random();
		String skillname;
		switch (number) {
		case 1:
			skillname = "���̾Ʈ";
			System.out.println(skillname + "��ų�� ����Ͽ����ϴ�.");
			this.mp -= 20;
			System.out.println(20 + "���� �Һ�");
			sd = skilldamage.nextInt(10) + 100;
			System.out.println(sd + "�� �������� �־����ϴ�.");

			break;
		case 2:
			skillname = "���̽���Ʈ";
			System.out.println(skillname + "��ų�� ����Ͽ����ϴ�.");
			this.mp -= 30;
			System.out.println(30 + "���� �Һ�");
			sd = skilldamage.nextInt(20) + 150;
			System.out.println(sd + "�� �������� �־����ϴ�.");

			break;
		case 3:
			skillname = "��������Ʈ";
			System.out.println(skillname + "��ų�� ����Ͽ����ϴ�.");
			this.mp -= 40;
			System.out.println(40 + "���� �Һ�");
			sd = skilldamage.nextInt(30) + 200;
			System.out.println(sd + "�� �������� �־����ϴ�.");

			break;
		}
		return sd;
	}

	public int killMonster(String name) {

		return exp;
	}
	// ���� óġ �� ĳ������ ����ġ�� ������Ű�� �޼ҵ� // name���� ���� �̸��� ���� ó��

}
