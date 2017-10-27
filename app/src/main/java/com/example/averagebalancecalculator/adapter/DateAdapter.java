package com.example.averagebalancecalculator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.averagebalancecalculator.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SULTAN on 05-08-2017.
 */

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {

    private List<Integer> mDate;
    //    private int mDay;
    private int mLayout;
    private Context mContext;

    public DateAdapter(List<Integer> date, int dateLayout, Context context) {
        //int day,
        mDate = date;
//        mDay = new ArrayList<>();
//        mDay = day;
        mLayout = dateLayout;
        mContext = context;
    }

    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        return new DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DateViewHolder holder, int position) {
        holder.etDate.setText(String.valueOf(mDate.get(position)));
        Log.e("day", String.valueOf(mDate.get(position)));

        double averageBalance[] = new double[position];
//        double openingBalance;
        double closingBalance[] = new double[position];
        double sumBalance = 0.00, temp = 0.00;

//        openingBalance = Float.parseFloat(holder.tvOpeningBalance.getText().toString());
        if (!holder.etClosingBalance.getText().toString().equals("")) {
            closingBalance[position] = Double.valueOf(holder.etClosingBalance.getText().toString());
            averageBalance[position] = 0.00;

            for (int i = 0; i < position; i++) {
                sumBalance += closingBalance[i];
                averageBalance[i] = sumBalance / position;

                temp = averageBalance[i];
            }
        }
        holder.etAverageBalance.setText(String.valueOf(temp));

    }

    public float calculateAverageBalance(float balanceStart, float balanceEnd, int date) {
        return (balanceStart + balanceEnd) / date;
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder {

        TextView etDate;
        EditText etOpeningBalance, etClosingBalance, etAverageBalance;

        public DateViewHolder(View itemView) {
            super(itemView);
            etDate = itemView.findViewById(R.id.date_item);
//            tvOpeningBalance = (EditText) itemView.findViewById(R.id.opening_balance_item);
            etClosingBalance = itemView.findViewById(R.id.closing_balance_item);
            etAverageBalance = itemView.findViewById(R.id.average_balance_item);
        }
    }
}
