package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String empty = users == null ? "yes" : "no";
            printWriter.println(empty);
            for (User u : users) {
                if (users != null) {
                    printWriter.println(u.getFirstName() == null ? "noFirstName" : u.getFirstName());
                    printWriter.println(u.getLastName() == null ? "noLastName" : u.getLastName());
                    printWriter.println(u.getBirthDate() == null ? "noBD" : new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).format(u.getBirthDate()));
                    printWriter.println(u.isMale());
                    printWriter.println(u.getCountry() == null ? "noCountry" : u.getCountry());
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String empty = reader.readLine();
            while (reader.ready()) {
                User user = new User();
                if (empty.equals("no")) {
                    String firstName = reader.readLine();
                    user.setFirstName(firstName.equals("noFirstName") ? null : firstName);
                    String lastName = reader.readLine();
                    user.setLastName(lastName.equals("noLastName") ? null : lastName);
                    String birthDate = reader.readLine();
                    user.setBirthDate(birthDate.equals("noBD") ? null : new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(birthDate));
                    String sex = reader.readLine();
                    user.setMale(Boolean.valueOf(sex));
                    String country = reader.readLine();
                    user.setCountry(country.equals("noCountry") ? null : User.Country.valueOf(country));
                    users.add(user);
                }else {
                    users.add(null);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
