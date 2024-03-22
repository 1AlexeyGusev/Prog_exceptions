import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
//
//Фамилия Имя Отчество дата _ рождения номер _ телефона пол
//
//Форматы данных:
//
//фамилия, имя, отчество - строки
//дата _ рождения - строка формата dd.mm.yyyy
//номер _ телефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m.
//Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код
//ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не
//совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы
//java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные
//данные, вида
//        <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//Не забудьте закрыть соединение с файлом.
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс
//ошибки.
//
//Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"
//
//        "Зачет" ставится, если слушатель успешно выполнил задание.
//
//"Незачет" ставится, если слушатель не выполнил задание.
//
//Критерии оценивания: Слушатель написал приложение, которое запрашивает у пользователя следующие данные, разделенные пробелом:
//Фамилия Имя Отчество дата _ рождения номер _ телефона пол
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилию, Имя, Отчество, дату рождения, номер телефона, пол");
        String personalData = scanner.nextLine();
        try {
            String[] personalDataArray = personalData.split(" ");
            if(personalDataArray.length != 6) {
                throw new IOException("Неверно введены данные. Введите Фамилию, Имя, Отчество, дату рождения, номер телефона, пол");
            }
            if(!personalDataArray[3].matches("\\d{2}\\.\\d{2}\\.\\d{4}")){
                throw new IOException("Неверный формат даты!");
            }
            if(!personalDataArray[5].contains("f")||!personalDataArray[5].contains("m")&&personalDataArray[5].length()!=1){
                throw new IOException("Введите либо 'f', либо 'm'");

            }
            PersonalData pd = new PersonalData(personalDataArray[0], personalDataArray[1], personalDataArray[2],
                    personalDataArray[3], Long.parseLong(personalDataArray[4]), personalDataArray[5]);
            FileWriter.writeToFile(pd);
            System.out.println("Данные записаны!");
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка:"+ e.getMessage());
        } catch (Exception e){
            System.out.println("Произошла ошибка записи в файл:");
            e.printStackTrace();
        }
    }
}