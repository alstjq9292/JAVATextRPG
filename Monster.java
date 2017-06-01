package semiproject;

import java.util.*;

public class Monster {
   // ���� ����
   String name;
   int hp;
   int damage;
   int exp;
   int maxHp;
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public int getHp() {
      return hp;
   }
   
   public void setHp(int hp) {
      this.hp = hp;
   }
   
   public int getDamage() {
      return damage;
   }
   
   public void setDamage(int damage) {
      this.damage = damage;
   }
   
   public int getExp() {
      return exp;
   }
   
   public void setExp(int exp) {
      this.exp = exp;
   }
   
   // ���� �����ڷ� �پ��� ���͸� ����� �迭�� ������ ����
   public Monster(String name, int hp, int damage, int exp){
      this.name = name;
      this.hp = hp;
      this.maxHp = hp;
      this.damage = damage;
      this.exp = exp;
      
      
   }
   

      
   // ���� �������� ĳ������ hp�� ����
   public int attack(Monster mon){
      /*
       * �������� +- ������ ���ؼ� �������� �������� ���� ����
             ���� ���ݷ��� 40�̸� 36~44 ������ ���� ����
         �׸��� ������ ������ ĳ���� attackpage�� �����ϱ�    
       * */ 
      
      Random r = new Random();
      
      
      int rd;
      int randomDam;
      
      rd = r.nextInt(8)-4;
      
      
      randomDam = mon.damage + rd;
      
      return randomDam;
   }
   
   
}