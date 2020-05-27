package br.com.kmg.appgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;

import br.com.kmg.appgithub.util.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText edQuery;
    Button btSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edQuery = findViewById(R.id.edQuery);
        btSearch = findViewById(R.id.btSearch);
        setListeners();

    }

    public void setListeners(){
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchRepositories(edQuery.getText().toString());
            }
        });

    }
     public void searchRepositories(String query){
         URL url = NetworkUtil.getURL(query);
         Log.d(TAG, "URL: " + url);
         Toast.makeText(getApplicationContext(), "Acessando URL", Toast.LENGTH_LONG).show();

         try {
             String json = NetworkUtil.getResponseFromHttpUrl(url);
             Log.d(TAG, json);
         } catch (IOException e) {
             e.printStackTrace();
         }

     }

}
