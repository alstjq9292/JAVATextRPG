package semiproject;
import java.util.HashMap;
public class Map {
 /*
  * �� 3�� ����� �� �ȿ� ���� ������ �ֱ�
  * */
    // �ؽø� ��ü hm ���� 
   
      HashMap<String, String[]> hm;
      public Map(){
         hm = new HashMap<String, String[]>(); 
           
          String[] map1monster = {"��ũ","�����"};
          String[] map2monster = {"���", "��"};
          String[] map3monster = {"����ȥ"};

          hm.put("map1", map1monster);  // �ؽøʿ� �ڷ� �߰� 
          hm.put("map2", map2monster);
          hm.put("map3", map3monster);
      }
      public static void main(String args[]){
         
      }
      
         
       

   }
 