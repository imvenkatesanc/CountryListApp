package LongCoding;

import java.time.LocalDate;

// Abstract class representing a person
abstract class Person {
    int id;
    String name;
    String email;
    String address;

    public Person(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public abstract void displayInfo();
}

// User class extending Person
class User extends Person {
    String password;

    public User(int id, String name, String email, String address, String password) {
        super(id, name, email, address);
        this.password = password;
    }

    @Override
    public void displayInfo() {
        System.out.println("User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]");
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

// Role class
class Role {
    int roleId;
    String roleName;

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Getters and setters
    public int getRoleId() { return roleId; }
    public void setRoleId(int roleId) { this.roleId = roleId; }
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
}

// UserRole class showing association between User and Role
class UserRole {
    Role role;
    User user;

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    // Getters and setters
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

// Interface for bookable items
interface Bookable {
    void book();
    void cancel();
}

// TourPackage class implementing Bookable interface
class TourPackage implements Bookable {
    int packageId;
    String destination;
    String duration;
    String description;
    int amount;

    public TourPackage(int packageId, String destination, String duration, String description, int amount) {
        this.packageId = packageId;
        this.destination = destination;
        this.duration = duration;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public void book() {
        System.out.println("Booking tour package to " + destination);
    }

    @Override
    public void cancel() {
        System.out.println("Cancelling tour package to " + destination);
    }

    // Getters and setters
    public int getPackageId() { return packageId; }
    public void setPackageId(int packageId) { this.packageId = packageId; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}

// BookTour class showing association between User and TourPackage
class BookTour {
    int transactionId;
    User user;
    TourPackage tourPackage;
    LocalDate date;
    String status;

    public BookTour(int transactionId, User user, TourPackage tourPackage, LocalDate date, String status) {
        this.transactionId = transactionId;
        this.user = user;
        this.tourPackage = tourPackage;
        this.date = date;
        this.status = status;
    }

    // Getters and setters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public TourPackage getTourPackage() { return tourPackage; }
    public void setTourPackage(TourPackage tourPackage) { this.tourPackage = tourPackage; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

// Feedback class showing association between User and TourPackage
class Feedback {
    int feedbackId;
    TourPackage tourPackage;
    User user;

    public Feedback(int feedbackId, TourPackage tourPackage, User user) {
        this.feedbackId = feedbackId;
        this.tourPackage = tourPackage;
        this.user = user;
    }

    // Getters and setters
    public int getFeedbackId() { return feedbackId; }
    public void setFeedbackId(int feedbackId) { this.feedbackId = feedbackId; }
    public TourPackage getTourPackage() { return tourPackage; }
    public void setTourPackage(TourPackage tourPackage) { this.tourPackage = tourPackage; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "John Doe", "john@example.com", "123 Main St", "password123");
        Role role = new Role(1, "Admin");
        UserRole userRole = new UserRole(role, user);

        TourPackage tourPackage = new TourPackage(1, "Paris", "7 days", "A wonderful trip to Paris", 1500);
        BookTour bookTour = new BookTour(1, user, tourPackage, LocalDate.now(), "Booked");

        Feedback feedback = new Feedback(1, tourPackage, user);

        user.displayInfo();
        tourPackage.book();
        System.out.println(bookTour.getStatus());
    }
}
