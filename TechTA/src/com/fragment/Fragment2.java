package com.fragment;

import com.fragment.JWC;
import com.fragment.R;


import org.jwebsocket.api.WebSocketClientTokenListener;
import org.jwebsocket.api.WebSocketClientEvent;
import org.jwebsocket.api.WebSocketPacket;
import org.jwebsocket.kit.WebSocketException;
import org.jwebsocket.token.Token;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;



public class Fragment2 extends FragmentActivity implements WebSocketClientTokenListener{
	
	
	private Button btn_back;//回上一頁
	private Button btn_send;//送出訊息
	private EditText Message;//訊息內容
	private RelativeLayout mRelativeLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ask_question);
		btn_back = (Button) findViewById(R.id.btn_back);		
		btn_send = (Button) findViewById(R.id.btn_send);
		Message = (EditText) findViewById(R.id.question);
		
		btn_back.setOnClickListener(new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	           Intent nextPage = new Intent();
	           //nextPage.setClass(Fundamentals.this.getActivity(), MainActivity.class);
	           nextPage.setClass(Fragment2.this, MainActivity.class);
	           startActivity(nextPage);
	           //Fundamentals.this.getActivity().finish();
	           Fragment2.this.finish();
	           //setContentView(R.layout.room);
	        }
	     }); 
		
		btn_send.setOnClickListener(new OnClickListener() {

			public void onClick(View aView) {
				try {
					// lSamplePlugIn.getRandom();
					JWC.sendText("address", Message.getText().toString());
				} catch (WebSocketException ex) {
					// TODO: handle exception
				}
			}
		});
	}
	
	

	/*@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mRelativeLayout = (RelativeLayout) inflater.inflate(R.layout.ask_question,
                container, false);
		btn_back = (Button) mRelativeLayout.findViewById(R.id.btn_back);		
		btn_send = (Button) mRelativeLayout.findViewById(R.id.btn_send);
		Message = (EditText) mRelativeLayout.findViewById(R.id.question);
		
		btn_back.setOnClickListener(new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	           Intent nextPage = new Intent();
	           nextPage.setClass(Fragment2.this.getActivity(), MainActivity.class);
	           startActivity(nextPage);
	           Fragment2.this.getActivity().finish();
	           //setContentView(R.layout.room);
	        }
	     }); 
		
		btn_send.setOnClickListener(new OnClickListener() {

			public void onClick(View aView) {
				try {
					// lSamplePlugIn.getRandom();
					JWC.sendText("address", Message.getText().toString());
				} catch (WebSocketException ex) {
					// TODO: handle exception
				}
			}
		});
				
		return mRelativeLayout;
	}*/
	
	@Override
	protected void onResume() {
		super.onResume();
		//log("* opening... ");
		try {
			JWC.addListener(this);
			JWC.open();
		} catch (WebSocketException ex) {
			//log("* exception: " + ex.getMessage());
		}
	}
	
	public void processOpened(WebSocketClientEvent aEvent) {
		//log("opened\n");
		ImageView lImgView = (ImageView) mRelativeLayout.findViewById(R.id.ImgStatus);
		if (lImgView != null) {
			// TODO: in fact it is only connected, not yet authenticated!
			lImgView.setImageResource(R.drawable.authenticated);
		}
	}



	@Override
	public void processClosed(WebSocketClientEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void processOpening(WebSocketClientEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void processPacket(WebSocketClientEvent arg0, WebSocketPacket arg1) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void processReconnecting(WebSocketClientEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void processToken(WebSocketClientEvent arg0, Token arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
