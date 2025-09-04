package model;

import java.util.ArrayList;

public class Mutual {
    private String name;
    private String address;
    private String postCode;
    private String city;
    private String department;
    private String phoneNumber;
    private String email;
    private double refundRate = 0.60;

    public static ArrayList<Mutual> mutualList = new ArrayList<>();
    public static ArrayList<Mutual> getMutuals() {
        return mutualList;
    }

    public Mutual(String name, String address, String postCode, String city, String department,
                String phoneNumber, String email, double refundRate) {
        this.setName(name);
        this.setAddress(address);
        this.setPostCode(postCode);
        this.setCity(city);
        this.setDepartment(department);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setRefundRate(refundRate);

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRefundRate() {
        return this.refundRate;
    }

    public void setRefundRate(double refundRate) {
        this.refundRate = refundRate;
    }

    public ArrayList<Mutual> getMutualList() {
        return this.mutualList;
    }

    public void setMutualList(ArrayList<Mutual> mutualList) {
        this.mutualList = mutualList;
    }

    public void displayMutual() {
        if (mutualList.isEmpty()) {
            System.out.println("La liste est vide.");
        } else {
            for (Mutual mutual : mutualList) {
                System.out.println(mutual.getName());
            }
        }
    }
    public void deleteMutual() {
        mutualList.remove(this);
    }

    @Override
    public String toString() {
        return "Mutual{ " +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", postCode=" + getPostCode() +
                ", city='" + getCity() + '\'' +
                ", department=" + getDepartment() +
                ", phoneNumber=" + getPhoneNumber() +
                ", email='" + getEmail() + '\'' +
                ", refundRate=" + getRefundRate() +
                '}';
    }
}
