package model;

import exception.MyException;

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

    /**
     * DISPLAY MUTUAL
     * @throws MyException
     */
    public static void displayMutual() throws MyException {
        if (mutualList.isEmpty()) {
            throw new MyException("La liste est vide, veuillez créer une nouvelle mutuelle. ");
        } else {
            for (Mutual mutual : mutualList) {
                System.out.println(mutual.getName());
            }
        }
    }

    /**
     * ADD MUTUAL NEED TEST IN MAIN (not mandatory)
     * @param Mutual
     */
    public static void addMutual(Mutual Mutual) {
        mutualList.add(Mutual);

        System.out.println(" Mutuelle ajoutée : " + Mutual.toString());
    }

    /**
     * DELETE MUTUAL *** A TESTER
     * @param mutual
      */
    public void deleteMutual(Mutual mutual) {
        mutualList.remove(this);
    }

    @Override
    public String toString() {
        return "Mutual { " +
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
