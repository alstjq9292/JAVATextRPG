package semiproject;
import java.util.HashMap;
public class Map {
 /*
  * 맵 3개 만들고 그 안에 몬스터 정보를 넣기
  * */
    // 해시맵 객체 hm 생성 
   
      HashMap<String, String[]> hm;
      public Map(){
         hm = new HashMap<String, String[]>(); 
           
          String[] map1monster = {"오크","오우거"};
          String[] map2monster = {"고블린", "골렘"};
          String[] map3monster = {"루인혼"};

          hm.put("map1", map1monster);  // 해시맵에 자료 추가 
          hm.put("map2", map2monster);
          hm.put("map3", map3monster);
      }
      public static void main(String args[]){
         
      }
      
         
       

   }
 