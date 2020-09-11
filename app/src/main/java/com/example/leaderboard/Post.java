package com.example.leaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;

    @SerializedName("githubUrl")
    @Expose
    private String githubUrl;

    public Post(String firstName, String lastName, String emailAddress, String githubUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.githubUrl = githubUrl;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", emailAddress='" + emailAddress + '\'' +
                ", githubUrl='" + githubUrl + '\'' +
                '}';
    }

}
