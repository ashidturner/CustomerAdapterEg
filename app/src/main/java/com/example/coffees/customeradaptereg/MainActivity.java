package com.example.coffees.customeradaptereg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return emp.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Employee e = emp.get(position);
            final int no= e.getlEno();
            final String name = e.getlEname();
            final String sal = e.getlEsalary();
            View v = getLayoutInflater().inflate(R.layout.row,null);
            TextView tv1 = (TextView) v.findViewById(R.id.tv1);
            TextView tv2 = (TextView) v.findViewById(R.id.tv2);
            TextView tv3 = (TextView) v.findViewById(R.id.tv3);
            CheckBox cb = (CheckBox) v.findViewById(R.id.cb1);

                tv1.setText(""+no);
                tv2.setText(name);
                tv3.setText(sal);
            tv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Employee Name is: "+name, Toast.LENGTH_SHORT).show();
                }
            });
            tv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Employee Salary is: "+sal, Toast.LENGTH_SHORT).show();
                }
            });
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, ""+no+" entry selected", Toast.LENGTH_SHORT).show();
                }
            });

            if(e!=null){

                return v;
            }
            else{
                return null;
            }

        }
    }
    ArrayList<Employee> emp;
    EditText etNo,etName,etSal;
    ListView lv;
    MyAdapter m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNo = (EditText) findViewById(R.id.editNo);
        etName = (EditText) findViewById(R.id.editName);
        etSal = (EditText) findViewById(R.id.editSalary);
        lv = (ListView) findViewById(R.id.listView);
        emp = new ArrayList<Employee>();
        m = new MyAdapter();
        lv.setAdapter(m);


    }

    public void clicked(View view) {
        String no = etNo.getText().toString();
        String name = etName.getText().toString();
        String sal = etSal.getText().toString();
        if(no.length()==0||name.length()==0||sal.length()==0){
            Toast.makeText(this, "Enter required details", Toast.LENGTH_SHORT).show();
        }
        else{
            int num = 0;
            if(no.length()!=0){
                num= Integer.parseInt(no);

            }
            Employee e= new Employee(num,name,sal);
            if(e!=null){
                emp.add(e);
                m.notifyDataSetChanged();
            }

            etNo.setText("");
            etName.setText("");
            etSal.setText("");
            etNo.requestFocus();
        }

    }
}
