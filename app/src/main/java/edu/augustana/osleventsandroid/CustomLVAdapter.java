package edu.augustana.osleventsandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.osleventsandroid.R;

import java.util.ArrayList;
// from https://www.youtube.com/watch?v=_YF6ocdPaBg
public class CustomLVAdapter extends ArrayAdapter{
    private ArrayList<Event> events;
    private Activity context;

    public CustomLVAdapter(Activity context, ArrayList<Event> events) {
        super(context, R.layout.custom_listview_event_layout,events);
        this.context=context;
        this.events=new ArrayList<Event>(events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.custom_listview_event_layout, null, true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) r.getTag();
        }
        Event event=events.get(position);
        viewHolder.img.setImageResource(event.getImgid());
        viewHolder.txtTitle.setText(event.getName());
        viewHolder.txtLocation.setText(event.getLocation());
        viewHolder.txtDate.setText(event.getFormatedDate());
        viewHolder.txtTime.setText(event.getFormatedTime());
        viewHolder.txtType.setText(event.getType());
        return r;
    }

    class ViewHolder{
        TextView txtTitle;
        TextView txtLocation;
        TextView txtDate;
        TextView txtTime;
        TextView txtType;
        ImageView img;
        ViewHolder(View v){
            this.txtTitle=(TextView) v.findViewById(R.id.txtTitle);
            this.txtLocation=(TextView) v.findViewById(R.id.txtLocation);
            this.txtDate=(TextView) v.findViewById(R.id.txtDate);
            this.txtTime=(TextView) v.findViewById(R.id.txtTime);
            this.txtType=(TextView) v.findViewById(R.id.txtEventType);
            this.img=(ImageView) v.findViewById(R.id.eventImg);
        }
    }
}
