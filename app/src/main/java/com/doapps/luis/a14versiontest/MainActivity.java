package com.doapps.luis.a14versiontest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;

import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {

    private LineChartView line_chart_view;
    private LineChartData data;
    public final static String[] days = new String[]{"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        line_chart_view = (LineChartView) findViewById(R.id.chart);

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        axisValues.add(new AxisValue(0).setLabel("-A-"));
        axisValues.add(new AxisValue(10).setLabel("A"));
        axisValues.add(new AxisValue(20).setLabel("B"));
        axisValues.add(new AxisValue(30).setLabel("C"));
        axisValues.add(new AxisValue(40).setLabel("D"));
        axisValues.add(new AxisValue(50).setLabel("E"));
        axisValues.add(new AxisValue(60).setLabel("f"));
        axisValues.add(new AxisValue(70).setLabel("g"));
        axisValues.add(new AxisValue(80).setLabel("h"));
        axisValues.add(new AxisValue(90).setLabel("i"));
        axisValues.add(new AxisValue(100).setLabel("j"));


        List<Line> lines = new ArrayList<Line>();

        //--
        List<PointValue> pointValueList = new ArrayList<>();
        PointValue pointValue5 = new PointValue(12, 41);
        pointValueList.add(pointValue5);

        PointValue pointValue6 = new PointValue(56, 35);
        pointValueList.add(pointValue6);

        PointValue pointValue7 = new PointValue(50, 12);
        pointValueList.add(pointValue7);

        PointValue pointValue8 = new PointValue(80, 80);
        pointValueList.add(pointValue8);

        Line line = new Line(pointValueList);
        //line.setCubic(true);
        lines.add(line);


        List<PointValue> pointValueList1 = new ArrayList<>();
        PointValue pointValue11 = new PointValue(10, 30);
        pointValueList1.add(pointValue11);
        PointValue pointValue22 = new PointValue(20, 20);
        pointValueList1.add(pointValue22);
        PointValue pointValue33 = new PointValue(30, 70);
        pointValueList1.add(pointValue33);
        PointValue pointValue44 = new PointValue(40, 69);
        pointValueList1.add(pointValue44);


        Line line1 = new Line(pointValueList1);
        //line.setCubic(true);
        lines.add(line1);

        List<PointValue> pointValueList11 = new ArrayList<>();
        PointValue pointValue111 = new PointValue(14, 30);
        pointValueList11.add(pointValue111);
        PointValue pointValue222 = new PointValue(25, 22);
        pointValueList11.add(pointValue222);
        PointValue pointValue333 = new PointValue(31, 75);
        pointValueList11.add(pointValue333);
        PointValue pointValue444 = new PointValue(43, 65);
        pointValueList11.add(pointValue444);


        Line line2 = new Line(pointValueList11);
        //line.setCubic(true);
        lines.add(line2);


        List<PointValue> pointValueLista = new ArrayList<>();
        PointValue pointValuea = new PointValue(14, 50);
        pointValueLista.add(pointValuea);
        PointValue pointValueaa = new PointValue(35, 42);
        pointValueLista.add(pointValueaa);
        PointValue pointValueaaa = new PointValue(41, 15);
        pointValueLista.add(pointValueaaa);
        PointValue pointValueaaaa = new PointValue(53, 55);
        pointValueLista.add(pointValueaaaa);


        Line line3 = new Line(pointValueLista);
        //line.setCubic(true);
        lines.add(line3);


        List<PointValue> pointValueListb = new ArrayList<>();
        PointValue pointValueb = new PointValue(12, 54);
        pointValueListb.add(pointValueb);
        PointValue pointValuebb = new PointValue(34, 45);
        pointValueListb.add(pointValuebb);
        PointValue pointValuebbb = new PointValue(42, 16);
        pointValueListb.add(pointValuebbb);
        PointValue pointValuebbbb = new PointValue(54, 55);
        pointValueListb.add(pointValuebbbb);


        Line line4 = new Line(pointValueListb);
        //line.setCubic(true);
        lines.add(line4);
        //--- add data list 5 lines ---//
             addArrayLines(lines, axisValues);


            line_chart_view.setLineChartData(data);

            Viewport viewport = initViewPort();

            line_chart_view.startDataAnimation(300);
            line_chart_view.setMaximumViewport(viewport);
            line_chart_view.setCurrentViewport(viewport);
            line_chart_view.setViewportCalculationEnabled(false);


    }


    private void addArrayLines(List<Line> Lines, List<AxisValue> axisValues) {

        try {
            if (Lines.size() > 0 && !Lines.isEmpty()) {
                for (int i = 0; i < Lines.size(); i++) {
                    Line line = Lines.get(i);
                    //line1.setShape(ValueShape.CIRCLE);
                    line.setHasPoints(false);
                    //line1.setFilled(false);
                    line.setStrokeWidth(2);

                    if (i == 0) {
                        line.setColor(getResources().getColor(R.color.colorRed));
                    } else if (i == 1) {
                        line.setColor(getResources().getColor(R.color.colorGreen));
                    } else if (i == 2) {
                        line.setColor(getResources().getColor(R.color.colorBlue));
                    } else if (i == 3) {
                        line.setColor(getResources().getColor(R.color.colorBlack));
                    } else if (i == 4) {
                        line.setColor(getResources().getColor(R.color.colorBrown));
                    } else {
                        line.setColor(getResources().getColor(R.color.colorNeutral));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data = initData(Lines, axisValues);
        }

    }

    private Viewport initViewPort() {
        Viewport viewport = new Viewport();
        viewport.top = 100;
        viewport.bottom = 0;
        viewport.left = 0;
        viewport.right = 100;

        return viewport;
    }

    private LineChartData initData(List<Line> lines, List<AxisValue> axisValues) {

        LineChartData data = new LineChartData(lines);
        /*
        Axis axisX = new Axis(axisValues);
        Axis axisY = new Axis();

        axisX.setTextColor(Color.BLACK);
        axisX.setLineColor(Color.BLACK);
        axisX.setHasLines(true);

        axisY.setTextColor(Color.BLACK);
        axisY.setLineColor(Color.BLACK);
        axisY.setHasLines(true);

        axisX.setName("Dias");
        axisY.setName("Alturas Arbitrarias");

        data.setAxisYLeft(axisY);
        data.setAxisXBottom(axisX);
        */
        data.setAxisXBottom(new Axis(axisValues)
                .setHasLines(true)
                .setLineColor(Color.BLACK)
                .setTextColor(Color.BLACK)
                .setName("Dias")
        );

        data.setAxisYLeft(new Axis()
                .setHasLines(true)
                .setLineColor(Color.BLACK)
                .setTextColor(Color.BLACK)
                .setMaxLabelChars(3)
                .setName("Alturas Arbitrarias")
        );

        return data;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
