package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            String isNamePresent = name!=null? "yes":"no";
            pw.println(isNamePresent);
            if (name!=null){
                pw.println(name);
            }
            String isAssetsPresent = assets!=null? "yes":"no";
            pw.println(isAssetsPresent);
            if (assets!=null){
                pw.println(assets.size());
                for (int i = 0; i <assets.size() ; i++) {
                    pw.println(assets.get(i).getName());
                    pw.println(assets.get(i).getPrice());
                }
            }
            pw.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isNamePresent = reader.readLine();
            if (isNamePresent.equals("yes")){
                this.name = reader.readLine();
                String isAssetsPresent = reader.readLine();
                if (isAssetsPresent.equals("yes")) {
                    this.assets = new ArrayList<>();
                    int assetsSize = Integer.parseInt(reader.readLine());
                    for (int i = 0; i <assetsSize ; i++) {
                        String assetName = reader.readLine();
                        double price = Double.parseDouble(reader.readLine());
                        Asset asset = new Asset(assetName, price);
                        this.assets.add(asset);
                    }
                } else {
                    this.assets = null;
                }
            } else {
                this.name = null;
            }

        }
    }
}
