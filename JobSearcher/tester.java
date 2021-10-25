package JobSearcher;

public class tester {
    public static void main(String Args[]) {
        Companies c = Companies.getInstance();
        System.out.println(c.haveCompany("Google"));
    }
}
