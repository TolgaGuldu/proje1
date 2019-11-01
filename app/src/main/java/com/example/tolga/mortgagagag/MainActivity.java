package com.example.tolga.mortgagagag;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.EditText;
        import android.widget.SeekBar;
        import android.widget.TextView;
        import java.text.DecimalFormat;

public class MainActivity extends Activity {
    private EditText HomeValue;
    private EditText Purchasprice;
    private EditText InterestRate;
    private SeekBar seekbar;
    private TextView MonthlyPayment;
    private TextView TotalAmountofDebt;
    private TextView Capital;
    private TextView DistinctionBetween;
    private TextView years;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar= (SeekBar) findViewById(R.id.seekBar);
        years = (TextView) findViewById(R.id.TextView);
        HomeValue = (EditText) findViewById(R.id.HomeValue);
        Purchasprice = (EditText) findViewById(R.id.Purchasprice);
        InterestRate = (EditText) findViewById(R.id.InterestRate);
        MonthlyPayment = (TextView) findViewById(R.id.MonthlyPayment);
        TotalAmountofDebt = (TextView) findViewById(R.id.TotatAmonutofDebt);
        Capital = (TextView) findViewById(R.id.Capital);
        DistinctionBetween = (TextView) findViewById(R.id.DistinctionBetween);

        seekbar.setMax(30);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                years.setText("SeekBar Değeri : " + progress);
            }
        });



    }


    private void showResult(){
        double homevalue = Integer.parseInt(HomeValue.getText().toString());
        double purchasprice = Integer.parseInt(Purchasprice.getText().toString());
        double interestrate = Integer.parseInt(InterestRate.getText().toString());
        double loanperiods = Integer.parseInt(years.getText().toString());
        double a = interestrate/1200;
        double a1 = Math.pow(a+1,loanperiods);

        double monthly = (double) (a+(a/(a1-1)) * (homevalue-purchasprice));
        double total=monthly*loanperiods;

        double capital= homevalue;
        double between= total-homevalue;

        MonthlyPayment.setText(new DecimalFormat("##.##").format(monthly));
        TotalAmountofDebt.setText(new DecimalFormat("##.##").format(total));
        Capital.setText(new DecimalFormat("##.##").format(capital));
        DistinctionBetween.setText(new DecimalFormat("##.##").format(between));



    }


}
