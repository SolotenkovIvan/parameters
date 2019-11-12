package homework.v3;


import homework.v3.entity.Bundle;
import homework.v3.entity.JsonFileClass;
import homework.v3.entity.JsonParameters;
import homework.v3.entity.Path;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 * */
public class HomeWork {
    public static void main(String[] args) {
        Path path1 = new Path();
        path1.setCode("0x08EF");
        path1.setValue("2287");
        Path path2 = new Path();
        path2.setCode("0x0425");
        path2.setValue("2345");
        Path path3 = new Path();
        path3.setCode("0x3412");
        path3.setValue("2412");
        List<Path> listPath = new ArrayList<>();
        listPath.add(path1);
        listPath.add(path2);
        listPath.add(path3);
        String str1 = "String1";
        String str2 = "String2";
        String str3 = "String2";
        List<String> listValue = new ArrayList<>();
        listValue.add(str1);
        listValue.add(str2);
        listValue.add(str3);
        Bundle bundle = new Bundle();
        bundle.setPath(listPath);
        bundle.setValues(listValue);
        JsonParameters jsonParameters = new JsonParameters();
        List<Bundle> listBundle = new ArrayList<>();
        listBundle.add(bundle);
        List<String> listRoles = new ArrayList<>();
        listRoles.add("Admin");
        listRoles.add("User");
        listRoles.add("Guest");
        jsonParameters.setBundle(listBundle);
        jsonParameters.setDescription("description");
        jsonParameters.setType("type");
        jsonParameters.setName("Parameters №1");
        jsonParameters.setList(true);
        jsonParameters.setRoles(listRoles);
        List<JsonParameters> listJsonParameters = new ArrayList<>();
        listJsonParameters.add(jsonParameters);
        JsonFileClass jsonFileClass = new JsonFileClass();
        jsonFileClass.setVersion("v.1.1");
        jsonFileClass.setParameters(listJsonParameters);


        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("homework.parameters.json"), jsonFileClass);
            System.out.println("homework.parameters.json");
            JsonReader jsonReader = new JsonReader();
            JsonFileClass object = jsonReader.read("homework.parameters.json");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("homework.parameters.ser"));
            oos.writeObject(object);
            System.out.println("homework.parameters.ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("homework.parameters.ser"));
            JsonFileClass readObject = (JsonFileClass)ois.readObject();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("homework.result.ser.parameters.json"), readObject);
            System.out.println("homework.result.ser.parameters.json");
            JsonFileClass readExterObject = jsonReader.read("homework.parameters.json");
            ObjectOutputStream oosExter = new ObjectOutputStream(new FileOutputStream("homework.parameters.exter"));
            oosExter.writeObject(readExterObject);
            ObjectInputStream oisExter = new ObjectInputStream(new FileInputStream("homework.parameters.exter"));
            JsonFileClass jsonFileClassExter = (JsonFileClass)oisExter.readObject();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("homework.result.exter.parameters.json"), jsonFileClassExter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
