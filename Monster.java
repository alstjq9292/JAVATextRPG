package semiproject;

import java.util.*;

public class Monster {
   // 몬스터 정보
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
   
   // 몬스터 생성자로 다양한 몬스터를 만들고 배열에 저장할 예정
   public Monster(String name, int hp, int damage, int exp){
      this.name = name;
      this.hp = hp;
      this.maxHp = hp;
      this.damage = damage;
      this.exp = exp;
      
      
   }
   

      
   // 몬스터 공격으로 캐릭터의 hp를 깎음
   public int attack(Monster mon){
      /*
       * 데미지의 +- 비율을 정해서 랜덤으로 데미지가 들어가게 설정
             만약 공격력이 40이면 36~44 사이의 값이 들어가게
         그리고 공격이 끝나면 캐릭터 attackpage를 실행하기    
       * */ 
      
      Random r = new Random();
      
      
      int rd;
      int randomDam;
      
      rd = r.nextInt(8)-4;
      
      
      randomDam = mon.damage + rd;
      
      return randomDam;
   }
   
   
}