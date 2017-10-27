package com.example.averagebalancecalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.averagebalancecalculator.adapter.DateAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mAccountNumber;
    private RecyclerView mRecyclerViewDate;
    private List<Integer> mDateList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccountNumber = findViewById(R.id.account_number);

        int day = numberOfDaysInMonth();
        int days[];

        //= new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

//        mDateList = new ArrayList<>(day);
//        mDateList.add(new Date());

        Log.e("days", String.valueOf(day));
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mRecyclerViewDate = findViewById(R.id.balance_calculator);
        mRecyclerViewDate.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        try {
            days = new int[day];
            List<Integer> listDays = new ArrayList<>();
            for (int i = 0; i < days.length; i++) {
                Log.e("i", String.valueOf(i + 1));
//            mDateList = new ArrayList<>();
//            mDateList.add(i);

                listDays.add(i, i + 1);

                days[i] = i + 1;

//                Log.e("days[" + i + "]", String.valueOf(listDays.get(i + 1)));
                if (mRecyclerViewDate.getAdapter() == null) {
                    mRecyclerViewDate.setAdapter(new DateAdapter(listDays, R.layout.row_item, getApplicationContext()));
                }
            }
        } catch (ArrayIndexOutOfBoundsException aIOoBE) {
            aIOoBE.printStackTrace();
            Log.e("aIOoBE", aIOoBE.toString());
        } catch (IndexOutOfBoundsException iOoBE) {
            iOoBE.printStackTrace();
            Log.e("iOoBE", String.valueOf(iOoBE));
        }
    }

    /***
     *
     * @return
     * Returns the total number of days in the current month
     *
     */
    public static int numberOfDaysInMonth() {
        Calendar monthStart = Calendar.getInstance();
        return monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

}
