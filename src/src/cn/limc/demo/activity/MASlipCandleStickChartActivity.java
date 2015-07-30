/*
 * MASlipCandleStickChartActivity.java
 * Android-Charts Demo
 *
 * Created by limc on 2014/04/29.
 *
 * Copyright 2014 limc.cn All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.limc.demo.activity;

import java.util.ArrayList;
import java.util.List;

import cn.limc.androidcharts.R;
import cn.limc.androidcharts.component.Axis;
import cn.limc.androidcharts.entity.ChartDataSet;
import cn.limc.androidcharts.entity.ChartDataTable;
import cn.limc.androidcharts.entity.DateValueEntity;
import cn.limc.androidcharts.entity.LineEntity;
import cn.limc.androidcharts.event.IZoomable;
import cn.limc.androidcharts.view.MASlipCandleStickChart;
import cn.limc.demo.common.BaseActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Menu;

public class MASlipCandleStickChartActivity extends BaseActivity {

    MASlipCandleStickChart maslipcandlestickchart;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maslip_candle_stick_chart);
        
        initMASlipCandleStickChart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maslip_candle_stick_chart, menu);
        return true;
    }
    
    private void initMASlipCandleStickChart() {
        this.maslipcandlestickchart = (MASlipCandleStickChart) findViewById(R.id.maslipcandlestickchart);
        ChartDataSet lines = new ChartDataSet();

        // 计算5日均线
        LineEntity ma5 = new LineEntity();
        ma5.setTitle("MA5");
        ma5.setLineColor(Color.WHITE);
        ma5.setTableData(initMA(5));
        lines.add(ma5);

        // 计算10日均线
        LineEntity ma10 = new LineEntity();
        ma10.setTitle("MA10");
        ma10.setLineColor(Color.CYAN);
        ma10.setTableData(initMA(10));
        lines.add(ma10);

        // 计算25日均线
        LineEntity ma25 = new LineEntity();
        ma25.setTitle("MA25");
        ma25.setLineColor(Color.BLUE);
        ma25.setTableData(initMA(25));
        lines.add(ma25);

        maslipcandlestickchart.setAxisXColor(Color.LTGRAY);
        maslipcandlestickchart.setAxisYColor(Color.LTGRAY);
        maslipcandlestickchart.setLatitudeColor(Color.GRAY);
        maslipcandlestickchart.setLongitudeColor(Color.GRAY);
        maslipcandlestickchart.setBorderColor(Color.LTGRAY);
        maslipcandlestickchart.setLongitudeFontColor(Color.WHITE);
        maslipcandlestickchart.setLatitudeFontColor(Color.WHITE);

        // 最大纬线数
        maslipcandlestickchart.setLatitudeNum(5);
        // 最大经线数
        maslipcandlestickchart.setLongitudeNum(3);
        // 最大价格
        maslipcandlestickchart.setMaxValue(1200);
        // 最小价格
        maslipcandlestickchart.setMinValue(200);

        maslipcandlestickchart.setDisplayFrom(10);

        maslipcandlestickchart.setDisplayNumber(30);

        maslipcandlestickchart.setMinDisplayNumber(5);

        maslipcandlestickchart.setZoomBaseLine(IZoomable.ZOOM_BASE_LINE_CENTER);

        maslipcandlestickchart.setDisplayLongitudeTitle(true);
        maslipcandlestickchart.setDisplayLatitudeTitle(true);
        maslipcandlestickchart.setDisplayLatitude(true);
        maslipcandlestickchart.setDisplayLongitude(true);
        maslipcandlestickchart.setBackgroundColor(Color.BLACK);

        maslipcandlestickchart.setDataQuadrantPaddingTop(5);
        maslipcandlestickchart.setDataQuadrantPaddingBottom(5);
        maslipcandlestickchart.setDataQuadrantPaddingLeft(5);
        maslipcandlestickchart.setDataQuadrantPaddingRight(5);
//      maslipcandlestickchart.setAxisYTitleQuadrantWidth(50);
//      maslipcandlestickchart.setAxisXTitleQuadrantHeight(20);
        maslipcandlestickchart
                .setAxisXPosition(Axis.AXIS_X_POSITION_BOTTOM);
        maslipcandlestickchart
                .setAxisYPosition(Axis.AXIS_Y_POSITION_RIGHT);

        // 为chart2增加均线
        maslipcandlestickchart.setLinesData(lines);

        // 为chart2增加均线
        maslipcandlestickchart.setChartData(new ChartDataSet(new ChartDataTable(ohlc)));

    }

}