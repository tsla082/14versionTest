package com.doapps.luis.a14versiontest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.doapps.luis.a14versiontest.R;
import com.doapps.luis.a14versiontest.beanDTO.Student;
import com.doapps.luis.a14versiontest.service.StudentService;
import com.doapps.luis.a14versiontest.util.LineChartUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    private List<Line> lines = new ArrayList<Line>();
    private List<PointValue> pointValueList_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initUIEvents();
    }

    /**
     * method to initialize ui elements
     */
    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        line_chart_view = (LineChartView) findViewById(R.id.chart);

        lineChartUtil = new LineChartUtil(MainActivity.this, data);
        studentService = new StudentService(MainActivity.this);
        studentService.getAllStudents();
    }

    /**
     * method to initialize ui elements events
     */
    private void initUIEvents() {
        studentService.initGetAllStudentInterface(new StudentService.studentGetAllInterface() {
            @Override
            public void IgetAllStudents(JSONArray jsonArray) {
                try {
                    Log.e(TAG, "cantidad de datos en el array : " + jsonArray.length());
                    String id = "";
                    pointValueList_ = new ArrayList<PointValue>();
                    //Line line_ = null;

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = (JSONObject) jsonArray.get(i);
                        Student student = new Student();
                        student.setId(obj.getString("id"));
                        student.setName(obj.getString("name"));
                        student.setScore(obj.getString("score"));

                        if (!student.getName().isEmpty() && !student.getId().isEmpty() && !student.getScore().isEmpty()) {
                            pointValueList_.add(new PointValue(i * 10, Integer.parseInt(student.getScore())));
                        } else {
                            Log.d(TAG, "pos : " + i + " id or name were empty");
                        }
                    }

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

                    Viewport viewport = lineChartUtil.initViewPort(300, 300);

                    line_chart_view.startDataAnimation(300);
                    line_chart_view.setMaximumViewport(viewport);
                    line_chart_view.setCurrentViewport(viewport);
                    line_chart_view.setViewportCalculationEnabled(false);

                } catch (Exception e) {
                    e.getMessage();
                    e.printStackTrace();
                }
            }
        });
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
