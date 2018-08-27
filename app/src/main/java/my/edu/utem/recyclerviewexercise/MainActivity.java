package my.edu.utem.recyclerviewexercise;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerView);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext());
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView desctextView;
        ImageView imageView;

        public CustomViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.custom_row, parent, false));
            titleTextView = itemView.findViewById(R.id.titleTextView);
            desctextView = itemView.findViewById(R.id.descTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    //find new id by row, adapter utk link data dkt UI
    public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{


        public final String[] titleView;
        public final String[] descView;
        public final Drawable[] imageView;

        public CustomAdapter(Context context) {
            Resources resources = context.getResources();
            titleView = resources.getStringArray(R.array.title);
            descView = resources.getStringArray(R.array.description);

            TypedArray a = resources.obtainTypedArray(R.array.pictures);
            imageView = new Drawable[a.length()];
            for (int i = 0; i < imageView.length; i++) {
                imageView[i] = a.getDrawable(i);
            }
        }
        @NonNull
        @Override
        //customviewholder akan link custom row
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        }

        @Override
        //apa nk tunjuk
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            customViewHolder.titleTextView.setText(titleView[i]);
            customViewHolder.desctextView.setText(descView[i]);
            customViewHolder.imageView.setImageDrawable(imageView[i]);

        }

        @Override
        //berapa kali nk loop
        public int getItemCount() {
            return titleView.length;
        }
    }
}



