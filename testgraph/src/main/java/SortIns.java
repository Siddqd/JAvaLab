import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author siddi
 */
public class SortIns {
    private String arrStr;
    private ArrayList<Integer> al;
    private String ErrorMsg;
    
    public void SortIns() {
        arrStr = new String();
        al = new ArrayList<>(0);
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
    
    public void set(String s) {
        arrStr = s;
    }
    
    public String get() {
        return arrStr;
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
    
    private void InsSort (ArrayList<Integer> al) {
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
    }
    private void PrintArr (ArrayList <Integer> al) {
        System.out.println("");
        for(Integer i : al) {
            System.out.print(i);
        }
    }
}


