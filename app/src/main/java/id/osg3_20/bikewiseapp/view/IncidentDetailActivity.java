package id.osg3_20.bikewiseapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import id.osg3_20.bikewiseapp.R;

public class IncidentDetailActivity extends AppCompatActivity{

    EditText title, description, address, type;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_detail);

        title = (EditText) findViewById(R.id.title);
        description = (EditText) findViewById(R.id.description);
        address = (EditText) findViewById(R.id.address);
        type = (EditText) findViewById(R.id.type);
        image = (ImageView) findViewById(R.id.image);

        String incident_title = getIntent().getExtras().getString("title");
        String incident_image = getIntent().getExtras().getString("image_url");
        String incident_description = getIntent().getExtras().getString("description");
        String incident_address = getIntent().getExtras().getString("address");
        String incident_type = getIntent().getExtras().getString("type");

        title.setText(incident_title);
        description.setText(incident_description);
        address.setText(incident_address);
        type.setText(incident_type);

        Picasso.get()
                .load(incident_image)
                .into(image);
    }

}
