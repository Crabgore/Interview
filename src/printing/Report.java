package printing;

import java.util.ArrayList;
import java.util.List;

class Report{
    private List<ReportItem> items; // Отчетные данные
    private ShowReport showReport;

    public Report(ShowReport showReport) {
        this.showReport = showReport;
    }

    // расчет отчетных данных
    public void calculate(){
        items =  new ArrayList<ReportItem>();
        items.add(new ReportItem("First", (float)5));
        items.add(new ReportItem("Second", (float)6));
    }

    public void output(){
        showReport.output(items);
    }
}