import java.util.Scanner;

public class FileName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // String first = scan.next();
        // String second = scan.next();
        // String first = scan.nextLine();
        // int second = scan.nextInt();
        // int third = scan.nextInt();
        // double fourth = scan.nextDouble();
        // String fifth = scan.next();        
        // String input = scan.nextLine();
        // System.out.println(input);
        // System.out.println(first);
        // System.out.println(second);
        // System.out.println(third);
        // System.out.println(fourth);
        // System.out.println(fifth);
        String noOfLines = scan.nextLine();
        int n = Integer.parseInt(noOfLines);
        for(int i = 0; i < n; i++) {
            String name = scan.next();
            double Math = scan.nextDouble();
            double science = scan.nextDouble();
            double social = scan.nextDouble();
            double english = scan.nextDouble();
        }
        // int n = scan.nextInt();
        // String second = scan.nextLine();
        // String third = scan.nextLine();
        // System.out.println(n);
        // System.out.println(second);
        // String[] A = new String[n];
        // int i = 0;
        // while(i < n){
        //     A[i] = scan.next();
        // }
        //     System.out.println("Name        Math        Science     Social");
    //     String n;
    //     int m;
    //     int s;
    //     int so;
    //     Scanner scan=new Scanner(System.in);
    //     // Student obj=new Student();
    //     int nOFe=scan.nextInt();
    //     for(int i=0;i<nOFe;i++){
    //         for (int j=0;j<4;j++){

    //             if(j == 0){
    //                 n=scan.nextLine();
    //             }
    //             if(j == 1){
    //                 m = scan.nextInt();
    //             }
    //             if(j == 2) {
    //                 s = scan.nextInt();
    //             }
    //             if(j == 3) {
    //                 so = scan.nextInt();
    //             }
    //         }
    //         Student obj=new Student(n,m,s,so);
    //         System.out.println(obj.toString());
    //     }
    // }
    }
}