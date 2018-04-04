// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package codeu.model.data;

import java.time.Instant;
import java.util.UUID;

/** Class representing a registered user. */
public class User {
    private final UUID id;
    private final String name;
    private final String password;
    private final Instant creation;
    private final Integer age;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNum;
    private final String bio;

    /**
     * Constructs a new User.
     *
     * @param newId the ID of this User
     * @param newName the username of this User
     * @param newPassword the password of this User
     * @param newCreation the creation time of this User
     * @param newAge the age of this User
     * @param newFirstName the first name of this User
     * @param newLastName the last name of this User
     * @param newEmail the email of this User
     * @param newPhoneNum the phone number of this User
     * @param newBio the bio of this User
     */
    public User(UUID newId, String newName, String newPassword, Instant newCreation) {
	
	this.id = newId;
	this.name = newName;
	this.password = newPassword;
	this.creation = newCreation;
	this.age = 0;
	this.firstName = "First name";
	this.lastName = "Last name";
	this.email = "no-reply@example.com";
	this.phoneNum = "123-456-7890";
	this.bio = "Hello World!";
    }
    
    public static class UserBuilder {
	private UUID nestedId;
	private String nestedName;
	private String nestedPassword;
	private Instant nestedCreation;
	private Integer nestedAge;
	private String nestedFirstName;
	private String nestedLastName;
	private String nestedEmail;
	private String nestedPhoneNum;
	private String nestedBio;

	public UserBuilder(final UUID newId, final String newName, final String newPassword, final Instant newCreation) {
	    this.nestedId = newId;
	    this.nestedName = newName;
	    this.nestedPassword = newPassword;
	    this.nestedCreation = newCreation;
	}
	
	public UserBuilder id(UUID newId) {
	    this.nestedId = newId;
	    return this;
	}
	
	public UserBuilder name(String newName) {
	    this.nestedName = newName;
	    return this;
	}
	
	public UserBuilder Password(String newPassword) {
	    this.nestedPassword = newPassword;
	    return this;
	}
	
	public UserBuilder creation(Instant newCreation) {
	    this.nestedCreation = newCreation;
	    return this;
	}
	
	public UserBuilder age(Integer newAge) {
	    this.nestedAge = newAge;
	    return this;
	}
	
	public UserBuilder firstName(String newFirstName) {
	    this.nestedFirstName = newFirstName;
	    return this;
	} 
	
	public UserBuilder lastName(String newLastName) {
	    this.nestedLastName = newLastName;
	    return this;
	}
	
	public UserBuilder email(String newEmail) {
	    this.nestedEmail = newEmail;
	    return this;
	}
	
	public UserBuilder phoneNum(String newPhoneNum) {
	    this.nestedPhoneNum = newPhoneNum;
	    return this;
	}
	
	public UserBuilder bio(String newBio) {
	    this.nestedBio = newBio;
	    return this;
	}
	
	public User createUser() {
	    return new User(nestedId, nestedName, nestedPassword, nestedCreation);
	}
    }
    /** Returns the ID of this User. */
    public UUID getId() {
	return id;
    }

    /** Returns the username of this User. */
    public String getName() {
	return name;
    }

    /** Returns the password of this User. */
    public String getPassword() {
	return password;
    }

    /** Returns the creation time of this User. */
    public Instant getCreationTime() {
	return creation;
    }
    
    /** Returns the age of this User. */
    public Integer getAge() {
	return age;
    }
    
    /** Returns the first name of this User. */
    public String getFirstName() {
	return firstName;
    }

    /** Returns the last name of this User. */
    public String getLastName() {
	return lastName;
    }

    /** Returns the email of this User. */
    public String getEmail() {
	return email;
    }

    /** Returns the phone number of this User. */
    public String getPhoneNum() {
	return phoneNum;
    }
    
    /** Returns the bio of this User. */
    public String getBio() {
	return bio;
    }
}
