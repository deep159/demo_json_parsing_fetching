package com.example.hi.myjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.hi.myjson.R.id.image;

/**
 * Created by Hi on 22-03-2017.
 */

public class myadapter extends BaseAdapter {
    Context context;
    ArrayList<String> Aimage;
    ArrayList<String> Aname;
    ArrayList<String> Adob;
    ArrayList<String> Acountry;
    ArrayList<String> Aheight;
    ArrayList<String> Aspouse;
    ArrayList<String> Achildren;
    ArrayList<String> Adescription;
    LayoutInflater inflater;
    public myadapter(MainActivity mainActivity, ArrayList<String> imagearray, ArrayList<String> namearray, ArrayList<String> dobarray, ArrayList<String> countryarray, ArrayList<String> heightarray, ArrayList<String> spousearray, ArrayList<String> childrenarray, ArrayList<String> descriptionarray) {
        context=mainActivity;
        Aimage=imagearray;
        Aname=namearray;
        Adob=dobarray;
        Acountry=countryarray;
        Aheight=heightarray;
        Aspouse=spousearray;
        Achildren=childrenarray;
        Adescription=descriptionarray;
        inflater = inflater.from(context);

    }

    @Override
    public int getCount() {
        return Aname.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TextView mname,mdob,mcountry,mheight,mspouse,mchildren,mdescription;
        ImageView mimage;
        view=inflater.inflate(R.layout.mylist,null);
        mimage= (ImageView) view.findViewById(R.id.imageView);
        mname= (TextView) view.findViewById(R.id.ename);
        mdob= (TextView) view.findViewById(R.id.edob);
        mcountry= (TextView) view.findViewById(R.id.ecountry);
        mheight= (TextView) view.findViewById(R.id.eheight);
        mspouse= (TextView) view.findViewById(R.id.espouse);
        mchildren= (TextView) view.findViewById(R.id.echildren);
        mdescription= (TextView) view.findViewById(R.id.description);
        Picasso.with(context).load(Aimage.get(position)).into(mimage);
        mname.setText(Aname.get(position));
        mdob.setText(Adob.get(position));
        mcountry.setText(Acountry.get(position));
        mheight.setText(Aheight.get(position));
        mspouse.setText(Aspouse.get(position));
        mchildren.setText(Achildren.get(position));
        mdescription.setText(Adescription.get(position));
        return view;
    }
}
