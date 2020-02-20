package lesson_2.printing;

class Programm{
    public static void main(String[] args){
        Report printReport = new Report(new PrintReport());
        Report displayReport = new Report(new DisplayReport());
        printReport.calculate();
        displayReport.calculate();
        printReport.output();
        displayReport.output();
    }
}