package com.project.umang.filterlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class fragment extends Fragment {


    MyAdapter adapter;
    ArrayList<listcomp> lis = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment,container,false);


        lis.add(new listcomp("Parliament","Delhi",R.drawable.par));
        lis.add(new listcomp("Arvind Kejriwal","CM of New Delhi",R.drawable.arvind));
        lis.add(new listcomp("Hockey","National Sport of India",R.drawable.hockey));
        lis.add(new listcomp("Shah Jahan","Builder (Taj Mahal) ",R.drawable.shah));
        lis.add(new listcomp("Calculator", " ", R.drawable.android_tiled_background));

        adapter = new MyAdapter(getContext(),lis);
        ListView liview = (ListView)v.findViewById(R.id.listview);
        liview.setAdapter(adapter);

        registerForContextMenu(liview);
      /*  liview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listcomp lc =(listcomp) parent.getItemAtPosition(position);
                Intent intent =  new Intent(getActivity().getBaseContext(), ScrollingActivity.class);
                intent.putExtra("image",lc.getim());
                startActivity(intent);
            }
*/
        EditText esearch = (EditText)v.findViewById(R.id.filter);
        esearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflat = getActivity().getMenuInflater();
        inflat.inflate(R.menu.context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch(item.getItemId())
        {
            case R.id.delete:
                lis.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
        }
        return super.onContextItemSelected(item);
    }





    public class MyAdapter extends BaseAdapter implements Filterable {

        private ArrayList<listcomp> mOriginalValues; // Original Values
        private ArrayList<listcomp> mDisplayedValues;    // Values to be displayed
        LayoutInflater inflater;

        public MyAdapter(Context context, ArrayList<listcomp> mlistcompArrayList) {
            this.mOriginalValues = mlistcompArrayList;
            this.mDisplayedValues = mlistcompArrayList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mDisplayedValues.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            LinearLayout llContainer,l2,l3;
            TextView t1,t2;
            CardView c1;
            ImageView i1;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if (convertView == null) {

                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.listcomp, null);
                holder.llContainer = (LinearLayout)convertView.findViewById(R.id.llcontainer);
                holder.l2 = (LinearLayout) convertView.findViewById(R.id.l2);
                holder.l3 = (LinearLayout) convertView.findViewById(R.id.l3);
                holder.t1 = (TextView) convertView.findViewById(R.id.textView);
                holder.t2 = (TextView) convertView.findViewById(R.id.textView2);
                holder.i1 = (ImageView) convertView.findViewById(R.id.imm);
                holder.c1 = (CardView) convertView.findViewById(R.id.c1);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.t1.setText(mDisplayedValues.get(position).gettext1());
            holder.t2.setText(mDisplayedValues.get(position).gettext2());
            holder.i1.setImageResource(mDisplayedValues.get(position).getim());


            holder.llContainer.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent intent =  new Intent(getActivity().getBaseContext(), ScrollingActivity.class);
                    intent.putExtra("image",mDisplayedValues.get(position).getim());
                    intent.putExtra("title",mDisplayedValues.get(position).gettext1().toString());
                    startActivity(intent);
                }
            });

            return convertView;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint,FilterResults results) {

                    mDisplayedValues = (ArrayList<listcomp>) results.values; // has the filtered values
                    notifyDataSetChanged();  // notifies the data with new filtered values
                }

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                    ArrayList<listcomp> FilteredArrList = new ArrayList<listcomp>();

                    if (mOriginalValues == null) {
                        mOriginalValues = new ArrayList<listcomp>(mDisplayedValues); // saves the original data in mOriginalValues
                    }

                    /********
                     *
                     *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                     *  else does the Filtering and returns FilteredArrList(Filtered)
                     *
                     ********/
                    if (constraint == null || constraint.length() == 0) {

                        // set the Original result to return
                        results.count = mOriginalValues.size();
                        results.values = mOriginalValues;
                    } else {
                        constraint = constraint.toString().toLowerCase();
                        for (int i = 0; i < mOriginalValues.size(); i++) {
                            String data = mOriginalValues.get(i).gettext1();
                            if (data.toLowerCase().startsWith(constraint.toString())) {
                                FilteredArrList.add(new listcomp(mOriginalValues.get(i).gettext1(),mOriginalValues.get(i).gettext2(),mOriginalValues.get(i).getim()));
                            }
                        }
                        // set the Filtered result to return
                        results.count = FilteredArrList.size();
                        results.values = FilteredArrList;
                    }
                    return results;
                }
            };
            return filter;
        }
    }



}