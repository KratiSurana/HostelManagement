package com.example.cdgi_hostel;

public class Model {
    int image;
    String studentName,time,rollNumber;

    public Model(int image, String studentName, String time, String rollNumber) {
        this.image = image;
        this.studentName = studentName;
        this.time = time;
        this.rollNumber = rollNumber;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
