package my.edu.taruc.lab34picker;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    int age = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view)
    {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datepicker");
    }

    public void processDatePickerResult(int year, int month, int day)
    {
        TextView textViewAge = findViewById(R.id.textViewAge);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DATE);

        if (currentYear > year)
        {
            if (currentMonth > month)
            {
                age = currentYear - year;
            }
            else if  (currentMonth == month)
            {
                if (currentDay >= day)
                    age = currentYear - year;
                else
                    age = currentYear - year - 1;
            }
            else
                age = currentYear - year - 1;
        }



        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        Toast.makeText(this, getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();

        textViewAge.setText("Age : " + age);
    }

    public void calculateEligibleAmount(View view)
    {
        double EligibleAmount = 0;
        TextView textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
        EditText editTextBalance = findViewById(R.id.editTextAccountBalance);
        double currentBalance = Double.parseDouble(editTextBalance.getText().toString());

        if(age <= 20 && age >= 16)
        {
            if (currentBalance > 5000)
            {
                EligibleAmount = (currentBalance - 5000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else if(age <= 25 && age >= 21)
        {
            if (currentBalance > 14000)
            {
                EligibleAmount = (currentBalance - 14000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else if(age <= 30 && age >= 26)
        {
            if (currentBalance > 29000)
            {
                EligibleAmount = (currentBalance - 29000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else if(age <= 35 && age >= 31)
        {
            if (currentBalance > 50000)
            {
                EligibleAmount = (currentBalance - 50000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else if(age <= 40 && age >= 36)
        {
            if (currentBalance > 78000)
            {
                EligibleAmount = (currentBalance - 78000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else if(age <= 45 && age >= 41)
        {
            if (currentBalance > 116000)
            {
                EligibleAmount = (currentBalance - 116000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else if(age <= 50 && age >= 46)
        {
            if (currentBalance > 165000)
            {
                EligibleAmount = (currentBalance - 165000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else if(age <= 55 && age >= 51)
        {
            if (currentBalance > 228000)
            {
                EligibleAmount = (currentBalance - 228000) * 30 / 100;
            }
            else
                EligibleAmount = 0;
        }
        else
            EligibleAmount = 0;

        textViewEligibleAmount.setText("Eligible Amount : RM " + EligibleAmount);
    }

    public void resetCalculation(View view)
    {
        TextView textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
        EditText editTextBalance = findViewById(R.id.editTextAccountBalance);
        TextView textViewAge = findViewById(R.id.textViewAge);
        Button buttonDOB = findViewById(R.id.buttonDOB);

        textViewEligibleAmount.setText(R.string.eligible_amount);
        textViewAge.setText(R.string.age);
        editTextBalance.setText("");
        buttonDOB.setText(R.string.select_date_of_birth);
    }
}
