package com.doapps.luis.a14versiontest.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.doapps.luis.a14versiontest.R;
import com.doapps.luis.a14versiontest.beanDTO.Student;
import com.doapps.luis.a14versiontest.service.StudentService;
import com.doapps.luis.a14versiontest.util.LineChartUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;

import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LineChartView line_chart_view;
    private LineChartData data;

    private LineChartUtil lineChartUtil;
    private StudentService studentService;

    List<Line> lines = new ArrayList<Line>();
    List<PointValue> pointValueList_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        line_chart_view = (LineChartView) findViewById(R.id.chart);

        lineChartUtil = new LineChartUtil(MainActivity.this, data);
        studentService = new StudentService(MainActivity.this);
        studentService.getAllStudents();


        studentService.initGetAllStudentInterface(new StudentService.studentGetAllInterface() {
            @Override
            public void IgetAllStudents(JSONArray jsonArray) {
                try {
                    String id = "";
                    pointValueList_ = new ArrayList<PointValue>();
                    //Line line_ = null;

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject obj=(JSONObject) jsonArray.get(i);
                        Student student = new Student();
                        student.setId(obj.getString("id"));
                        student.setName(obj.getString("name"));
                        student.setScore(obj.getString("score"));

                        if (!student.getName().isEmpty() && !student.getId().isEmpty() &&  !student.getScore().isEmpty()) {
                            pointValueList_.add(new PointValue(i * 10, Integer.parseInt(student.getScore())));

                        }
                        else {
                            Log.d(TAG, "pos : " + i + " id or name were empty");
                        }
                    }

                    /*
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject obj=(JSONObject) jsonArray.get(i);
                        Student student = new Student();
                        student.setId(obj.getString("id"));
                        student.setName(obj.getString("name"));
                        student.setScore(obj.getString("score"));

                       // if (!student.getName().isEmpty() && !student.getId().isEmpty() &&  !student.getScore().isEmpty()) {
                        if (  !student.getScore().isEmpty()) {

                            if (!id.equals(student.getId())) {
                                // instance new object
                                pointValueList_ = new ArrayList<PointValue>();
                                pointValueList_.add(new PointValue(i * 10, Integer.parseInt(student.getScore())));
                                line_ = new Line(pointValueList_);
                                lines.add(line_);

                                id = student.getId();
                            } else {
                                //normal process
                                id = student.getId();
                                pointValueList_.add(new PointValue(i * 10, Integer.parseInt(student.getScore())));
                                lines.add(line_);
                            }

                        } else {
                            Log.d(TAG, "pos : " + i + " id or name were empty");
                        }
                    }
                    */


                } catch (Exception e) {
                    e.getMessage();
                    e.printStackTrace();
                }
                finally {

                    Line line_ = new Line(pointValueList_);
                    lines.add(line_);

                    ArrayList<String> xValues = new ArrayList<String>();
                    xValues.add("0");
                    xValues.add("1");
                    xValues.add("2");
                    xValues.add("3");
                    xValues.add("4");
                    xValues.add("5");
                    xValues.add("6");
                    xValues.add("7");
                    xValues.add("8");
                    xValues.add("9");
                    xValues.add("10");
                    xValues.add("11");
                    xValues.add("12");
                    xValues.add("13");
                    xValues.add("14");
                    xValues.add("15");
                    xValues.add("16");
                    xValues.add("17");
                    xValues.add("18");
                    xValues.add("19");
                    xValues.add("20");
                    xValues.add("21");
                    xValues.add("22");
                    xValues.add("23");
                    xValues.add("24");
                    xValues.add("25");
                    xValues.add("26");
                    xValues.add("27");
                    xValues.add("28");
                    xValues.add("29");
                    xValues.add("30");

                    lineChartUtil.addDataLine(xValues, lines);
                    line_chart_view.setLineChartData(lineChartUtil.data);

                    Viewport viewport = lineChartUtil.initViewPort();

                    line_chart_view.startDataAnimation(300);
                    line_chart_view.setMaximumViewport(viewport);
                    line_chart_view.setCurrentViewport(viewport);
                    line_chart_view.setViewportCalculationEnabled(false);
                }
            }
        });
        //-----------------------------------------

        /*/--
        List<PointValue> pointValueList = new ArrayList<PointValue>();
        PointValue pointValue5 = new PointValue(12, 41);
        pointValueList.add(pointValue5);

        PointValue pointValue6 = new PointValue(56, 35);
        pointValueList.add(pointValue6);

        PointValue pointValue7 = new PointValue(50, 12);
        pointValueList.add(pointValue7);

        PointValue pointValue8 = new PointValue(80, 80);
        pointValueList.add(pointValue8);

        Line line = new Line(pointValueList);
        lines.add(line);


        List<PointValue> pointValueList1 = new ArrayList<PointValue>();
        PointValue pointValue11 = new PointValue(10, 30);
        pointValueList1.add(pointValue11);
        PointValue pointValue22 = new PointValue(20, 20);
        pointValueList1.add(pointValue22);
        PointValue pointValue33 = new PointValue(30, 70);
        pointValueList1.add(pointValue33);
        PointValue pointValue44 = new PointValue(40, 69);
        pointValueList1.add(pointValue44);


        Line line1 = new Line(pointValueList1);
        lines.add(line1);

        List<PointValue> pointValueList11 = new ArrayList<PointValue>();
        PointValue pointValue111 = new PointValue(14, 30);
        pointValueList11.add(pointValue111);
        PointValue pointValue222 = new PointValue(25, 22);
        pointValueList11.add(pointValue222);
        PointValue pointValue333 = new PointValue(31, 75);
        pointValueList11.add(pointValue333);
        PointValue pointValue444 = new PointValue(43, 65);
        pointValueList11.add(pointValue444);


        Line line2 = new Line(pointValueList11);
        lines.add(line2);


        List<PointValue> pointValueLista = new ArrayList<PointValue>();
        PointValue pointValuea = new PointValue(14, 50);
        pointValueLista.add(pointValuea);
        PointValue pointValueaa = new PointValue(35, 42);
        pointValueLista.add(pointValueaa);
        PointValue pointValueaaa = new PointValue(41, 15);
        pointValueLista.add(pointValueaaa);
        PointValue pointValueaaaa = new PointValue(53, 55);
        pointValueLista.add(pointValueaaaa);


        Line line3 = new Line(pointValueLista);
        lines.add(line3);


        List<PointValue> pointValueListb = new ArrayList<PointValue>();
        PointValue pointValueb = new PointValue(12, 54);
        pointValueListb.add(pointValueb);
        PointValue pointValuebb = new PointValue(34, 45);
        pointValueListb.add(pointValuebb);
        PointValue pointValuebbb = new PointValue(42, 16);
        pointValueListb.add(pointValuebbb);
        PointValue pointValuebbbb = new PointValue(54, 55);
        pointValueListb.add(pointValuebbbb);


        Line line4 = new Line(pointValueListb);
        lines.add(line4);
        //-----------------------------------------
        ArrayList<String> xValues = new ArrayList<String>();
        xValues.add("0");
        xValues.add("1");
        xValues.add("2");
        xValues.add("3");
        xValues.add("4");
        xValues.add("5");
        xValues.add("6");
        xValues.add("7");
        xValues.add("8");
        xValues.add("9");
        xValues.add("10");
        //----------------------------------------- */

        // lineChartUtil.addDataLine(xValues, lines);

        //line_chart_view.setLineChartData(lineChartUtil.data);

       /* Viewport viewport = lineChartUtil.initViewPort();

        line_chart_view.startDataAnimation(300);
        line_chart_view.setMaximumViewport(viewport);
        line_chart_view.setCurrentViewport(viewport);
        line_chart_view.setViewportCalculationEnabled(false);
        */
    }


    /**
     * default activity template method
     *
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * default activity template method
     *
     * @return true
     * @item MenuItem
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
