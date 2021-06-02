package com.example.car_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;
 
public class MainActivity extends AppCompatActivity {

    int [] car_images_array = {R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4};
    String [] car_name = { "bugatti", "bmw","bugatti","ferrari","ford","mercedes","mercedes","ferrari","audi","rolls royce",
    "corvette","lamborghini","porsche","land rover","mclaren","porsche","mustang","mclaren","land rover","jeep",
    "jaguar","kia","koenigsegg ","range rover","tesla","aston martin","ferrari","volkswagen","ford","toyota","audi"};

    Spinner spinner;
    ImageView Car_Image;
    Button Next_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //....................................................................................
        int n = 30;
        Random rand = new Random();
         int  rndInt = rand.nextInt(n) + 1; // n = the number of images, that start at idx 1
        String imgName = "car" + rndInt;
        String Generated_car = (car_name[rndInt]);



        //...............................................................

        spinner = (Spinner) findViewById(R.id.spinner);
        Car_Image = (ImageView) findViewById(R.id.car_Image);
        Next_Button = (Button) findViewById(R.id.Next_Button);

        //....................................................................................


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Car_options, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        Car_Image.setImageResource(id);



        //....................................................................................




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();



                Toast.makeText
                        (getApplicationContext(), "Selected : " + item, Toast.LENGTH_SHORT).show();
                //.....................................................................................
                Next_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Random rand = new Random();
                        int n=30;
                        int rndInt = rand.nextInt(n) +1 ; // n = the number of images, that start at idx 1
                        String imgName = "car" + rndInt;
                        String Generated_car = (car_name[rndInt]);

                        if (item.equals(Generated_car)) {
                            int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
                            Car_Image.setImageResource(id);
                            v.setOnClickListener(null);//Remove setOnClickListene
                        }
                    }
                });




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}









