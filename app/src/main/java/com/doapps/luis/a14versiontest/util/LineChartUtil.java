package com.doapps.luis.a14versiontest.util;

import android.content.Context;
import android.graphics.Color;

import com.doapps.luis.a14versiontest.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.Viewport;

/**
 * Created by Luis alberto on 21/07/2016.
 */
public class LineChartUtil {

    private Context context ;
    public LineChartData data;

    /**
     * method to build an instance of the service
     * @param context ==> class.this
     * @param data data which represent data to a linearchart
     */
    public LineChartUtil(Context context,LineChartData data){
        this.context=context;
        this.data=data;
    }

    /**
     * method to add values to arraylines
     * @param xValues
     * @param lines
     */
    public void addDataLine(ArrayList<String> xValues, List<Line> lines) {

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        for(int i=0;i<xValues.size();i++){
            axisValues.add(new AxisValue(i*10).setLabel(xValues.get(i)));
        }
        /*
        axisValues.add(new AxisValue(0).setLabel(""));
        axisValues.add(new AxisValue(10).setLabel("6"));
        axisValues.add(new AxisValue(20).setLabel("12"));
        axisValues.add(new AxisValue(30).setLabel("16"));
        axisValues.add(new AxisValue(40).setLabel("23"));
        axisValues.add(new AxisValue(50).setLabel("25"));
        axisValues.add(new AxisValue(60).setLabel("28"));
        axisValues.add(new AxisValue(70).setLabel("35"));
        axisValues.add(new AxisValue(80).setLabel("45"));
        axisValues.add(new AxisValue(90).setLabel("56"));
        axisValues.add(new AxisValue(100).setLabel("67"));
        */
        /*
        List<Line> lines = new ArrayList<Line>();

        //--
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
        //--- add data list 5 lines ---//
        */
        addArrayLines(lines, axisValues);
    }

    /**
     * method to add lines and list of axisValues
     * @param Lines
     * @param axisValues
     */
    public void addArrayLines(List<Line> Lines, List<AxisValue> axisValues) {
        try {
            if (Lines.size() > 0 && !Lines.isEmpty()) {
                for (int i = 0; i < Lines.size(); i++) {
                    Line line = Lines.get(i);
                    line.setHasPoints(false);
                    line.setCubic(true);
                    line.setStrokeWidth(2);

                    if (i == 0) {
                        line.setColor(context.getResources().getColor(R.color.colorRed));
                    } else if (i == 1) {
                        line.setColor(context.getResources().getColor(R.color.colorGreen));
                    } else if (i == 2) {
                        line.setColor(context.getResources().getColor(R.color.colorBlue));
                    } else if (i == 3) {
                        line.setColor(context.getResources().getColor(R.color.colorBlack));
                    } else if (i == 4) {
                        line.setColor(context.getResources().getColor(R.color.colorBrown));
                    } else {
                        line.setColor(context.getResources().getColor(R.color.colorNeutral));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data = initData(Lines, axisValues);
        }
    }

    /**
     * method to set the ViewPort
     * @return
     */
    public Viewport initViewPort() {
        Viewport viewport = new Viewport();
        viewport.top = 300;
        viewport.bottom = 0;
        viewport.left = 0;
        viewport.right = 300;

        return viewport;
    }

    /**
     * method that initialice and set default rule X and Y titles and styles
     * @param lines
     * @param axisValues
     * @return a LineChartData
     */
    public LineChartData initData(List<Line> lines, List<AxisValue> axisValues) {

        LineChartData data = new LineChartData(lines);
        data.setAxisXBottom(new Axis(axisValues).setHasLines(true).setLineColor(Color.BLACK).setTextColor(Color.BLACK).setName("Notas"));
        data.setAxisYLeft(new Axis().setHasLines(true).setLineColor(Color.BLACK).setTextColor(Color.BLACK).setMaxLabelChars(3).setName("Alturas Arbitrarias"));

        return data;
    }

}
