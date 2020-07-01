package exercises.pdm_true_class_06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateAvg extends AppCompatActivity {

    private EditText txtGrade1;
    private EditText txtGrade2;
    private TextView lblAvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_avg);

        txtGrade1 = findViewById(R.id.txtGrade1);
        txtGrade2 = findViewById(R.id.txtGrade2);
        lblAvg = findViewById(R.id.lblAvg);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener( new BtnCalcListener() );
    }

    private class BtnCalcListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            double grade1, grade2, average;

            grade1 = Double.parseDouble(txtGrade1.getText().toString());
            grade2 = Double.parseDouble(txtGrade2.getText().toString());

            average = (grade1 + grade2) / 2;

            lblAvg.setText("" + average);
        }
    }
}