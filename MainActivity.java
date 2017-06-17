package com.example.hi.myjson;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> Imagearray;
    ArrayList<String> Namearray;
    ArrayList<String> Dobarray;
    ArrayList<String> Countryarray;
    ArrayList<String> Heightarray;
    ArrayList<String> Spousearray;
    ArrayList<String> Childrenarray;
    ArrayList<String> Descriptionarray;
    ListView mCustomList;
    //ImageView mimageview;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mimageview= (ImageView) findViewById(R.id.imageView);
        Imagearray=new ArrayList<>();
        Namearray=new ArrayList<>();
        Dobarray=new ArrayList<>();
        Countryarray=new ArrayList<>();
        Heightarray=new ArrayList<>();
        Spousearray=new ArrayList<>();
        Childrenarray=new ArrayList<>();
        Descriptionarray=new ArrayList<>();
        mCustomList= (ListView) findViewById(R.id.mylist);
        new GetResponse().execute();
    }
    class GetResponse extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(MainActivity.this);
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait....");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String url="http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
            String response=HitURL.urlReader(url);
            try {
                JSONObject outer_object=new JSONObject(response);
                JSONArray array=outer_object.getJSONArray("actors");
                for(int i=0;i<array.length();i++)
                {
                    JSONObject inner_object=array.getJSONObject(i);
                    String name=inner_object.getString("name");
                    Namearray.add(name);
                    String description=inner_object.getString("description");
                    Descriptionarray.add(description);
                    String dob=inner_object.getString("dob");
                    Dobarray.add(dob);
                    String country=inner_object.getString("country");
                    Countryarray.add(country);
                    String height=inner_object.getString("height");
                    Heightarray.add(height);
                    String spouse=inner_object.getString("spouse");
                    Spousearray.add(spouse);
                    String children=inner_object.getString("children");
                    Childrenarray.add(children);
                    String image=inner_object.getString("image");
                    Imagearray.add(image);

                    /*Log.e(">>>",name);
                    Log.e(">>>",dob);
                    Log.e(">>>",country);
                    Log.e(">>>",height);
                    Log.e(">>>",spouse);
                    Log.e(">>>",children);
                    Log.e(">>>",description);*/
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(">>>",e.toString());
            }

            //Log.e(">>>",response);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(dialog.isShowing())
            {
                dialog.dismiss();
            }

myadapter adapter=new myadapter(MainActivity.this,Imagearray,Namearray,Dobarray,Countryarray,Heightarray,Spousearray,Childrenarray,Descriptionarray);
            mCustomList.setAdapter(adapter);
        }
    }
}
