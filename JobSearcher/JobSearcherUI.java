package JobSearcher;
import java.util.Scanner;
public class JobSearcherUI {
    private static final String WELCOME_MESSAGE = "Welcome to the job searcher!";
    private static final String LOG_IN_MESSAGE = "Please log in, are you a \n1. Student \n2. Employer \n3. New user";
    private static final int NUM_LOGIN_COMMANDS = 3;
    private Student studentUser;
    private Employer employerUser;
    private String[] studentMenuOptions = {"Create resume","add experience to resume","Display all jobs","Search jobs","Search jobs by company","Apply to a job","View ratings","logout"};
    private String[] employerMenuOptions = {"Create job","Delete job","Add a company","Display all jobs","Search jobs","Search jobs by company", "View applicants to a job", "Decline an applicant","logout"};
    private String[] adminMenuOptions = {"Add admin", "Remove admin", "Remove Student", "Remove Employer", "Remove company"};
    private Scanner scanner;
    private JobSystem jobSystem;

    JobSearcherUI(){
        scanner = new Scanner(System.in);
        jobSystem = new JobSystem();
    }

    public void run(){
        System.out.println(WELCOME_MESSAGE);
        System.out.println(LOG_IN_MESSAGE);
            
        int userCommand = getUserCommand(NUM_LOGIN_COMMANDS);
        if(userCommand == -1){
            System.out.println("Not a valid command, Try again");
            System.exit(0);
        }
        switch(userCommand){
            case(1):
                studentLogin();
            case(2):
                employerLogin();
            case(3):
                createUser();
        }
    }
    private int getUserCommand(int numCommands) {
		String input = scanner.nextLine();
		int command = Integer.parseInt(input);
        if(command >= 0 && command <= numCommands) return command;
		
		return -1;
    }
    private void studentLogin(){
        System.out.println("Enter username");
        String input = scanner.nextLine();

    }
    private void employerLogin(){
        System.out.println("Enter username");
        String input = scanner.nextLine();
    }
    private void createUser(){

    }
    public static void main(String[] args){
        JobSearcherUI jobSearcherInterface = new JobSearcherUI();
        jobSearcherInterface.run();
    }
}
