import java.io.*;

public class PersonalData {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private Long phoneNumber;
    private String gender;

    public PersonalData(String surname, String name, String patronymic, String birthDate, Long phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;

    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }
}

class FileWriter {
    public static void writeToFile(PersonalData pd) throws Exception {
        String fileName = pd.getSurname() + ".txt";
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(fileName)) {
            String personalData = pd.getSurname() + " " + pd.getName() + " " + pd.getPatronymic() + " " + pd.getBirthDate() + " " + pd.getPhoneNumber() + " " + pd.getGender();
            fileWriter.write(personalData);
        }
    }
}
