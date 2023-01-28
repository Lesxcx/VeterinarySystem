package org.VeterinarySystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class AppMenu {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public AppMenu(){
        boolean dec = true;
        while (dec) {
//            System.out.println("Describe patient name.");
//            String patientName = new Scanner(System.in).nextLine();
            System.out.println("""
                    Press 1 to view patient.
                    Press 2 to add patient.
                    Press 3 to search patient.
                    Press 4 to exit.""");
            byte dec2 = new Scanner(System.in).nextByte();
            switch (dec2) {
                case 1 -> getPatient();
                case 2 -> addPatient();
                case 3 -> {
                    System.out.println("What field do you want to search for. Available fields: owner/breed/day");
                    String choice = new Scanner(System.in).nextLine();
                    if (choice.equals("owner")) {
                        System.out.println("What is the owner name?");
                        String owner = new Scanner(System.in).nextLine();
                        File[] ownerDirs = new File(".").listFiles(File::isDirectory);
                        for (File ownerDir : Objects.requireNonNull(ownerDirs)) {
                            if (!ownerDir.getName().equalsIgnoreCase(owner)) {
                            }
                            File[] patientFiles = ownerDir.listFiles((dir, name) -> name.endsWith(".json"));
                            for (File patientFile : patientFiles) {
                                Patient patient = gson.fromJson(String.valueOf(patientFile), Patient.class);
                                System.out.println("Name: " + patient.getName());
                            }
                        }
                            if (choice.equalsIgnoreCase("breed")) {

                            }
                            if (choice.equalsIgnoreCase("day")) {

                            }
                        }
                    }
                case 4 -> dec = false;
            }
        }
    }

    public void addPatient(){
        System.out.println("Describe patient name.");
        String patientName = new Scanner(System.in).nextLine();
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
            this.gson.toJson(patient, writer);
            System.out.println("Patient are added.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPatient(){
        System.out.println("Describe patient name.");
        String patientName = new Scanner(System.in).nextLine();
        try (FileReader reader = new FileReader(patientName.concat(".json"))){
            JsonElement json = gson.fromJson(reader, JsonElement.class);

            String jsonInString = gson.toJson(json);

            System.out.println(jsonInString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
