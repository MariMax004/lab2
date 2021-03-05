import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

public class DrawChart {
    public void draw(long a, long b){
        DefaultCategoryDataset line_chart = new DefaultCategoryDataset();

        for(long i = a-1; i <= b+1; i++){
            line_chart.addValue(Math.pow(i,3) - 3.125*Math.pow(i,2) - 3.5*i + 2.458,
                    "fun", String.valueOf(i));
        }

        /*for(long i = a-1; i <= b+1; i++){
            line_chart.addValue(i*i,
                    "fun2", String.valueOf(i));
        }*/


        JFreeChart lineChart = ChartFactory.createLineChart(
                "f(x)", "x", "y",
                line_chart, PlotOrientation.VERTICAL,
                true,true,false
        );

        int width = 1920;
        int height = 1080;
        File lineChartFile = new File("Chart.jpeg");

        try {
            ChartUtilities.saveChartAsJPEG(lineChartFile, lineChart, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMethod3(double a, double b, double e){
        Method3 method3 = new Method3();
        method3.startMethod(a,b,e,true);

        DefaultCategoryDataset line_chart = new DefaultCategoryDataset();

        for(long i = Math.round(a)-1; i <= Math.round(b)+1; i++){
            line_chart.addValue(method3.F(i),
                    "fun", String.valueOf(i));
        }

        for(long i = Math.round(a)-1; i <= Math.round(b)+1; i++){
            line_chart.addValue(i,
                    "line", String.valueOf(i));
        }


        JFreeChart lineChart = ChartFactory.createLineChart(
                "f(x)", "x", "y",
                line_chart, PlotOrientation.VERTICAL,
                true,true,false
        );

        int width = 1920;
        int height = 1080;
        File lineChartFile = new File("Chart.jpeg");

        try {
            ChartUtilities.saveChartAsJPEG(lineChartFile, lineChart, width, height);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
