package com.nickteck.colormecrazy.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;

import com.nickteck.colormecrazy.R;
import com.nickteck.colormecrazy.additionalClass.HelperClass;
import com.nickteck.colormecrazy.fragment.ContentFragment;
import com.nickteck.colormecrazy.fragment.UserRegistrationFragment;
import com.nickteck.colormecrazy.utilclass.Constants;

public class DashBoardActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    TextView txtHomeToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtHomeToolBar = (TextView) findViewById(R.id.txtHomeToolBar);

        txtHomeToolBar.setText("Check");*/
       // coordinatorLayout = (CoordinatorLayout) findViewById(R.id.snackbar_id);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ContentFragment contentFragment = new ContentFragment();
        HelperClass.replaceFragment(contentFragment, Constants.CONTENTFRAGMENT, DashBoardActivity.this);

        /*UserRegistrationFragment userRegistrationFragment = new UserRegistrationFragment();
        HelperClass.replaceFragment(userRegistrationFragment,Constants.REGISTRATIONFRAGMENT,DashBoardActivity.this);*/

       /* Intent intent = new Intent(this,UserRegistrationActivity.class);
        startActivity(intent);*/
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean back = false;
        if(keyCode == KeyEvent.KEYCODE_BACK){
            back = true;
            backStack();
        }
        return back;

    }

    private void backStack(){
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else
        if(getSupportFragmentManager().getBackStackEntryCount()==1){
            this.finish();
        }
    }
}
