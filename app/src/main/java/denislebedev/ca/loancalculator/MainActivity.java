package denislebedev.ca.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LoanCalculator loanCal;
    private TextView displayMonthPaym,
            displayTotalPaym, displayTotalInterest;
    private EditText loanAmount, totalYears, yearlyInterestRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayMonthPaym = (TextView) findViewById(R.id.monthPaym);
        displayTotalPaym = (TextView) findViewById(R.id.totalPaym);
        displayTotalInterest = (TextView) findViewById(R.id.totalInterest);

        loanAmount= (EditText) findViewById(R.id.loanAmount);
        totalYears= (EditText) findViewById(R.id.loanYear);
        yearlyInterestRate= (EditText) findViewById(R.id.yearInterest);

        loanCal = new LoanCalculator();
    }



    public void calculate(View view) {

        loanCal.setLoanAmount(Double.parseDouble(loanAmount.getText().toString()));
        loanCal.setNumberOfYears(Integer.parseInt(totalYears.getText().toString()));
        loanCal.setYearlyInterestRate(Double.parseDouble(yearlyInterestRate.getText()
                .toString()));

        displayMonthPaym.setText(Double.toString(Math.round(
                                loanCal.getMonthlyPayment() * 100) / 100.0 ));
        displayTotalPaym.setText(Double.toString(Math.round(
                                loanCal.getTotalCostOfLoan() * 100) / 100.0 ));
        displayTotalInterest.setText(Double.toString(Math.round(
                                loanCal.getTotalInterest() * 100) / 100.0 ));

    }

    public void clearApp(View view) {

        displayMonthPaym.setText("");
        displayTotalPaym.setText("");
        displayTotalInterest.setText("");

        loanAmount.setText("");
        totalYears.setText("");
        yearlyInterestRate.setText("");
    }
}
