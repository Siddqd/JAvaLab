import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author siddi
 */
public class SortIns {
    private String arrStr;
    private ArrayList<Integer> al  = new ArrayList<>();
    private String ErrorMsg;
    
    public void SortIns() {
        arrStr = new String();
        al = new ArrayList<>();
        ErrorMsg = "";
    }
       /* ArrayList <Integer> arl = new ArrayList<>(0);
        System.out.println("Enter array throw Enter : ");
        FillArray(arl);
        PrintArr(arl);
        InsSort(arl);
        PrintArr(arl);*/
    public void isErrorNumeric() {
        if (arrStr.matches("[^0-9\\ ]")) {//если есть символы кроме 0-9 пробел записать сообщ в ErrorMsg
            ErrorMsg = "Введены некорректные символе в поле ввода массива целых чисел";
        }
        strToInt();
    }
    
    public void setStr(String s) {
        arrStr = s;
    }
    
    public String getStr() {
        return arrStr;
    }
    public void setAL(ArrayList<Integer> arl) {
        al = arl;
    }
    
    public ArrayList<Integer> getAL() {
        return al;
    }
    
    public String getErrMsg() {
        return ErrorMsg;
    }
    
    
    /*public  void FillArray (ArrayList<Integer> al) {
        
        Scanner scanner = new Scanner(System.in);
        Integer i;
        while (scanner.hasNextInt()) {
            i = scanner.nextInt();
            al.add(i);
        }
    }*/
    
    private void strToInt() {
        try {
            String[] bar = arrStr.split(" ");
            for(String t : bar) {
                al.add(Integer.parseInt(t));
            }
        } catch (NumberFormatException e) {
            ErrorMsg = "Ошибка ввода числа " + e.getMessage();
        }
    }
    
    public void InsSort () {
        int x, j = 0;
        for (int i = 1; i < al.size(); i++) {
            x = al.get(i);
            j = i;
            while (j > 0 && al.get(j-1) > x) {
                al.set(j, al.get(j-1));
                j--;
            }
            al.set(j,x);
        }
        ErrorMsg = "";
        arrStr = "";
        for(Integer i : al) {
            arrStr+= i.toString() + " ";
        }
    }
      
    private void PrintArr (ArrayList <Integer> al) {
        System.out.println("");
        for(Integer i : al) {
            System.out.print(i);
        }
    }
}


