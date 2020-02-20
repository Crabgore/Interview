package lesson_2.printing;

import java.util.List;

class PrintReport implements ShowReport{
    public void output(List<ReportItem> items){
        System.out.println("Output to printer");
        for(ReportItem item : items){
            System.out.format("printer %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}