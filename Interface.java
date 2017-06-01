package semiproject;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Interface {
	/*
	 * ĳ����, ����, �� ���� �����ؼ� ���ڸ� �Է¹޾� ó���ϴ� Ŭ����
	 */

	// �ӽ÷� ���� ��ü��
	Character ch = new Character(1500, 1500, 1, 100, 80); // ĳ���� �ʱⰪ���� ���� ü�� /
	// ����/ ���� / �ʿ����ġ /
	// ���ݷ�
	Monster orc = new Monster("��ũ", 100, 100, 40); // �̸�/ ü��/ ������/ ����ġ
	Monster ogre = new Monster("�����", 900, 400, 100);
	Monster goblin = new Monster("���", 60, 20, 20);
	Monster golem = new Monster("��", 600, 300, 50);
	Monster ruin = new Monster("����ȥ", 10000, 600, 300); // ���̵� ����
	Monster tempMon = new Monster("����", 0, 0, 0);
	HashMap<String, String[]> hm = new HashMap<String, String[]>();
	Map map = new Map();
	Scanner inObj = new Scanner(System.in);

	int mapNum = 0;
	// ������ ���⼭ ù ���� �� �����ڸ� ���ο��� �����ϸ鼭 ������ ���۵ȴ�.

	public Interface() {
		System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
		System.out.println("�١�               ������ �����մϴ�                �١�");
		System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
		hm.putAll(map.hm);
		firstPage();
	}

	//
	public void firstPage() {
		System.out.print("| 1.�ʼ���  | 2.ĳ��������  | 3.��������  :: ");
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

	// �ʼ��� �޼ҵ� -> ���� �����ؼ� ���ڸ� �Է¹޾Ƽ� ���� �߰� �������� �Ѿ��
	public void selectMap() {
		System.out.println("���� �����մϴ�.");
		System.out.print("1.�ʿ�(��ũ, �����) || 2.����(���, ��) || 3.����ȥ�� ����  ::");
		int select = inObj.nextInt();
		mapNum = select;

		Random random = new Random();
		int ran = random.nextInt(2);

		switch (select) {
		case 1: // ���⼭ �ʿ����� ���� �� 0~1 �ؼ� �ؽ��� hm Ű�� ������ ������
			// 1���� �޼ҵ�
			String monArray[] = hm.get("map1");
			if (monArray[ran] == "��ũ") {
				tempMon = orc;
			} else if (monArray[ran] == "�����") {
				tempMon = ogre;
			}
			attackPage(mapNum);
			break;

		case 2:
			// 2���� �޼ҵ�
			String monArray2[] = hm.get("map2");
			if (monArray2[ran] == "���") {
				tempMon = goblin;
			} else if (monArray2[ran] == "��") {
				tempMon = golem;
			}
			attackPage(mapNum);
			break;

		case 3:
			// 3���� �޼ҵ�
			tempMon = ruin;
			attackPage(mapNum);
			break;
		}
	}

	// ĳ���� ���� Ȯ�� �޼ҵ�
	public void characterInfo() {
		// ĳ���� Ŭ�������� ���� ���
		System.out.println("ĳ���� ����â");
		System.out.println("���� : " + ch.getLv());
		System.out.println("����ġ : (" + ch.getExp() + "/" + ch.needExp + ")");
		System.out.println("ü�� : " + ch.getHp());
		System.out.println("���� : " + ch.getMp());
		System.out.println("���ݷ� : " + ch.getDamage());

		firstPage();

	}

	// ���� ���� �޼ҵ�
	public void exit() {
		// ������ �����Ͻðڽ��ϱ�?
		System.out.println("������ �����Ͻðڽ��ϱ�?(Y/N)");
		String select = inObj.next();

		switch (select) {
		case "Y":
			// y == ����
			System.exit(0);

		case "N":
			// n == �ٽ� �ʼ��� ����Ȯ�� â���� ���ư���
			firstPage();
		}

	}

	// ���Ϳ� ������ �� 1 �⺻���� 2 ��ų���� 3 ü��ȸ�� 4 ����ȸ��
	public void attackPage(int mapNum) {
		// System.out.println("���� " + �ʿ����� ���� ���� + "(��)�� �߰��ߴ�!!");

		System.out.println("���Ϳ� ������..!! ���� �̸� : " + tempMon.name);

		System.out.println("1.�⺻����  | 2.��ų����  | 3.ü��ȸ��  | 4.����ȸ��  :: ");
		int select = inObj.nextInt();

		switch (select) {
		case 1:
			// �⺻���� -> ĳ������ ��������ŭ ������ ü���� ��´�.
			tempMon.hp -= ch.attack();
			System.out.println(ch.attack() + "��ŭ ����!");

			if (tempMon.hp <= 0) {
				System.out.println("���͸� óġ!!");
				ch.exp += killMonster(tempMon.name); // ���� �̸� �迭�� �޾ƿ���
				if (ch.exp >= ch.needExp) {
					ch.levelUp();
				}
				firstPage();
			}

			break;

		case 2:
			// ��ų����
			
			System.out.println("1.���̾Ʈ | 2.���̽���Ʈ | 3.��������Ʈ");
			int select2 = inObj.nextInt();
				if(select2 == 1){
					tempMon.hp -= ch.skill(1);
				}else if(select2 == 2){
					tempMon.hp -= ch.skill(2);
				}else{
					tempMon.hp -= ch.skill(3);
				}if (tempMon.hp <= 0) {
					System.out.println("���͸� óġ!!");
					ch.exp += killMonster(tempMon.name); // ���� �̸� �迭�� �޾ƿ���
					if (ch.exp >= ch.needExp) {
						ch.levelUp();
					}
					firstPage();
				}

			break;

		case 3:
			System.out.println("ü���� 150ȸ���մϴ�.");
			ch.hp += 150;
			if (ch.getHp() > ch.maxHp) {
				ch.setHp(ch.maxHp);
			}
			break;

		case 4:
			System.out.println("������ 100 ȸ���մϴ�.");
			ch.mp += 100;
			if (ch.getMp() > ch.maxMp) {
				ch.setMp(ch.maxMp);
			}
			break;

		}

		monsterPage();

	}

	public void status() {
		System.out.println("====���� ����====");
		System.out.println("���� ü�� : (" + ch.getHp() + "/ " + ch.maxHp + ")");
		System.out.println("���� ���� : (" + ch.getMp() + "/ " + ch.maxMp + ")");
		System.out.println("������ ü�� : (" + tempMon.hp + "/ " + tempMon.maxHp + ")");

	}

	// ���� ���Ͱ� �������� �Ǵ��ϰ� ĳ���Ϳ��� �������� �ִ� �޼ҵ�
	public void monsterPage() {
		String monName = tempMon.name;

		switch (monName) {
		case "��ũ":
			int mdorc = tempMon.attack(orc);
			System.out.println("��ũ�� ����!! ü���� " + mdorc + "�����Ͽ����ϴ�.");
			ch.hp -= mdorc;
			if (ch.hp <= 0) {
				System.out.println("ĳ���Ͱ� ����Ͽ����ϴ�. ������ �����մϴ�.");
				System.exit(0);
			}
			break;

		case "�����":
			int mdogre = tempMon.attack(ogre);;
			System.out.println("������� ����!! ü���� " + mdogre + "�����Ͽ����ϴ�.");
			ch.hp -= mdogre;
			if (ch.hp <= 0) {
				System.out.println("ĳ���Ͱ� ����Ͽ����ϴ�. ������ �����մϴ�.");
				System.exit(0);
			}
			break;

		case "��":
			int mdgolem = tempMon.attack(golem);
			System.out.println("���� ����!! ü���� " + mdgolem + "�����Ͽ����ϴ�.");
			ch.hp -= mdgolem;
			if (ch.hp <= 0) {
				System.out.println("ĳ���Ͱ� ����Ͽ����ϴ�. ������ �����մϴ�.");
				System.exit(0);
			}
			break;

		case "���":
			int mdgoblin = tempMon.attack(goblin);
			System.out.println("����� ����!! ü���� " + mdgoblin + "�����Ͽ����ϴ�.");
			ch.hp -= mdgoblin;
			if (ch.hp <= 0) {
				System.out.println("ĳ���Ͱ� ����Ͽ����ϴ�. ������ �����մϴ�.");
				System.exit(0);
			}
			break;

		case "����ȥ":
			int md = tempMon.attack(ruin);
			System.out.println("����ȥ�� ����!! ü���� " + md + "�����Ͽ����ϴ�.");
			ch.hp -= md;
			if (ch.hp <= 0) {
				System.out.println("ĳ���Ͱ� ����Ͽ����ϴ�. ������ �����մϴ�.");
				System.exit(0);
			}
			break;
		}
		status();
		attackPage(mapNum);
	}

	// ���� óġ �� ĳ������ ����ġ�� ������Ű�� �޼ҵ� // name���� ���� �̸��� ���� ó��
	public int killMonster(String name) {
		int tempExp = 0;
		switch (name) {
		case "��ũ":
			orc.setHp(orc.maxHp);
			tempExp = orc.exp;
			break;

		case "�����":
			ogre.setHp(ogre.maxHp);
			tempExp = ogre.exp;
			break;

		case "���":
			goblin.setHp(goblin.maxHp);
			tempExp = goblin.exp;
			break;

		case "��":
			golem.setHp(golem.maxHp);
			tempExp = golem.exp;
			break;

		case "����ȥ":
			ruin.setHp(ruin.maxHp);
			tempExp = ruin.exp;
			break;
		}
		return tempExp;

	}

	// ������ ���� �ִ��� Ȯ��

	public static void main(String[] args) {

	}

}