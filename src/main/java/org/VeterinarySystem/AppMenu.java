package org.VeterinarySystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class AppMenu {
    public AppMenu(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        boolean dec = true;
        while (dec) {
            System.out.println("Describe patient name.");
            String patientName = new Scanner(System.in).nextLine();
            System.out.println("Press 1 to view patient." +
                    "\nPress 2 to add patient." +
                    "\nPress 3 to exit.");
            byte dec2 = new Scanner(System.in).nextByte();
            switch (dec2) {
                case 1 -> {
                    try (FileReader reader = new FileReader(patientName.concat(".json"))){
                        JsonElement json = gson.fromJson(reader, JsonElement.class);

                        String jsonInString = gson.toJson(json);

                        System.out.println(jsonInString);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    System.out.println("Describe owner name.");
                    String owner = new Scanner(System.in).nextLine();
                    System.out.println("Describe patient breed.");
                    String breed = new Scanner(System.in).nextLine();
                    System.out.println("Describe issue.");
                    String issue = new Scanner(System.in).nextLine();
                    System.out.println("Describe patient age.");
                    int age = new Scanner(System.in).nextInt();
                    Date date = new Date();
                    Patient patient = new Patient(patientName, owner, breed, issue, age, date);
                    try (FileWriter writer = new FileWriter(patientName.concat(".json"))){
                        gson.toJson(patient, writer);
                        System.out.println("Patient are added.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case 3 -> dec = false;
            }
        }
    }
}
