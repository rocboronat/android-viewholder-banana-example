/** This file is part of ListView Efficiency Examples.

    ListView Efficiency Examples is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    ListView Efficiency Examples is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with ListView Efficiency Examples.  If not, see <http://www.gnu.org/licenses/>.
    
    @author Roc Boronat
    @date 31/10/2011
    @see http://rocboronat.net
*/

package net.rocboronat.android.examples.viewholder;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
				Toast.makeText(getApplicationContext(),"Click!!", Toast.LENGTH_SHORT).show();
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
	    	Chrono c = new Chrono();
	    	c.start(1);
	    	
	    	ViewHolder holder = null;
	    	if (convertView == null || !(convertView.getTag() instanceof ViewHolder)) {
		        LayoutInflater mInflater = LayoutInflater.from(context);
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

            Log.i("With uncached ViewHolder: " + country, c.stop(1)+"ms");
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