package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.StringBufferInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class OrderViewModel extends ViewModel {

    public static final double PRICE = 100.00;

    private MutableLiveData<Integer> _quantity = new MutableLiveData<>(0);

    private MutableLiveData<Double> _price = new MutableLiveData<>(0.0);
    public LiveData<Double> price = _price;

    private MutableLiveData<String> _flavor = new MutableLiveData<>("");
    public LiveData<String> flavor = _flavor;

    private MutableLiveData<String> _pickup_date = new MutableLiveData<>("");
    public LiveData<String> pickup_date = _pickup_date;


    public void set_quantity(int q) {
        _quantity.setValue(q);
        calc_price();
    }

    public void set_flavor(String f) {
        _flavor.setValue(f);
    }

    public void set_date(String d) {
        _pickup_date.setValue(d);
    }

    private void calc_price() {
        _price.setValue(_quantity.getValue()*PRICE);
    }

    public List<String> getDates() {
        ArrayList<String> options = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM d");
        Calendar calendar = new GregorianCalendar();
        for(int i=0; i<4; i++) {
            options.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE,1);
        }
        return options;
    }

}
