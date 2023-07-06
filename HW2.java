// 1) Напишите метод, который определит тип (расширение) файлов из текущей папки и 
// выведет в консоль результат вида
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg

// import java.io.File;
// import java.util.ArrayList;
// import java.util.List;

// public class HW2 {
//     public static void main(String[] args) {
//         List<String> files = get_files();
//         for (String file : files)
//             System.out.println(file + " - Расширение: " + get_extention(file));
//     }

//     public static String get_extention(String file) {
//         int index = file.lastIndexOf(".");
//         if (index == -1)
//             return "";
//         return file.substring(index + 1);
//     }

//     public static List<String> get_files() {

//         File dir = new File(".");

//         File[] files;
//         try {
//             files = dir.listFiles();
//         } catch (Exception ex) {
//             ex.printStackTrace();
//             return null;
//         }
//         if (files == null)
//             return null;

//         List<String> list = new ArrayList<String>();
//         for (File file : files)
//             if (file.isFile())
//                 list.add(file.getName());

//         return list;
//     }
// }

// 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class HW2 {
    private static File log;
    private static FileWriter fileWriter;

    public static void main(String[] args) {
        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);
            int[] sortArr = { 100, 23, 0, -1, 12, 5, -5, 17, -70, 45};
            bubbleSort(sortArr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
            writeLog(Arrays.toString(sortArr));
        }
    }    

    public static void writeLog(String note) {
        
        try(FileWriter writer = new FileWriter("log.txt"))
        {
           fileWriter.write(note + "\n"); 
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}