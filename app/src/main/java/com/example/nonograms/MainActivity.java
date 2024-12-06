package com.example.nonograms;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // 화면 보여주는 부분!!
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        // tableRow랑 TextView는 자바로 직접 추가
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        Random random = new Random();

        // 8개의 tableRow 추가하기
        for(int i=0;i<8;i++){
            TableRow tableRow = new TableRow(this);
            tableLayout.addView(tableRow);

            //크기 조정 중!!
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            layoutParams.setMargins(5,5,5,5);

            // TextView와 Button 추가 - 첫 3줄은 Textview가 8, 나머지는 Textview = 3, button = 5
            if(i<3){
                for(int j=0;j<8;j++){
                    TextView textView = new TextView(this);
                    textView.setText("T"+j);
                    textView.setLayoutParams(layoutParams);
                    tableRow.addView((textView));
                }
            }
            else{
                int consecutive = 0; // 연속된 Black
                for(int j=0;j<3;j++){
                    TextView textViews = new TextView(this);
                    textViews.setText("T"+j);
                    textViews.setLayoutParams(layoutParams);
                    tableRow.addView(textViews);
                }
                for(int j=0;j<5;j++){
                    Button buttons = new Button(this);
                    if(random.nextBoolean()){
                        buttons.setText("b");
                        consecutive++;
                    }
                    else
                        buttons.setText("");

                    //buttons.setText("B"+j);
                    buttons.setLayoutParams(layoutParams);
                    tableRow.addView(buttons);
                }
            }

        }


    }
}