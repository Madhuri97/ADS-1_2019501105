import java.util.Scanner;

public class Student {
    String name;
    int math;
    int science;
    int social;

    Student() { }

    public Student(String name, int math, int science, int social) {
        this.name = name;
        this.math = math;
        this.science = science;
        this.social = social;
    }

    public String toString() {
        return " "+this.name+" "+this.math+" "+this.science+" "+this.social;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String no = sc.nextLine();
        int n = Integer.parseInt(no);
        Student stu[] = new Student[n]; 
        
        for(int i = 0 ;i < n; i++) {
            String name = sc.next();
            int Math = sc.nextInt();
            int Science = sc.nextInt();
            int Social = sc.nextInt();
            Student s = new Student(name, Math, Science, Social);
            stu[i] = s;

        }
        for(int k = 0; k < n; k++) {
        System.out.println(stu[k]);
        }
        // System.out.println(Arrays.toString(stu));
        sc.close();
    }
}