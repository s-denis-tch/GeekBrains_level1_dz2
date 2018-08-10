package dz2;


import java.lang.reflect.Array;
import java.util.Arrays;

//Домашнее​​задание
//1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
//0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
//2 Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
//значениями 0 3 6 9 12 15 18 21;
//3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
//умножить на 2;
//4 Создать квадратный двумерный целочисленный массив (количество строк и столбцов
//одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
//5 ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
//помощи интернета);
//6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
//массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) →
//false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не
//входят.
//7 **** Написать метод, которому на вход подаётся одномерный массив и число n (может быть
//положительным, или отрицательным), при этом метод должен сместить все элементы
//массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
//массивами.

public class Main {

	
	private static void change(int[] mass) {
        for(int i = 0; i < mass.length; i++) {
            mass[i] = (mass[i] == 1) ? 0 : 1;
        }
    }

    private static void fillIn(int[] mass) {
        for(int i = 0; i < mass.length; i++) {
            mass[i] = i * 3;
        }
    }

    private static void doubling(int[] mass) {
        for(int i = 0; i < mass.length; i++) {
            if(mass[i] < 6) {
                mass[i] *= 2;
            }
        }
    }

    private static void crossFill(int[][] mass) {
        int str, bkw;
        for(str = 0, bkw = mass.length - 1; str < mass.length; str++, bkw--) {
            mass[str][bkw] = 1;
            mass[str][str] = 1;
        }
    }

    private static int findMax(int[] mass) {
        int max = mass[0];

        for(int i = 1; i < mass.length; i++) {
            if(mass[i] > max) {
                max = mass[i];
            }
        }
        return max;
    }

    private static int findMin(int[] mass) {
        int min = mass[0];

        for(int i = 1; i < mass.length; i++) {
            if(mass[i] < min) {
                min = mass[i];
            }
        }
        return min;
    }

    private static boolean checkBalance(int[] mass) {
        int right = 0;
        int left = 0;

        for(int i = 0; i < mass.length - 1; i++) {
            left += mass[i];
            for (int j = i + 1; j < mass.length; j++) {
                right += mass[j];
            }
            if (left == right) {
                return  true;
            }
            right = 0;
        }
        return  false;

    }

    private static void shifter(int[] array, int value) {
        boolean flag;
        if (value < 0) {
            flag = true;
            value = -value;
        } else {
            flag = false;
        }

        int lastIndex = array.length - 1;
        for(int i = 0; i < value; i++) {
            int temp;
            if(flag) {
                temp = array[0];
            } else {
                temp = array[lastIndex];
            }

            for(int j = 0; j < lastIndex; j++) {
                if(flag) {
                    array[j] = array[j + 1];
                } else {
                    array[lastIndex - j] = array[lastIndex - j - 1];
                }
            }
            if(flag) {
                array[lastIndex] = temp;
            } else {
                array[0] = temp;
            }
        }
    }
    public static void main(String[] args) {
//      1. 
      int[] bin = {1,0,1,0,0,0,0,1,0,1};
      System.out.println("1.1 " + Arrays.toString(bin));
      change(bin);
      System.out.println("1.2 " + Arrays.toString(bin));

//      2. 
      int[] mass2 = new int[8];
      fillIn(mass2);
      System.out.println("2.1 " + Arrays.toString(mass2));

//      3. 
      int[] mass3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
      System.out.println("3.1 " + Arrays.toString(mass3));
      doubling(mass3);
      System.out.println("3.2 " + Arrays.toString(mass3));
//
//      4. 

      final int side = 10;
      int[][] mass4 = new int[side][side];
      crossFill(mass4);
      for(int i = 0; i < mass4.length; i++) {
          for(int j = 0; j < mass4.length; j++) {
              System.out.print(mass4[i][j] + " ");
          }
          System.out.println();
      }


//     5. 
      System.out.println("5.1 Max " + findMax(mass3));
      System.out.println("5.2 Min " + findMin(mass3));

//      6. 
      int[] balance = {0,31,7,1,23};
      System.out.print("6. 1" + Arrays.toString(balance) + " " + checkBalance(balance));

//      7.  
      int[] shiftArray = {0,1,2,3,4,5,6,7,8,9};
      System.out.println();
      System.out.println("7.1 " + Arrays.toString(shiftArray));
      shifter(shiftArray, -3);
      System.out.println("7.2 " + Arrays.toString(shiftArray));
      shifter(shiftArray, 4);
      System.out.println("7.3 " + Arrays.toString(shiftArray));

  }
    
}
