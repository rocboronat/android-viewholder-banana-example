package net.rocboronat.android.examples.viewholder;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HelloListViewActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new SimpleArrayAdapter(this));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	SimpleArrayAdapter adapter = null;
	class SimpleArrayAdapter extends ArrayAdapter {
		Context context = null;
		
		public SimpleArrayAdapter(Context c) {
			super(c, R.layout.list_item, ExampleData.COUNTRIES);
			context = c;
		}
		
	    public View getView(int pos, View convertView, ViewGroup parent){
	        LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.list_item, null);
            
            String country = ExampleData.COUNTRIES[pos];
	    	
            TextView direccio = (TextView)convertView.findViewById(R.id.direccio);
            direccio.setText(country);
            
            View color = convertView.findViewById(R.id.color);
            color.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.gradientgreen));
	    	
            ImageView estat = (ImageView) convertView.findViewById(R.id.estat);
            estat.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.stats_d));
            
            View preferit = (View) convertView.findViewById(R.id.preferit);
            preferit.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.softstarclear));
            
	    	return convertView;
	    }
	}
}