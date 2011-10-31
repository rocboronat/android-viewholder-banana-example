package net.rocboronat.android.examples.viewholder;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
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

public class HelloListViewHolderActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("With ViewHolder");
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
	        ViewHolder holder = null;
	    	if (convertView == null || !(convertView.getTag() instanceof ViewHolder)) {
                convertView = mInflater.inflate(R.layout.list_item, null);
                // Creates a ViewHolder and store references to the two children views we want to bind data to.
                holder = new ViewHolder();
                holder.estat = (ImageView) convertView.findViewById(R.id.estat);
                holder.direccio = (TextView) convertView.findViewById(R.id.direccio);
                holder.preferit = (View) convertView.findViewById(R.id.preferit);
                holder.color = (View) convertView.findViewById(R.id.color);
                convertView.setTag(holder);
            } else {
                // Get the ViewHolder back to get fast access to the TextView
                // and the ImageView.
                holder = (ViewHolder) convertView.getTag();
            }
            
            String country = ExampleData.COUNTRIES[pos];
	    	
            holder.direccio.setText(country);
            holder.color.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.gradientgreen));
            holder.estat.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.stats_d));
            holder.preferit.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.softstarclear));
            
	    	return convertView;
	    }
	    
	    private class ViewHolder {
            View color;
            View preferit;
            ImageView estat;
            TextView direccio;
        }	
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
}