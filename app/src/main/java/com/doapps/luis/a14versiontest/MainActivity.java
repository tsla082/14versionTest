package com.doapps.luis.a14versiontest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

//import im.dacer.androidcharts.LineView;

public class MainActivity extends AppCompatActivity {

    private LineChartView line_chart_view;
    private LineChartData data;
    private LineChartData data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
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

        List<Line> lines = initLine();

        data = initData(lines);
        //--
        List<PointValue> pointValueList = new ArrayList<>();
        PointValue pointValue1 = new PointValue(10, 30);
        pointValueList.add(pointValue1);
        PointValue pointValue2 = new PointValue(25, 20);
        pointValueList.add(pointValue2);
        PointValue pointValue3 = new PointValue(23, 70);
        pointValueList.add(pointValue3);
        PointValue pointValue4 = new PointValue(13, 69);
        pointValueList.add(pointValue4);
        PointValue pointValue5 = new PointValue(12, 41);
        pointValueList.add(pointValue5);
        PointValue pointValue6 = new PointValue(56, 35);
        pointValueList.add(pointValue6);
        PointValue pointValue7 = new PointValue(50, 12);
        pointValueList.add(pointValue7);
        PointValue pointValue8 = new PointValue(80, 100);
        pointValueList.add(pointValue8);

        Line line = new Line(pointValueList);
        line.setColor(getResources().getColor(R.color.colorPrimary));
        line.setShape(ValueShape.DIAMOND);

        lines.add(line);


        List<PointValue> pointValueList1 = new ArrayList<>();
        PointValue pointValue11 = new PointValue(10, 30);
        pointValueList.add(pointValue11);
        PointValue pointValue22 = new PointValue(20, 20);
        pointValueList.add(pointValue22);
        PointValue pointValue33 = new PointValue(30, 70);
        pointValueList.add(pointValue33);
        PointValue pointValue44 = new PointValue(40, 69);
        pointValueList.add(pointValue44);
        PointValue pointValue55 = new PointValue(50, 64);
        pointValueList.add(pointValue55);
        PointValue pointValue66 = new PointValue(60, 31);
        pointValueList.add(pointValue66);
        PointValue pointValue77 = new PointValue(70, 22);
        pointValueList.add(pointValue77);
        PointValue pointValue88 = new PointValue(80, 100);
        pointValueList1.add(pointValue88);


        Line line1 = new Line(pointValueList);
        line1.setColor(getResources().getColor(R.color.colorAccent));
        line1.setShape(ValueShape.CIRCLE);
        lines.add(line);


        //---
        line_chart_view.setLineChartData(data);

        Viewport viewport = initViewPort();

        line_chart_view.setMaximumViewport(viewport);
        line_chart_view.setCurrentViewport(viewport);
    }

    private Viewport initViewPort() {
        Viewport viewport = new Viewport();
        viewport.top = 100;
        viewport.bottom = 0;
        viewport.left = 0;
        viewport.right = 90;

        return viewport;
    }

    private List<Line> initLine() {
        List<Line> lineList = new ArrayList<>();

        List<PointValue> pointValueList = new ArrayList<>();
        PointValue pointValue1 = new PointValue(10, 30);
        pointValueList.add(pointValue1);
        PointValue pointValue2 = new PointValue(20, 20);
        pointValueList.add(pointValue2);
        PointValue pointValue3 = new PointValue(30, 70);
        pointValueList.add(pointValue3);
        PointValue pointValue4 = new PointValue(40, 69);
        pointValueList.add(pointValue4);
        PointValue pointValue5 = new PointValue(50, 64);
        pointValueList.add(pointValue5);
        PointValue pointValue6 = new PointValue(60, 31);
        pointValueList.add(pointValue6);
        PointValue pointValue7 = new PointValue(70, 22);
        pointValueList.add(pointValue7);
        PointValue pointValue8 = new PointValue(80, 100);
        pointValueList.add(pointValue8);


        Line line = new Line(pointValueList);
        line.setColor(getResources().getColor(R.color.colorAccent));
        line.setShape(ValueShape.CIRCLE);
        lineList.add(line);

        return lineList;
    }

    private List<Line> initLine1() {
        List<Line> lineList = new ArrayList<>();

        List<PointValue> pointValueList = new ArrayList<>();
        PointValue pointValue1 = new PointValue(10, 30);
        pointValueList.add(pointValue1);
        PointValue pointValue2 = new PointValue(25, 20);
        pointValueList.add(pointValue2);
        PointValue pointValue3 = new PointValue(23, 70);
        pointValueList.add(pointValue3);
        PointValue pointValue4 = new PointValue(13, 69);
        pointValueList.add(pointValue4);
        PointValue pointValue5 = new PointValue(12, 41);
        pointValueList.add(pointValue5);
        PointValue pointValue6 = new PointValue(56, 35);
        pointValueList.add(pointValue6);
        PointValue pointValue7 = new PointValue(50, 12);
        pointValueList.add(pointValue7);
        PointValue pointValue8 = new PointValue(80, 100);
        pointValueList.add(pointValue8);

        Line line = new Line(pointValueList);
        line.setColor(getResources().getColor(R.color.colorPrimary));
        line.setShape(ValueShape.DIAMOND);
        lineList.add(line);

        return lineList;
    }

    private LineChartData initData(List<Line> lines) {

        LineChartData data = new LineChartData(lines);
        Axis axisX = new Axis();
        Axis axisY = new Axis().setHasLines(true);

        axisX.setName("时间");
        axisY.setName("销量");

        data.setAxisYLeft(axisY);
        data.setAxisXBottom(axisX);

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
