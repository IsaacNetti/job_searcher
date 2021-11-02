package JobSearcher;

import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

public class JobSearcherUI {
  private static final String TITLE = "Job Searcher\n";
  private static final String LOGIN = "What would you like to do: \n1. Sign in\n2. Create a New Account";
  private static final String ERROR = "Not a valid input";
  private static final String NEW_ACCOUNT = "What type of account would you like to create: \n1. Student\n2. Employer";
  private static final String EXIT = "SEE YA HOMIE";
  private Student studentUser;
  private Employer employerUser;
  private Admin adminUser;
  private String[] studentMenuOptions = { "Create resume", "add experience to resume", "Display all jobs",
      "Search jobs", "Search jobs by company", "Apply to a job", "View ratings", "Download Resume", "logout" };
  private String[] employerMenuOptions = { "Create job", "Delete job", "Display all jobs", "Search jobs",
      "Search jobs by company", "View applicants to a job", "Decline an applicant", "logout" };
  private String[] adminMenuOptions = { "Add admin", "Remove admin", "Remove Student", "Remove Employer",
      "Remove company", "logout" };
  private Scanner scanner;
  private JobSystem jobSystem;

  JobSearcherUI() {
    this.scanner = new Scanner(System.in);
    jobSystem = new JobSystem();
  }

  public void run() {
    System.out.println(TITLE);
    System.out.println(LOGIN);
    int choice = scanner.nextInt();
    scanner.nextLine();
    while (choice != 1 && choice != 2) {
      System.out.println(ERROR);
      choice = scanner.nextInt();
      scanner.nextLine();
    }
    if (choice == 1) {
      login();
    } else if (choice == 2) {
      createUser();
    }
    if (studentUser != null) {
      studentAccout();
    } else if (employerUser != null) {
      employerAccount();
    } else if (adminUser != null) {
      admin();
    }
  }

  private void login() {
    System.out.println(TITLE);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    studentUser = jobSystem.studentLogin(username, password);
    if (studentUser == null) {
      employerUser = jobSystem.employerLogin(username, password);
    }
    if (studentUser == null && employerUser == null) {
      adminUser = jobSystem.adminLogin(username, password);
    }
    if (studentUser == null && employerUser == null && adminUser == null) {
      System.out.println("Invalid Login");
      login();
    }
  }

  private void createUser() {
    System.out.println(TITLE);
    System.out.println(NEW_ACCOUNT);
    int choice = scanner.nextInt();
    scanner.nextLine();
    while (choice != 1 && choice != 2) {
      System.out.println(ERROR);
      choice = scanner.nextInt();
      scanner.nextLine();
    }
    if (choice == 1) {
      newStudent();
    } else if (choice == 2) {
      newEmployer();
    }
  }
  private void admin() {
    boolean logout = false;
    while (!logout) {
      System.out.println("What would you like to do?");
      int num = 1;
      for (String s : adminMenuOptions) {
        System.out.println(num + ". " + s);
        num++;
      }
      int choice = scanner.nextInt();
      scanner.nextLine();
      while (choice < 1 && choice > 6) {
        choice = scanner.nextInt();
        scanner.nextLine();
      }
      switch (choice) { 
        case(1):
          System.out.print("What is the username: ");
          String username = scanner.nextLine();
          System.out.print("What is the password: "); 
          String password = scanner.nextLine(); 
          jobSystem.createAdmin(username, password);
          break;
        case(2):
          System.out.print("Enter the UUID of the admin you want to remove: ");
          String adminID = scanner.nextLine();
          UUID ida = UUID.fromString(adminID);
          Admin a = jobSystem.adminExists(ida);
          if (a == null) {
            System.out.println("This employer does not exist");
            break;
          }
          jobSystem.deleteAdmin(a);
          break;
        case(3):
          System.out.print("Enter the UUID of the student you want to remove: ");
          String studentID = scanner.nextLine();
          UUID id = UUID.fromString(studentID);
          Student s = jobSystem.studentExists(id);
          if (s == null) {
            System.out.println("This employer does not exist");
            break;
          }
          jobSystem.deleteStudent(s);
          break;
        case(4):
          System.out.print("Enter the UUID of the employer you want to remove: ");
          String employerID = scanner.nextLine();
          UUID ide = UUID.fromString(employerID);
          Employer e = jobSystem.employerExists(ide);
          if (e == null) {
            System.out.println("This employer does not exist");
            break;
          }
          jobSystem.deleteEmployer(e);
          break;
        case(5):
          System.out.print("Enter the name of the company you want to remove: ");
          String companyName = scanner.nextLine();
          Company c = jobSystem.companyExists(companyName);
          if (c == null) {
            System.out.println("This employer does not exist");
            break; 
          }
          jobSystem.deleteCompany(c);
          break;
        case(6):
          logout = true;
          break;
      } 
    }
  }
  private void newStudent() {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    System.out.print("Enter First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Enter Last Name: ");
    String lastName = scanner.nextLine();
    System.out.print("Enter GPA: ");
    String gpa = scanner.nextLine();
    System.out.print("Enter EDU Email: ");
    String eduAccount = scanner.nextLine();
    System.out.print("Enter Phone Number: ");
    String phoneNumber = scanner.nextLine();
    jobSystem.createStudent(username, password, firstName, lastName, gpa, eduAccount, phoneNumber);
  }

  private void newEmployer() {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    System.out.print("Enter First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Enter Last Name: ");
    String lastName = scanner.nextLine();
    System.out.print("Enter Phone Number: ");
    String phoneNumber = scanner.nextLine();
    jobSystem.createEmployer(username, password, firstName, lastName, phoneNumber);
  }

  private Company createCompany(String name) {
    System.out.println("That company is not on this site yet\nPlease enter the following information");
    System.out.print("Enter the location of the Company: ");
    String location = scanner.nextLine();
    System.out.print("Enter the industry of the Company: ");
    String industry = scanner.nextLine();
    System.out.print("Enter the sector of the Company: ");
    String sector = scanner.nextLine();
    jobSystem.createCompany(name, location, industry, sector);
    return jobSystem.companyExists(name);
  }

  private void studentAccout() {
    boolean logout = false;
    while (!logout) {
      System.out.println("What would you like to do?");
      int num = 1;
      for (String s : studentMenuOptions) {
        System.out.println(num + ". " + s);
        num++;
      }
      int choice = scanner.nextInt();
      scanner.nextLine();
      while (choice < 1 && choice > 8) {
        choice = scanner.nextInt();
        scanner.nextLine();
      }
      switch (choice) {
        case (1):
          createResume();
          break;
        case (2):
          addExperience();
          break;
        case (3):
          jobSystem.displayAllJobs();
          break;
        case (4):
          System.out.println("How would you like to search?");
          jobSystem.jobFilters();
          
          int response = scanner.nextInt();
          scanner.nextLine();
          System.out.println("What phrase are you searching for?");
          String phrase = scanner.nextLine();
          jobSystem.searchJobs(response, phrase);
          break;
        case (5):
          jobSystem.companyFilters();
          System.out.println("How would you like to search?");
          int response1 = scanner.nextInt();
          scanner.nextLine();
          System.out.println("What phrase are you searching for?");
          String phrase1 = scanner.nextLine();
          jobSystem.searchCompany(response1, phrase1);
          break;
        case (6):
          System.out.println("What company are you applying at?");
          String companyName = scanner.nextLine();
          System.out.println("What job would you like to apply for?");
          String jobTitle = scanner.nextLine();
          Job j = jobSystem.getJob(jobTitle, companyName);
          if (j == null) {
            System.out.println("This job does not exist");
            break;
          }
          jobSystem.apply(studentUser, j);
          System.out.println("Application submitted\n");
          break;
        case (7):
          System.out.println("Your average rating is: " + studentUser.getRatings().getAverageRating());
          break;
        case (8):
          if (studentUser.getResume() == null) {
            System.out.println("You have not created a resume yet");
            break;
          }
          System.out.println("What do you want to save it as?");
          String fileName = scanner.nextLine();
          jobSystem.saveResume(studentUser, fileName);
          System.out.println("resume saved under "+ fileName);
          break;
        case (9):
          logout = true;
          break;
      }
    }
  }

  private void createResume() {
    System.out.println("Enter the name of your college: ");
    String education = scanner.nextLine();
    String skills = "";
    String achievements = "";
    boolean done = false;
    while (!done) {
      System.out.println("Enter a skill (Enter 'done' when finished)");
      String temp = scanner.nextLine();
      if (temp.equalsIgnoreCase("done")) {
        break;
      }
      skills += temp + "\n";
    }
    while (!done) {
      System.out.println("Enter an achievement (Enter 'done' when finished)");
      String temp = scanner.nextLine();
      if (temp.equalsIgnoreCase("done")) {
        break;
      }
      achievements += temp + "\n";
    }
    jobSystem.createResume(studentUser, skills, education, achievements);
  }

  private void addExperience() {
    System.out.print("What was your job title: ");
    String title = scanner.nextLine();
    System.out.print("What what the name of the company: ");
    String company = scanner.nextLine();
    System.out.print("When did you start working there: ");
    String startDate = scanner.nextLine();
    System.out.print("When did you finish working there: ");
    String endDate = scanner.nextLine();
    System.out.print("What did you do while working there: ");
    String jobDescription = scanner.nextLine();
    jobSystem.addExperience(studentUser.getResume(), title, company, startDate, endDate, jobDescription);
  }

  private void employerAccount() {
    boolean logout = false;
    while (!logout) {
      if (employerUser.getCompany() == null) {
        System.out.print("What company do you work for? ");
        String companyName = scanner.nextLine();
        Company c = jobSystem.companyExists(companyName);
        if (c == null) {
          c = createCompany(companyName);
        }
      } else {
        System.out.println("What would you like to do?");
        int num = 1;
        for (String s : employerMenuOptions) {
          System.out.println(num + ". " + s);
          num++;
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice < 1 && choice > 8) {
          choice = scanner.nextInt();
          scanner.nextLine();
        }
        switch (choice) {
          case (1):
            System.out.print("What is the Job Title: ");
            String name = scanner.nextLine();
            System.out.print("What is the Start Date: ");
            String startDate = scanner.nextLine();
            System.out.print("What is the End Date: ");
            String endDate = scanner.nextLine();
            System.out.print("What is the Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("What is the Description: ");
            String description = scanner.nextLine();
            System.out.print("What is the Location: ");
            String location = scanner.nextLine();
            System.out.print("Can you work remotely (Enter yes or no): ");
            String remote = scanner.nextLine();
            boolean isRemote = false;
            if (remote.equalsIgnoreCase("yes")) {
              isRemote = true;
            }
            jobSystem.createJob(name, startDate, endDate, salary, description, location, isRemote, employerUser.getCompany(), employerUser);
            break;
          case (2):
            for (int i = 0; i < employerUser.getListings().size(); i++) {
              System.out.println(i + ". " + employerUser.getListings().get(i));
            }
            System.out.print("Enter the number of which job you want to delete: ");
            int option = scanner.nextInt();
            if (option > employerUser.getListings().size()) {
              System.out.println("Not a valid input");
              break;
            }
            employerUser.getListings().remove(option);
            break;
          case (3):
            jobSystem.displayAllJobs();
            break;
          case (4):
            jobSystem.jobFilters();
            System.out.println("How would you like to search?");
            int response = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What phrase are you searching for?");
            String phrase = scanner.nextLine();
            jobSystem.searchJobs(response, phrase);
            break;
          case (5):
            jobSystem.companyFilters();
            System.out.println("How would you like to search?");
            int response1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What phrase are you searching for?");
            String phrase1 = scanner.nextLine();
            jobSystem.searchCompany(response1, phrase1);
            break;
          case (6):
            for (int i = 0; i < employerUser.getListings().size(); i++) {
              System.out.println(i+1 + ". " + employerUser.getListings().get(i));
            }
            System.out.print("Enter the number of which job you want see the Applications for: ");
            int option1 = scanner.nextInt();
            option1 -= 1;
            scanner.nextLine();
            if (option1 < 0 && option1 > employerUser.getListings().size()) {
              System.out.println("Not a valid input");
              break;
            }
            ArrayList<Application> applications = employerUser.getListings().get(option1).getApplications();
            for (int i = 0; i < applications.size(); i++) {
              System.out.println(i + 1 + ". " + applications.get(i));
            }
            break;
          case (7):
            for (int i = 0; i < employerUser.getListings().size(); i++) {
              System.out.println(i + 1 + ". " + employerUser.getListings().get(i));
            }
            System.out.print("Enter the number of which job you want see the Applications for: ");
            int option2 = scanner.nextInt();
            option2 -= 1;
            scanner.nextLine();
            if (option2 < 0 && option2 > employerUser.getListings().size()) {
              System.out.println("Not a valid input");
              break;
            }
            ArrayList<Application> applications1 = employerUser.getListings().get(option2).getApplications();
            for (int i = 0; i < applications1.size(); i++) {
              System.out.println(i + 1 + ". " + applications1.get(i));
            }
            System.out.print("Enter the applicant number you want to delete: ");
            int applicant1 = scanner.nextInt();
            applicant1 -= 1;
            scanner.nextLine();
            if (applicant1 < 0 && applicant1 > applications1.size()) {
              System.out.println("Not a valid input");
              break;
            }
            applications1.remove(applicant1);
            break;
          case (8):
            logout = true;
            break;
        }
      }
    }
  }

  public static void main(String[] args) {
    JobSearcherUI jobSearcherInterface = new JobSearcherUI();
    jobSearcherInterface.run();
    System.out.println(EXIT);
  }
}

