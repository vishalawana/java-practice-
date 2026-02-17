package statics;

public class University {
   static String universityName = "ABC";
   static void showNmae(){
    System.out.println(universityName);
   }
   public static void main(String[] args){
    University.Department D1 = new University.Department("test1");
     University.Department D2 = new University.Department("test2");
     D1.show();
     D2.show();

     University U1 = new University();
     University.universityName = "XYZ";
     University.showNmae();
         D1.show();
     D2.show();

   }
   static class Department {
        String deptName;

        Department(String deptName) {
            this.deptName = deptName;
        }

        void show() {
            System.out.println(universityName + " - " + deptName);
        }
    }
}
