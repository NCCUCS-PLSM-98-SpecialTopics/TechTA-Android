package com.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment3 extends Fragment {
	private GridView gridView;
	private View v;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.fragment3_gridview, container, false);
		//listView = (ListView)v.findViewById(R.id.listView);
		gridView = (GridView)v.findViewById(R.id.main_page_gridview);
		final String[] list = new String[]{
				"A","B","C","D"
			};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
		gridView.setNumColumns(2);
		gridView.setAdapter(adapter);
		//listView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "§A«ö¤U"+list[position], Toast.LENGTH_SHORT).show();
			}
			
		}
		);
		return v;
	}
}